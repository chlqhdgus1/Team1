package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmpDao;
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
	@RequestMapping(value = "/insertEmp")
	public String insertEmp(HttpServletRequest request,EmpVo e) {
		String str = "ok";
		dao.insertEmp(e);
		return str;
	}

	// 사원목록
	@RequestMapping(value = "/listEmp", produces = "application/json;charset=UTF-8")
	public String listEmp(HttpServletRequest request) {
		String str ="";
		List<EmpVo> list = dao.listEmp();
		Gson gson = new Gson();
		str = gson.toJson(list);
		return str;
	}
	
	//상세보기 
	@RequestMapping(value = "/getEmp", produces = "application/json;charset=UTF-8")
	public String getEmp( HttpServletRequest request,EmpVo e) {
		String str = "";
		Gson gson = new Gson();
		str = gson.toJson(dao.getEmp(e));
		return str;
	}

	// 사원삭제
	@RequestMapping(value = "/deleteEmp", produces = "application/json;charset=UTF-8")
	public String deleteEmp( HttpServletRequest request,EmpVo e) {
		String str = "";
		Gson gson = new Gson();
		str = gson.toJson(dao.deleteEmp(e));
		return str;
	}

	// 사원수정
	@RequestMapping(value = "/updateEmp", produces = "application/json;charset=UTF-8")
	public String updateEmp(HttpServletRequest request,EmpVo e) {
		String str = "";
		Gson gson = new Gson();
		str = gson.toJson(dao.updateEmp(e));
		return str;
	}
}
