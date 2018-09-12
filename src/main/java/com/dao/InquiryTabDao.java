package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.InquiryTab;
/**
 * 咨询留言表Dao层接口
 * @author vip
 *
 */
@Mapper
public interface InquiryTabDao {
	/**
	 *  添加咨询留言
	 * @param inquiryTab
	 * @return
	 */
	public int addInquiryTab(InquiryTab inquiryTab);
	/**
	 * 查询咨询留言
	 * @param hashMap
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryInquiryTab(HashMap<String,Object> hashMap);
	/**
	 * 查询咨询留言总数
	 * @param hashMap
	 * @return
	 */
	public int queryInquiryTabCount(HashMap<String,Object> hashMap);
	/**
	 * 修改咨询留言
	 * @param inquiryTab
	 * @return
	 */
	public int updateInquiryTab(InquiryTab inquiryTab);
	/**
	 * 删除咨询留言
	 * @param inqu_id
	 * @return
	 */
	public int deleteInquiryTab(int inqu_id);
}
