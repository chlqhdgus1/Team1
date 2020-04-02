package com.example.demo.controller;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Scheduled;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.Manager;
import com.example.demo.vo.EmpVo;


@RestController
public class EmailController {
   
   @Autowired
private JavaMailSender mailSender;
	
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}    

	@Scheduled(cron = "00 01 17 * * *")
	public void pro() {
		
		List<EmpVo> list = Manager.listEmp();
				  
		for(EmpVo e : list) {
			sendMail(e);
		}
	}

	public void sendMail(EmpVo e) {	
		mailSender.send(new MimeMessagePreparator() {
			  
			
			public void prepare(MimeMessage mimeMessage) throws MessagingException {
				String content = "<h2>"+"안녕하세요"+e.getEname()+"님의 월급은"+e.getSal() +"입니다.문의 사항은 x..</h2>";
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			     message.setFrom("chlqhdgus1@gmail.com");
			     message.setTo(e.getEmail());
			     message.setSubject("급여명세");
			     content += "<img src ='cid:egg'>";
			     message.setText(content, true);
			     message.addInline("egg", new ClassPathResource("static/egg.jpg"));
			    //message.addAttachment("NewFile2.html", new ClassPathResource("static/NewFile2.html"));
			
			   };
		});
	}
}