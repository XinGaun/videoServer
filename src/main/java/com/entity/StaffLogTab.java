package com.entity;
/**
 * 员工日志表实体类
 * @author vip
 *
 */
public class StaffLogTab {
	Integer staff_log_id;//员工日志ID
	Integer staff_id;//员工ID
	String staff_log_api;//操作API名称
	String staff_log_date;//操作日期
	String staff_log_relatedid;//相关ID
	public Integer getStaff_log_id() {
		return staff_log_id;
	}
	public void setStaff_log_id(Integer staff_log_id) {
		this.staff_log_id = staff_log_id;
	}
	public Integer getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(Integer staff_id) {
		this.staff_id = staff_id;
	}
	public String getStaff_log_api() {
		return staff_log_api;
	}
	public void setStaff_log_api(String staff_log_api) {
		this.staff_log_api = staff_log_api;
	}
	public String getStaff_log_date() {
		return staff_log_date;
	}
	public void setStaff_log_date(String staff_log_date) {
		this.staff_log_date = staff_log_date;
	}
	public String getStaff_log_relatedid() {
		return staff_log_relatedid;
	}
	public void setStaff_log_relatedid(String staff_log_relatedid) {
		this.staff_log_relatedid = staff_log_relatedid;
	}
	
}
