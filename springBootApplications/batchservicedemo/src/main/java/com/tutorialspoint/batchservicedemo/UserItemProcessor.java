package com.tutorialspoint.batchservicedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class UserItemProcessor implements ItemProcessor<User, User> {
   private static final Logger log = LoggerFactory.getLogger(UserItemProcessor.class);

   @Override
   public User process(final User user) throws Exception {
      final String firstName = user.getFirstName().toUpperCase();
      final String lastName = user.getLastName().toUpperCase();
      final User transformedPerson = new User(firstName, lastName);

      log.info("Converting (" + user + ") into (" + transformedPerson + ")");
      return transformedPerson;
   }
}