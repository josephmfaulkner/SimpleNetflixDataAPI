#!/bin/bash
INPUT_FILE="$1"
OUTPUT_FILE="$2"
OLDIFS=$IFS
IFS=','
[ ! -f $INPUT_FILE ] && { echo "$INPUT_FILE file not found"; exit 99; }

{
{
    read firstLine
    echo "id,title,type,description,release_year,runtime,imdb_score,tmdb_score"
    while IFS=, read -r id title movie_type description release_year \
        age_certification runtime genres production_countries \
        seasons imdb_id imdb_score imdb_votes tmdb_popularity tmdb_score
    do 
        echo "$id,$title,$type,$description,$release_year,$runtime,$imdb_score,$tmdb_score"
    done
} < $INPUT_FILE 
} > "$OUTPUT_FILE"

IFS=$OLDIFS


#filename="$1"
#sed 's/\s*,*\s*$//g' "$filename" > tmp.csv
#outputName=$(echo "$filename" | cut -d"." -f 1)
#outputfile="$outputName OUT.csv"
#$outputName="\`$outputName\`"
#columns=$(head --lines=1 tmp.csv | sed 's/,/`,`/g' | tr -d "\r\n")
#columns="\`$columns\`"
#echo "$columns"
#tail --lines=+1 tmp.csv | while read l ; do
#values=$(echo $l | sed 's/,/\",\"/g' | tr -d "\r\n")
#echo "$values"
#done > "$outputfile"
#rm tmp.csv