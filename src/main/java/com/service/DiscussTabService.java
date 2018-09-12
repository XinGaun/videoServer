package com.service;
/**
 * 评论表Service层接口
 * @author vip
 *
 */
public interface DiscussTabService {
	/**
	 * 添加评论信息
	 * @param data
	 * @return
	 */
	public String addDiscussTab(String data);
	/**
	 * 查询评论信息
	 * @param data
	 * @return
	 */
	public String queryDiscussTab(String data);
	/**
	 * 更新评论信息
	 * @param data
	 * @return
	 */
	public String updateDiscussTab(String data);
	/**
	 * 删除评论信息
	 * @param data
	 * @return
	 */
	public String deleteDiscussTab(String data);
}
