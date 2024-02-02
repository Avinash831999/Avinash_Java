package com.example.rabbitmqconsumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitConsumer {
	
	private static final Logger logger = LoggerFactory.getLogger(RabbitConsumer.class); 
	
	@RabbitListener(queues = {"${rabbitmq.queue.name}"})
	public void consumeMesage(String message) {
		logger.info("Received Messages ", message);;
	}
	
	@RabbitListener(queues = {"${rabbitmq.json.queue.name}"})
	public void consumeJsonMesage(Object message) {
		logger.info("Received Json Messages ", message.toString());;
	}
}
