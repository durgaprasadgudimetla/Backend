package com.example.kafaproducer.kafkacontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafaproducer.kafkaservice.ProducerService;

@RestController
@RequestMapping(value = "/kafka")
public class kafkacontroller {
	private final ProducerService producerService;
	@Autowired
	public kafkacontroller(ProducerService service) {
		this.producerService =service;
	}
	
	@PostMapping(value = "/publish")
	public void sendMsgToKafkaTopic(@RequestParam("message") String message) {
		producerService.sendMessage(message);
	}
}
