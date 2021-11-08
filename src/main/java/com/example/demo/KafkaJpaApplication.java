package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class KafkaJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(KafkaJpaApplication.class, args);
		PersonService service = ctx.getBean(PersonService.class);
		while (true) {
			service.createPersonAndSend();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
