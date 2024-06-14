package com.example.restproject.controller;

import com.example.restproject.Kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final KafkaProducer kafkaProducer;
    @PostMapping("/kafka/send")
    @ResponseStatus(HttpStatus.CREATED)
    public String send(@RequestBody String message){
        kafkaProducer.sendMessage(message);

        return "success";
    }
}
