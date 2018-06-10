package com.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.UserDomain;
import com.service.IUserService;
import com.util.PaginationBean;
import com.util.ResponseInfo;

/**
 * 
* @ClassName: TeacherController
* @Description: 教师信息的管理控制类
* @author A18ccms a18ccms_gmail_com
* @date 2018年6月9日 下午9:44:21
*
 */

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private IUserService userService;
	
	
	/**
	 * 
	* @Title: queryUserAll
	* @Description:查询用户信息
	* @param @return    参数
	* @return ResponseInfo    返回类型
	* @throws
	 */
	@RequestMapping("/queryUserAll")
	public @ResponseBody ResponseInfo queryUserAll(UserDomain param,Integer pageSize,Integer currPage){
		ResponseInfo responseInfo = new ResponseInfo(1, "加载用户信息成功!");
		PaginationBean page = null;
		if (pageSize != null && currPage != null) {
			page = new PaginationBean();
			page.setPageSize(pageSize);
			page.setCurrentPage(currPage);
		}
		List<UserDomain> userList = userService.queryListUser(param, page);
		responseInfo.setListObject(userList);
		return responseInfo;
	}
	
	
}
