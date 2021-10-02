package com.Indoera.ecomProject.Utils.Mail;

import java.util.List;

public interface MailService {

	public void sendMail(String emailTo,String userName,List<String> errorList);
	
}
