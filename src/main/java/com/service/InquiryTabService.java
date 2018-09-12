package com.service;



import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.InquiryTab;

/**
 * 咨询留言表Service层接口
 * @author vip
 *
 */
public interface InquiryTabService {
	/**
	 * 添加咨询留言信息
	 * @param req
	 * @param res
	 * @param inqu_img 相关照片
	 * @param buye_id 买家ID
	 * @param inqu_title 留言标题
	 * @param inqu_test 留言内容
	 * @param inqu_type 留言类型
	 * @param inqu_status 状态
	 * @param inqu_phone 买家联系电话
	 * @param orde_id 关联订单ID
	 * @return
	 */
	public String addInquiryTab(@RequestParam(value="inqu_imgs",required=false) MultipartFile[] inqu_imgs,InquiryTab inquiryTab);
	/**
	 * 查询留言咨询信息
	 * @param data
	 * @return
	 */
	public String queryInquiryTab(String data);
	/**
	 * 更新留言咨询表
	 * @param data
	 * @return
	 */
	public String updateInquiryTab(@RequestParam(value="inqu_imgs",required=false) MultipartFile[] inqu_imgs,InquiryTab inquiryTab);
	/**
	 * 删除留言咨询信息
	 * @param data
	 * @return
	 */
	public String deleteInquiryTab(String data);
}
