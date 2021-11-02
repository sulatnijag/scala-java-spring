package com.explore.scalajavaspring.service;

import com.explore.scalajavaspring.entity.Customer;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Service;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
public class KafkaProducerService {

    private final static String BOOTSTRAP_SERVERS = "localhost:9092";
    private final static String TOPIC = "customer-avro";
    private Producer<String, Customer> producer;

    public KafkaProducerService() {
        producer = createProducer();
    }


    public Producer<String, Customer> createProducer() {
        Properties config = new Properties();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        config.put(ProducerConfig.CLIENT_ID_CONFIG, "KafkaExampleProducer");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        config.put("schema.registry.url", "http://localhost:8081");
        config.put(ProducerConfig.ACKS_CONFIG, "1");
        config.put(ProducerConfig.RETRIES_CONFIG, "10");

        return new KafkaProducer<String, Customer>(config);

    }

    public void sendMessage() throws ExecutionException, InterruptedException {

        long time = System.currentTimeMillis();


        Customer customer = Customer.newBuilder()
                .setFirstName("Jag")
                .setLastName("Gagarin")
                .setAge(10)
                .setHeight(179.0f)
                .setWeight(85f)
                .setAutomatedEmail(false)
                .build();


        final ProducerRecord<String, Customer> record = new ProducerRecord<String, Customer>(
                TOPIC, customer
        );

        producer.send(record, new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception exception) {
                if (exception==null) {
                    log.info("Message Sent");
                    log.info(metadata.toString());
                } else {
                    exception.printStackTrace();
                }
            }
        });

        producer.flush();
        //producer.close();






    }

}
