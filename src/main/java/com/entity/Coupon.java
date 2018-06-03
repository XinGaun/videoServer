package com.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 优惠券实体类
 *
 */
public class Coupon {
	/**
	 * 优惠券id
	 */
	private Integer disCountsId;
	/**
	 * 优惠内容
	 */
	private String discountsText;
	/**
	 * 优惠码
	 */
	private Integer discountsNumber;
	/**
	 * 有效日期
	 */
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date discountsDate;
	/**
	 * 是否有效
	 */
	private Integer discountsValid;
	/**
	 * 投放地区
	 */
	private String discountsAddr;
	
	public Integer getDisCountsId() {
		return disCountsId;
	}
	
	public void setDisCountsId(Integer disCountsId) {
		this.disCountsId = disCountsId;
	}
	
	public String getDiscountsText() {
		return discountsText;
	}
	
	public void setDiscountsText(String discountsText) {
		this.discountsText = discountsText;
	}
	
	public Integer getDiscountsNumber() {
		return discountsNumber;
	}
	
	public void setDiscountsNumber(Integer discountsNumber) {
		this.discountsNumber = discountsNumber;
	}
	
	public Date getDiscountsDate() {
		return discountsDate;
	}
	
	public void setDiscountsDate(Date discountsDate) {
		this.discountsDate = discountsDate;
	}
	
	public Integer getDiscountsValid() {
		return discountsValid;
	}
	
	public void setDiscountsValid(Integer discountsValid) {
		this.discountsValid = discountsValid;
	}
	
	public String getDiscountsAddr() {
		return discountsAddr;
	}
	
	public void setDiscountsAddr(String discountsAddr) {
		this.discountsAddr = discountsAddr;
	}
	
}
