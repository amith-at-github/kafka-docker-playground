test_file=$(playground state get run.test_file)

if [ ! -f $test_file ]
then 
    logerror "File $test_file retrieved from $root_folder/playground.ini does not exist!"
    exit 1
fi

# determining the docker-compose file from from test_file
docker_compose_file=$(grep "start-environment" "$test_file" |  awk '{print $6}' | cut -d "/" -f 2 | cut -d '"' -f 1 | tail -n1 | xargs)
test_file_directory="$(dirname "${test_file}")"
docker_compose_file="${test_file_directory}/${docker_compose_file}"

if [ "${docker_compose_file}" != "" ] && [ ! -f "${docker_compose_file}" ]
then
    logwarn "Skipping as docker-compose override file could not be detemined"
    exit 0
fi

connector_paths=$(grep "CONNECT_PLUGIN_PATH" "${docker_compose_file}" | grep -v "KSQL_CONNECT_PLUGIN_PATH" | cut -d ":" -f 2  | tr -s " " | head -1)
if [ "$connector_paths" == "" ]
then
    logwarn "Skipping as it is not an example with connector"
    exit 0
else
    current_tag=$(docker inspect -f '{{.Config.Image}}' broker 2> /dev/null | cut -d ":" -f 2)
    log "🎯 Version currently used for confluent platform"
    echo "$current_tag"

    my_array_connector_tag=($(echo $CONNECTOR_TAG | tr "," "\n"))
    for connector_path in ${connector_paths//,/ }
    do
        full_connector_name=$(basename "$connector_path")
        connector_name=$(echo "$full_connector_name" | cut -d'-' -f2-)

        connectors=(
        "$connector_name"
        )

        output_format="\"🔢 v\" + .version + \" - 📅 release date: \" + .release_date"

        curl -s -S 'https://api.hub.confluent.io/api/plugins?per_page=100000' | jq '. | sort_by(.release_date) | reverse | .' > /tmp/allmanis.json

        connectors_string=""
        delim=""
        for conn in "${connectors[@]}"; do
            connectors_string="$connectors_string$delim\"$conn\""
            delim=","
        done 
        latest=$(jq '.[] | select(IN(.name; '"${connectors_string}"')) | '"${output_format}"'' /tmp/allmanis.json)

        rm /tmp/allmanis.json

        ## current version        
        manifest_file="$root_folder/confluent-hub/$full_connector_name/manifest.json"
        if [ -f $manifest_file ]
        then
            version=$(cat $manifest_file | jq -r '.version')
            release_date=$(cat $manifest_file | jq -r '.release_date')
        else
            logerror "file $manifest_file does not exist"
            exit 1
        fi

        current="\"🔢 v$version - 📅 release date: $release_date\""
        if [ "$current" == "$latest" ]
        then
            log "👻 Version currently used for $full_connector_name is latest"
            echo "$current"
        else
            log "🗯️ Version currently used for $full_connector_name is not latest"
            log "Current"
            echo "$current"
            log "Latest on Hub"
            echo "$latest"
        fi 
    done
fi