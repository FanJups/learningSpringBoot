
package com.example.configclient;

import org.springframework.beans.factory.annotation.Value;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

public class ConfigclientApplication {
   

   
   public static void main(String[] args) {
      SpringApplication.run(ConfigclientApplication.class, args);
   }
   

   @RestController
    @RefreshScope
    class ExampleController {

         @Value("${welcome.message}")
         String welcomeText;
         @Value("${changebyrefreshing.message}")
         String changeText;

        @RequestMapping(value = "/")
        public String Text() {

            StringBuilder builder = new StringBuilder();

            builder.append(" Welcome message property - ").append(welcomeText)
            .append(" || ")
            .append("change refresh property - ").append(changeText);

            return builder.toString();
        }
    }

   /*/refresh endpoint only refreshes those properties annotated with @ConfigurationProperties means 
   it does not refresh those properties which are initialized during app initialization.*/


}

