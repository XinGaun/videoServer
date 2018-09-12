package com.service;
/**
 * 文案模块表Service层接口
 * @author vip
 *
 */
public interface DocumentsTabService {
	/**
	 * 添加文案模块表
	 * @param data
	 * @return
	 */
	public String addDocumentsTab(String data);
	/**
	 * 查询文案模块表
	 * @param data
	 * @return
	 */
	public String queryDocumentsTab(String data);
	/**
	 * 更新文案模块表
	 * @param data
	 * @return
	 */
	public String updateDocumentsTab(String data);
	/**
	 * 修改文案模块表
	 * @param data
	 * @return
	 */
	public String deleteDocumentsTab(String data);
}
