### Task
#### Separate Data Source Configurations Using Profiles:

* There should be 2 different Data Sources - one for QA and one for DEV.
* Introduce 2 data sources(using @Component and @Profile("QA")/ @Component and @Profile("DEV"))
* Implement test(using @ActiveProfile("DEV")) which tests your application by requesting data from DEV Data Source.

#### Solution
* Done adding 2 componenets to seperate Datasource depending on profiles DEV & TEST
* Done using DEV profile in application.properties for main, and using @ActiveProfile("TEST") annotation for testing.

#### To run the App
* Just build the application, then you have 2 option;
  * Runing the main application check for log info with that pattern for DEV Profile  "========== Initializing DevDataSource ==========".
  * Or Runing the test class then check for log info with that pattern for TEST Profile  "========== Initializing TestDataSource ==========".
