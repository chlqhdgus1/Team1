package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class DeptController {
	
	@Autowired
	private DeptDao dao;
	
	
	@RequestMapping("/")
	public String listDept() {
		String str ="";
		Gson gson = new Gson();
		str = gson.toJson(dao.listAll());
		return str;
	}
}
