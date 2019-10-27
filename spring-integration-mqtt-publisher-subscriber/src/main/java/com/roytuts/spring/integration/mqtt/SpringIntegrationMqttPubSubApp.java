package com.roytuts.spring.integration.mqtt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.roytuts.spring.integration.mqtt.service.MessagingService;

@SpringBootApplication(scanBasePackages = "com.roytuts.spring.integration.mqtt")
public class SpringIntegrationMqttPubSubApp implements CommandLineRunner {

	@Autowired
	private MessagingService messagingService;

	@Autowired
	private ConfigurableApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationMqttPubSubApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		final String topic = "roytuts/topic/event";

		messagingService.subscribe(topic);

		messagingService.publish(topic, "Hi\nThis is a sample message published to topic roytuts/topic/event", 0, true);

		context.close();
	}

}
