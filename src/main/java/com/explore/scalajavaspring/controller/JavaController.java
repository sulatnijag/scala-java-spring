package com.explore.scalajavaspring.controller;

import com.explore.scalajavaspring.service.KafkaConsumerService;
import com.explore.scalajavaspring.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class JavaController {

    @Autowired
    KafkaProducerService kafkaProducerService;

    @Autowired
    KafkaConsumerService kafkaConsumerService;

    @GetMapping("/")
    public String index() {

        return "Greetings from Spring Boot! ";
    }

    @GetMapping("/sendMessage")
    public String sendMessage() {
        try {
            kafkaProducerService.sendMessage();
            return "Message Sent";
        } catch (ExecutionException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }


    @GetMapping("/pollMessages")
    public String pollMessages() {
        try {
            kafkaConsumerService.pollMessages();
            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed";
        }
    }

}
