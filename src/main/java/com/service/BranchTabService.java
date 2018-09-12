package com.service;
/**
 * 分公司Service层接口
 * @author vip
 *
 */
public interface BranchTabService {
	/**
	 * 添加分公司信息
	 * @param data
	 * @return
	 */
	public String addBranchTab(String data);
	/**
	 * 查询分公司信息
	 * @param data
	 * @return
	 */
	public String queryBranchTab(String data);
	/**
	 * 更新分公司信息
	 * @param data
	 * @return
	 */
	public String updateBranchTab(String data);
	/**
	 * 删除分公司信息
	 * @param data
	 * @return
	 */
	public String deleteBranchTab(String data);
}
