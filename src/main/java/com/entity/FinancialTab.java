package com.entity;
/**
 * 财务记录表实体类
 * @author vip
 *
 */
public class FinancialTab {
	private Integer fina_id;//财务记录表ID
	private Integer orde_id;//订单ID
	private String fina_money;//金额
	private String pay_type;//支付方式
	private String pay_date;//支付时间
	private String pay_number;//支付平台流水号
	private String surplus_money;//剩余余额
	private String refund_rele_id;//退款关联记录ID
	private String bank_name;//银行名称
	private String bank_num;//银行卡号
	public Integer getFina_id() {
		return fina_id;
	}
	public void setFina_id(Integer fina_id) {
		this.fina_id = fina_id;
	}
	public Integer getOrde_id() {
		return orde_id;
	}
	public void setOrde_id(Integer orde_id) {
		this.orde_id = orde_id;
	}
	public String getFina_money() {
		return fina_money;
	}
	public void setFina_money(String fina_money) {
		this.fina_money = fina_money;
	}
	public String getPay_type() {
		return pay_type;
	}
	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}
	public String getPay_date() {
		return pay_date;
	}
	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}
	public String getPay_number() {
		return pay_number;
	}
	public void setPay_number(String pay_number) {
		this.pay_number = pay_number;
	}
	public String getSurplus_money() {
		return surplus_money;
	}
	public void setSurplus_money(String surplus_money) {
		this.surplus_money = surplus_money;
	}
	public String getRefund_rele_id() {
		return refund_rele_id;
	}
	public void setRefund_rele_id(String refund_rele_id) {
		this.refund_rele_id = refund_rele_id;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getBank_num() {
		return bank_num;
	}
	public void setBank_num(String bank_num) {
		this.bank_num = bank_num;
	}
	
}

