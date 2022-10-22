const fs = require("fs");
const { parse } = require("csv-parse");

const commandArgs = process.argv.slice(2);

fs.writeFileSync(commandArgs[1],''); 

const readFileStream = fs.createReadStream(commandArgs[0]);
const writeFileStream = fs.createWriteStream( commandArgs[1]);

const tableName = commandArgs[2];

const columnNames = [
    'id',
    'title',
    'type',
    'description',
    'release_year',
    'age_certification',
    'runtime',
    'genres',
    'production_countries',
    'seasons',
    'imdb_id',
    'imdb_score',
    'imdb_votes',
    'tmdb_popularity',
    'tmdb_score'
]
;

let firstLineWrite = true;

const writeDataToFile = (rowData, writeFileStream) => {
    
    let { id,title,type,description,release_year,runtime,imdb_score,tmdb_score } = rowData;
    
    title = title.replace(/'/g, '"');
    description = description.replace(/'/g, '"');

    const columns = 'id,title,type,description,release_year,runtime,imdb_score,tmdb_score';
    const values = `'${id}','${title}','${type}','${description}',${release_year},${runtime},${imdb_score},${tmdb_score}`;

    const insertStatement = `INSERT INTO ${tableName} (${columns}) VALUES (${values});`
    
    
    if(firstLineWrite)
    {
      writeFileStream.write(insertStatement);
      firstLineWrite = false;
    }
    else 
    {
      writeFileStream.write("\r\n"+insertStatement);
    }

}

readFileStream
  .pipe(parse({ delimiter: ",", from_line: 2, columns: columnNames  }))
  .on("data", function (row) {
    //console.log(row);
    writeDataToFile(row, writeFileStream);
    //writeFileStream.write(JSON.stringify(row)+"\r\n");
  })
  .on("end", function () {
    //console.log("finished");
  })
  .on("error", function (error) {
    console.log(error.message);
  });