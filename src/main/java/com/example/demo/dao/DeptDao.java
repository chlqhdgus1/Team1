package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.Manager;
import com.example.demo.vo.DeptVo;
@Repository
public class DeptDao {
	public List<DeptVo> listDept(){
		return Manager.listDept();
	}
	
	public static int insertDept(DeptVo d) {
		return Manager.insertDept(d);
	}
}
