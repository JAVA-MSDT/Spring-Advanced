# Java-Mentoring-Program-Advanced-Backend-Services
Java Mentoring Program Advanced: Backend Services
## Description
This is the Java Global Mentoring Program: Advanced, which contains a set of modules aimed to cover technical gaps and to enrich the expertise of  senior level engineers in Java technologies stack.
* Program contains of 4 Main Tasks;
## 01 - Spring foundation
### Task 
#### Description
#### Spring Auto Configuration

* Create Basic Spring application which will have Data Source Configuration provided by spring Auto-Configuration:
  * Introduce a configuration(using @Configuration) which should have a method annotated with @Bean which returns a configured data source instance.
  * Use https://mvnrepository.com/artifact/com.h2database/h2 as a Data Source.
  * Add test which tests your application by saving an entity to the data source.
#### Custom Configuration

* Create Custom configuration for data source based on conditional properties:
  * Introduce a configuration(using @Configuration) which should return a data source if an instance of provided interface doesn't exist(@ConditionalOnMissingBean).
  * Add test which tests your application by saving an entity to the data source.
#### Spring Actuator

* Enable actuator by adding https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-actuator dependency. 
* Expose Default Spring Actuator by configuring SecurityWebFilterChain bean. 
* Add a new custom actuator endpoint(using @Component and @Endpoint(id = ...)) and return a custom response. 
** Spring Profiles (optional, should be done when previous items are complete) **

#### Separate Data Source Configurations Using Profiles:

* There should be 2 different Data Sources - one for QA and one for DEV.
* Introduce 2 data sources(using @Component and @Profile("QA")/ @Component and @Profile("DEV"))
* Implement test(using @ActiveProfile("DEV")) which tests your application by requesting data from DEV Data Source.

## 02 - RPC protocols and data formats
### Task 
#### Preparation
  * In the first task, you will need to write a gRPC client in any other language you like, so you probably need to install some dependencies.
  * You need to install Kafka for the second task (or Docker if you want to run it in a container)
1. ***gRPC part*** (2 point) 
   * Create a simple gRPC server application that listens on port 8080 for a request like this (feel free to add more fields)
 { "message": "Ping" }
   * And responses with something like this (feel free to add more fields)
 { "message": "Pong" }
   * Create a simple Java gRPC client application that sends a request to the simple server (share the same proto file), gets a response, and prints it.
   * Create a simple gRPC client application in any other language you like (or ask a trainer/lector for a Python example) that sends a request to the simple server,  gets a response, and prints it. Use the same proto file.
   * Start a server and try to communicate with it using the clients you just wrote.
2. ***Avro part*** (3 point)
   * In this task, you need to create a Kafka producer and consumer using Avro to serialize messages.
   * Create a simple Kafka producer that sends a simple message to a topic serializing it using Avro.
   * Create a simple Kafka consumer which listens to a topic for a message, deserializes the message, and prints it.
   * Start Kafka, create a topic, and run consumer and producer.
   * Try to use different Avro schemas for serialization and deserialization. Include Avro schema version/id into the massage so a client can understand which schema to use.
   
## 03 - Rest API Architecture  
### Task 
#### Description
1. Create maven project with 4 modules :

- jmp-dto - jmp-service-api - jmp-cloud-service-impl - jmp-service-rest

2. Create the fallowing classes under jmp-dto module :

- [User] Long id; String name; String surname; LocalDate birthday; - [Subscription] Long id; User user; LocalDate startDate; - [UserRequestDto] Long id; String name; String surname; String birthday; - [SubscriptionRequestDto] Long id; Long userId; - [UserResponseDto] Long id; String name; String surname; String birthday; - [SubscriptionResponseDto] Long id; Long userId; String startDate;

3. Create UserController under jmp-service-rest module with following methods:

- createUser(UserRequestDto); - updateUser(UserRequestDto); - deleteUser(Long); - getUser(Long); - getAllUser();

4. Use id filed into UserRequestDto only for updating data.

5. Must be returned UserResponseDto from the following methods :

- createUser(UserRequestDto); - updateUser(UserRequestDto); - getUser(Long); - getAllUser();

6. Create ServiceController under jmp-service-rest module with following methods :

- createSubscription(SubscriptionRequestDto); - updateSubscription(SubscriptionRequestDto); - deleteSubscription(Long); - getSubscription(Long); - getAllSubscription();

7. Use id filed into SubscriptionRequestDto only for updating data.

8. Must be returned SubscriptionResponseDto from the following methods :

- createSubscription(SubscriptionRequestDto); - updateSubscription(SubscriptionRequestDto); - getSubscription(Long); - getAllSubscription(); (as list)

9. Add necessary interfaces/methods to jmp-service-api.

10. Implement interfaces/methods under jmp-service-api into jmp-cloud-service-impl.

11. UserController and ServiceController must provide REST API interfaces according to 2nd of REST API maturity.

12. You can use memory structures to store the data (List, Map..).

13. Use jmp-cloud-service-impl to implement UserController and ServiceController.

14. Implement Application class with @SpringBootApplication annotation and main method.

15. Use lambdas and Java 8 features wherever it’s applicable.

16. Make sample requests to UserController and ServiceController, provide screenshots/responses.

(3-4 stars)

17. Use a DB to store the data (List, Map..).

18. Use spring boot data jpa module to access data.

19. Use spring converters to convert :

- UserRequestDto to User - User to UserResponseDto - SubscriptionRequestDto to Subscription - Subscription to SubscriptionResponseDto

20. Document methods in UserController and ServiceController using Swagger 2 annotations.

21. Make sample requests to UserController and ServiceController via Swagger UI, provide screenshots.

(5 stars)

22. Use Java 9 modules wherever it’s applicable.

23. Implement REST APIs according to all Richardson Maturity Level (0 - 3).

24. Make sample requests to UserController and ServiceController, provide screenshots/responses.

## 04 - Authentication-Authorization  
### Task 
#### Description
##### Necessary Tools

* Java Development Kit 11+
* Apache Maven 3.6.0+
* Git 2.24+
* Spring 5
* Spring Boot 2+

##### Task

(1 star)

1. Create Spring Boot MVC project.

2. Create REST endpoint "GET /info" that provide random stats (ex: "MVC application"). Test this endpoint.

3. Add Spring Security module to your project and configure it for authenticated access to all resources. Use email/password combination for it.

(2 starts)

4. Use a non-embedded DB to store users.

5. Use salt and hashing to store user passwords.

6. Create additional REST endpoint "GET /about" and configure non-authenticated access to it.

(3-4 starts)

7. Create one more REST endpoint "GET /admin".

8. Now you need to add authorised access to "GET /info" and "GET /admin", add "VIEW_INFO", "VIEW_ADMIN" permissions for it. Create 3 users with different combination of permissions.

9. Create new Login/Logout pages and configure Spring Security to use new Login/Logout.

10. Add Brute Force protector. BLock user email for 5 minute on 3 unsuccessful login.

11. Create an endpoint to show blocked users

(5 start)

12. Implement a new Spring Boot MVC application called "Secret providers". Application should provide page with text form. After sending a secret, application must generate uniq link address, to provide one-time access to secret information. After this information must be removed from application.

13. User (sender and recipient) must be authorized and have "STANDARD" permission.

14. Use docker containers to implement solution.

