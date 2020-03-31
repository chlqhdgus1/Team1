package com.example.demo.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmpVo {
	
	private int eno;
	private String ename;
	private String job;
	private int sal;
	private int comm;
	private int mgr;
	private Date hiredate;
	private int dno;
	private String jumin;
	private String email;
}
