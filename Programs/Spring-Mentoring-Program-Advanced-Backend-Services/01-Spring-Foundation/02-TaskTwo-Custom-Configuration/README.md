
### Task
#### Custom Configuration

* Create Custom configuration for data source based on conditional properties:
  * Introduce a configuration(using @Configuration) which should return a data source if an instance of provided interface doesn't exist(@ConditionalOnMissingBean).
  * Add test which tests your application by saving an entity to the data source.

#### Solution
* Done creating spring start configuration to use h2 database if the datasource is missing in runtime.
* Done including the new starter library in the dbconfig project to use the custom starter in case of the datasource is missing.

#### To run the App
* Just build the application, then you have 2 option;
  * Runing the main application check for log info with that pattern for the custom starter "========== Initializing DataSource from DataSourceCustomConfiguration Class ==========" and info for the user responce pattern ::========== User DB ==========:: " + userDb.getUsername()
  * Or runing the test cases 
