# Springboot with Groovy
### Testing with Postman
Run the Application: Start your Spring Boot application. The server will be running at http://localhost:8080.

### Testing Endpoints:

GET all users:
URL: http://localhost:8080/api/users

POST a new user:
URL: http://localhost:8080/api/users

Body: Select raw -> JSON, and enter the following sample:
```
{
  "name": "Rajesh",
  "email": "raj.b@test.com"
}
```
GET a user by ID:
URL: http://localhost:8080/api/users/{id} (replace {id} with the user ID returned by the POST request).

PUT to update a user:
URL: http://localhost:8080/api/users/{id}

Body: Provide the updated user details in raw -> JSON:
```
{
  "name": "Rajesh Updated",
  "email": "raj.b@test123.com"
}
```
DELETE a user:
URL: http://localhost:8080/api/users/{id}

View H2 Database Console: You can check your data via the H2 console:
URL: http://localhost:8080/h2-console
