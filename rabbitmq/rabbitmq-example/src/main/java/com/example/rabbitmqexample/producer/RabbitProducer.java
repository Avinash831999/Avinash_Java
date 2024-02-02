package com.example.rabbitmqexample.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitProducer {
	
	@Value("${rabbitmq.exchange.name}")
	private String exchange_name;
	
	@Value("${rabbitmq.queue.name}")
	private String queue_name;
	
	@Value("${rabbitmq.routing.key}")
	private String routing_key;
	
	@Value("${rabbitmq.queue.name}")
	private String json_queue_name;
	
	@Value("${rabbitmq.routing.key}")
	private String json_routing_key;
	
	private RabbitTemplate rabbitTemplate;
	
	private RabbitProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate =rabbitTemplate;
	}
	
	private static final Logger logger = LoggerFactory.getLogger(RabbitProducer.class);
	
	public void messageProduce(String message) {
		this.rabbitTemplate.convertAndSend(exchange_name, routing_key, message);;
		logger.info("Message Sent");
		
	}
	
//	public void JsonMessageProduce(Object message) {
//		this.rabbitTemplate.convertAndSend(exchange_name, json_routing_key, message);;
//		logger.info("Json Message Sent ",message);
//		
//	}
	
}