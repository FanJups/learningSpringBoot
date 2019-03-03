package com.tutorialspoint.emailapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Properties;

import java.io.IOException;



import javax.mail.internet.*;

//import javax.mail.internet.AddressException;





import javax.mail.*;

import java.util.*;



@RestController
public class EmailController {
   @RequestMapping(value = "/sendemail")
   public String sendEmail() throws AddressException , MessagingException , IOException {
   	  sendmail();
      return "Email sent successfully";
   }   


   private void sendmail() throws AddressException , MessagingException , IOException {

   

   			   Properties props = new Properties();
			   props.put("mail.smtp.auth", "true");
			   props.put("mail.smtp.starttls.enable", "true");
			   props.put("mail.smtp.host", "smtp.gmail.com");
			   props.put("mail.smtp.port", "587");
			   
			   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			      protected PasswordAuthentication getPasswordAuthentication() {
			         return new PasswordAuthentication("jupsfan@gmail.com", "04102012csepSCP4HWCGOOGLE");
			      }
			   });
			   Message msg = new MimeMessage(session);
			   msg.setFrom(new InternetAddress("jupsfan@gmail.com", false));

			   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("jupsfan@gmail.com"));
			   msg.setSubject("Tutorials point email");
			   msg.setContent("Tutorials point email", "text/html");
			   msg.setSentDate(new Date());

			   MimeBodyPart messageBodyPart = new MimeBodyPart();
			   messageBodyPart.setContent("Tutorials point email", "text/html");

			   Multipart multipart = new MimeMultipart();
			   multipart.addBodyPart(messageBodyPart);
			   //MimeBodyPart attachPart = new MimeBodyPart();

			   //attachPart.attachFile("/var/tmp/image19.png");
			   //multipart.addBodyPart(attachPart);
			   msg.setContent(multipart);
			   Transport.send(msg);   

			
}

}