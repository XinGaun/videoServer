
package com.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.entity.UserTab;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.service.UserService;
import com.util.MD5;


@Controller
@RequestMapping("/User")
public class UserControllers {
	@Autowired
	UserService aService;
	@ResponseBody
	@RequestMapping(value="/saveuser",method=RequestMethod.POST)
	public String saveuser(@RequestBody UserTab ut,HttpServletResponse response){
		
		System.out.println(ut);
		System.out.println(ut.getUser_phone());
		String spwd=ut.getUser_pwd();
		String smi=MD5.md5(spwd);
		ut.setUser_pwd(smi);
		//System.out.println(ut.getUser_date());
		
		return JSON.toJSONString(aService.addUser(ut));
	}
	@ResponseBody
	@RequestMapping(value="/queryuser")
	public String queryuser(String user_phone,HttpServletResponse response){
		System.out.println(1111);
		System.out.println(user_phone);
		ArrayList<HashMap<String, Object>> aList=aService.queryUser(user_phone);
		return JSON.toJSONString(aList.size());
	}
	@ResponseBody
	@RequestMapping(value="/selectuser",produces="application/json;charset=utf-8")
	public String selectuser(@RequestBody UserTab ut,HttpServletResponse response){
		System.out.println("aaaaaaaaa");
		System.out.println(ut.getUser_phone());
		System.out.println(ut.getUser_pwd());
		ArrayList<HashMap<String, Object>> aList=aService.selectUser(ut);
		int flag=aList.size();
		if(flag==1){
			Cookie cookie1=new Cookie("user_phone",aList.get(0).get("user_phone").toString());
			
			response.addCookie(cookie1);

			return JSON.toJSONString(aList);
		}
		return JSON.toJSONString("账号和密码不一致！");
	}
	@ResponseBody
	@RequestMapping(value="/updateuser",method=RequestMethod.POST)
	public String updateuser(@RequestBody UserTab ut,HttpServletResponse response){
		System.out.println("bbbbb");
		System.out.println(ut.getUser_phone());
		System.out.println(ut.getUser_pwd());
		String spwd=ut.getUser_pwd();
		String smi=MD5.md5(spwd);
		ut.setUser_pwd(smi);
		ut.setUser_phone(ut.getUser_phone());
		int flag=aService.updateUser(ut);
		
		if(flag==1){
			return JSON.toJSONString("更新成功！");
		}
		return JSON.toJSONString("更新失败！");
		//return JSON.toJSONString(flag);
	}
}
