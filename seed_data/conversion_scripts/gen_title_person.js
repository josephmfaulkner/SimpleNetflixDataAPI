const fs = require("fs");
const { parse } = require("csv-parse");

const commandArgs = process.argv.slice(2);

fs.writeFileSync(commandArgs[1],''); 

const readFileStream = fs.createReadStream(commandArgs[0]);
const writeFileStream = fs.createWriteStream( commandArgs[1]);

const tableName = commandArgs[2];

const columnNames = [
  'person_id',
  'id',
  'name',
  'character',
  'role'
]
;

let firstLineWrite = true;

const writeDataToFile = (rowData, writeFileStream) => {
    
    let { person_id, id, name, character, role } = rowData;
    
    character = character.replace(/'/g, '"');
    role = role.replace(/'/g, '"');

    const columns = 'person_id, movie_id, character, role';
    const values = `'${person_id}','${id}','${character}','${role}'`;

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