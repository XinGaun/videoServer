package com.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.entity.videoFormTab;
import com.service.videoFormTabService;
@Controller
@RequestMapping("/videoFormTab")
public class videoFormTabController {
	@Autowired
	private videoFormTabService vService;
	
	@RequestMapping(value="/updateTab.do",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void uploadflv(String video_form_id,String video_form_name,String video_form_class,Integer video_form_status){
		System.out.println(video_form_id+video_form_name+video_form_class+video_form_status);
		videoFormTab v=new videoFormTab();
		v.setVideo_form_id(Integer.parseInt(video_form_id));
		v.setVideo_form_name(video_form_name);
		v.setVideo_form_class(video_form_class);
		v.setVideo_form_status(video_form_status);
		vService.updateTab(v);
	}
	@RequestMapping(value="/getVideoList.do",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String getVideoList(){
		return JSON.toJSONString(vService.getVideoFormTabs());
	}
	@RequestMapping(value="/insertTab.do",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void insertTab(String video_form_name,String video_form_class){
		videoFormTab v=new videoFormTab();
		v.setVideo_form_name(video_form_name);
		v.setVideo_form_class(video_form_class);
		vService.insertTab(v);
	}
	
	@RequestMapping(value="/searchTab.do",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String searchTab(String video_form_name,String video_form_class){
		System.out.println(video_form_name+video_form_class);
		videoFormTab v=new videoFormTab();
		v.setVideo_form_name(video_form_name);
		v.setVideo_form_class(video_form_class);	
		return JSON.toJSONString(vService.searchTab(v));
	}
	
	@RequestMapping(value="/getTabById.do",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String getTabById(String video_form_id){
		System.out.println(video_form_id);
		return JSON.toJSONString(vService.getTabById(Integer.parseInt(video_form_id)));
	}
	
	@RequestMapping(value="/upstatusTabById.do",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void upStatusTabById(String video_form_id,String video_form_status){
		System.out.println(video_form_id+video_form_status);
		vService.upStatusTabById(Integer.parseInt(video_form_id),Integer.parseInt(video_form_status));
	}
}
