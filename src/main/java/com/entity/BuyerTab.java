package com.entity;
/**
 * 买家信息表实体类
 * @author vip
 *
 */
public class BuyerTab {
	private int buye_id;//ID
	private String nineteen_id;//19服务厅ID
	private String buye_phone;//手机号码
	public int getBuye_id() {
		return buye_id;
	}
	public void setBuye_id(int buye_id) {
		this.buye_id = buye_id;
	}
	public String getNineteen_id() {
		return nineteen_id;
	}
	public void setNineteen_id(String nineteen_id) {
		this.nineteen_id = nineteen_id;
	}
	public String getBuye_phone() {
		return buye_phone;
	}
	public void setBuye_phone(String buye_phone) {
		this.buye_phone = buye_phone;
	}
	
}
