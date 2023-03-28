# Authentication-Authorization
Authentication and Authorization Using Spring Security

## Description
### Necessary Tools

* Java Development Kit 11+
* Apache Maven 3.6.0+
* Git 2.24+
* Spring 5
* Spring Boot 2+

### Task

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

### Solution
 * Done implementing till point 11, then point 14.
 * Docker compose file contains 2 images, one for PostgreSql and the second for PG-Admin.
 * You can ccess the PG-Admin using localhost:5431 url, **Login**: admin@admin.com, **password**: admin
 * The app is Web MVC not rest, so you wcan after access the front-end part using the localhost:8080 to interact with the application
 * Using flyway migration DB will be populated  with the nesseccury records to test the project, check migration folder under resources/db/migration
 * Some of the url are admin access only, some are public and some for user view role, check the java security configuration file for details.
 * After few attempts to login the user will be blocked, so to unblock it, Admin access required to the localhost:8080/blocked url to see who is blocked and to unblock it as well.
 
   
### Running the app
 * For first time you need to run mvn clean install from the project root where is the pom.xml file under rest folder exicts, using command line or maven pugin in your idea.
 * Run Docker compose file under security/docker folder to start the DB before starting the application.
 * Run the application from the java class SecurityApplication.java.
 * Browse to localhost:8080 then you can experiment with the application.

   
   
