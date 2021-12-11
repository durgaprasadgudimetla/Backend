package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;
@Entity
@Component
@XmlRootElement
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int eno;
	private String eName;
	private String eAddress;
	/*@OneToOne( mappedBy ="emp", fetch= FetchType.LAZY,cascade=CascadeType.ALL)
	private Department dept;*/
	
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String geteAddress() {
		return eAddress;
	}
	public void seteAddress(String eAddress) {
		this.eAddress = eAddress;
	}
	/*public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}*/
	
	
}
