To test out this application, you need Maven to build the dependencies.

First, install the dependencies
mvn clean install

Running
Second, run the production build with live reload
mvn spring-boot:run
When the application is first built, it will create a database file in the directory specified in the application.properties file.

Testing *
Maven Tests
mvn test

Explore Rest APIs
The app defines following  APIs.

GET /api/register/users

POST /api/v1/user

GET /api/register/users/{userId}
To test out this application, you need Maven to build the dependencies.

First, install the dependencies
mvn clean install

Running
Second, run the production build with live reload
mvn spring-boot:run
When the application is first built, it will create a database file in the directory specified in the application.properties file.

Testing *
Maven Tests
mvn test

Explore Rest APIs
The app defines following CRUD APIs.

GET /api/register/user/1

POST /api/register/user



# Spring Boot, H2, Rest API

Build Restful CRUD API for a blog using Spring Boot, H2.

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/ramzakus/workstation.git
```

**4. Run the app using maven**

```bash
mvn spring-boot:run
```
The app will start running at <http://localhost:9000>

## Explore Rest APIs

The app defines following CRUD APIs.

### Users

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| GET    | /api/register/users/{id} | Get user by id | |
| POST   | /api/register/users | Add user Check if user data is available to register | [JSON](#usercreate) |


Test them using postman or any other rest client.

## Sample Valid JSON Request Bodys

##### <a id="usercreate">Create User -> /api/users</a>
```json
{
	"userName": "USAF23456",
	"birthDay": "1996-05-09",
	"countryOfResidence": "France",
	"phoneNumber": "0645675345",
	"gender": "M"
}
```
