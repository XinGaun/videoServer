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

import com.service.SupplierTabService;
/**
 * 厂商API
 * @author vip
 *
 */
@Controller
@ResponseBody
@RequestMapping("/hangrano2o/Supplier")
public class SupplierTabController {
	@Autowired
	private SupplierTabService supplierTabService;//调用厂商信息Service层接口
	/**
	 * 添加厂商信息
	 * @param req
	 * @param res
	 * @param supp_logo LOGO
	 * @param supp_name	名称
	 * @param supp_weight 权重
	 * @return
	 */
	@RequestMapping(value="/addSupplierTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addSupplierTab(HttpServletRequest req,HttpServletResponse res,@RequestParam("supp_logo") MultipartFile supp_logo,String supp_name,int supp_weight,String lock_status) {		
		return supplierTabService.addSupplierTab(req, res, supp_logo, supp_name, supp_weight,lock_status);
	};
	/**
	 * 查询厂商信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/querySupplierTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String querySupplierTab(@RequestBody String data) {
		return supplierTabService.querySupplierTab(data);
	};
	/**
	 * 更新厂商信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateSupplierTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateSupplierTab(HttpServletRequest req,HttpServletResponse res,@RequestParam(value="supp_logo",required=false) MultipartFile supp_logo,String supp_name,int supp_weight,int supp_id,String lock_status) {
		return supplierTabService.updateSupplierTab(req, res, supp_logo, supp_name, supp_weight,supp_id,lock_status);
	};
	/**
	 * 删除厂商信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteSupplierTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateSupplierTab(@RequestBody String data) {
		return supplierTabService.deleteSupplierTab(data);
	};
	/**
	 * 总实例添加厂商信息
	 * @param req
	 * @param res
	 * @param supp_logo LOGO
	 * @param supp_name	名称
	 * @param supp_weight 权重
	 * @return
	 */
	@RequestMapping(value="/addPushSupplierTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addPushSupplierTab(HttpServletRequest req,HttpServletResponse res,@RequestParam("supp_logo") MultipartFile supp_logo,String supp_name,int supp_weight,String lock_status) {		
		return supplierTabService.addPushSupplierTab(req, res, supp_logo, supp_name, supp_weight,lock_status);
	};
	/**
	 * 总实例更新厂商信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updatePushSupplierTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updatePushSupplierTab(HttpServletRequest req,HttpServletResponse res,@RequestParam(value="supp_logo",required=false) MultipartFile supp_logo,String supp_name,int supp_weight,int supp_id,String lock_status) {
		return supplierTabService.updatePushSupplierTab(req, res, supp_logo, supp_name, supp_weight, supp_id, lock_status);
	};
}
