package com.tutorialspoint.smscallsdemo;


import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@SpringBootApplication
public class SmscallsdemoApplication implements ApplicationRunner {
   private final static String ACCOUNT_SID = "";
   private final static String AUTH_ID = "";

   static {
      Twilio.init(ACCOUNT_SID, AUTH_ID);
   }
   public static void main(String[] args) {
      SpringApplication.run(SmscallsdemoApplication.class, args);
   }
   @Override
   public void run(ApplicationArguments arg0) throws Exception {
      Message.creator(new PhoneNumber("to-number"), new PhoneNumber("from-number"),
         "Message from Spring Boot Application").create();

      Call.creator(new PhoneNumber("<to-number>"), new PhoneNumber("<from-number>"),
         new URI("http://demo.twilio.com/docs/voice.xml")).create();
   }
}
