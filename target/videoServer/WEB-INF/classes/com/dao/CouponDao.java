package com.dao;

import java.util.ArrayList;
import java.util.HashMap;
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
	/**
	 * 根据年级查询课程分类信息
	 * @param map
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryvideoFormClass(HashMap<String,Object> map);
	/**
	 * 根据课程分类ID查询所属课程信息
	 */
	public ArrayList<HashMap<String,Object>> queryCoursesTabAll(HashMap<String,Object> map);
	/**
	 * 添加优惠卷信息
	 */
	public int addDiscountsTab(HashMap<String,Object> map);
	/**
	 * 添加优惠码信息
	 */
	public int addDiscountsNumberTab(ArrayList<HashMap<String,Object>> list);
	/**
	 * 查询优惠卷信息
	 */
	public ArrayList<HashMap<String,Object>> queryDiscountsTab(HashMap<String,Object> map);
	/**
	 * 查询优惠卷信息总数
	 */
	public int queryDiscountsTabCount(HashMap<String,Object> map);
	/**
	 * 修改优惠卷信息
	 * @param map
	 * @return
	 */
	public int updateDiscountsTab(HashMap<String,Object> map);
	/**
	 * 根据优惠卷ID查询优惠码信息
	 */
	public ArrayList<HashMap<String,Object>> queryDiscountsNumberTab(HashMap<String,Object> map);
}
