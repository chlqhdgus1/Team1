package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.DeptDao;
import com.example.demo.vo.DeptVo;
import com.google.gson.Gson;

@RestController
public class DeptController {
	
	@Autowired
	private DeptDao dao;

	public void setDao(DeptDao dao) {
		this.dao = dao;
	}

	//부서등록
	@RequestMapping(value = "/insertDept")
	public String insertDept(HttpServletRequest request,DeptVo d) {
		String str ="ok";
		dao.insertDept(d);
		return str; 
	} 
	
	//부서목록
	@RequestMapping(value = "/listDept" , produces ="application/json;charset=UTF-8")
	public String listDept(HttpServletRequest request) {
		String str ="";
		List<DeptVo> list = dao.listDept();
		Gson gson = new Gson();
		str = gson.toJson(list);
		return str;
	}
}
