package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.UserTestService;

@Controller
@RequestMapping("/UserTest")
@ResponseBody
public class UserTestController {
	@Autowired
	private UserTestService userTestService;
	/**
	 * 添加题目信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addUserTest",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addUserTest(@RequestBody String data) {
		return userTestService.addUserTest(data);
	}
	/**
	 * 查询题目信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryUserTest",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryUserTest(@RequestBody String data) {
		return userTestService.queryUserTest(data);
	}
	/**
	 * 查询答案信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryUserTestAnswer",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryUserTestAnswer(@RequestBody String data) {
		return userTestService.queryUserTestAnswer(data);
	}
	/**
	 * 更新题目信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateUserTest",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateUserTest(@RequestBody String data) {
		return userTestService.updateUserTest(data);
	}
	/**
	 * 删除题目信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deteleUserTest",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deteleUserTest(@RequestBody String data) {
		return userTestService.deteleUserTest(data);
	}
}
