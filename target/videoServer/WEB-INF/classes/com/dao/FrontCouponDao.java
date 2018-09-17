package com.dao;
/**
 * 前端优惠卷Dao层接口
 * @author 87518
 *
 */

import java.util.ArrayList;
import java.util.HashMap;

public interface FrontCouponDao {
	/**
	 * 根据优惠卷ID查询优惠卷信息
	 * @param map
	 * @return
	 */
	public HashMap<String,Object> queryCouponIDList(HashMap<String,Object> map);
	/**
	 * 查询是否领取过优惠卷
	 * @param map
	 * @return
	 */
	public int queryUseridCoupon(HashMap<String,Object> map);
	/**
	 * 查询优惠码信息
	 */
	public HashMap<String,Object> queryCouponCode(HashMap<String,Object> map);
	/**
	 * 用户领取优惠卷
	 * @param map
	 * @return
	 */
	public int updateUseridCoupon(HashMap<String,Object> map);
	/**
	 * 用户查询自己优惠卷信息
	 */
	public ArrayList<HashMap<String,Object>> queryUseridCouponAll(HashMap<String,Object> map);
	/**
	 * 用户使用优惠码领取优惠卷
	 * @param map
	 * @return
	 */
	public int queryCodeCoupon(HashMap<String,Object> map);
	/**
	 * 用户根据优惠码领取优惠卷
	 */
	public int updateCodeCoupon(HashMap<String,Object> map);
	/**
	 * 购买时查询优惠卷信息
	 * @param map
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryPurchaseCoupon(HashMap<String,Object> map);
	/**
	 * 修改优惠卷状态
	 */
	public int updateUserIDPurchaseCoupon(HashMap<String,Object> map);
}
