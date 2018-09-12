package com.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.entity.InquiryTab;
import com.service.InquiryTabService;

/**
 * 咨询留言API
 * @author vip
 *
 */
@RequestMapping("/hangrano2o/Inquiry")
@Controller
@ResponseBody
public class InquiryTabController {
	@Autowired
	private InquiryTabService inquiryTabService;//调用咨询留言Service层接口
	/**
	 * 添加咨询留言
	 * @return
	 */
	@RequestMapping(value="/addInquiryTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addInquiryTab(@RequestParam(value="inqu_imgs",required=false) MultipartFile[] inqu_imgs,InquiryTab inquiryTab) {
		return inquiryTabService.addInquiryTab(inqu_imgs, inquiryTab);
	}
	/**
	 * 查询咨询信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryInquiryTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryInquiryTab(@RequestBody String data) {
		return inquiryTabService.queryInquiryTab(data);
	}
	/**
	 * 更新咨询信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateInquiryTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateInquiryTab(@RequestParam(value="inqu_imgs",required=false) MultipartFile[] inqu_imgs,InquiryTab inquiryTab) {
		return inquiryTabService.updateInquiryTab(inqu_imgs, inquiryTab);
	}
	/**
	 * 删除咨询信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteInquiryTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteInquiryTab(@RequestBody String data) {
		return inquiryTabService.deleteInquiryTab(data);
	}
}
