package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

public interface opinionDao {
	/**
	 * 查询所有建议内容
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryOpinionAll(HashMap<String,Object> hashmap);
	
	/**
	 * 查询建议信息总数
	 * @param hashMap
	 * @return
	 */
	public int queryOpinionTabCount(HashMap<String,Object> hashMap);
	/**
	 * 删除订单信息
	 * @param opinion_id
	 * @return
	 */
	public int deleteOpinionTab(int opinion_id);
}
