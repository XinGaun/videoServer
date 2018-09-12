package com.entity;
/**
 * 出库单表实体类
 * @author vip
 *
 */
public class ComeWarehouseTab {
	private Integer come_ware_id;//出库单ID
	private String come_ware_cause;//出库原因
	private Integer purc_id;//采购单ID
	private Integer staff_id;//出库操作员ID
	private String come_ware_date;//出库时间
	public Integer getCome_ware_id() {
		return come_ware_id;
	}
	public void setCome_ware_id(Integer come_ware_id) {
		this.come_ware_id = come_ware_id;
	}
	public String getCome_ware_cause() {
		return come_ware_cause;
	}
	public void setCome_ware_cause(String come_ware_cause) {
		this.come_ware_cause = come_ware_cause;
	}
	public Integer getPurc_id() {
		return purc_id;
	}
	public void setPurc_id(Integer purc_id) {
		this.purc_id = purc_id;
	}
	public Integer getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(Integer staff_id) {
		this.staff_id = staff_id;
	}
	public String getCome_ware_date() {
		return come_ware_date;
	}
	public void setCome_ware_date(String come_ware_date) {
		this.come_ware_date = come_ware_date;
	}
	
}
