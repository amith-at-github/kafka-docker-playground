environment_before_switch=$(playground state get run.environment_before_switch)
if [ "$environment_before_switch" == "" ]
then
    logerror "switch-ccloud was probably not executed before"
    exit 1
fi

log "💺 Switch back to previous environment ($environment_before_switch)"

playground state set run.environment "$environment_before_switch"
playground state del run.environment_before_switch

test_file=$(playground state get run.test_file)

if [ ! -f $test_file ]
then 
    logerror "File $test_file retrieved from $root_folder/playground.ini does not exist!"
    exit 1
fi

last_two_folders=$(basename $(dirname $(dirname $test_file)))/$(basename $(dirname $test_file))
filename=$(basename $test_file)
last_folder=$(basename $(dirname $test_file))

log "🚀 Running example "
echo $last_two_folders/$filename