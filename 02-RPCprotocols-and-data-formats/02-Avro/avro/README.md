2. ***Avro part*** (3 point)
   * In this task, you need to create a Kafka producer and consumer using Avro to serialize messages.
   * Create a simple Kafka producer that sends a simple message to a topic serializing it using Avro.
   * Create a simple Kafka consumer which listens to a topic for a message, deserializes the message, and prints it.
   * Start Kafka, create a topic, and run consumer and producer.
   * Try to use different Avro schemas for serialization and deserialization. Include Avro schema version/id into the massage so a client can understand which schema to use.
#### Solution
##### Project Structure
  * It's a simple project consists of Producer, Consumer and main classes.

#### To run the App
   * First you need to run the docker-compose file to run Kafka server to be able to communicate with Kafka.
   * from main class you need just to execute it.
   * Check in your console for a log message in that pattern;
      * Mar 14, 2023 9:47:15 AM org.avro.Producer produce
      * INFO: Sending Record: Hello
      * Mar 14, 2023 9:47:15 AM org.avro.ConsumerApp consume
      * INFO: Record Value:: {"greet": "Hello", "time": 1678783635417} 
   * In case of the consumer or the producer unabling to communicate with the KAfka, restart the docker compose file, or remove all the images from docker, then re run docker compose
