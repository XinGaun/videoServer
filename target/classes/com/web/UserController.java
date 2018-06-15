package com.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.UserDomain;
import com.service.IUserService;
import com.util.MD5;
import com.util.PaginationBean;
import com.util.ResponseInfo;
import com.util.StringUtils;

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
	@Autowired
	private HttpSession session;
	
	/**
	 * 
	* @Title: modifyUserInfo
	* @Description:修改用户信息
	* @param @param param
	* @param @return    参数
	* @return ResponseInfo    返回类型
	* @throws
	 */
	@RequestMapping("/modifyInfo")
	public @ResponseBody ResponseInfo modifyUserInfo(UserDomain param){
		ResponseInfo responseInfo = new ResponseInfo(1, "修改用户信息成功!");
		if (StringUtils.isBlank(param.getUser_id())) {
			responseInfo.setRetCode(0).setRetMsg("修改用户信息失败,接收用户信息为空!");
			return responseInfo;
		}
		int mdfStatus = userService.modifyUser(param);
		if (mdfStatus == 0) {
			responseInfo.setRetCode(0).setRetMsg("修改用户信息失败!");
		}
		
		return responseInfo;
	}
	
	/**
	 * 
	* @Title: queryUserAll
	* @Description:查询用户信息
	* @param @return    参数
	* @return ResponseInfo    返回类型
	* @throws
	 */
	@RequestMapping("/queryUserAll")
//	@RequiresRoles("user")
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
	
	/**
	 * 
	* @Title: userLogin
	* @Description:哦用户登录方法
	* @param @return    参数
	* @return ResponseInfo    返回类型
	* @throws
	 */
	@RequestMapping("/userLogin")
	public @ResponseBody ResponseInfo userLogin(UserDomain param,String code){
		ResponseInfo responseInfo = new ResponseInfo(1, "登录成功!");
		Subject subject = SecurityUtils.getSubject();
		String password = MD5.md5(param.getUser_pwd());
		String sessionCode = (String)session.getAttribute("key");
        UsernamePasswordToken token = new UsernamePasswordToken(param.getUser_name(), password);
        if (StringUtils.isBlank(code)) {
			responseInfo.setRetCode(0).setRetMsg("验证码为空!");
        	return responseInfo;
		}
        if (code.equals(sessionCode)) {
        	try {
        		//执行认证操作. 
        		subject.login(token);
        	}catch (UnknownAccountException ae) {
        		ae.printStackTrace();
        		System.out.println("登陆失败: " + ae.getMessage());
        		responseInfo.setRetCode(0).setRetMsg("用户名或密码错误!");
        		return responseInfo;
        	}catch (Exception e) {
        		e.printStackTrace();
        		responseInfo.setRetCode(0).setRetMsg("用户名或密码错误!");
        		return responseInfo;
			}
        	//获取认证信息对象中存储的User对象
        	UserDomain user = (UserDomain) subject.getPrincipal();
        	session.setAttribute("user", user);
//		ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
		}else {
			responseInfo.setRetCode(0).setRetMsg("验证码错误!");
		}
        return responseInfo;
		
	}
}
