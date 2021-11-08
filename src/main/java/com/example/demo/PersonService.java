package com.example.demo;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PersonService {

	@Autowired
	private PersonRepository repo;
	
	@Autowired
	private KafkaTemplate<String, Object> kafka;

	@Transactional
	public void createPersonAndSend() {
		Person p = new Person();
		p.setId(UUID.randomUUID());
		p.setName("foo");
		repo.save(p);
		log.info("kafka.send {}", p.getId());
		kafka.send("personTopic", "person created: " + p.getId().toString());
	}
}

