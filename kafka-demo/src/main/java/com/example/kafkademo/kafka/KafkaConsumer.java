package com.example.kafkademo.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "course",groupId = "my_consumer")
    public void listen(String message){
        System.out.println("Message: " + message);
    }
}
