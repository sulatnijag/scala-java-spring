package com.explore.scalajavaspring.service;

import com.explore.scalajavaspring.entity.Customer;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Service;


import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

@Service
@Slf4j
public class KafkaConsumerService {
    private final static String BOOTSTRAP_SERVERS = "localhost:9092";
    private final static String TOPIC = "customer-avro";
    private KafkaConsumer<String, GenericRecord> consumer;
    private final static String grp_id="third_app";
    private final static String SCHEMA_REGISTRY_URL = "http://localhost:8081";

    public KafkaConsumerService() {
        Properties config = new Properties();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        config.put("schema.registry.url", SCHEMA_REGISTRY_URL);
        config.put(ConsumerConfig.CLIENT_ID_CONFIG, "KafkaExampleProducer");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, grp_id);


        consumer = new KafkaConsumer<>(config);

        consumer.subscribe(Arrays.asList(TOPIC));
    }

    public void pollMessages() {
        ConsumerRecords<String, GenericRecord> records=consumer.poll(1000);
        for(ConsumerRecord<String, GenericRecord> record: records){
            log.info("Key: "+ record.key() + ", Firstname:" + record.value().toString());
            log.info("Partition:" + record.partition()+",Offset:"+record.offset());
        }
    }



}
