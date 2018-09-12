package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.WantTab;
/**
 * 缺货登记表Dao层接口
 * @author vip
 *
 */
@Mapper
public interface WantTabDao {
	/**
	 * 添加缺货登记表信息
	 * @param wantTab
	 * @return
	 */
	public int addWantTab(WantTab wantTab);
	/**
	 * 查询缺货登记表信息
	 * @param wantTab
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryWantTab(HashMap<String,Object> hashMap);
	/**
	 * 查询缺货登记表信息总数
	 * @param wantTab
	 * @return
	 */
	public int queryWantTabCount(HashMap<String,Object> hashMap);
	/**
	 * 更新缺货登记表信息
	 * @param wantTab
	 * @return
	 */
	public int updateWantTab(WantTab wantTab);
	/**
	 * 删除缺货登记表信息
	 * @param wantTab
	 * @return
	 */
	public int deleteWantTab(int want_id);
	/**
	 * 添加采购需求信息
	 * @param map
	 * @return
	 */
	public int addprocurement(HashMap<String,Object> map);
	/**
	 * 更新缺货登记记录
	 */
	public int updatescWantTab(HashMap<String,Object> map);
}
