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

       - Introduce a configuration(using @Configuration) which should have a method annotated with @Bean which returns a configured data source instance.
       - Use https://mvnrepository.com/artifact/com.h2database/h2 as a Data Source.
       - Add test which tests your application by saving an entity to the data source.
#### Custom Configuration

* Create Custom configuration for data source based on conditional properties:

       - Introduce a configuration(using @Configuration) which should return a data source if an instance of provided interface doesn't exist(@ConditionalOnMissingBean).
       - Add test which tests your application by saving an entity to the data source.
#### Spring Actuator

* Enable actuator by adding https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-actuator dependency. 
* Expose Default Spring Actuator by configuring SecurityWebFilterChain bean. 
* Add a new custom actuator endpoint(using @Component and @Endpoint(id = ...)) and return a custom response. 
** Spring Profiles (optional, should be done when previous items are complete) **

#### Separate Data Source Configurations Using Profiles:

* There should be 2 different Data Sources - one for QA and one for DEV.
* Introduce 2 data sources(using @Component and @Profile("QA")/ @Component and @Profile("DEV"))
* Implement test(using @ActiveProfile("DEV")) which tests your application by requesting data from DEV Data Source.

