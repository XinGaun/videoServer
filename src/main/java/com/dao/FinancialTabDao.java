package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.FinancialTab;
/**
 * 财务记录表Dao层接口
 * @author vip
 *
 */
@Mapper
public interface FinancialTabDao {
	/**
	 * 添加财务记录
	 * @param financialTab
	 * @return
	 */
	public int addFinancialTab(FinancialTab financialTab);
	/**
	 * 查询财务记录
	 * @param hashMap
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryFinancialTab(HashMap<String,Object> hashMap);
	/**
	 * 查询财务记录总数
	 * @param hashMap
	 * @return
	 */
	public int queryFinancialTabCount(HashMap<String,Object> hashMap);
	/**
	 * 更新财务记录
	 * @param financialTab
	 * @return
	 */
	public int updateFinancialTab(FinancialTab financialTab);
	/**
	 * 删除财务记录
	 * @param fina_id
	 * @return
	 */
	public int deleteFinancialTab(int fina_id);
}
