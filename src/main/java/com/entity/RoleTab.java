package com.entity;

import com.alibaba.fastjson.JSON;

/**
 * 角色实体类
 * @author vip
 *
 */
public class RoleTab {
	private int role_id;
	private String role_name;//名称
	private Integer[] role_righ_arr;//权限列表
	private String role_stop_status;//停权状态
	private String role_dete_status;//删除状态
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_righ_arr() {
		return JSON.toJSONString(role_righ_arr);
	}
	public void setRole_righ_arr(Integer[] role_righ_arr) {
		this.role_righ_arr = role_righ_arr;
	}
	public String getRole_stop_status() {
		return role_stop_status;
	}
	public void setRole_stop_status(String role_stop_status) {
		this.role_stop_status = role_stop_status;
	}
	public String getRole_dete_status() {
		return role_dete_status;
	}
	public void setRole_dete_status(String role_dete_status) {
		this.role_dete_status = role_dete_status;
	}
	
}
