#!/bin/bash
set -e

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null && pwd )"
source ${DIR}/../../scripts/utils.sh

create_or_get_oracle_image "linuxx64_12201_database.zip" "../../connect/connect-jdbc-oracle12-source/ora-setup-scripts"

if [ ! -z "$SQL_DATAGEN" ]
then
     log "🌪️ SQL_DATAGEN is set"
     for component in oracle-datagen
     do
     set +e
     log "🏗 Building jar for ${component}"
     docker run -i --rm -e KAFKA_CLIENT_TAG=$KAFKA_CLIENT_TAG -e TAG=$TAG_BASE -v "${PWD}/${component}":/usr/src/mymaven -v "$HOME/.m2":/root/.m2 -v "$PWD/../../scripts/settings.xml:/tmp/settings.xml" -v "${PWD}/${component}/target:/usr/src/mymaven/target" -w /usr/src/mymaven maven:3.6.1-jdk-11 mvn -s /tmp/settings.xml -Dkafka.tag=$TAG -Dkafka.client.tag=$KAFKA_CLIENT_TAG package > /tmp/result.log 2>&1
     if [ $? != 0 ]
     then
          logerror "ERROR: failed to build java component "
          tail -500 /tmp/result.log
          exit 1
     fi
     set -e
     done
else
     log "🛑 SQL_DATAGEN is not set"
fi

if [ ! -z "$CONNECTOR_TAG" ]
then
     JDBC_CONNECTOR_VERSION=$CONNECTOR_TAG
else
     JDBC_CONNECTOR_VERSION=$(docker run ${CP_CONNECT_IMAGE}:${CONNECT_TAG} cat /usr/share/confluent-hub-components/confluentinc-kafka-connect-jdbc/manifest.json | jq -r '.version')
fi
log "JDBC Connector version is $JDBC_CONNECTOR_VERSION"
if ! version_gt $JDBC_CONNECTOR_VERSION "9.9.9"; then
     get_3rdparty_file "ojdbc8.jar"
     if [ ! -f ${DIR}/ojdbc8.jar ]
     then
          logerror "ERROR: ${DIR}/ojdbc8.jar is missing. It must be downloaded manually in order to acknowledge user agreement"
          exit 1
     fi
     ${DIR}/../../environment/plaintext/start.sh "${PWD}/docker-compose.plaintext.yml"
else
     log "ojdbc jar is shipped with connector (starting with 10.0.0)"
     ${DIR}/../../environment/plaintext/start.sh "${PWD}/docker-compose.plaintext.no-ojdbc.yml"
fi

# Verify Oracle DB has started within MAX_WAIT seconds
MAX_WAIT=900
CUR_WAIT=0
log "⌛ Waiting up to $MAX_WAIT seconds for Oracle DB to start"
docker container logs oracle > /tmp/out.txt 2>&1
while [[ ! $(cat /tmp/out.txt) =~ "DATABASE IS READY TO USE" ]]; do
sleep 10
docker container logs oracle > /tmp/out.txt 2>&1
CUR_WAIT=$(( CUR_WAIT+10 ))
if [[ "$CUR_WAIT" -gt "$MAX_WAIT" ]]; then
     logerror "ERROR: The logs in oracle container do not show 'DATABASE IS READY TO USE' after $MAX_WAIT seconds. Please troubleshoot with 'docker container ps' and 'docker container logs'.\n"
     exit 1
fi
done
log "Oracle DB has started!"
log "Setting up Oracle Database Prerequisites"
docker exec -i oracle bash -c "ORACLE_SID=ORCLCDB;export ORACLE_SID;sqlplus /nolog" << EOF
     CONNECT sys/Admin123 AS SYSDBA
     CREATE USER  C##MYUSER IDENTIFIED BY mypassword;
     GRANT CONNECT TO  C##MYUSER;
     GRANT CREATE SESSION TO  C##MYUSER;
     GRANT CREATE TABLE TO  C##MYUSER;
     GRANT CREATE SEQUENCE TO  C##MYUSER;
     GRANT CREATE TRIGGER TO  C##MYUSER;
     ALTER USER  C##MYUSER QUOTA 100M ON users;
     exit;
EOF

log "Inserting initial data"
docker exec -i oracle sqlplus C\#\#MYUSER/mypassword@//localhost:1521/ORCLCDB << EOF

     create table CUSTOMERS (
          id NUMBER(10) GENERATED BY DEFAULT ON NULL AS IDENTITY (START WITH 42) NOT NULL PRIMARY KEY,
          first_name VARCHAR(50),
          last_name VARCHAR(50),
          email VARCHAR(50),
          gender VARCHAR(50),
          club_status VARCHAR(20),
          comments VARCHAR(90),
          create_ts timestamp DEFAULT CURRENT_TIMESTAMP ,
          update_ts timestamp
     );

     CREATE OR REPLACE TRIGGER TRG_CUSTOMERS_UPD
     BEFORE INSERT OR UPDATE ON CUSTOMERS
     REFERENCING NEW AS NEW_ROW
     FOR EACH ROW
     BEGIN
     SELECT SYSDATE
          INTO :NEW_ROW.UPDATE_TS
          FROM DUAL;
     END;
     /

     insert into CUSTOMERS (id, first_name, last_name, email, gender, club_status, comments) values (1, 'Rica', 'Blaisdell', 'rblaisdell0@rambler.ru', 'Female', 'bronze', 'Universal optimal hierarchy');
     insert into CUSTOMERS (id, first_name, last_name, email, gender, club_status, comments) values (2, 'Ruthie', 'Brockherst', 'rbrockherst1@ow.ly', 'Female', 'platinum', 'Reverse-engineered tangible interface');
     insert into CUSTOMERS (id, first_name, last_name, email, gender, club_status, comments) values (3, 'Mariejeanne', 'Cocci', 'mcocci2@techcrunch.com', 'Female', 'bronze', 'Multi-tiered bandwidth-monitored capability');
     insert into CUSTOMERS (id, first_name, last_name, email, gender, club_status, comments) values (4, 'Hashim', 'Rumke', 'hrumke3@sohu.com', 'Male', 'platinum', 'Self-enabling 24/7 firmware');
     insert into CUSTOMERS (id, first_name, last_name, email, gender, club_status, comments) values (5, 'Hansiain', 'Coda', 'hcoda4@senate.gov', 'Male', 'platinum', 'Centralized full-range approach');
     exit;
EOF

log "Creating Oracle source connector"
playground connector create-or-update --connector oracle-source << EOF
{
               "connector.class":"io.confluent.connect.jdbc.JdbcSourceConnector",
               "tasks.max":"1",
               "connection.user": "C##MYUSER",
               "connection.password": "mypassword",
               "connection.url": "jdbc:oracle:thin:@oracle:1521/ORCLCDB",
               "numeric.mapping":"best_fit",
               "mode":"timestamp",
               "poll.interval.ms":"1000",
               "validate.non.null":"false",
               "schema.pattern": "C##MYUSER",
               "table.whitelist":"CUSTOMERS",
               "timestamp.column.name":"UPDATE_TS",
               "topic.prefix":"oracle-",
               "errors.log.enable": "true",
               "errors.log.include.messages": "true"
          }
EOF


sleep 5

log "Verifying topic oracle-CUSTOMERS"
playground topic consume --topic oracle-CUSTOMERS --min-expected-messages 2 --timeout 60


if [ ! -z "$SQL_DATAGEN" ]
then
     DURATION=10
     log "Injecting data for $DURATION minutes"
     docker exec -d sql-datagen bash -c "java ${JAVA_OPTS} -jar sql-datagen-1.0-SNAPSHOT-jar-with-dependencies.jar --host oracle --username C##MYUSER --password mypassword --sidOrServerName sid --sidOrServerNameVal ORCLCDB --maxPoolSize 10 --durationTimeMin $DURATION"
fi

