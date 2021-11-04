# Kafka Events Producer and Consumer

**Description :**

**1. **KafkaSwipeProducer Service****
  - Captures Employees swipe in/swipe out details for every 30 seconds and send it for Kafka
  - While sending the data to Kakfa, it serializes the data to Avro format

**2. KafkaSwipeConsumer Service**
  - Listens to the Kafka topic where the employees swipe events are captured and fetches the messages
  - While receiving the data, it deserializes the data from Avro to POJO format
  - Then it stores the data into MongoDB 
  - When post swipe event api is invoked for storing the event manually, it checks for the duplicate entries and overwrite the entries based on Employee number and Swipe Event.
  - Exposes API for getting all the employee swipe events
  - Exposes API for getting one specific employee swipe events

**3. PojoToAvro and AvroToPojo Service**
  - Converts the Pojo model to Avro format which can be referred in serializer and deserializer classes implementation


**Technical Details**

1. Microservices - Springboot 2.5.6 & JAVA 8
2. Documentation - Swagger - 2.10.0
3. Containerization - Docker 4.1.1
4. Database - MongoDB 4.4
5. Event Streaming - Kafka



