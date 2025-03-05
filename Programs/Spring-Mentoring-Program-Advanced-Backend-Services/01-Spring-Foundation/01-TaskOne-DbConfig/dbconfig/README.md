### Task 
#### Description

* Create Basic Spring application which will have Data Source Configuration provided by spring Auto-Configuration:
  * Introduce a configuration(using @Configuration) which should have a method annotated with @Bean which returns a configured data source instance.
  * Use https://mvnrepository.com/artifact/com.h2database/h2 as a Data Source.
  * Add test which tests your application by saving an entity to the data source.

#### Solution
* Done adding h2 configuration class using @Configuration annotation for h2 database
* Done writing test case for user class.

#### To run the App
* Just build the application, then you have 2 option;
  * Runing the main application check for log info with that pattern ::========== User DB ==========:: " + userDb.getUsername()
  * Or runing the test cases
