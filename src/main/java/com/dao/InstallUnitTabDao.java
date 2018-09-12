package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.InstallUnitTab;
/**
 * 安装单位Dao层接口
 * @author vip
 *
 */
@Mapper
public interface InstallUnitTabDao {
	/**
	 * 添加安装单位
	 * @param installUnitTab
	 * @return
	 */
	public int addInstallUnitTab(InstallUnitTab installUnitTab);
	/**
	 * 查询安装单位
	 * @param hashMap
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryInstallUnitTab(HashMap<String,Object> hashMap);
	/**
	 * 查询安装单位总数
	 * @param hashMap
	 * @return
	 */
	public int queryInstallUnitTabCount(HashMap<String,Object> hashMap);
	/**
	 * 更新安装单位信息
	 * @param installUnitTab
	 * @return
	 */
	public int updateInstallUnitTab(InstallUnitTab installUnitTab);
	/**
	 * 删除安装单位
	 * @param inst_unit_id
	 * @return
	 */
	public int deleteInstallUnitTab(int inst_unit_id);
}
