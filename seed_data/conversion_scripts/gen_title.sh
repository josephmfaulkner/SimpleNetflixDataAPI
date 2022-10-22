#!/bin/bash
INPUT_FILE="$1"
OUTPUT_FILE="$2"
TABLE_NAME="$3"
OLDIFS=$IFS
IFS=','
[ ! -f $INPUT_FILE ] && { echo "$INPUT_FILE file not found"; exit 99; }

{
{
    read firstLine
    #echo "id,title,type,description,release_year,runtime,imdb_score,tmdb_score"
    while IFS=, read -r line
    do 
        echo | awk -vFPAT='([^,]*)|("[^"]+")' -v linedata='$line' -vOFS=, '{print $1,$4}' 
        #awk '{while(match($0,/"[^"]+",|([^,]+(,|$))/,a)){$0=substr($0,RSTART+RLENGTH);b[++x]=a[0]} print b[1] b[4];x=0}' line
        title=$(echo $title | sed "s/'/''/g")
        description=$(echo $description | sed "s/'/''/g")
        echo "INSERT INTO $TABLE_NAME (id,title,movie_type,description,release_year,runtime,imdb_score,tmdb_score) \
         VALUES ($id,'$title',$movie_type,'$description',$release_year,$runtime,$imdb_score,$tmdb_score);"
        #echo "$id,$title,$movie_type,$description,$release_year,$runtime,$imdb_score,$tmdb_score"
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