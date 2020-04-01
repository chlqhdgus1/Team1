package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.Manager;
import com.example.demo.vo.LogVo;

@Repository
public class LogDao {
	
	public List<LogVo> listLog(){
		return Manager.listLog();
	}
	
	public int insertLog(LogVo lo) {
		return Manager.insertLog(lo);
	}
}
