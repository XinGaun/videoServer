package com.entity;
/**
 * 供应商实体类
 * @author vip
 *
 */
public class SupplierTab {
	private int supp_id;//ID
	private String supp_logo;//厂商LOGO
	private String supp_name;//厂商名称
	private int supp_weight;//排序权重
	private String lock_status;//锁定状态
	
	public String getLock_status() {
		return lock_status;
	}
	public void setLock_status(String lock_status) {
		this.lock_status = lock_status;
	}
	public int getSupp_id() {
		return supp_id;
	}
	public void setSupp_id(int supp_id) {
		this.supp_id = supp_id;
	}
	public String getSupp_logo() {
		return supp_logo;
	}
	public void setSupp_logo(String supp_logo) {
		this.supp_logo = supp_logo;
	}
	public String getSupp_name() {
		return supp_name;
	}
	public void setSupp_name(String supp_name) {
		this.supp_name = supp_name;
	}
	public int getSupp_weight() {
		return supp_weight;
	}
	public void setSupp_weight(int supp_weight) {
		this.supp_weight = supp_weight;
	}
	
}
