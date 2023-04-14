ret=$(get_connect_url_and_security)

connect_url=$(echo "$ret" | cut -d "@" -f 1)
security=$(echo "$ret" | cut -d "@" -f 2)

curl $security -s -X GET -H "Content-Type: application/json" "$connect_url/connector-plugins" | jq .