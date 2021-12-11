package com.example.kafaproducer.kafkaservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
	public static final String TOPIC = "users";
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	public void sendMessage(String message) {
		this.kafkaTemplate.send(TOPIC,message);
	}

}
