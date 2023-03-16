# Java-Mentoring-Program-Advanced-Backend-Services
Java Mentoring Program Advanced: Backend Services
## Description
This is the Java Global Mentoring Program: Advanced, which contains a set of modules aimed to cover technical gaps and to enrich the expertise of  senior level engineers in Java technologies stack.
* Program contains of 4 Main Tasks;
## Spring foundation
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
