package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmpDao;
import com.example.demo.vo.DeptVo;
import com.example.demo.vo.EmpVo;
import com.google.gson.Gson;

@RestController
public class EmpController {

	@Autowired
	private EmpDao dao;

	public void setDao(EmpDao dao) {
		this.dao = dao;
	}

	// 사원등록
	@RequestMapping(value = "/insertEmp", produces = "application/json;charset=UTF-8")
	public String insertEmp(EmpVo e) {
		String str = "";
		Gson gson = new Gson();
		str = gson.toJson(dao.insertEmp(e));
		return str;
	}

	// 사원목록
	@RequestMapping(value = "/listEmp", produces = "application/json;charset=UTF-8")
	public String listEmp() {
		String str ="";
		List<EmpVo> list = dao.listEmp();
		Gson gson = new Gson();
		str = gson.toJson(list);
		return str;
	}
	
	//상세보기 
	@RequestMapping(value = "/getEmp", produces = "application/json;charset=UTF-8")
	public String getEmp(EmpVo e) {
		String str = "";
		Gson gson = new Gson();
		str = gson.toJson(dao.getEmp(e));
		return str;
	}

	// 사원삭제
	@RequestMapping(value = "/deleteEmp", produces = "application/json;charset=UTF-8")
	public String deleteEmp(EmpVo e) {
		String str = "";
		Gson gson = new Gson();
		str = gson.toJson(dao.deleteEmp(e));
		return str;
	}

	// 사원수정
	@RequestMapping(value = "/updateEmp", produces = "application/json;charset=UTF-8")
	public String updateEmp(EmpVo e) {
		String str = "";
		Gson gson = new Gson();
		str = gson.toJson(dao.updateEmp(e));
		return str;
	}
}
