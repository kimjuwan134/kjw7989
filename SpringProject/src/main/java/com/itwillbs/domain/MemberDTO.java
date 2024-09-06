package com.itwillbs.domain;

import java.sql.Timestamp;

public class MemberDTO {
	// alt + shift + s : get, set 자동 완성
	
	private String id;
	private String pass;
	private String name;
	private Timestamp date;
	
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pass=" + pass + ", name=" + name + ", date=" + date + "]";
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getPass() {
		return pass;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public Timestamp getDate() {
		return date;
	}
		
}
