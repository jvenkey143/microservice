package com.venkey.service;

import java.util.Date;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	JavaMailSender sender;

	Logger LOG = Logger.getLogger(EmailService.class);

	public void emailSend(String toAddress, String stdName) {
		SimpleMailMessage message = new SimpleMailMessage();
		String text = "Dear  " + stdName
				+ ", \n You are successfully  registerd with this site\n Regards\n Support Team";
		message.setTo(toAddress);
		message.setSubject("Student Reg Confirmation from BOOT App");
		message.setText(text);
		message.setSentDate(new Date());
		try {
			sender.send(message);
			LOG.log(Level.INFO, "Email has been sent successfully");
		} catch (Exception e) {
			LOG.log(Level.ERROR, e.getMessage());
		}
	}
}
