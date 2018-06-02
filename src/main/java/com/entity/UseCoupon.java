package com.entity;

import java.util.Date;

public class UseCoupon {

	private Integer userId;
	private Integer DiscountsId;
	private Integer videoId;
	private Integer comboId;
	private Date discountsDate;
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getDiscountsId() {
		return DiscountsId;
	}

	public void setDiscountsId(Integer discountsId) {
		DiscountsId = discountsId;
	}

	public Integer getVideoId() {
		return videoId;
	}

	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}

	public Integer getComboId() {
		return comboId;
	}

	public void setComboId(Integer comboId) {
		this.comboId = comboId;
	}

	public Date getDiscountsDate() {
		return discountsDate;
	}

	public void setDiscountsDate(Date discountsDate) {
		this.discountsDate = discountsDate;
	}

	@Override
	public String toString() {
		return "UseCoupon [userId=" + userId + ", DiscountsId=" + DiscountsId + ", videoId=" + videoId + ", comboId="
				+ comboId + ", discountsDate=" + discountsDate + "]";
	}
	
}
