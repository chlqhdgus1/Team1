package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class DeptController {
	
	@Autowired
	private DeptDao dao;
	
	
	//부서등록
	@RequestMapping(value = "/insertDept" , produces ="application/json;charset=UTF-8")
	public String insertDept() {
		String str ="";
		Gson gson = new Gson();
		str = gson.toJson(dao.insert());
		return str;
	}
	
	//부서목록
	@RequestMapping(value = "/listDept" , produces ="application/json;charset=UTF-8")
	public String listDept() {
		String str ="";
		Gson gson = new Gson();
		str = gson.toJson(dao.listAll());
		return str;
	}
}
