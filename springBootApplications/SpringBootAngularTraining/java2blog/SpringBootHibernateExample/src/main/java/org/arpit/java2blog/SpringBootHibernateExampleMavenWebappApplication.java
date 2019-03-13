package org.arpit.java2blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration.class)
public class SpringBootHibernateExampleMavenWebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateExampleMavenWebappApplication.class, args);
	}

}
