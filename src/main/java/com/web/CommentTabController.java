package com.web;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.entity.TeacherDomain;
import com.service.CommentTabService;

@Controller
@RequestMapping("/commentTab")
@ResponseBody
public class CommentTabController extends DemoController{
	@Autowired
	private CommentTabService service;

//	@RequestMapping(value="/addComment",produces="application/json;charset=utf-8")
//	public String addComment(@RequestBody String data) {
//		
//		HashMap<String,Object> datemap = formQuery(data);
//		String result = service.addCommentTabMap(datemap);
//		return result;
//	}
	
	@RequestMapping(value="/queryCommentAll",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})	
	public String queryCommentTabList(@RequestBody String data,HttpServletRequest request) {
		TeacherDomain teacher=(TeacherDomain) request.getSession().getAttribute("user");
		int teacher_id = Integer.parseInt(teacher.getTeacher_id());
		
		HashMap<String,Object> hashmap = JSON.parseObject(data, HashMap.class);
		hashmap.put("teacher_id", teacher_id);
		logger.info("hashmap"+hashmap);
		String result =service.queryCommentTab(hashmap);
		logger.info("result"+result);
		return result;
	}
	
	@RequestMapping(value="/deleteComment",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})	
	public String deleteCommentTabList(@RequestBody String data) {
		logger.info("data"+data);
		@SuppressWarnings("unchecked")
		List<String> datalist =  JSON.parseObject(data, List.class);
		String result =service.deleteCommentTab(datalist);
		return result;
	}
	
	@RequestMapping(value="/updateComment",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})	
	public String updateCommentTabList(@RequestBody String data,HttpServletRequest request) {
		logger.info("data"+data);
		TeacherDomain teacher=(TeacherDomain) request.getSession().getAttribute("user");
		int teacher_id = Integer.parseInt(teacher.getTeacher_id());
		
		@SuppressWarnings("unchecked")
		HashMap<String,Object> hashmap = JSON.parseObject(data, HashMap.class);
		hashmap.put("reply_teacher", teacher_id);
		String result =service.updateCommentTab(hashmap);
		return result;
	}
}
