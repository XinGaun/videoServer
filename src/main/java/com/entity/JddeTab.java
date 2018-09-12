package com.entity;
/**
 * 配送单位实体类
 * @author vip
 *
 */
public class JddeTab {
	private Integer jdde_id;//ID
	private String jdde_name;//名称
	private String jdde_scope;//配送范围
	private String jdde_stop_status;//停权状态
	private String jdde_dete_status;//删除状态
	private Integer branch_id;//分公司ID
	
	
	public Integer getJdde_id() {
		return jdde_id;
	}
	public void setJdde_id(Integer jdde_id) {
		this.jdde_id = jdde_id;
	}
	public Integer getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(Integer branch_id) {
		this.branch_id = branch_id;
	}
	public String getJdde_name() {
		return jdde_name;
	}
	public void setJdde_name(String jdde_name) {
		this.jdde_name = jdde_name;
	}
	public String getJdde_scope() {
		return jdde_scope;
	}
	public void setJdde_scope(String jdde_scope) {
		this.jdde_scope = jdde_scope;
	}
	public String getJdde_stop_status() {
		return jdde_stop_status;
	}
	public void setJdde_stop_status(String jdde_stop_status) {
		this.jdde_stop_status = jdde_stop_status;
	}
	public String getJdde_dete_status() {
		return jdde_dete_status;
	}
	public void setJdde_dete_status(String jdde_dete_status) {
		this.jdde_dete_status = jdde_dete_status;
	}
	
}
