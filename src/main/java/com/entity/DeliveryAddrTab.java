package com.entity;
/**
 * 配送地址实体类
 * @author vip
 *
 */
public class DeliveryAddrTab {
	private int deli_addr_id;//ID
	private int buye_id;//买家ID
	private String deli_addr;//配送地址
	private String deli_contacts;//联系人
	private String deli_phone;//联系电话
	private String deli_jdde;//换管单位
	
	public String getDeli_jdde() {
		return deli_jdde;
	}
	public void setDeli_jdde(String deli_jdde) {
		this.deli_jdde = deli_jdde;
	}
	public int getDeli_addr_id() {
		return deli_addr_id;
	}
	public void setDeli_addr_id(int deli_addr_id) {
		this.deli_addr_id = deli_addr_id;
	}
	public int getBuye_id() {
		return buye_id;
	}
	public void setBuye_id(int buye_id) {
		this.buye_id = buye_id;
	}
	public String getDeli_addr() {
		return deli_addr;
	}
	public void setDeli_addr(String deli_addr) {
		this.deli_addr = deli_addr;
	}
	public String getDeli_contacts() {
		return deli_contacts;
	}
	public void setDeli_contacts(String deli_contacts) {
		this.deli_contacts = deli_contacts;
	}
	public String getDeli_phone() {
		return deli_phone;
	}
	public void setDeli_phone(String deli_phone) {
		this.deli_phone = deli_phone;
	}
}
