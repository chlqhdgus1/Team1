package com.example.demo;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.LogDao;
import com.example.demo.vo.LogVo;

@Component
@Aspect
public class LogAop {

	@Pointcut("execution(public *  com.example.demo.controller..*(..))")
	private void loggg() {}

	@Autowired
	private LogDao dao;

	public void setDao(LogDao dao) {
		this.dao = dao;
	}

	
	@After("loggg()")
	public void before(JoinPoint j) {
		
		String methodName = j.getSignature().toShortString();
		HttpServletRequest request = (HttpServletRequest) j.getArgs()[0];
		
		String url = request.getRequestURI();
		String ip = request.getRemoteAddr();
		String time = new Date().toLocaleString();
		LogVo lo = new LogVo();
	
		lo.setUrl(url);
		lo.setIp(ip);
		lo.setTime(time);
		
		dao.insertLog(lo);
	}
}
