#!/bin/bash
node seed_data/conversion_scripts/gen_title.js seed_data/source_data/titles.csv seed_data/formatted_data/title.sql TITLE
node seed_data/conversion_scripts/gen_title_person.js seed_data/source_data/credits.csv seed_data/formatted_data/title_person.sql TITLE_PERSON
node seed_data/conversion_scripts/gen_person.js seed_data/source_data/credits.csv seed_data/formatted_data/person.sql PERSON