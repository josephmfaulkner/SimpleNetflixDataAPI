#!/bin/bash
INPUT_FILE="$1"
OUTPUT_FILE="$2"
OLDIFS=$IFS
IFS=','
[ ! -f $INPUT_FILE ] && { echo "$INPUT_FILE file not found"; exit 99; }

{
{
    read firstLine
    echo "person_id,movie_id,character,role"
    while IFS=, read -r person_id movie_id name character role
    do 
        echo "$person_id,$movie_id,$character,$role"
    done
} < $INPUT_FILE 
} > "$OUTPUT_FILE"

IFS=$OLDIFS
