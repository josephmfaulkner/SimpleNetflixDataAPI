# Simple Netflix API


## Local Setup

This project was developed on a desktop running Ubuntu 20.04.3 LTS

### To follow this setup, you will need:

* Node
* NPM

### Format Source Data
```
npm install
node seed_data/conversion_scripts/gen_title.js seed_data/source_data/titles.csv seed_data/formatted_data/title.sql TITLE
node seed_data/conversion_scripts/gen_title_person.js seed_data/source_data/credits.csv seed_data/formatted_data/title_person.sql TITLE_PERSON
node seed_data/conversion_scripts/gen_person.js seed_data/source_data/credits.csv seed_data/formatted_data/person.sql PERSON



cd ./seed_data
bash ./gen_formatted_data.sh

node gen_title.js source_data/titles_short.csv formatted_data/title_TEST.sql TITLE

```

