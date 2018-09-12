package com.entity;
/**
 * 文案表实体类
 * @author vip
 *
 */
public class WriterTab {
	private Integer writ_id;//文案ID
	private String writ_title;//标题
	private String writ_img;//封面图片
	private String writ_test;//文案内容
	private String writ_status;//激活状态
	private String writ_date;//创建时间
	private Integer staf_id;//创建人员ID
	public Integer getWrit_id() {
		return writ_id;
	}
	public void setWrit_id(Integer writ_id) {
		this.writ_id = writ_id;
	}
	public String getWrit_title() {
		return writ_title;
	}
	public void setWrit_title(String writ_title) {
		this.writ_title = writ_title;
	}
	public String getWrit_img() {
		return writ_img;
	}
	public void setWrit_img(String writ_img) {
		this.writ_img = writ_img;
	}
	public String getWrit_test() {
		return writ_test;
	}
	public void setWrit_test(String writ_test) {
		this.writ_test = writ_test;
	}
	public String getWrit_status() {
		return writ_status;
	}
	public void setWrit_status(String writ_status) {
		this.writ_status = writ_status;
	}
	public String getWrit_date() {
		return writ_date;
	}
	public void setWrit_date(String writ_date) {
		this.writ_date = writ_date;
	}
	public Integer getStaf_id() {
		return staf_id;
	}
	public void setStaf_id(Integer staf_id) {
		this.staf_id = staf_id;
	}

	
}
