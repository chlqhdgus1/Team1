package com.example.demo.controller;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.Manager;
import com.example.demo.vo.EmpVo;

import lombok.Data;

@RestController
public class EmailController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Scheduled(cron = "0 0 12 1 * *")
	public void pro() {
		
		List<EmpVo> list = Manager.listEmp();
				
		for(EmpVo e : list) {
			sendMail(e);
		}
	}
	
	@RequestMapping("/mail.do")
	public void sendMail(EmpVo e) {	
		mailSender.send(new MimeMessagePreparator() {
			  
			
			public void prepare(MimeMessage mimeMessage) throws MessagingException {
				String content = "<h2>"+"안녕하세요"+e.getEname()+"님의 월급은"+e.getSal() +"입니다.문의 사항은 chlqhdgus1@naver.com 으로 부탁드립니다.</h2>";
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			     message.setFrom("chlqhdgus1@gmail.com");
			     message.setTo(e.getEmail());
			     message.setSubject("급여명세");
			     content += "<img src ='cid:egg'>";
			     message.setText(content, true);
			     message.addInline("egg", new ClassPathResource("static/egg.jpg"));
			     message.addAttachment("mail.html", new ClassPathResource("static/mail.html"));
			
			   };
		});
	}
}
