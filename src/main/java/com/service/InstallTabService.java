package com.service;
/**
 * 安装单信息Service层接口
 * @author vip
 *
 */
public interface InstallTabService {
	/**
	 * 添加安装单信息
	 * @param data
	 * @return
	 */
	public String addInstallTab(String data);
	/**
	 * 查询安装单信息
	 * @param data
	 * @return
	 */
	public String queryInstallTab(String data);
	/**
	 * 更新安装单信息
	 * @param data
	 * @return
	 */
	public String updateInstallTab(String data);
	/**
	 * 删除安装单信息
	 * @param data
	 * @return
	 */
	public String deleteInstallTab(String data);
	/**
	 * 更新已安装信息
	 * @param data
	 * @return
	 */
	String updateInstallTabAll(String data);
}
