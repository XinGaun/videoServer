package com.entity;
/**
 * 配送单表实体类
 * @author vip
 *
 */
public class DeliverTab {
	private Integer deli_id;//配送单表ID
	private Integer orde_id;//订单ID
	private Integer chan_id;//退换货ID
	private Integer jdde_id;//配送单位ID
	private String deli_addr;//配送地址
	private String deli_phone;//联系电话
	private String deli_name;//买家姓名
	private String deli_make_date;//预约时间
	private String deli_delivery_date;//配送时间
	private Integer staf_id;//配送员ID
	private String deli_come_date;//出库时间
	private String deli_visit_date;//上门时间
	private String deli_sign_date;//签收时间
	private String deli_sign_name;//签收签名
	private String deli_status;//配送状态
	private String deli_remark;//备注
	public Integer getDeli_id() {
		return deli_id;
	}
	public void setDeli_id(Integer deli_id) {
		this.deli_id = deli_id;
	}
	public Integer getOrde_id() {
		return orde_id;
	}
	public void setOrde_id(Integer orde_id) {
		this.orde_id = orde_id;
	}
	public Integer getChan_id() {
		return chan_id;
	}
	public void setChan_id(Integer chan_id) {
		this.chan_id = chan_id;
	}
	public Integer getJdde_id() {
		return jdde_id;
	}
	public void setJdde_id(Integer jdde_id) {
		this.jdde_id = jdde_id;
	}
	public String getDeli_addr() {
		return deli_addr;
	}
	public void setDeli_addr(String deli_addr) {
		this.deli_addr = deli_addr;
	}
	public String getDeli_phone() {
		return deli_phone;
	}
	public void setDeli_phone(String deli_phone) {
		this.deli_phone = deli_phone;
	}
	public String getDeli_name() {
		return deli_name;
	}
	public void setDeli_name(String deli_name) {
		this.deli_name = deli_name;
	}
	public String getDeli_make_date() {
		return deli_make_date;
	}
	public void setDeli_make_date(String deli_make_date) {
		this.deli_make_date = deli_make_date;
	}
	public String getDeli_delivery_date() {
		return deli_delivery_date;
	}
	public void setDeli_delivery_date(String deli_delivery_date) {
		this.deli_delivery_date = deli_delivery_date;
	}
	public Integer getStaf_id() {
		return staf_id;
	}
	public void setStaf_id(Integer staf_id) {
		this.staf_id = staf_id;
	}
	public String getDeli_come_date() {
		return deli_come_date;
	}
	public void setDeli_come_date(String deli_come_date) {
		this.deli_come_date = deli_come_date;
	}
	public String getDeli_visit_date() {
		return deli_visit_date;
	}
	public void setDeli_visit_date(String deli_visit_date) {
		this.deli_visit_date = deli_visit_date;
	}
	public String getDeli_sign_date() {
		return deli_sign_date;
	}
	public void setDeli_sign_date(String deli_sign_date) {
		this.deli_sign_date = deli_sign_date;
	}
	public String getDeli_sign_name() {
		return deli_sign_name;
	}
	public void setDeli_sign_name(String deli_sign_name) {
		this.deli_sign_name = deli_sign_name;
	}
	public String getDeli_status() {
		return deli_status;
	}
	public void setDeli_status(String deli_status) {
		this.deli_status = deli_status;
	}
	public String getDeli_remark() {
		return deli_remark;
	}
	public void setDeli_remark(String deli_remark) {
		this.deli_remark = deli_remark;
	}
	
}
