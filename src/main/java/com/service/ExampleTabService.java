package com.service;

import java.util.ArrayList;

import com.entity.ExampleTab;

/**
 * 分实例管理Service层接口
 * @author vip
 *
 */
public interface ExampleTabService {
	/**
	 * 添加分公司实例信息
	 * @param exampleTab
	 * @return
	 */
	public String addExampleTab(ExampleTab exampleTab);
	/**
	 * 查询分公司实例信息
	 * @return
	 */
	public String queryExampleTab();
	/**
	 * 修改分公司实例信息
	 * @param exampleTab
	 * @return
	 */
	public String updateExampleTab(ExampleTab exampleTab);
	/**
	 * 删除分公司实例信息
	 * 
	 */
	public String deleteExampleTab(ArrayList<Integer> list);
}
