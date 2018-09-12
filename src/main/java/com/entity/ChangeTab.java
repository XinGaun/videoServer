package com.entity;

import com.alibaba.fastjson.JSON;

/**
 * 退换货单表
 * @author vip
 *
 */
public class ChangeTab {
	private Integer chan_id;// 退换货单表ID
	private Integer orde_id;// 订单ID
	private Integer sale_id;// 商品销售记录ID
	private Integer chan_num;// 数量
	private Integer[] sale_ids;// 商品销售记录ID
	private Integer[] chan_nums;// 数量
	private Integer[] comm_ids;// 数量
	private String chan_status;// 状态
	private Integer staf_acce_id;//受理人员ID
	private String chan_sign;//退换货标志
	private String apply_date;//申请时间
	private String cargo_status;//货物状态
	private String return_date;//退货接收时间
	private String chan_date;//换货发货时间
	private Integer staf_refu_id;//退款审核人员ID
	private String refund_audit_date;//退款审核时间
	private String refund_type;//退款方式
	private String refund_number;//退款单号
	private String refund_date;//退款时间
	private String chan_delivery_type;//换货配送方式
	private Integer deli_id;//换货配送单ID
	private Integer inst_id;//换货安装单ID
	private String chan_cause;//退货理由
	private String chan_remark;//备注
	private String chan_img;//相关照片
	
	
	public String getComm_ids() {
		return JSON.toJSONString(comm_ids);
	}
	public void setComm_ids(Integer[] comm_ids) {
		this.comm_ids = comm_ids;
	}
	public Integer getSale_id() {
		return sale_id;
	}
	public void setSale_id(Integer sale_id) {
		this.sale_id = sale_id;
	}
	public Integer getChan_num() {
		return chan_num;
	}
	public void setChan_num(Integer chan_num) {
		this.chan_num = chan_num;
	}
	public Integer[] getSale_ids() {
		return sale_ids;
	}
	public void setSale_ids(Integer[] sale_ids) {
		this.sale_ids = sale_ids;
	}
	public String getChan_nums() {
		return JSON.toJSONString(chan_nums);
	}
	public void setChan_nums(Integer[] chan_nums) {
		this.chan_nums = chan_nums;
	}
	public Integer getChan_id() {
		return chan_id;
	}
	public void setChan_id(Integer chan_id) {
		this.chan_id = chan_id;
	}
	public Integer getOrde_id() {
		return orde_id;
	}
	public void setOrde_id(Integer orde_id) {
		this.orde_id = orde_id;
	}


	public String getChan_status() {
		return chan_status;
	}
	public void setChan_status(String chan_status) {
		this.chan_status = chan_status;
	}
	public Integer getStaf_acce_id() {
		return staf_acce_id;
	}
	public void setStaf_acce_id(Integer staf_acce_id) {
		this.staf_acce_id = staf_acce_id;
	}
	public String getChan_sign() {
		return chan_sign;
	}
	public void setChan_sign(String chan_sign) {
		this.chan_sign = chan_sign;
	}
	public String getApply_date() {
		return apply_date;
	}
	public void setApply_date(String apply_date) {
		this.apply_date = apply_date;
	}

	public String getCargo_status() {
		return cargo_status;
	}
	public void setCargo_status(String cargo_status) {
		this.cargo_status = cargo_status;
	}
	public String getReturn_date() {
		return return_date;
	}
	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}
	public String getChan_date() {
		return chan_date;
	}
	public void setChan_date(String chan_date) {
		this.chan_date = chan_date;
	}
	public Integer getStaf_refu_id() {
		return staf_refu_id;
	}
	public void setStaf_refu_id(Integer staf_refu_id) {
		this.staf_refu_id = staf_refu_id;
	}
	public String getRefund_audit_date() {
		return refund_audit_date;
	}
	public void setRefund_audit_date(String refund_audit_date) {
		this.refund_audit_date = refund_audit_date;
	}
	public String getRefund_type() {
		return refund_type;
	}
	public void setRefund_type(String refund_type) {
		this.refund_type = refund_type;
	}
	public String getRefund_number() {
		return refund_number;
	}
	public void setRefund_number(String refund_number) {
		this.refund_number = refund_number;
	}
	public String getRefund_date() {
		return refund_date;
	}
	public void setRefund_date(String refund_date) {
		this.refund_date = refund_date;
	}
	public String getChan_delivery_type() {
		return chan_delivery_type;
	}
	public void setChan_delivery_type(String chan_delivery_type) {
		this.chan_delivery_type = chan_delivery_type;
	}
	public Integer getDeli_id() {
		return deli_id;
	}
	public void setDeli_id(Integer deli_id) {
		this.deli_id = deli_id;
	}
	public Integer getInst_id() {
		return inst_id;
	}
	public void setInst_id(Integer inst_id) {
		this.inst_id = inst_id;
	}
	public String getChan_cause() {
		return chan_cause;
	}
	public void setChan_cause(String chan_cause) {
		this.chan_cause = chan_cause;
	}
	public String getChan_remark() {
		return chan_remark;
	}
	public void setChan_remark(String chan_remark) {
		this.chan_remark = chan_remark;
	}
	public String getChan_img() {
		return chan_img;
	}
	public void setChan_img(String chan_img) {
		this.chan_img = chan_img;
	}
	
}
