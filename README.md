# UrlGenerator

The microservice generates a specified number of unique IDs and checks that there are no such IDs in the [ShareAll](https://github.com/Apolones/shareAll) application. It adds them to the database and returns them one by one upon a GET request.

## Technology Stack

The URL Generator Microservice is built using the following technologies:

- Spring Boot
- Java

## API Endpoints

### Generate URL

Get Generated URL
<br>Endpoint: /generate
<br>HTTP Method: GET
<br>Response:
<br>json
<br>Copy code
<br>{
<br>  "31d85a0f9845247c5845168a18920d67"
<br>}

## Setup
1. Install MySQL.
2. Configure the database properties in "application.properties".
3. Build the UrlGeneratorl project using the following command:
```
mvn clean package
```
4. Run the project:
```
java -jar target/urlRestApp-0.0.1.jar
```
