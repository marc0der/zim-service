###Demo Spring Boot Groovy app

This application demonstrates how easy it is to build a Groovy Spring Boot application, using Cucumber to test. It uses embedded server and mongo during functional tests.

####To run tests

	gradle clean check

####Set up MongoDB

Make sure that you have MongoDB installed and running. Once the `mongod` process is up and running, insert some test data into the database by running:

    mongo invasion mongo/quotes.js

####To run the app from Gradle using local Mongo

    gradle run

####To run up the fat jar

	java -jar build/libs/zim-service
