package com.websystique.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration.class)
public class SpringBootCrudApplicationExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudApplicationExampleApplication.class, args);
	}

}
