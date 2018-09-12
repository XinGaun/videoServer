package com.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.entity.WriterTab;
import com.service.WriterTabService;
/**
 * 文案API
 * @author vip
 *
 */
@RequestMapping("/hangrano2o/Writer")
@ResponseBody
@Controller
public class WriterTabController {
	@Autowired
	private WriterTabService writerTabService;//调用文案Service层接口
	/**
	 *  添加文案信息
	 * @param req
	 * @param res
	 * @param writ_img 文案封面
	 * @param writ_title 标题
	 * @param writ_test 内容
	 * @param writ_status 激活状态
	 * @param staf_id 员工ID
	 * @return
	 */
	@RequestMapping(value="/addWriterTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addWriterTab(MultipartFile writ_imgs,WriterTab writerTab) {
		return writerTabService.addWriterTab(writ_imgs, writerTab);
	}
	/**
	 * 查询文案信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryWriterTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryWriterTab(@RequestBody String data) {
		return writerTabService.queryWriterTab(data);
	}
	/**
	 * 更新文案信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateWriterTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateWriterTab(@RequestParam(value="writ_imgs",required=false) MultipartFile writ_imgs,WriterTab writerTab) {
		return writerTabService.updateWriterTab(writ_imgs, writerTab);
	}
	/**
	 * 删除文案信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteWriterTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteWriterTab(@RequestBody String data) {
		return writerTabService.deleteWriterTab(data);
	}

}
