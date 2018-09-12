package com.entity;
/**
 * 缺货登记表实体类
 * @author vip
 *
 */
public class WantTab {
	private Integer want_id;//缺货登记表ID
	private Integer orde_id;//订单ID
	private Integer comm_id;//商品ID
	private Integer want_num;//数量
	private String want_date;//登记时间
	private Integer buye_id;//买家ID
	private String want_phone;//联系电话
	private Integer purc_need_id;//采购需求ID
	public Integer getWant_id() {
		return want_id;
	}
	public void setWant_id(Integer want_id) {
		this.want_id = want_id;
	}
	public Integer getOrde_id() {
		return orde_id;
	}
	public void setOrde_id(Integer orde_id) {
		this.orde_id = orde_id;
	}
	public Integer getComm_id() {
		return comm_id;
	}
	public void setComm_id(Integer comm_id) {
		this.comm_id = comm_id;
	}
	public Integer getWant_num() {
		return want_num;
	}
	public void setWant_num(Integer want_num) {
		this.want_num = want_num;
	}
	public String getWant_date() {
		return want_date;
	}
	public void setWant_date(String want_date) {
		this.want_date = want_date;
	}
	public Integer getBuye_id() {
		return buye_id;
	}
	public void setBuye_id(Integer buye_id) {
		this.buye_id = buye_id;
	}
	public String getWant_phone() {
		return want_phone;
	}
	public void setWant_phone(String want_phone) {
		this.want_phone = want_phone;
	}
	public Integer getPurc_need_id() {
		return purc_need_id;
	}
	public void setPurc_need_id(Integer purc_need_id) {
		this.purc_need_id = purc_need_id;
	}
	
}
