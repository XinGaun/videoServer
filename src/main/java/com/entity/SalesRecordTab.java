package com.entity;
/**
 * 商品销售记录表实体类
 * @author vip
 *
 */
public class SalesRecordTab {
	private Integer sale_id;//商品销售记录ID
	private Integer orde_id;//订单ID
	private Integer comm_id;//商品ID
	private String sale_price;//原价
	private String real_price;//实价
	private Integer sale_num;//数量
	private String discounts_id;//优惠活动ID
	private String cargo_id;//优惠活动ID
	private String sale_change;//退换货标记
	
	public String getCargo_id() {
		return cargo_id;
	}
	public void setCargo_id(String cargo_id) {
		this.cargo_id = cargo_id;
	}
	public String getSale_change() {
		return sale_change;
	}
	public void setSale_change(String sale_change) {
		this.sale_change = sale_change;
	}
	public Integer getSale_id() {
		return sale_id;
	}
	public void setSale_id(Integer sale_id) {
		this.sale_id = sale_id;
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
	public String getSale_price() {
		return sale_price;
	}
	public void setSale_price(String sale_price) {
		this.sale_price = sale_price;
	}
	public String getReal_price() {
		return real_price;
	}
	public void setReal_price(String real_price) {
		this.real_price = real_price;
	}
	public Integer getSale_num() {
		return sale_num;
	}
	public void setSale_num(Integer sale_num) {
		this.sale_num = sale_num;
	}
	public String getDiscounts_id() {
		return discounts_id;
	}
	public void setDiscounts_id(String discounts_id) {
		this.discounts_id = discounts_id;
	}
	
}
