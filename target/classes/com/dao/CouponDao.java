package com.dao;

import java.util.List;

import com.entity.Coupon;
import com.entity.UseCoupon;

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
	public Integer addCoupon(Coupon coupon);
	/**
	 * 查询所有优惠券
	 * @return
	 */
	public List<Coupon> queryCoupon(Coupon coupon);
	/**
	 * 查询所有优惠券总数
	 * @return
	 */
	public Integer queryCouponCount(Coupon coupon);
	/**
	 * 通过id查询优惠券
	 * @param couponId
	 * @return
	 */
	public List<Coupon> queryCouponById(Integer discountsId);
	/**
	 * 物理上删除优惠券
	 * @param couponId
	 */
	public Integer deleteCoupon(Integer discountsId);
	/**
	 * 作废优惠券
	 * @param couponId
	 */
	public Integer delCoupon(Coupon coupon);
	/**
	 * 通过用户id查询该用户的优惠券
	 * @param userId
	 * @return
	 */
	public List<Coupon> queryCouponByUserId(Integer userId);
	/**
	 * 添加优惠券使用信息
	 * @param userCoupon
	 * @return
	 */
	public Integer addDiscountsUse(UseCoupon userCoupon);
}
