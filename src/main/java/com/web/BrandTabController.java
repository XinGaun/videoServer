package com.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.service.BrandTabService;
/**
 * 品牌API
 * @author vip
 *
 */
@RequestMapping("/hangrano2o/Brand")
@Controller
@ResponseBody
public class BrandTabController {
	@Autowired
	private BrandTabService brandTabService;//调用品牌Service层接口
	/**
	 * 添加品牌
	 * @param req
	 * @param res
	 * @param brand_logo logo
	 * @param brand_name 品牌名称
	 * @param brand_weight	权重
	 * @param brand_supp_id	供应商ID
	 * @param brand_cate_id 品类ID
	 * @return
	 */
	@RequestMapping(value="/addBrandTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addBrandTab(HttpServletRequest req,HttpServletResponse res,@RequestParam("brand_logo") MultipartFile brand_logo,String brand_name,int brand_weight,int brand_supp_id,int brand_cate_id,String lock_status) {		
		return brandTabService.addBrandTab(req, res, brand_logo, brand_name, brand_weight, brand_supp_id, brand_cate_id,lock_status);
	};
	/**
	 * 查询品牌信息
	 * @return
	 */
	@RequestMapping(value="/queryBrandTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryBrandTab(@RequestBody String data) {
		return brandTabService.queryBrandTab(data);
	}
	/**
	 * 更新品牌
	 * @param req
	 * @param res
	 * @param brand_logo logo
	 * @param brand_name 品牌名称
	 * @param brand_weight	权重
	 * @param brand_supp_id	供应商ID
	 * @param brand_cate_id 品类ID
	 * @return
	 */
	@RequestMapping(value="/updateBrandTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateBrandTab(HttpServletRequest req,HttpServletResponse res,@RequestParam(value="brand_logo",required=false) MultipartFile brand_logo,@RequestParam(value="brand_name",required=false)String brand_name,@RequestParam(value="brand_weight",required=false)int brand_weight,@RequestParam(value="brand_supp_id",required=false)int brand_supp_id,@RequestParam(value="brand_cate_id",required=false)int brand_cate_id,int brand_id,@RequestParam(value="lock_status",required=false)String lock_status) {		
		return brandTabService.updateBrandTab(req, res, brand_logo, brand_name, brand_weight, brand_supp_id, brand_cate_id,brand_id,lock_status);
	};
	/**
	 * 删除品牌信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteBrandTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteBrandTab(@RequestBody String data) {
		return brandTabService.deleteBrandTab(data);
	}
	/**
	 * 总实例添加品牌信息
	 * @param req
	 * @param res
	 * @param brand_logo logo
	 * @param brand_name 品牌名称
	 * @param brand_weight	权重
	 * @param brand_supp_id	供应商ID
	 * @param brand_cate_id 品类ID
	 * @return
	 */
	@RequestMapping(value="/addPushBrand",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addPushBrand(HttpServletRequest req,HttpServletResponse res,@RequestParam("brand_logo") MultipartFile brand_logo,String brand_name,int brand_weight,int brand_supp_id,int brand_cate_id,String lock_status) {		
		return brandTabService.addPushBrand(req, res, brand_logo, brand_name, brand_weight, brand_supp_id, brand_cate_id, lock_status);
	};
	/**
	 * 总实例更新品牌信息
	 * @param req
	 * @param res
	 * @param brand_logo logo
	 * @param brand_name 品牌名称
	 * @param brand_weight	权重
	 * @param brand_supp_id	供应商ID
	 * @param brand_cate_id 品类ID
	 * @return
	 */
	@RequestMapping(value="/updatePushBrandTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updatePushBrandTab(HttpServletRequest req,HttpServletResponse res,@RequestParam(value="brand_logo",required=false) MultipartFile brand_logo,@RequestParam(value="brand_name",required=false)String brand_name,@RequestParam(value="brand_weight",required=false)int brand_weight,@RequestParam(value="brand_supp_id",required=false)int brand_supp_id,@RequestParam(value="brand_cate_id",required=false)int brand_cate_id,int brand_id,@RequestParam(value="lock_status",required=false)String lock_status) {		
		return brandTabService.updatePushBrandTab(req, res, brand_logo, brand_name, brand_weight, brand_supp_id, brand_cate_id, brand_id, lock_status);
	};
}
