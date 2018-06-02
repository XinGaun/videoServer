package com.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Coupon {
	private Integer disCountsId;
	private String discountsText;
	private Integer discountsNumber;
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date discountsDate;
	private Integer discountsValid;
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
	@Override
	public String toString() {
		return "Coupon [disCountsId=" + disCountsId + ", discountsText=" + discountsText + ", discountsNumber="
				+ discountsNumber + ", discountsDate=" + discountsDate + ", discountsValid=" + discountsValid
				+ ", discountsAddr=" + discountsAddr + "]";
	}
	
}
