package com.tutorialspoint.sleuthapp;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SleuthappApplication {
   private static final Logger LOG = Logger.getLogger(SleuthappApplication.class.getName());
   public static void main(String[] args) {
      SpringApplication.run(SleuthappApplication.class, args);
   }
   @RequestMapping("/")
   public String index() {
      LOG.log(Level.INFO, "Index API is calling");
      return "Welcome Sleuth!";
   }
}