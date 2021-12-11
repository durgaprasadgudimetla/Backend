package com.example.kafaproducer.kafkaservice;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

	@KafkaListener(topics = "users",groupId = "group_id")
	public void consume(String message) {
		System.out.println("ConsumerService::"+message);
	}

}
