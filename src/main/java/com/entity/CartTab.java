package com.entity;
/**
 * 购物车表实体类
 * @author vip
 *
 */
public class CartTab {
	private int cart_id;//购物车ID
	private int buye_id;//买家ID
	private int comm_putaway_id;//商品ID
	private int cart_num;//数量
	private String cart_date;
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getBuye_id() {
		return buye_id;
	}
	public void setBuye_id(int buye_id) {
		this.buye_id = buye_id;
	}
	public int getComm_putaway_id() {
		return comm_putaway_id;
	}
	public void setComm_putaway_id(int comm_putaway_id) {
		this.comm_putaway_id = comm_putaway_id;
	}
	public int getCart_num() {
		return cart_num;
	}
	public void setCart_num(int cart_num) {
		this.cart_num = cart_num;
	}
	public String getCart_date() {
		return cart_date;
	}
	public void setCart_date(String cart_date) {
		this.cart_date = cart_date;
	}
	
}
