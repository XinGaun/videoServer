package com.entity;
/**
 * 品牌表实体类
 * @author vip
 *
 */
public class BrandTab {
	private int brand_id;
	private int brand_supp_id;//供应商ID
	private int brand_cate_id;//品类ID
	private String brand_name;//品牌名称
	private String brand_logo;//品牌LOGO
	private int brand_weight;//排序权重
	private String lock_status;//锁定状态
	
	public String getLock_status() {
		return lock_status;
	}
	public void setLock_status(String lock_status) {
		this.lock_status = lock_status;
	}
	public int getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}
	public int getBrand_supp_id() {
		return brand_supp_id;
	}
	public void setBrand_supp_id(int brand_supp_id) {
		this.brand_supp_id = brand_supp_id;
	}
	public int getBrand_cate_id() {
		return brand_cate_id;
	}
	public void setBrand_cate_id(int brand_cate_id) {
		this.brand_cate_id = brand_cate_id;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public String getBrand_logo() {
		return brand_logo;
	}
	public void setBrand_logo(String brand_logo) {
		this.brand_logo = brand_logo;
	}
	public int getBrand_weight() {
		return brand_weight;
	}
	public void setBrand_weight(int brand_weight) {
		this.brand_weight = brand_weight;
	}
	
}
