package com.explore.scalajavaspring;

import com.explore.scalajavaspring.service.KafkaProducerService;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@SpringBootApplication
public class ScalaJavaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScalaJavaSpringApplication.class, args);
	}



}
