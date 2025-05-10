package org.kafka;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class SimpleProducer {
    public static void main(String[] args) {
        String topicName = "my-topic";

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        int i=0;
                for( ;i<5;i++) {
        ProducerRecord<String, String> record = new ProducerRecord<>(topicName, "Hello from  allow me to enter!"+" its "+ i +"th time");
                    producer.send(record, (metadata, exception) -> {
            if (exception == null) {
                    System.out.println("Sent message to topic: " + metadata.topic());
            } else {
                exception.printStackTrace();
            }
        });
                }

        producer.close();
    }
}
