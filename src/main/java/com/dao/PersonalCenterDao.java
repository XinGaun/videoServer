package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

public interface PersonalCenterDao {
	/**
	 * 查询收藏课程详情
	 * @param map
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryPersonalCenter(HashMap<String,Object> map);
	/**
	 * 查询收藏课程总数
	 * @param hashMap
	 * @return
	 */
	public int queryPersonalCenterAllCount(HashMap<String,Object> hashMap);
	/**
	 * 查询购买课程总数
	 * @param courses_id
	 * @return
	 */
	public int queryPurchaseAllCount(Object courses_id);
	/**
	 * 删除收藏信息
	 * @param map
	 * @return
	 */
	public int deleteSubscription(HashMap<String,Object> map);
	/**
	 * 查询视频页面推荐课程
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryRecommend();
	/**
	 * 查询订单信息
	 * @param map
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryOrderInformation(HashMap<String,Object> map);
	/**
	 * 查询订单总数
	 * @param hashMap
	 * @return
	 */
	public int queryOrderInformationAllCount(HashMap<String,Object> hashMap);
}
