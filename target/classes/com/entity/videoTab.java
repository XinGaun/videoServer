package com.entity;


public class videoTab {
	Integer video_id;
	Integer video_form_id;
	Integer teacher_id;
	String video_name;
	String video_introduce;
	String video_url;
	Double video_pricemoney;
	String video_date;
	Integer video_status;
	Integer video_click;
	String video_img_url;
	Integer video_grade;
	public Integer getVideo_id() {
		return video_id;
	}
	public void setVideo_id(Integer video_id) {
		this.video_id = video_id;
	}
	public Integer getVideo_form_id() {
		return video_form_id;
	}
	public void setVideo_form_id(Integer video_form_id) {
		this.video_form_id = video_form_id;
	}
	public Integer getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(Integer teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getVideo_name() {
		return video_name;
	}
	public void setVideo_name(String video_name) {
		this.video_name = video_name;
	}

	public String getVideo_introduce() {
		return video_introduce;
	}
	public void setVideo_introduce(String video_introduce) {
		this.video_introduce = video_introduce;
	}
	public String getVideo_date() {
		return video_date;
	}
	public void setVideo_date(String video_date) {
		this.video_date = video_date;
	}
	public String getVideo_url() {
		return video_url;
	}
	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}
	public Double getVideo_pricemoney() {
		return video_pricemoney;
	}
	public void setVideo_pricemoney(Double video_pricemoney) {
		this.video_pricemoney = video_pricemoney;
	}

	public Integer getVideo_status() {
		return video_status;
	}
	public void setVideo_status(Integer video_status) {
		this.video_status = video_status;
	}
	public Integer getVideo_click() {
		return video_click;
	}
	public void setVideo_click(Integer video_click) {
		this.video_click = video_click;
	}
	public String getVideo_img_url() {
		return video_img_url;
	}
	public void setVideo_img_url(String video_img_url) {
		this.video_img_url = video_img_url;
	}
	public Integer getVideo_grade() {
		return video_grade;
	}
	public void setVideo_grade(Integer video_grade) {
		this.video_grade = video_grade;
	}
	/*public videoTab(Integer video_id, Integer video_form_id, Integer teacher_id, String video_name, String video_Integerroduce,
			String video_url, Double video_pricemoney, Timestamp video_date, Integer video_status, Integer video_click,
			String video_img_url, Integer video_grade) {
		super();
		this.video_id = video_id;
		this.video_form_id = video_form_id;
		this.teacher_id = teacher_id;
		this.video_name = video_name;
		this.video_Integerroduce = video_Integerroduce;
		this.video_url = video_url;
		this.video_pricemoney = video_pricemoney;
		this.video_date = video_date;
		this.video_status = video_status;
		this.video_click = video_click;
		this.video_img_url = video_img_url;
		this.video_grade = video_grade;
	}
	public videoTab(){}*/
}
