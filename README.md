# TestTask

TestTask is a TestNG based test automation framework for API acceptance testing using RestAssured jars.
 

## Requirements

In order to utilise this project you need to have the following installed locally:

- Maven 3.5.0
- Java 1.8

### Advised working environment

- Eclipse / IntelliJ
- Git Integration for the IDE

## Tools

- Maven
- TestNG

## Usage

To run all modules, navigate to TestTask directory and run on command prompt :

 `mvn clean install`

## Reporting

Reports for API test run module are written into `/Reports/{Today's Date}/` directories after a successful run.

API acceptance tests result in a HTML report for each class file present in package `/com.testTask.app.api/`.
