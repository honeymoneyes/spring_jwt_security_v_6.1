# Modified implementation of JWT token authentication and Spring Security configuration.

# Technologies Used:
+ Spring Boot 3.1.2
+ Spring Data JPA
+ Spring Security 6.1.2
+ PostgreSQL Database
+ Lombok
+ Spring Dev Tools
+ JWT

# Configuration Steps:

### Clone the Application:

Clone the repository using the following command:

```
git clone https://github.com/honeymoneyes/spring_jwt_security_v_6.1
```

### Create a PostgreSQL Database:
```
Create a new PostgreSQL database named "jwt_security".
```

### Configure PostgreSQL Username and Password:
Open the file server/src/main/resources/application.yml and update the following properties with your PostgreSQL installation details:

```
    url: YOUR_DATABASE_URL
    username: YOUR_DATABASE_USERNAME
    password: YOUR_DATABASE_PASSWORD
```

### Run the Application Using Maven:
Open a terminal, navigate to the project root directory (jwt_security_v_6.1), and run the following command:

```
mvn spring-boot:run
```

The application will start running at http://localhost:8080.

### Perform the registration:
By doing the registration you get a JWT token with which you can fulfill requests for authenticated users.

![ImageAlt](https://github.com/honeymoneyes/spring_jwt_security_v_6.1/blob/master/src/main/resources/static/register.png)

### Perform the login:
Next, the token has the property that it expires, so you have the ability to renew its expiration date.

![ImageAlt](https://github.com/honeymoneyes/spring_jwt_security_v_6.1/blob/master/src/main/resources/static/login.png)

In this way the token is updated

### Perform authenticated redirection:
Then, having the copied token we add it to the headers and go to the endpoint for authenticated users.

![ImageAlt](https://github.com/honeymoneyes/spring_jwt_security_v_6.1/blob/master/src/main/resources/static/authorization_endpoint.png)
