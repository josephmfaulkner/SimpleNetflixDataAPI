# Simple Netflix API


## Local Setup

This project was developed on a desktop running Ubuntu 20.04.3 LTS

### To follow this setup, you will need:

* Node
* NPM
* Docker
* Docker Compose
* Maven
* Java SDK
* Java 8 or higher

### Install Node Dependencies
```
npm install
```

### Format Source Data
```
bash convert_source_data.sh
```
### Open another terminal window and run
```
docker-compose up
``` 

### Run database migrations and seed source data
```
npx db-migrate up
```
### Start the SpringBoot API Application
```
cd ./api
mvn install
mvn spring-boot:run
```

### Test commands
```
curl http://localhost:3080/showbytitle/Taxi%20Driver
```