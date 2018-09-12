package com.entity;
/**
 * 仓库表实体类
 * @author vip
 *
 */
public class WarehouseTab {
	private Integer ware_id;//ID
	private String ware_name;//名称
	private String ware_addr;//地址
	private Integer ware_superior;//上级仓库ID
	private Integer jdde_id;//所属配送单位
	private Integer branch_id;//所属分公司
	private String ware_class;//仓库类别
	
	
	public Integer getWare_id() {
		return ware_id;
	}
	public void setWare_id(Integer ware_id) {
		this.ware_id = ware_id;
	}
	public Integer getJdde_id() {
		return jdde_id;
	}
	public void setJdde_id(Integer jdde_id) {
		this.jdde_id = jdde_id;
	}
	public Integer getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(Integer branch_id) {
		this.branch_id = branch_id;
	}
	public String getWare_class() {
		return ware_class;
	}
	public void setWare_class(String ware_class) {
		this.ware_class = ware_class;
	}
	public String getWare_name() {
		return ware_name;
	}
	public void setWare_name(String ware_name) {
		this.ware_name = ware_name;
	}
	public String getWare_addr() {
		return ware_addr;
	}
	public void setWare_addr(String ware_addr) {
		this.ware_addr = ware_addr;
	}
	public Integer getWare_superior() {
		return ware_superior;
	}
	public void setWare_superior(Integer ware_superior) {
		this.ware_superior = ware_superior;
	}

}
