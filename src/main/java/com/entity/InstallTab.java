package com.entity;
/**
 * 安装单表实体类
 * @author vip
 *
 */
public class InstallTab {
	private Integer inst_id;//安装单ID
	private Integer orde_id;//订单ID
	private Integer chan_id;//退换货ID
	private Integer inst_unit_id;//安装单位ID
	private String inst_addr;//安装地址
	private String inst_phone;//联系电话
	private String inst_name;//买家姓名
	private String inst_make_date;//预约时间
	private String inst_date;//安装时间
	private Integer staf_id;//安装员ID
	private String inst_visit_date;//上门时间
	private String inst_achieve_date;//施工完成时间
	private String inst_check_date;//验收时间
	private String inst_check_name;//验收签名
	private String inst_status;//施工状态
	private String inst_remark;//备注
	private String inst_staf_id;//
	public Integer getInst_id() {
		return inst_id;
	}
	public void setInst_id(Integer inst_id) {
		this.inst_id = inst_id;
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
	public Integer getInst_unit_id() {
		return inst_unit_id;
	}
	public void setInst_unit_id(Integer inst_unit_id) {
		this.inst_unit_id = inst_unit_id;
	}
	public String getInst_addr() {
		return inst_addr;
	}
	public void setInst_addr(String inst_addr) {
		this.inst_addr = inst_addr;
	}
	public String getInst_phone() {
		return inst_phone;
	}
	public void setInst_phone(String inst_phone) {
		this.inst_phone = inst_phone;
	}
	public String getInst_name() {
		return inst_name;
	}
	public void setInst_name(String inst_name) {
		this.inst_name = inst_name;
	}
	public String getInst_make_date() {
		return inst_make_date;
	}
	public void setInst_make_date(String inst_make_date) {
		this.inst_make_date = inst_make_date;
	}
	public String getInst_date() {
		return inst_date;
	}
	public void setInst_date(String inst_date) {
		this.inst_date = inst_date;
	}
	public Integer getStaf_id() {
		return staf_id;
	}
	public void setStaf_id(Integer staf_id) {
		this.staf_id = staf_id;
	}
	public String getInst_visit_date() {
		return inst_visit_date;
	}
	public void setInst_visit_date(String inst_visit_date) {
		this.inst_visit_date = inst_visit_date;
	}
	public String getInst_achieve_date() {
		return inst_achieve_date;
	}
	public void setInst_achieve_date(String inst_achieve_date) {
		this.inst_achieve_date = inst_achieve_date;
	}
	public String getInst_check_date() {
		return inst_check_date;
	}
	public void setInst_check_date(String inst_check_date) {
		this.inst_check_date = inst_check_date;
	}
	public String getInst_check_name() {
		return inst_check_name;
	}
	public void setInst_check_name(String inst_check_name) {
		this.inst_check_name = inst_check_name;
	}
	public String getInst_status() {
		return inst_status;
	}
	public void setInst_status(String inst_status) {
		this.inst_status = inst_status;
	}
	public String getInst_remark() {
		return inst_remark;
	}
	public void setInst_remark(String inst_remark) {
		this.inst_remark = inst_remark;
	}
	
}
