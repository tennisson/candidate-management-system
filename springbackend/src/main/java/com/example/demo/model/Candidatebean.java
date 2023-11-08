package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")

public class Candidatebean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long regno;
	@Column(name = "name")
	private String name;
	
	@Column(name = "m1")
	private int m1;
	
	@Column(name = "m2")
	private int m2;
	
	@Column(name = "m3")
	private int m3;
	
	@Column(name = "result")
	private String result;
	
	@Column(name = "grade")
	private String grade;
	

	
	public Candidatebean(String name, int m1, int m2, int m3, String result, String grade) {
		super();
		this.name = name;
		this.m1 = m1;
		this.m2 = m2;
		this.m3 = m3;
		this.result = result;
		this.grade = grade;
	}

	


	public long getRegno() {
		return regno;
	}




	public void setRegno(long regno) {
		this.regno = regno;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public int getM1() {
		return m1;
	}




	public void setM1(int m1) {
		this.m1 = m1;
	}




	public int getM2() {
		return m2;
	}




	public void setM2(int m2) {
		this.m2 = m2;
	}




	public int getM3() {
		return m3;
	}




	public void setM3(int m3) {
		this.m3 = m3;
	}




	public String getResult() {
		return result;
	}




	public void setResult(String result) {
		this.result = result;
	}




	public String getGrade() {
		return grade;
	}




	public void setGrade(String grade) {
		this.grade = grade;
	}




	public Candidatebean() {}


}
