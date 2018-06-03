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
	
	public List<Coupon> quaryCoupon(Integer discountsId);
	
	public String deleteCoupon(Coupon coupon);
	
	public List<Coupon> queryCouponByUserId(Integer userId);
}
