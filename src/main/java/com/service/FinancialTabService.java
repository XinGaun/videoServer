package com.service;

import java.util.HashMap;

/**
 * 财务记录Service层接口
 * @author vip
 *
 */
public interface FinancialTabService {
	/**
	 * 添加财务记录信息
	 * @param data
	 * @return
	 */
	public String addFinancialTab(String data);
	/**
	 * 查询财务记录信息
	 * @param data
	 * @return
	 */
	public String queryFinancialTab(String data);
	/**
	 * 更新财务记录信息
	 * @param data
	 * @return
	 */
	public String updateFinancialTab(String data);
	/**
	 * 删除财务记录信息
	 * @param data
	 * @return
	 */
	public String deleteFinancialTab(String data);

}
