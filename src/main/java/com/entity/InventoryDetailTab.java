package com.entity;
/**
 * 库存明细表 实体类
 * @author vip
 *
 */
public class InventoryDetailTab {
	private Integer inve_id;//库存明细表ID
	private Integer ware_id;//仓库ID
	private Integer comm_id;//商品ID
	private String cargo_id;//货物ID
	private String inve_code;//条码
	private String inve_status;//状态
	private String inve_cause;//入库原因
	private Integer staf_id;//操作员ID
	private String inve_join_date;//入库时间
	private String inve_come_sign;//出库标记
	private String inve_come_date;//出库时间
	private Integer come_ware_id;//出库单号
	public Integer getInve_id() {
		return inve_id;
	}
	public void setInve_id(Integer inve_id) {
		this.inve_id = inve_id;
	}
	public Integer getWare_id() {
		return ware_id;
	}
	public void setWare_id(Integer ware_id) {
		this.ware_id = ware_id;
	}
	public Integer getComm_id() {
		return comm_id;
	}
	public void setComm_id(Integer comm_id) {
		this.comm_id = comm_id;
	}
	public String getCargo_id() {
		return cargo_id;
	}
	public void setCargo_id(String cargo_id) {
		this.cargo_id = cargo_id;
	}
	public String getInve_code() {
		return inve_code;
	}
	public void setInve_code(String inve_code) {
		this.inve_code = inve_code;
	}
	public String getInve_status() {
		return inve_status;
	}
	public void setInve_status(String inve_status) {
		this.inve_status = inve_status;
	}
	public String getInve_cause() {
		return inve_cause;
	}
	public void setInve_cause(String inve_cause) {
		this.inve_cause = inve_cause;
	}
	public Integer getStaf_id() {
		return staf_id;
	}
	public void setStaf_id(Integer staf_id) {
		this.staf_id = staf_id;
	}
	public String getInve_join_date() {
		return inve_join_date;
	}
	public void setInve_join_date(String inve_join_date) {
		this.inve_join_date = inve_join_date;
	}
	public String getInve_come_sign() {
		return inve_come_sign;
	}
	public void setInve_come_sign(String inve_come_sign) {
		this.inve_come_sign = inve_come_sign;
	}
	public String getInve_come_date() {
		return inve_come_date;
	}
	public void setInve_come_date(String inve_come_date) {
		this.inve_come_date = inve_come_date;
	}
	public Integer getCome_ware_id() {
		return come_ware_id;
	}
	public void setCome_ware_id(Integer come_ware_id) {
		this.come_ware_id = come_ware_id;
	}
	
}
