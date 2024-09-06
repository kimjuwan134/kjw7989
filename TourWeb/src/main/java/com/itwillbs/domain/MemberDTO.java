package com.itwillbs.domain;

import java.sql.Timestamp;

public class MemberDTO {
	
	private String id;
	private String pass;
	private String name;
	private String phone;
	private String email;
	private String email2;
	private String gender;
	private String agree;
	private String content;
	private Timestamp date;
		
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pass=" + pass + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ ", email2=" + email2 + ", gender=" + gender + ", agree=" + agree + ", content=" + content + ", date="
				+ date + "]";
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public String getAgree() {
		return agree;
	}
	public void setAgree(String agree) {
		this.agree = agree;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
