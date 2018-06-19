package com.entity;

import java.util.Date;
/**
 * 用户使用优惠券记录
 *
 */
public class UseCoupon {
	/**
	 * 用户ID
	 */
	private Integer userId;
	/**
	 * 优惠码ID
	 */
	private Integer DiscountsId;
	/**
	 * 视频ID
	 */
	private Integer videoId;
	/**
	 * 套餐ID
	 */
	private Integer comboId;
	/**
	 * 使用日期
	 */
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

}
