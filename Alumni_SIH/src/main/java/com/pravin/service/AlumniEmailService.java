package com.pravin.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class AlumniEmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String fromEmailId;
	
	public String sendEmail(String emailSubject,String emailBody,String[] toEmails) throws Exception{
		
		//Create MimeMessage Object
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		
		//creating object for MimeMessageHelper class
		MimeMessageHelper mimehelper = new MimeMessageHelper(mimeMessage, true);
		//setting the properties
		mimehelper.setFrom(fromEmailId);
		mimehelper.setTo(toEmails);
		mimehelper.setSubject(emailSubject);
		mimehelper.setSentDate(new Date());
		mimehelper.setText(emailBody);
		mimehelper.addAttachment("equlance.pdf", new FileSystemResource("C:\\Users\\pravi\\Desktop\\equlance.pdf"));
		
		//sending email
		javaMailSender.send(mimeMessage);
		
		return "Mail Sent Successfully";
	}

}
