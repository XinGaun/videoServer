package com.service;

import java.util.List;

import com.entity.Coupon;
import com.entity.UseCoupon;

/**
 * 优惠券service接口
 *
 */
public interface CouponService {
	
	public String addCoupon(Coupon coupon);
	
	public String addDiscountsUse(UseCoupon userCoupon);
	
	public String queryCoupon(String data);
	
	public List<Coupon> queryCoupon(Integer discountsId);
	
	public String deleteCoupon(Coupon coupon);
	
	public List<Coupon> queryCouponByUserId(Integer userId);
	/**
	 * 据年级查询课程分类信息
	 * @param data
	 * @return
	 */
	public String queryvideoFormClass(String data);
	/**
	 * 根据课程分类ID查询所属课程信息
	 * @param data
	 * @return
	 */
	public String queryCoursesTabAll(String data);
	/**
	 * 添加优惠码信息
	 * @param data
	 * @return
	 */
	public String addDiscountsTab(String data);
	/**
	 * 查询优惠卷信息
	 * @param data
	 * @return
	 */
	public String queryDiscountsTab(String data);
	/**
	 * 修改优惠卷信息
	 * @param data
	 * @return
	 */
	public String updateDiscountsTab(String data);
	/**
	 * 查询优惠码信息
	 */
	public String queryDiscountsNumberTab(String data);
	/**
	 * 
	 */
	public String addDiscountsNumberTab(String data);
}
