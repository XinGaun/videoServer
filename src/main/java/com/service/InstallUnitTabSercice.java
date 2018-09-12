package com.service;
/**
 * 安装单位Service层接口
 * @author vip
 *
 */
public interface InstallUnitTabSercice {
	/**
	 * 添加安装单位信息
	 * @param data
	 * @return
	 */
	public String addInstallUnitTab(String data);
	/**
	 * 查询安装单位信息
	 * @param data
	 * @return
	 */
	public String queryInstallUnitTab(String data);
	/**
	 * 更新安装单位信息
	 * @param data
	 * @return
	 */
	public String updateInstallUnitTab(String data);
	/**
	 * 删除安装单位
	 * @param data
	 * @return
	 */
	public String deleteInstallUnitTab(String data);
}
