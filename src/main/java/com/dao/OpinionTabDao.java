package com.dao;

import java.util.HashMap;
/**
 * 建议管理
 * @param hashMap
 * @return
 */
public interface OpinionTabDao {
	/**
	 * 添加
	 * @param hashMap
	 * @return
	 */
	public int addOpinionTab(HashMap<String,Object> hashMap);
	/**
	 * 查询
	 * @param hashMap
	 * @return
	 */
	public int queryOpinionTab(HashMap<String,Object> hashMap);
	/**
	 * 查询总数
	 * @param hashMap
	 * @return
	 */
	public int queryOpinionTabCount(HashMap<String,Object> hashMap);
	/**
	 * 更新
	 * @param hashMap
	 * @return
	 */
	public int updateOpinionTab(HashMap<String,Object> hashMap);
	/**
	 * 删除
	 * @param order_id
	 * @return
	 */
	public int deleteOpinionTab(int order_id);
}
