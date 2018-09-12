package com.entity;
/**
 * 商品规格表实体类
 * @author vip
 *
 */
public class SpecificationsTab {
	private int spec_id;//ID
	private int spec_cate_id;//品类ID
	private String spec_name;//规格名称
	private String spec_form;//规格类型
	private String spec_scope;//取值范围
	private String lock_status;//锁定状态
	
	public String getLock_status() {
		return lock_status;
	}
	public void setLock_status(String lock_status) {
		this.lock_status = lock_status;
	}
	public int getSpec_id() {
		return spec_id;
	}
	public void setSpec_id(int spec_id) {
		this.spec_id = spec_id;
	}
	public int getSpec_cate_id() {
		return spec_cate_id;
	}
	public void setSpec_cate_id(int spec_cate_id) {
		this.spec_cate_id = spec_cate_id;
	}
	public String getSpec_name() {
		return spec_name;
	}
	public void setSpec_name(String spec_name) {
		this.spec_name = spec_name;
	}

	public String getSpec_form() {
		return spec_form;
	}
	public void setSpec_form(String spec_form) {
		this.spec_form = spec_form;
	}
	public String getSpec_scope() {
		return spec_scope;
	}
	public void setSpec_scope(String spec_scope) {
		this.spec_scope = spec_scope;
	}
	
}
