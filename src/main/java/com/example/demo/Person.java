package com.example.demo;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Person {

	@Id
	private UUID id;
	
	@Column
	private String name;

}
