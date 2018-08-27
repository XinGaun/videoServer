package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.playsTab;
import com.service.playsTabService;

@Controller
@RequestMapping("/playsTab")
public class playsTabController {
	@Autowired
	private playsTabService pService;
	
	@RequestMapping(value="/insertTab.do",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void insertTab(int user_id,int video_id,String plays_time){
		playsTab v=new playsTab();
		v.setUser_id(user_id);
		v.setVideo_id(video_id);
		pService.insertPlaysTab(v);
	}
}
