package com.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.entity.register;
import com.service.registerService;

@Controller
@RequestMapping("/register")
public class registerController {
	@Autowired
	public registerService registerService;

	@RequestMapping(value = "getUser.do",produces="application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public String getRegister() {
		List<register> list=registerService.getRegister();
		return JSON.toJSONString(list);
	}
	
	@RequestMapping(value = "upload.do",produces="application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public String upload() {
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMddHHmmss");
		String date=df.format(new Date());
		//String newFujianName=date + ".avi";
		return JSON.toJSONString(date);
	}
}
