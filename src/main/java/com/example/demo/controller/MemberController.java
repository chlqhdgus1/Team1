package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.LoginDao;
import com.example.demo.vo.MemberVo;

@RestController
public class MemberController {

	@Autowired
	private LoginDao dao;
	
   public void setDao(LoginDao dao) {
		this.dao = dao;
	}

@RequestMapping("/login")
   public MemberVo login(HttpServletRequest request,MemberVo m) {
      MemberVo r = dao.login(m);
      if(r != null) {
         System.out.println("로그인 성공");
      }else {
         System.out.println("로그인 실패");
      }
      System.out.println("결과" + r.getName());
      
      return r;
   }   
   
}