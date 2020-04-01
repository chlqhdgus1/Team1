package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.DeptVo;
import com.example.demo.vo.EmpVo;
import com.example.demo.vo.LogVo;


public class Manager {
	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/example/demo/db/sqlConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public static int insertLog(LogVo lo) {
		int re =  -1;
		SqlSession session = factory.openSession();
		re= session.insert("log.insertLog",lo);
		session.commit();
		session.close();
		return re;
	}
	
	public static List<LogVo> listLog(){
		SqlSession session = factory.openSession();
		List<LogVo> list = session.selectList("log.selectLog");
		session.close();
		return list;
	} 
	
	public static List<EmpVo> listEmp(){
		SqlSession session = factory.openSession();
		List<EmpVo> list = session.selectList("emp.selectAll");
		session.close();
		return list;
	}
	
	public static EmpVo getEmp(EmpVo e) {
		EmpVo r = null;
		SqlSession session = factory.openSession();
		r = session.selectOne("emp.detail", e);
		session.close();
		return r;
	}
	
	public static int insertEmp(EmpVo e) {
		int re =  -1;
		SqlSession session = factory.openSession();
		re= session.insert("emp.insert",e);
		session.commit();
		session.close();
		return re;
	}
	public static int updateEmp(EmpVo e) {
		int re = -1;
		SqlSession session = factory.openSession();
		re =session.update("emp.update",e);
		session.commit();
		session.close();
		return re;		
	}
	public static int deleteEmp(EmpVo e) {
		int re = -1;
		SqlSession session = factory.openSession();
		re =session.delete("emp.delete",e);
		session.commit();
		session.close();
		return re;		
	}
	
	public static List<DeptVo> listDept(){
		SqlSession session = factory.openSession();
		List<DeptVo> list = session.selectList("dept.selectAll");
		session.close();
		return list;
	}
	
	public static int insertDept(DeptVo d) {
		int re =  -1;
		SqlSession session = factory.openSession();
		re= session.insert("dept.insert",d);
		session.commit();
		session.close();
		return re;
	}
	
	
	
}
