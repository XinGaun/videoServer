package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.subscriptionTab;
import com.service.subscriptionTabService;

@Controller
@RequestMapping("/subscriptionTab")
public class subscriptionTabController {
	@Autowired
	private subscriptionTabService subService;
	
	@RequestMapping(value="/insertTab.do",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void insertTab(Integer user_id,Integer video_id){
		subscriptionTab v=new subscriptionTab();
		v.setUser_id(user_id);
		v.setVideo_id(video_id);
		subService.insertSubTab(v);
	}
}
