package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class EmpController {

	@Autowired
	private EmpDao dao;
	
	//세터 만들기 

	// 사원등록
	@RequestMapping(value = "/insertEmp", produces = "application/json;charset=UTF-8")
	public String insertEmp() {
		String str = "";
		Gson gson = new Gson();
		str = gson.toJson(dao.insert());
		return str;
	}

	// 사원목록
	@RequestMapping(value = "/listEmp", produces = "application/json;charset=UTF-8")
	public String listEmp() {
		String str = "";
		Gson gson = new Gson();
		str = gson.toJson(dao.listEmp());
		return str;
	}

	// 사원삭제
	@RequestMapping(value = "/deleteEmp", produces = "application/json;charset=UTF-8")
	public String deleteEmp() {
		String str = "";
		Gson gson = new Gson();
		str = gson.toJson(dao.delete());
		return str;
	}

	// 사원수정
	@RequestMapping(value = "/updateEmp", produces = "application/json;charset=UTF-8")
	public String updateEmp() {
		String str = "";
		Gson gson = new Gson();
		str = gson.toJson(dao.update());
		return str;
	}
}
