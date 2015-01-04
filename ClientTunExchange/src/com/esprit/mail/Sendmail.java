package com.esprit.mail;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class Sendmail {
	public Sendmail() {
		super();
	}

	public boolean Sendmailresult(final String to, final String subject,final String text) {
		
	Properties props = new Properties();
	 props.put("mail.smtp.host", "smtp.gmail.com");
	 props.put("mail.smtp.socketFactory.port", "587");
	 props.put("mail.smtp.socketFactory.class", "javax.net.SocketFactory");
	 props.put("mail.smtp.auth", "true");
	 props.put("mail.smtp.port", "587");
	 props.put("mail.smtp.ssl.enable", "false");
	 props.put("mail.smtp.starttls.enable", "true");
	 props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

       Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
           protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication("tunexchangeesprit@gmail.com", "25096748");
           }
         });
       
       try {
      
           Message message = new MimeMessage(session);
           message.setFrom(new InternetAddress("tunexchangeesprit@gmail.com"));
           message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
           message.setSubject(subject);
           message.setText(text);

           Transport.send(message);
           return true;
       } 

       catch (MessagingException x) 
       {
    	   return false;
       }
   
}

}
