package com.service;

public interface OpinionService {
	/**
	 * 查询建议
	 * @return
	 */
	public String queryOpinionAll(String data);
	
	/**
	 * 删除订单
	 * @param data
	 * @return
	 */
	public String deleteOpinionTab(String data);
}
