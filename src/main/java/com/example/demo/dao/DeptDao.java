package com.example.demo.dao;

import java.util.List;

import com.example.demo.db.Manager;
import com.example.demo.vo.DeptVo;

public class DeptDao {
	public List<DeptVo> listDept(){
		return Manager.listDept();
	}
	
	public static int insertDept(DeptVo d) {
		return Manager.insertDept(d);
	}
}
