package com.idbiass.dao;

import java.util.Date;


public class IdbiDAO {
	private int id; //auto genrate in sql
	private String fName;
	private String lName;
	private String moNumber;
	private String regDate;
	private String regTime;
	private String gender;
	private String email;
	




	
	public IdbiDAO() {}
	
	
	
	public IdbiDAO(String fName, String lName, String moNumber, String regDate, String regTime, String gender) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.moNumber = moNumber;
		this.regDate = regDate;
		this.regTime = regTime;
		this.gender = gender;
	}



	public IdbiDAO(int id, String fName, String lName, String regDate, String regTime, String gender,String email) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.regDate = regDate;
		this.regTime = regTime;
		this.gender = gender;
		this.email = email;
	}
	public IdbiDAO(int id, String fName, String lName, String moNumber, String regDate, String regTime, String gender ,String email) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.moNumber = moNumber;
		this.regDate = regDate;
		this.regTime = regTime;
		this.gender = gender;
		this.email = email;
	}


	public IdbiDAO(String fName, String lName, String moNumber, String regDate, String regTime, String gender,String email) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.moNumber = moNumber;
		this.regDate = regDate;
		this.regTime = regTime;
		this.gender = gender;
		this.email = email;
	}


	
	
	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getMoNumber() {
		return moNumber;
	}
	public void setMoNumber(String moNumber) {
		this.moNumber = moNumber;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	
}
