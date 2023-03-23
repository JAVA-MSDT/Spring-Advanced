### Task
#### Spring Actuator

* Enable actuator by adding https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-actuator dependency. 
* Expose Default Spring Actuator by configuring SecurityWebFilterChain bean. 
* Add a new custom actuator endpoint(using @Component and @Endpoint(id = ...)) and return a custom response. 

#### Solution
* Done adding spring boot actuator
* Done wposing the actuator under security configuration by extending WebSecurityConfigurerAdapter, then open Health endpoint to public, but should be admin authorized rule to access the rest of end points.
* Done adding custom endpoint by the name "externalDbHealth" to desplay if the db is working or down.

#### To run the App
* Run the application in local host using port 8080
* append /actuator endpoint to the localhost url, you will not get access to the ctuator, so you need to be admin rule usie the following credentials;
  * username: admin
  * password: admin
* After loging in you can access the endpoint which permited by the application.properties file
*  you can check the costum endpoint by appending this url /actuator/externalDbHealth to your localhost base url.   
