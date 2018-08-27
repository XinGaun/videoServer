package com.entity;

import java.sql.Date;

import com.google.gson.Gson;

public class UserTab {
	private int user_id;
	private String user_name;
	private int user_sex;
	private String user_phone;
	private String user_pwd;
	private int user_status;
	private Date user_date;
	private String user_email;
	private String user_photo;
	private String user_truename;
	private String user_qq;
	private String user_self;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(int user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public int getUser_status() {
		return user_status;
	}
	public void setUser_status(int user_status) {
		this.user_status = user_status;
	}
	public Date getUser_date() {
		return user_date;
	}
	public void setUser_date(Date user_date) {
		this.user_date = user_date;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_truename() {
		return user_truename;
	}
	public void setUser_truename(String user_truename) {
		this.user_truename = user_truename;
	}
	public String getUser_qq() {
		return user_qq;
	}
	public void setUser_qq(String user_qq) {
		this.user_qq = user_qq;
	}
	public String getUser_self() {
		return user_self;
	}
	public void setUser_self(String user_self) {
		this.user_self = user_self;
	}
	public String getUser_photo() {
		return user_photo;
	}
	public void setUser_photo(String user_photo) {
		this.user_photo = user_photo;
	}
	public String toString() {
		return new Gson().toJson(this);
	}
	
}
