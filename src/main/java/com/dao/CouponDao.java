package com.dao;

import java.util.List;

import com.entity.Coupon;

/**
 * 
 * 优惠券Dao接口
 *
 */
public interface CouponDao {
	/**
	 * 添加优惠券信息
	 * @param coupon
	 */
	public void addCoupon(Coupon coupon);
	/**
	 * 查询所有优惠券
	 * @return
	 */
	public List<Coupon> queryCoupon();
	/**
	 * 通过id查询优惠券
	 * @param couponId
	 * @return
	 */
	public List<Coupon> queryCouponById(Integer couponId);
	/**
	 * 物理上删除优惠券
	 * @param couponId
	 */
	public void deleteCoupon(Integer couponId);
	/**
	 * 作废优惠券
	 * @param couponId
	 */
	public void delCoupon(Integer couponId);
	/**
	 * 通过用户id查询该用户的优惠券
	 * @param userId
	 * @return
	 */
	public List<Coupon> queryCouponByUserId(Integer userId);
}
