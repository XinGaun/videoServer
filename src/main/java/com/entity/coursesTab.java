package com.entity;

import com.google.gson.Gson;

public class coursesTab {
	int courses_id;
	int teacher_id;
	String courses_name;
	String courses_introduce;
	String courses_video;
	String courses_pricemoney;
	int courses_click;
	String courses_img_url;
	int courses_grade;
	int courses_status;
	int video_form_id;
	String video_form_name;
	String courses_date;
	public int getVideo_form_id() {
		return video_form_id;
	}
	public void setVideo_form_id(int video_form_id) {
		this.video_form_id = video_form_id;
	}
	public String getVideo_form_name() {
		return video_form_name;
	}
	public void setVideo_form_name(String video_form_name) {
		this.video_form_name = video_form_name;
	}

	public int getCourses_id() {
		return courses_id;
	}
	public void setCourses_id(int courses_id) {
		this.courses_id = courses_id;
	}
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getCourses_name() {
		return courses_name;
	}
	public void setCourses_name(String courses_name) {
		this.courses_name = courses_name;
	}
	public String getCourses_introduce() {
		return courses_introduce;
	}
	public void setCourses_introduce(String courses_introduce) {
		this.courses_introduce = courses_introduce;
	}
	public String getCourses_video() {
		return courses_video;
	}
	public void setCourses_video(String courses_video) {
		this.courses_video = courses_video;
	}
	public String getCourses_pricemoney() {
		return courses_pricemoney;
	}
	public void setCourses_pricemoney(String courses_pricemoney) {
		this.courses_pricemoney = courses_pricemoney;
	}
	public int getCourses_click() {
		return courses_click;
	}
	public void setCourses_click(int courses_click) {
		this.courses_click = courses_click;
	}
	public String getCourses_img_url() {
		return courses_img_url;
	}
	public void setCourses_img_url(String courses_img_url) {
		this.courses_img_url = courses_img_url;
	}
	public int getCourses_grade() {
		return courses_grade;
	}
	public void setCourses_grade(int courses_grade) {
		this.courses_grade = courses_grade;
	}
	public int getCourses_status() {
		return courses_status;
	}
	public void setCourses_status(int courses_status) {
		this.courses_status = courses_status;
	}
	public String getCourses_date() {
		return courses_date;
	}
	public void setCourses_date(String courses_date) {
		this.courses_date = courses_date;
	}
	public String toString() {
		return new Gson().toJson(this);
	}
}
