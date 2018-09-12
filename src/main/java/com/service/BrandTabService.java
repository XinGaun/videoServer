package com.service;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 品牌Service层接口
 * @author vip
 *
 */
public interface BrandTabService {
	/**
	 * 添加品牌信息
	 * @param req
	 * @param res
	 * @param brand_logo logo
	 * @param brand_name 品牌名称
	 * @param brand_weight 品牌权重
	 * @param brand_supp_id 供应商ID
	 * @param brand_cate_id 品类ID
	 * @return
	 */
	public String addBrandTab(HttpServletRequest req,HttpServletResponse res,MultipartFile brand_logo,String brand_name,int brand_weight,int brand_supp_id,int brand_cate_id,String lock_status);
	/**
	 * 查询品牌信息
	 * @param hashMap
	 * @return
	 */
	public String queryBrandTab(String data);
	/**
	 * 更新品牌信息
	 * @param data
	 * @return
	 */
	public String updateBrandTab(HttpServletRequest req,HttpServletResponse res,@RequestParam(value="brand_logo",required=false) MultipartFile brand_logo,String brand_name,int brand_weight,int brand_supp_id,int brand_cate_id,int brand_id,String lock_status);
	/**
	 * 删除品牌信息
	 * @param data
	 * @return
	 */
	public String deleteBrandTab(String data);
	/**
	 * 总实体类添加品牌信息
	 * @param req
	 * @param res
	 * @return
	 */
	public String addPushBrand(HttpServletRequest req,HttpServletResponse res,MultipartFile brand_logo,String brand_name,int brand_weight,int brand_supp_id,int brand_cate_id,String lock_status);
	/**
	 * 总实例更新品牌信息
	 * @param data
	 * @return
	 */
	public String updatePushBrandTab(HttpServletRequest req,HttpServletResponse res,@RequestParam(value="brand_logo",required=false) MultipartFile brand_logo,String brand_name,int brand_weight,int brand_supp_id,int brand_cate_id,int brand_id,String lock_status);
}
