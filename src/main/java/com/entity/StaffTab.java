package com.entity;
/**
 * 员工表实体类
 * @author vip
 *
 */
public class StaffTab {
	private Integer staf_id;//员工ID
	private String staf_usr_name;//员工名称
	private String staf_pwd;//员工密码
	private String staf_name;//员工姓名
	private String staf_sales;//销售权限
	private Integer shop_id;//所属门店ID
	private Integer jdde_id;//配送单位ID
	private Integer inst_unit_id;//所属安装单位ID
	private Integer ware_id;//所属仓库ID
	private String staf_role;//角色ID
	private String staf_date;//最近登录时间
	private String staf_stop_status;//停权状态
	private String staf_dete_status;//删除状态
	private String staf_job;//员工工号
	private Integer branch_id;//所属分公司ID;
	private String staf_approve;//退款审批权限
	
	public Integer getStaf_id() {
		return staf_id;
	}
	public void setStaf_id(Integer staf_id) {
		this.staf_id = staf_id;
	}
	public String getStaf_usr_name() {
		return staf_usr_name;
	}
	public void setStaf_usr_name(String staf_usr_name) {
		this.staf_usr_name = staf_usr_name;
	}
	public String getStaf_pwd() {
		return staf_pwd;
	}
	public void setStaf_pwd(String staf_pwd) {
		this.staf_pwd = staf_pwd;
	}
	public String getStaf_name() {
		return staf_name;
	}
	public void setStaf_name(String staf_name) {
		this.staf_name = staf_name;
	}
	public String getStaf_sales() {
		return staf_sales;
	}
	public void setStaf_sales(String staf_sales) {
		this.staf_sales = staf_sales;
	}
	public Integer getShop_id() {
		return shop_id;
	}
	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}

	public Integer getJdde_id() {
		return jdde_id;
	}
	public void setJdde_id(Integer jdde_id) {
		this.jdde_id = jdde_id;
	}

	public Integer getInst_unit_id() {
		return inst_unit_id;
	}
	public void setInst_unit_id(Integer inst_unit_id) {
		this.inst_unit_id = inst_unit_id;
	}

	public Integer getWare_id() {
		return ware_id;
	}
	public void setWare_id(Integer ware_id) {
		this.ware_id = ware_id;
	}

	
	public String getStaf_role() {
		return staf_role;
	}
	public void setStaf_role(String staf_role) {
		this.staf_role = staf_role;
	}
	public String getStaf_job() {
		return staf_job;
	}
	public void setStaf_job(String staf_job) {
		this.staf_job = staf_job;
	}
	public Integer getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(Integer branch_id) {
		this.branch_id = branch_id;
	}
	public String getStaf_approve() {
		return staf_approve;
	}
	public void setStaf_approve(String staf_approve) {
		this.staf_approve = staf_approve;
	}
	public String getStaf_date() {
		return staf_date;
	}
	public void setStaf_date(String staf_date) {
		this.staf_date = staf_date;
	}
	public String getStaf_stop_status() {
		return staf_stop_status;
	}
	public void setStaf_stop_status(String staf_stop_status) {
		this.staf_stop_status = staf_stop_status;
	}
	public String getStaf_dete_status() {
		return staf_dete_status;
	}
	public void setStaf_dete_status(String staf_dete_status) {
		this.staf_dete_status = staf_dete_status;
	}
	
}
