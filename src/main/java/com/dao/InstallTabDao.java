package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.InstallTab;
/**
 * 安装单表实体类
 * @author vip
 *
 */
@Mapper
public interface InstallTabDao {
	/**
	 * 添加安装单信息
	 * @param installTab
	 * @return
	 */
	public int addInstallTab(InstallTab installTab);
	/**
	 * 查询安装单信息
	 * @param installTab
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryInstallTab(HashMap<String,Object> hashMap);
	/**
	 * 查询安装单信息总数
	 * @param installTab
	 * @return
	 */
	public int queryInstallTabCount(HashMap<String,Object> hashMap);
	/**
	 * 更新安装单信息
	 * @param installTab
	 * @return
	 */
	public int updateInstallTab(InstallTab installTab);
	/**
	 * 删除安装单信息
	 * @param installTab
	 * @return
	 */
	public int deleteInstallTab(int inst_id);
	/**
	 * 更新多条配送单签收状态
	 */
	public int updateSignDeliverTabAll(HashMap<String,Object> hashMap);
	/**
	 * 更新安装单关联订单信息
	 */
	public int updateOrder(HashMap<String,Object> hashMap);
}
