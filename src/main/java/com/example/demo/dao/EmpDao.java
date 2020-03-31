package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.Manager;
import com.example.demo.vo.EmpVo;
@Repository

public class EmpDao {
	public static List<EmpVo> listEmp(){
		return Manager.listEmp();
	}
	
	public static EmpVo getEmp(EmpVo e) {
		return Manager.getEmp(e);
	}
	
	public static int insertEmp(EmpVo e) {
		return Manager.insertEmp(e);
	}
	
	public static int updateEmp(EmpVo e) {
		return Manager.updateEmp(e);
	}
	
	public static int deleteEmp(EmpVo e) {
		return Manager.deleteEmp(e);
	}
}
