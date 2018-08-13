package com.service;

public interface PersonalCenterService {
	/**
	 * 查询收藏课程详情
	 * @param data
	 * @return
	 */
	public String queryPersonalCenter(String data);
	/**
	 * 删除收藏信息
	 * @param data
	 * @return
	 */
	public String deleteSubscription(String data);
	//课程中心推荐课程
	/**
	 * 查询推荐课程
	 * @return
	 */
	public String queryRecommend();
	/**
	 * 查询订单详情
	 * @param data
	 * @return
	 */
	public String queryOrderInformation(String data);
}
