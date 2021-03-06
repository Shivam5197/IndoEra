package com.Indoera.ecomProject.Utils.Mail;

import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;


@Repository
public class MailserviceImpl implements MailService {

	private static final Logger LOGGER = LogManager.getLogger(MailserviceImpl.class);


	@Override
	public void sendMail(String emailTo,String userName,List<String> errorList) {

		
		try {
			MailDTO  myMail= new MailDTO();
			String url = "http://localhost:8080/indoUser/setpas";//The URL needs to be Updated here 
			myMail.setMESSAGE("Welcome "+userName+"  on \n  Indoera"
					+ "<hr>"
					+ "Click Here To set your password: " + url);
			
			myMail.setSUBJECT("Welcome to Indoera ");
			myMail.setFROM("sharmaascent3@gmail.com");
			myMail.setPASSWORD("sharma5197");
			//Variable for Gmail
			String HOST = "smtp.gmail.com";
			//Get the System Properties
			Properties properties = System.getProperties();
			properties.put("mail.smtp.host", HOST);
			properties.put("mail.smtp.port", "465");
			properties.put("mail.smtp.ssl.enable", "true");
			properties.put("mail.smtp.auth", "true");
			//Step 1: Get session Object
			Session session =  Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(myMail.getFROM(), myMail.getPASSWORD());
				} 
			});
			session.setDebug(true);
			//Step 2: Compose the Message
			MimeMessage mime = new MimeMessage(session);
			try {
				mime.setFrom(myMail.getFROM());
				mime.addRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
				mime.setSubject(myMail.getSUBJECT());
				mime.setContent(myMail.getMESSAGE(),"text/html");
				Transport.send(mime);
				LOGGER.info("Sent Successfully //////////////////////////////////////////////////");
			} catch (MessagingException e) {
				e.printStackTrace();
			}catch(Exception exe) {
				exe.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorList.add("There is some error at our end!! we are trying to resolve it please try after some time");
		}
	}


}


