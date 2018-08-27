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
	private Integer discountsId;
	/**
	 * 优惠内容
	 */
	private String discountsText;
	/**
	 * 优惠码
	 */
	private String discountsNumber;
	/**
	 * 有效日期
	 */
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date discountsDate;
	/**
	 * 有效日期
	 */
	private String discountsDateString;
	/**
	 * 是否有效
	 */
	private Integer discountsValid;
	/**
	 * 是否有效
	 */
	private String discountsValue;
	/**
	 * 投放地区
	 */
	private String discountsAddr;
	
	public Integer getDiscountsId() {
		return discountsId;
	}
	
	public void setDiscountsId(Integer discountsId) {
		this.discountsId = discountsId;
	}
	
	public String getDiscountsText() {
		return discountsText;
	}
	
	public void setDiscountsText(String discountsText) {
		this.discountsText = discountsText;
	}
	
	public String getDiscountsNumber() {
		return discountsNumber;
	}
	
	public void setDiscountsNumber(String discountsNumber) {
		this.discountsNumber = discountsNumber;
	}
	
	public Date getDiscountsDate() {
		return discountsDate;
	}
	
	public void setDiscountsDate(Date discountsDate) {
		this.discountsDate = discountsDate;
	}
	
	public String getDiscountsDateString() {
		return discountsDateString;
	}

	public void setDiscountsDateString(String discountsDateString) {
		this.discountsDateString = discountsDateString;
	}

	public Integer getDiscountsValid() {
		return discountsValid;
	}
	
	public void setDiscountsValid(Integer discountsValid) {
		this.discountsValid = discountsValid;
	}
	
	public String getDiscountsValue() {
		return discountsValue;
	}

	public void setDiscountsValue(String discountsValue) {
		this.discountsValue = discountsValue;
	}

	public String getDiscountsAddr() {
		return discountsAddr;
	}
	
	public void setDiscountsAddr(String discountsAddr) {
		this.discountsAddr = discountsAddr;
	}
	
}
