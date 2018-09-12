package com.entity;
/**
 * 门店表实体类
 * @author vip
 *
 */
public class ShopTab {
	private Integer shop_id;//门店ID
	private String shop_name;//门店名称
	private String shop_addr;//门店地址
	private String shop_date;//营业时间
	private Integer branch_id;//分公司ID

	
	public Integer getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(Integer branch_id) {
		this.branch_id = branch_id;
	}
	public Integer getShop_id() {
		return shop_id;
	}
	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public String getShop_addr() {
		return shop_addr;
	}
	public void setShop_addr(String shop_addr) {
		this.shop_addr = shop_addr;
	}
	public String getShop_date() {
		return shop_date;
	}
	public void setShop_date(String shop_date) {
		this.shop_date = shop_date;
	}
	
}
