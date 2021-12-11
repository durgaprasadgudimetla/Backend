package com.example.kafaproducer.kafkaservice;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class ConsumerService1 {

	@KafkaListener(topics = "users",groupId = "group_id1")
	public void consume(String message) {
		System.out.println("ConsumerService1::"+message);
	}
}
