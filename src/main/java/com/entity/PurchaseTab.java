package com.entity;
/**
 * 采购单表实体类
 * @author vip
 *
 */
public class PurchaseTab {
	private Integer purc_id;//采购单ID
	private String purc_date;//提交日期
	private String purc_status;//采购状态
	private Integer staff_id;//提交人ID
	public Integer getPurc_id() {
		return purc_id;
	}
	public void setPurc_id(Integer purc_id) {
		this.purc_id = purc_id;
	}
	public String getPurc_date() {
		return purc_date;
	}
	public void setPurc_date(String purc_date) {
		this.purc_date = purc_date;
	}
	public String getPurc_status() {
		return purc_status;
	}
	public void setPurc_status(String purc_status) {
		this.purc_status = purc_status;
	}
	public Integer getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(Integer staff_id) {
		this.staff_id = staff_id;
	}
	
}
