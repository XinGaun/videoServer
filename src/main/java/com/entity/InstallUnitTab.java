package com.entity;
/**
 * 安装单位实体类表
 * @author vip
 *
 */
public class InstallUnitTab {
	private Integer inst_unit_id;//安装单位ID
	private String inst_unit_name;//安装单位名称
	private String inst_unit_scope;//安装范围
	private String inst_unit_stop_status;//停权状态
	private String inst_unit_dete_status;//删除状态
	private Integer branch_id;//所属分公司
	
	public Integer getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(Integer branch_id) {
		this.branch_id = branch_id;
	}
	public int getInst_unit_id() {
		return inst_unit_id;
	}
	public void setInst_unit_id(Integer inst_unit_id) {
		this.inst_unit_id = inst_unit_id;
	}
	public String getInst_unit_name() {
		return inst_unit_name;
	}
	public void setInst_unit_name(String inst_unit_name) {
		this.inst_unit_name = inst_unit_name;
	}
	public String getInst_unit_scope() {
		return inst_unit_scope;
	}
	public void setInst_unit_scope(String inst_unit_scope) {
		this.inst_unit_scope = inst_unit_scope;
	}
	public String getInst_unit_stop_status() {
		return inst_unit_stop_status;
	}
	public void setInst_unit_stop_status(String inst_unit_stop_status) {
		this.inst_unit_stop_status = inst_unit_stop_status;
	}
	public String getInst_unit_dete_status() {
		return inst_unit_dete_status;
	}
	public void setInst_unit_dete_status(String inst_unit_dete_status) {
		this.inst_unit_dete_status = inst_unit_dete_status;
	}
	
}
