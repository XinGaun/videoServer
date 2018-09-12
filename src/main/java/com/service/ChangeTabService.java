package com.service;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.ChangeTab;

/**
 * 退换货单信息Service层接口
 * @author vip
 *
 */
public interface ChangeTabService {
	/**
	 * 添加退换货单信息
	 * @return
	 */
	public String addChangeTab(@RequestParam(value="chan_imgs",required=false) MultipartFile[] chan_imgs,ChangeTab changeTab);
	/**
	 * 查询退换货单信息
	 * @param data
	 * @return
	 */
	public String queryChangeTab(String data);
	/**
	 * 更新退换货单信息
	 * @return
	 */
	public String updateChangeTab(@RequestParam(value="chan_img",required=false) MultipartFile[] chan_imgs,ChangeTab changeTab);
	/**
	 * 删除退换货单信息
	 * @param data
	 * @return
	 */
	public String deleteChangeTab(String data);
	/**
	 * 审核退换货单
	 */
	public String auditChangeTab(String data);
	/**
	 * 根据订单ID查询对应的退换货记录
	 * @param data
	 * @return
	 */
	public String queryChangeOrderId(String data);
	/**
	 * 前端申请退换货ID
	 * @param data
	 * @return
	 */
	public String addFontChangeTab(MultipartFile[] chan_imgs,ChangeTab changeTab);
}
