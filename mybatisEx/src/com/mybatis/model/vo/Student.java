package com.mybatis.model.vo;

import java.sql.Date;

public class Student {
	
	private int studentNo;
	private String studentName, studentTel, studentEmail, studentAddr;
	private Date reg_date;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int studentNo, String studentName, String studentTel, String studentEmail, String studentAddr,
			Date reg_date) {
		super();
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.studentTel = studentTel;
		this.studentEmail = studentEmail;
		this.studentAddr = studentAddr;
		this.reg_date = reg_date;
	}

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentTel() {
		return studentTel;
	}

	public void setStudentTel(String studentTel) {
		this.studentTel = studentTel;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentAddr() {
		return studentAddr;
	}

	public void setStudentAddr(String studentAddr) {
		this.studentAddr = studentAddr;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "Student [studentNo=" + studentNo + ", studentName=" + studentName + ", studentTel=" + studentTel
				+ ", studentEmail=" + studentEmail + ", studentAddr=" + studentAddr + ", reg_date=" + reg_date + "]";
	}

	
	
	
}
