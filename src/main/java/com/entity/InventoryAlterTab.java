package com.entity;
/**
 * 库存变更表实体类
 * @author vip
 *
 */
public class InventoryAlterTab {
	private Integer inve_alter_id;//库存变更表ID
	private Integer warehouse_id;//仓库ID
	private Integer comm_id;//商品ID
	private Integer cargo_id;//货物ID
	private String inve_alter_code;//条码
	private String inve_alter_type;//变更类型
	private String inve_alter_cause;//变更原因
	private String inve_alter_date;//变更时间
	private Integer source_ware_id;//源仓库ID
	private Integer bourn_ware_id;//目的仓库ID
	private Integer purc_id;//采购单ID
	private Integer orde_id;//订单ID
	private Integer chan_id;//退换货单ID
	private Integer deli_id;//配送单ID
	private Integer come_ware_id;//出库单ID
	private Integer staff_id;//操作员ID
	private String inve_alter_remark;//备注
	private Integer shop_id;//出样门店ID
	
	public Integer getShop_id() {
		return shop_id;
	}
	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}
	public Integer getInve_alter_id() {
		return inve_alter_id;
	}
	public void setInve_alter_id(Integer inve_alter_id) {
		this.inve_alter_id = inve_alter_id;
	}
	public Integer getWarehouse_id() {
		return warehouse_id;
	}
	public void setWarehouse_id(Integer warehouse_id) {
		this.warehouse_id = warehouse_id;
	}
	public Integer getComm_id() {
		return comm_id;
	}
	public void setComm_id(Integer comm_id) {
		this.comm_id = comm_id;
	}
	public Integer getCargo_id() {
		return cargo_id;
	}
	public void setCargo_id(Integer cargo_id) {
		this.cargo_id = cargo_id;
	}
	public String getInve_alter_code() {
		return inve_alter_code;
	}
	public void setInve_alter_code(String inve_alter_code) {
		this.inve_alter_code = inve_alter_code;
	}
	public String getInve_alter_type() {
		return inve_alter_type;
	}
	public void setInve_alter_type(String inve_alter_type) {
		this.inve_alter_type = inve_alter_type;
	}
	public String getInve_alter_cause() {
		return inve_alter_cause;
	}
	public void setInve_alter_cause(String inve_alter_cause) {
		this.inve_alter_cause = inve_alter_cause;
	}
	public String getInve_alter_date() {
		return inve_alter_date;
	}
	public void setInve_alter_date(String inve_alter_date) {
		this.inve_alter_date = inve_alter_date;
	}
	public Integer getSource_ware_id() {
		return source_ware_id;
	}
	public void setSource_ware_id(Integer source_ware_id) {
		this.source_ware_id = source_ware_id;
	}
	public Integer getBourn_ware_id() {
		return bourn_ware_id;
	}
	public void setBourn_ware_id(Integer bourn_ware_id) {
		this.bourn_ware_id = bourn_ware_id;
	}
	public Integer getPurc_id() {
		return purc_id;
	}
	public void setPurc_id(Integer purc_id) {
		this.purc_id = purc_id;
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
	public Integer getDeli_id() {
		return deli_id;
	}
	public void setDeli_id(Integer deli_id) {
		this.deli_id = deli_id;
	}
	public Integer getCome_ware_id() {
		return come_ware_id;
	}
	public void setCome_ware_id(Integer come_ware_id) {
		this.come_ware_id = come_ware_id;
	}
	public Integer getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(Integer staff_id) {
		this.staff_id = staff_id;
	}
	public String getInve_alter_remark() {
		return inve_alter_remark;
	}
	public void setInve_alter_remark(String inve_alter_remark) {
		this.inve_alter_remark = inve_alter_remark;
	}
	
}
