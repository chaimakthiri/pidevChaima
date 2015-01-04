package com.esprit.pidev.crud;

import java.util.List;
import java.util.Properties;

import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.pidev.jpa.Claims;
import com.esprit.pidev.jpa.ResponseClaims;

/**
 * Session Bean implementation class ManageClaims
 */
@Stateless
public class ManageClaims implements ManageClaimsRemote, ManageClaimsLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	private EntityManager em;
    public ManageClaims() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void add(Claims c) {
		em.persist(c);
		
	}

	@Override
	public void update(Claims c) {
		em.merge(c);
		
	}

	@Override
	public Claims getClaimsbyid(int idClaims) {


		return em.find(Claims.class, idClaims);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Claims> getallClaims() {
		return em.createQuery("SELECT c FROM Claims c").getResultList();
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Claims> getnotresponse() {
		return em.createQuery("SELECT c FROM Claims c WHERE c.etat=FALSE").getResultList();
	}

	@Override
	public String getnbClaims() {
		return (String) em.createQuery("SELECT count(c) FROM Claims c where c.etat=false").getSingleResult().toString();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Claims> findclaimbyname(String name) {
		return em.createQuery("SELECT c FROM Claims c WHERE  name like :nm").setParameter("nm","%"+name+"%").getResultList();
	}

	@Override
	public Claims reportClaims(String content, String email,
			String subject) {
		Claims c = new Claims();
		c.setContent(content);
		c.setEmail(email);
		c.setSubject(subject);
		
		em.persist(c);
		return c;
	}

	@Override
	public void Delete(int id) {
		em.remove(getClaimsbyid(id));
		
	}

	@Override
	public void Sendmailresult(String to, String subject, String text) {
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
	           
	       } 

	       catch (MessagingException x) 
	       {
	    	   
	       }
	   
	}

	@Override
	public ResponseClaims getResponse(int idClaimss) {
		 return (ResponseClaims) em.createNamedQuery("findResponse").setParameter("id", idClaimss).getSingleResult();
	}

	
	
	

	

}
