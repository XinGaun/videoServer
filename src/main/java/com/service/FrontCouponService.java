package com.service;

import java.util.HashMap;

/**
 * 前端优惠卷Service层接口
 * @author 87518
 *
 */
public interface FrontCouponService {
	/**
	 * 根据优惠卷ID查询优惠卷信息
	 * @param data
	 * @return
	 */
	public String queryCouponIDList(String data);
	/**
	 * 查询是否领取过优惠卷
	 * @param data
	 * @return
	 */
	public String queryUseridCoupon(String data);
	/**
	 * 领取优惠卷
	 * @return
	 */
	public String updateUseridCoupon(String data);
	/**
	 * 用户查询自己优惠卷信息
	 * @param data
	 * @return
	 */
	public String queryUseridCouponAll(String data);
	/**
	 * 用户根据优惠码领取优惠卷
	 * @param data
	 * @return
	 */
	public String updateCodeCoupon(String data);
	/**
	 * 购买时查询优惠卷信息
	 * @param data
	 * @return
	 */
	public String queryPurchaseCoupon(String data);
	/**
	 * 购买时修改优惠卷使用状态
	 * @param map
	 * @return
	 */
	public int updateUserIDPurchaseCoupon(HashMap<String,Object> map);
}
