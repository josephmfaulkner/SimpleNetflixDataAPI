#!/bin/bash
bash ./conversion_scripts/gen_title.sh source_data/titles.csv formatted_data/title.csv
bash ./conversion_scripts/gen_title_person.sh source_data/credits.csv formatted_data/title_person.csv
bash ./conversion_scripts/gen_person.sh source_data/credits.csv formatted_data/person.csv