package com.example.demo.model;
import java.util.Date;

import org.springframework.http.HttpStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="errorlog")

public class errorlogbean {

public HttpStatus getErrcode() {
		return errcode;
	}
	public void setErrcode(HttpStatus errcode) {
		this.errcode = errcode;
	}
	public String getErrdesc() {
		return errdesc;
	}
	public void setErrdesc(String errdesc) {
		this.errdesc = errdesc;
	}
	public Date getLogdate() {
		return logdate;
	}
	public void setLogdate(Date logdate) {
		this.logdate = logdate;
	}


public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
public errorlogbean( HttpStatus errcode, String errdesc, Date logdate) {
		super();
		
		this.errcode = errcode;
		this.errdesc = errdesc;
		this.logdate = logdate;
	}


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column(name="errorcode")
private HttpStatus errcode;
@Column(name="errdesc")
private String errdesc;
@Column(name="logdate")
private Date logdate;

}
