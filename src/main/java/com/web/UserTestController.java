package com.web;

import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.UserTestService;
import com.util.OSSUtil;

@Controller
@RequestMapping("/front/UserTest")
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
	/**
	 * 查询评价信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryUserTestEvaluate",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryUserTestEvaluate(@RequestBody String data) {
		
		return userTestService.queryUserTestEvaluate(data);
	}
	/**
	 * 添加评价信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addUserTestEvaluate",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addUserTestEvaluate(@RequestBody String data) {
		return userTestService.addUserTestEvaluate(data);
	}
	/**
	 * 删除评价信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteUserTestEvaluate",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteUserTestEvaluate(@RequestBody String data) {
		return userTestService.deleteUserTestEvaluate(data);
	}
	/**
	 * 更新评价信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateUserTestEvaluate",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateUserTestEvaluate(@RequestBody String data) {
		return userTestService.updateUserTestEvaluate(data);
	}
	/**
	 * 查询评价分类
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryUserTestEvaluatetypeName",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryUserTestEvaluatetypeName() {
		return userTestService.queryUserTestEvaluatetypeName();
	}
	/**
	 * 按难分类查询难度信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryUserTestEvaluateTestGrade",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryUserTestEvaluateTestGrade(@RequestBody String data) {
		return userTestService.queryUserTestEvaluateTestGrade(data);
	}
	/**
	 * 随机查询测试题
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryRandomUserTestAnswer",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryRandomUserTestAnswer(@RequestBody String data) {
		return userTestService.queryRandomUserTestAnswer(data);
	}
	/**
	 * 查询测试题答案
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryAnswerEvaluate",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryAnswerEvaluate(@RequestBody String data) {
		System.out.println(data);
		return userTestService.queryAnswerEvaluate(data);
	}
	/**
	 * 测试文件下载
	 * @param data
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/download",produces="application/json;charset=utf-8",method=RequestMethod.GET)
	public void download(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		//System.out.println(123);
		OSSUtil ossUtil = new OSSUtil();
		String flieName = request.getQueryString()+".mp4";
		flieName = flieName.substring(9, flieName.length());
		System.out.println(flieName);
		resp.setHeader("Content-Disposition", "attachment;filename="+flieName);
		ossUtil.downloadInputStram(request,resp,flieName);
		
	}
}
