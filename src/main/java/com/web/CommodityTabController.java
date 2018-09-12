package com.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.entity.CommodityTab;
import com.service.CommodityTabService;
/**
 * 商品API
 * @author vip
 *
 */
@Controller
@ResponseBody
@RequestMapping("/hangrano2o/Commodity")
public class CommodityTabController {
	@Autowired
	private CommodityTabService commodityTabService;//调用商品Service层接口
	/**
	 * 添加商品
	 * @return
	 */
	@RequestMapping(value="/addCommodityTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addCommodityTab(@RequestParam("comm_main_imgs") MultipartFile comm_main_imgs,@RequestParam("comm_else_imgs") MultipartFile[] comm_else_imgs,CommodityTab commodityTab) {
		return commodityTabService.addCommodityTab(comm_main_imgs, comm_else_imgs, commodityTab);	
	}
	/**
	 * 查询商品
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryCommodityTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryCommodityTab(@RequestBody String data) {
		return commodityTabService.queryCommodityTab(data);
	}
	/**
	 * 修改商品
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateCommodityTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateCommodityTab(@RequestParam(value="comm_main_imgs",required=false) MultipartFile comm_main_imgs,@RequestParam(value="comm_else_imgs",required=false) MultipartFile[] comm_else_imgs,CommodityTab commodityTab) {
		return commodityTabService.updateCommodityTab(comm_main_imgs, comm_else_imgs, commodityTab);	
	}
	/**
	 * 删除商品
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteCommodityTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteCommodityTab(@RequestBody String data) {
		return commodityTabService.queryCommodityTab(data);
	}
	/**
	 * 根据商品名称ID模糊搜索
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryCommName",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryCommName(@RequestBody String data) {
		return commodityTabService.queryCommName(data);
	}
	/**
	 * 查询前端商品详情
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryFrontCommodityTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String quertFrontCommodityTab(@RequestBody String data) {
		return commodityTabService.quertFrontCommodityTab(data);
	}
	/**
	 * 后端前端商品详情
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryCommodityTabBack",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryCommodityTabBack(@RequestBody String data) {
		return commodityTabService.queryCommodityTabBack(data);
	}
	/**
	 * 总实例提添加商品
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addPushCommodityTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addPushCommodityTab(@RequestParam("comm_main_imgs") MultipartFile comm_main_imgs,@RequestParam("comm_else_imgs") MultipartFile[] comm_else_imgs,CommodityTab commodityTab) {
		return commodityTabService.addPushCommodityTab(comm_main_imgs, comm_else_imgs, commodityTab);
	}
	/**
	 * 总实例更新商品
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updatePushCommodityTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updatePushCommodityTab(@RequestParam(value="comm_main_imgs",required=false) MultipartFile comm_main_imgs,@RequestParam(value="comm_else_imgs",required=false) MultipartFile[] comm_else_imgs,CommodityTab commodityTab) {
		return commodityTabService.updatePushCommodityTab(comm_main_imgs, comm_else_imgs, commodityTab);
	}
	/**
	 * 总实例删除商品
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deletePushCommodityTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deletePushCommodityTab(@RequestBody String data) {
		return commodityTabService.deletePushCommodityTab(data);
	}
}
