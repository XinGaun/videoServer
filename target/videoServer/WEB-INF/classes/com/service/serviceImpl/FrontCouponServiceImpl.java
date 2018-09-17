package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dao.FrontCouponDao;
import com.service.FrontCouponService;
import com.util.Count;
/**
 * 前端优惠卷Service层实现类
 * @author 87518
 *
 */
@Service
@SuppressWarnings("unchecked")
public class FrontCouponServiceImpl implements FrontCouponService{
	@Autowired
	private FrontCouponDao couponDao;
	/**
	 * 根据优惠卷ID查询优惠卷信息
	 */
	@Override
	public String queryCouponIDList(String data) {
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		HashMap<String,Object> HashMap = new HashMap<String,Object>();
		ArrayList<HashMap<String,Object>> retulist = new ArrayList<HashMap<String,Object>>();
		for(int i=0;i<list.size();i++) {
			HashMap.put("discounts_id", list.get(i));
			HashMap<String,Object> map = couponDao.queryCouponIDList(HashMap);
			if(null!=map) {
				retulist.add(map);
			}	
		}
		return JSON.toJSONString(Count.counts(retulist, -1,HashMap,200,"queryCouponIDList success"));
	}
	/**
	 * 查询是否领取过优惠卷
	 */
	@Override
	public String queryUseridCoupon(String data) {
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		int flog = couponDao.queryUseridCoupon(map);
		if(flog>0) {
			return JSON.toJSONString(Count.counts(null, -1,map,400,"queryUseridCoupon success"));
		}
		return JSON.toJSONString(Count.counts(null, -1,map,200,"queryUseridCoupon success"));
	}
	/**
	 * 领取优惠卷
	 */
	@Override
	public String updateUseridCoupon(String data) {
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		HashMap<String,Object> hashMap = couponDao.queryCouponCode(map);
		if(null!=hashMap) {
			hashMap.put("user_id", map.get("user_id"));
			int flog =  couponDao.updateUseridCoupon(hashMap);
			if(flog>0) {
				return JSON.toJSONString(Count.counts(null, -1,map,200,"updateUseridCoupon success"));
			}
			return JSON.toJSONString(Count.counts(null, -1,map,400,"updateUseridCoupon error"));
		}
		return JSON.toJSONString(Count.counts(null, -1,map,400,"updateUseridCoupon error"));
	}
	/**
	 * 用户查询自己优惠卷信息
	 */
	@Override
	public String queryUseridCouponAll(String data) {
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		ArrayList<HashMap<String,Object>> list = couponDao.queryUseridCouponAll(map);
		return JSON.toJSONString(Count.counts(list, -1,map,200,"queryUseridCouponAll success"));
	}
	/**
	 * 用户根据优惠码领取优惠卷
	 */
	@Override
	public String updateCodeCoupon(String data) {
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		int flog = couponDao.queryCodeCoupon(map);
		if(flog>0) {
			flog = couponDao.updateCodeCoupon(map);
			if(flog>0) {
				return JSON.toJSONString(Count.counts(null, -1,map,200,"updateCodeCoupon success"));
			}
			return JSON.toJSONString(Count.counts(null, -1,map,400,"优惠码领取失败!"));
		}
		return JSON.toJSONString(Count.counts(null, -1,map,400,"该优惠码已经使用,请不要重复使用!"));
	}
	/**
	 * 购买时查询优惠卷信息
	 */
	@Override
	public String queryPurchaseCoupon(String data) {
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		ArrayList<HashMap<String,Object>> list = couponDao.queryPurchaseCoupon(map);
		return JSON.toJSONString(Count.counts(list, -1,map,200,"queryPurchaseCoupon success"));
	}
	/**
	 * 购买时修改优惠卷使用状态
	 */
	@Override
	public int updateUserIDPurchaseCoupon(HashMap<String, Object> map) {
		return couponDao.updateUserIDPurchaseCoupon(map);
	}

}
