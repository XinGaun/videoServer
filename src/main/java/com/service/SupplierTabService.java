package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 厂商信息service层信息
 * @author vip
 *
 */
public interface SupplierTabService {
	/**
	 * 添加厂商信息
	 * @param req
	 * @param res
	 * @param supp_logo 厂商logo
	 * @param supp_name 厂商名称
	 * @param supp_weight 权重
	 * @return
	 */
	public String addSupplierTab(HttpServletRequest req,HttpServletResponse res,@RequestParam("supp_logo") MultipartFile supp_logo,String supp_name,int supp_weight,String lock_status);
	/**
	 * 查询厂商信息
	 * @param data
	 * @return
	 */
	public String querySupplierTab(String data);
	/**
	 * 更新厂商信息
	 * @param data
	 * @return
	 */
	public String updateSupplierTab(HttpServletRequest req, HttpServletResponse res, MultipartFile supp_logo,
			String supp_name, int supp_weight,int supp_id,String lock_status);
	/**
	 * 删除厂商信息
	 * @param data
	 * @return
	 */
	public String deleteSupplierTab(String data);
	/**
	 * 总实例添加供应商
	 */
	public String addPushSupplierTab(HttpServletRequest req, HttpServletResponse res, MultipartFile supp_logo,
			String supp_name, int supp_weight,String lock_status);
	/**
	 * 总实例更新供应商信息
	 * @param data
	 * @return
	 */
	public String updatePushSupplierTab(HttpServletRequest req, HttpServletResponse res, MultipartFile supp_logo,
			String supp_name, int supp_weight,int supp_id,String lock_status);
}
