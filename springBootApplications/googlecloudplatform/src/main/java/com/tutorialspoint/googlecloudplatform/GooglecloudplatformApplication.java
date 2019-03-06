package com.tutorialspoint.googlecloudplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GooglecloudplatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(GooglecloudplatformApplication.class, args);
	}
	@RequestMapping(value = "/")
   public String success() {
      return "APP Engine deployment success";
   }

}
