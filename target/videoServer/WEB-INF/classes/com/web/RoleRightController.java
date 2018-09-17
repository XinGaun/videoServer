package com.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.eclipse.jetty.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.RightDomain;
import com.entity.RoleDomain;
import com.entity.RoleRightDomain;
import com.entity.TeacherDomain;
import com.service.IRightService;
import com.service.IRoleRightService;
import com.service.IRoleService;
import com.util.PaginationBean;
import com.util.ResponseInfo;

/**
 * 
* @ClassName: TeacherController
* @Description: 角色权限的管理控制类
* @author A18ccms a18ccms_gmail_com
* @date 2018年6月9日 下午9:44:21
*
 */

@Controller
@RequestMapping("roleRight")
public class RoleRightController {
	@Autowired
	private IRoleService roleService;//调用订单Service层接口
	
	@Autowired
	private IRightService rightService;
	
	@Autowired
	private IRoleRightService roleRightService;
	
	@Autowired
	private HttpSession session;
	
	/**
	 * 
	* @Title: httpPageEle
	* @Description:加载登录用户信息  判断用户角色
	* @param @return    参数
	* @return ResponseInfo    返回类型
	* @throws
	 */
	@RequestMapping("/httpPageEle")
	public @ResponseBody ResponseInfo httpPageEle(){
		ResponseInfo responseInfo = new ResponseInfo(1, "teacher");
		TeacherDomain teacher = (TeacherDomain)session.getAttribute("user");
		List<Map<String, String>> roleList = roleRightService.queryUserRole(teacher.getTeacher_id());
		for (Map<String, String> map : roleList) {
			if("admin".equals(map.get("role_name"))){
				responseInfo.setRetMsg("admin");
			}
		}
		return responseInfo;
	}
	
	/**
	 * 
	* @Title: modifyRoleRight
	* @Description:修改角色的权限
	* @param @param param
	* @param @return    参数
	* @return ResponseInfo    返回类型
	* @throws
	 */
	@RequestMapping("/modifyRoleRight")
	public @ResponseBody ResponseInfo modifyRoleRight(RoleRightDomain param){
		
		return  roleRightService.modifyRoleRight(param);
	}
	
	/**
	 * 
	* @Title: queryRightAll
	* @Description:查询所有角色权限
	* @param @param param
	* @param @return    参数
	* @return ResponseInfo    返回类型
	* @throws
	 */
	@RequestMapping("/queryRoleRight")
	private @ResponseBody ResponseInfo queryRoleRight(RoleRightDomain param){
		ResponseInfo responseInfo = new ResponseInfo(1, "加载信息成功!");
		List<RoleRightDomain> result = roleRightService.queryListRoleRight(param, null);
		responseInfo.setListObject(result);
		return responseInfo;
	}
	
	/**
	 * 
	* @Title: queryRightAll
	* @Description: 加载所有权限数据
	* @param @return    参数
	* @return ResponseInfo    返回类型
	* @throws
	 */
	@RequestMapping("/queryRightAll")
	public @ResponseBody ResponseInfo queryRightAll(RightDomain param){
		ResponseInfo responseInfo = new ResponseInfo(1, "加载信息成功!");
		List<RightDomain> result = rightService.queryListRight(param, null);
		responseInfo.setListObject(result);
		return responseInfo;
	}
	
	/**
	 * 
	* @Title: addRoleInfo
	* @Description:添加角色信息
	* @param @param param
	* @param @return    参数
	* @return ResponseInfo    返回类型
	* @throws
	 */
	@RequestMapping(value="/addRoleInfo")
	public @ResponseBody ResponseInfo addRoleInfo(RoleDomain param){
		param.setRole_status("5");
		return roleService.addRole(param);
		
	}
	
	/**
	* @Title: queryTeacherTabAll
	* @Description: 查询角色信息
	* @param @param param
	* @param @param pageSize
	* @param @param currPage
	* @param @return    参数
	* @return ResponseInfo    返回类型
	* @throws
	 */
	@RequestMapping(value="/queryRoleAll",produces="application/json;charset=utf-8")
	@ResponseBody 
	public ResponseInfo queryRoleTabAll(RoleDomain param,Integer pageSize,Integer currPage) {
		ResponseInfo responseInfo = new ResponseInfo(1, "查询角色信息成功!");
		PaginationBean page = null;
		if (pageSize != null && currPage != null) {
			page = new PaginationBean();
			page.setCurrentPage(currPage);
			page.setPageSize(pageSize);
		}
		List<RoleDomain> roleInfo = roleService.queryListRole(param, page);
		responseInfo.setListObject(roleInfo);
		return responseInfo;
	}
	
	/**
	 * 
	* @Title: modifyRoleInfo
	* @Description:修改角色信息
	* @param @param param
	* @param @return    参数
	* @return ResponseInfo    返回类型
	* @throws
	 */
	@RequestMapping(value="/modifyInfo")
	public @ResponseBody ResponseInfo modifyRoleInfo(RoleDomain param){
		ResponseInfo responseInfo = new ResponseInfo(1, "修改信息成功");
		if (StringUtil.isBlank(param.getRole_id())) {
			responseInfo.setRetCode(0).setRetMsg("数据有误,接收角色编号为空!");
			return responseInfo;
		}
		int mdfStatus = roleService.modifyRole(param);
		if (mdfStatus == 0) {
			responseInfo.setRetCode(0).setRetMsg("修改角色信息失败!");
		}
		return responseInfo;
	}
	
	/**
	 * 
	* @Title: deleteTeacherInfo
	* @Description:接收页面回传角色编号 删除角色信息
	* @param @param id
	* @param @return    参数
	* @return ResponseInfo    返回类型
	* @throws
	 */
	@RequestMapping(value="/deleteRoleInfo")
	public @ResponseBody ResponseInfo deleteRoleInfo(String teacher_id){
		ResponseInfo responseInfo = new ResponseInfo(1, "删除信息成功");
		if (StringUtil.isBlank(teacher_id)) {
			responseInfo.setRetCode(0).setRetMsg("数据有误,接收角色编号为空!");
			return responseInfo;
		}
		RoleDomain param = new RoleDomain();
		param.setRole_id(teacher_id);
		int delStatus = roleService.deleteRole(param);
		if (delStatus == 0) {
			responseInfo.setRetCode(0).setRetMsg("删除角色信息失败!");
		}
		return responseInfo;
	}
	
}
