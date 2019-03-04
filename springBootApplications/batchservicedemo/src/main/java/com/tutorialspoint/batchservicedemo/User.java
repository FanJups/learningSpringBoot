package com.tutorialspoint.batchservicedemo;
public class User {
   private String lastName;
   private String firstName;

   public User() {
   }
   public User(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
   }
   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }
   public String getFirstName() {
      return firstName;
   }
   public String getLastName() {
      return lastName;
   }
   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   @Override
   public String toString() {
      return "firstName: " + firstName + ", lastName: " + lastName;
   }   
}