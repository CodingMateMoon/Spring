package com.mybatis.model.vo;

import java.sql.Date;

public class Rstudent {

	private int studentNo;
	private String studentName;
	private String studentTel;
	private String studentEmail;
	private String studentAddr;
	private Date reg_date;
	
	public Rstudent() {
		// TODO Auto-generated constructor stub
	}

	public Rstudent(int studentNo, String studentName, String studentTel, Date reg_date) {
		super();
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.studentTel = studentTel;
		this.reg_date = reg_date;
	}
	
	

	public Rstudent(int studentNo, String studentName, String studentTel) {
		super();
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.studentTel = studentTel;
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

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "Rstudent [studentNo=" + studentNo + ", studentName=" + studentName + ", studentTel=" + studentTel
				+ ", reg_date=" + reg_date + "]";
	}

	
	
	
}
