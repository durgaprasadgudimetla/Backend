package com.durga.flightbooking.model.mysql;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "EMPLOYEEDETAILS")
public class EmpDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int dId;
	private String fName;
	private String lName;
	private String email;
	private long phNo;
	private String Address1;
	private String Address2;
	private int dNo;
	
	public EmpDetails() {
		super();
	}

	public EmpDetails(String fName, String lName, String email, long phNo, String address1, String address2,
			int dNo) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.phNo = phNo;
		Address1 = address1;
		Address2 = address2;
		this.dNo = dNo;
	}

	public int getdId() {
		return dId;
	}

	public void setdId(int dId) {
		this.dId = dId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhNo() {
		return phNo;
	}

	public void setPhNo(long phNo) {
		this.phNo = phNo;
	}

	public String getAddress1() {
		return Address1;
	}

	public void setAddress1(String address1) {
		Address1 = address1;
	}

	public String getAddress2() {
		return Address2;
	}

	public void setAddress2(String address2) {
		Address2 = address2;
	}

	public int getdNo() {
		return dNo;
	}

	public void setdNo(int dNo) {
		this.dNo = dNo;
	}
}
