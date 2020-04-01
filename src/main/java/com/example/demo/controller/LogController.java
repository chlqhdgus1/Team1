package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.LogDao;
import com.example.demo.vo.LogVo;
import com.google.gson.Gson;

@RestController
public class LogController {
	@Autowired
	private LogDao dao;

	public void setDao(LogDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value = "/listLog" , produces ="application/json;charset=UTF-8")
	public String listLog(HttpServletRequest request) {
		String str ="";
		List<LogVo> list = dao.listLog();
		Gson gson = new Gson();
		str = gson.toJson(list);
		return str;
	}
	
//	@RequestMapping(value = "/insertLog" , produces ="application/json;charset=UTF-8")
//	public String insertLog(LogVo lo) {
//		String str ="";
//		Gson gson = new Gson();
//		str = gson.toJson(dao.insertLog(lo));
//		return str;
//	}
}
