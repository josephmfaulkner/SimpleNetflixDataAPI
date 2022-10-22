#!/bin/bash
INPUT_FILE="$1"
OUTPUT_FILE="$2"
OLDIFS=$IFS
IFS=','
[ ! -f $INPUT_FILE ] && { echo "$INPUT_FILE file not found"; exit 99; }
{
{
    declare -A person_id_map
    read firstLine
    echo "id,name"
    while IFS=, read -r person_id movie_id name character role
    do 
        if ! [ "${person_id_map[$person_id]+abc}" ]; then
            person_id_map[$person_id]=1
            echo "$person_id,$name"
        fi      
    done
} < $INPUT_FILE 
} > "$OUTPUT_FILE"

IFS=$OLDIFS
