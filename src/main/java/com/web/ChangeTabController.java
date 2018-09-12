package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.entity.ChangeTab;
import com.service.ChangeTabService;

/**
 * 退换货单API
 * @author vip
 *
 */
@RequestMapping("/hangrano2o/Change")
@ResponseBody
@Controller
public class ChangeTabController {
	@Autowired
	private ChangeTabService changeTabService;//调用退换货单Service层接口
	/**
	 * 添加退换货单信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addChangeTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addChangeTab(@RequestParam(value="chan_imgs",required=false) MultipartFile[] chan_imgs,ChangeTab changeTab) {
		return changeTabService.addChangeTab(chan_imgs, changeTab);
	}
	/**
	 * 查询退换货单信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryChangeTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryChangeTab(@RequestBody String data) {
		return changeTabService.queryChangeTab(data);
	}
	/**
	 * 更新退换货单信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateChangeTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateChangeTab(@RequestParam(value="chan_imgs",required=false) MultipartFile[] chan_imgs,ChangeTab changeTab) {
		return changeTabService.updateChangeTab(chan_imgs, changeTab);
	}
	/**
	 * 删除退换货单信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteChangeTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteChangeTab(@RequestBody String data) {
		return changeTabService.deleteChangeTab(data);
	}
	/**
	 *审核退换货单信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/auditChangeTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String auditChangeTab(@RequestBody String data) {
		return changeTabService.auditChangeTab(data);
	}
	/**
	 * 订单ID查询退换货记录信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryChangeOrderId",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryChangeOrderId(@RequestBody String data) {
		return changeTabService.queryChangeOrderId(data);
	}
	/**
	 * 前端添加退换货单信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addFrontChangeTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addFrontChangeTab(@RequestParam(value="chan_imgs",required=false) MultipartFile[] chan_imgs,ChangeTab changeTab) {
		return changeTabService.addFontChangeTab(chan_imgs, changeTab);
	}
}
