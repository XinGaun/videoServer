package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.CategoryTabService;
/**
 * 品类API
 * @author vip
 *
 */
@Controller
@ResponseBody
@RequestMapping("/hangrano2o/Category")
public class CategoryTabController {
	@Autowired
	private CategoryTabService categoryTabService;//调用品类Service层接口
	/**
	 * 添加品类信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addCategoryTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addCategoryTab(@RequestBody String data) {
		return categoryTabService.addCategoryTab(data);
	}
	/**
	 * 查询品类信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryCategoryTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryCategoryTab(@RequestBody String data) {
		return categoryTabService.queryCategoryTab(data);
	}
	/**
	 * 更新品类信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateCategoryTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateCategoryTab(@RequestBody String data) {
		return categoryTabService.updateCategoryTab(data);
	}
	/**
	 * 删除品类信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteCategoryTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteCategoryTab(@RequestBody String data) {
		return categoryTabService.deleteCategoryTab(data);
	}
	/**
	 * ID查询品类信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryCateID",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryCateID(@RequestBody String data) {
		return categoryTabService.queryCateID(data);
	}
	/**
	 * 前端查询品类信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryFrontCategoryTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryFrontCategoryTab(@RequestBody String data) {
		return categoryTabService.queryFrontCategoryTab(data);
	}
	/**
	 * 总实例添加品类信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addPushCategoryTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addPushCategoryTab(@RequestBody String data) {
		return categoryTabService.addPushCategoryTab(data);
	}
	/**
	 * 总实例更新品类信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updatePushCategoryTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updatePushCategoryTab(@RequestBody String data) {
		return categoryTabService.updatePushCategoryTab(data);
	}
}
