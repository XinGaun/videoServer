package com.web;

import java.util.List;

import org.eclipse.jetty.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.TeacherDomain;
import com.service.ITeacherService;
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
@RequestMapping("teacher")
public class TeacherController {
	@Autowired
	private ITeacherService teacherService;//调用订单Service层接口
	
	/**
	 * 
	* @Title: addTeacherInfo
	* @Description:添加教师信息
	* @param @param param
	* @param @return    参数
	* @return ResponseInfo    返回类型
	* @throws
	 */
	@RequestMapping(value="/addTeacherInfo")
	public @ResponseBody ResponseInfo addTeacherInfo(TeacherDomain param){
		return teacherService.addTeacher(param);
		
	}
	
	/**
	* @Title: queryTeacherTabAll
	* @Description: 查询教师信息
	* @param @param param
	* @param @param pageSize
	* @param @param currPage
	* @param @return    参数
	* @return ResponseInfo    返回类型
	* @throws
	 */
	@RequestMapping(value="/queryTeacherAll",produces="application/json;charset=utf-8")
	@ResponseBody 
	public ResponseInfo queryTeacherTabAll(TeacherDomain param,Integer pageSize,Integer currPage) {
		ResponseInfo responseInfo = new ResponseInfo(1, "查询教师信息成功!");
		PaginationBean page = null;
		if (pageSize != null && currPage != null) {
			page = new PaginationBean();
			page.setCurrentPage(currPage);
			page.setPageSize(pageSize);
		}
		List<TeacherDomain> teacherInfo = teacherService.queryListTeacher(param, page);
		responseInfo.setListObject(teacherInfo);
		return responseInfo;
	}
	
	/**
	 * 
	* @Title: modifyTeacherInfo
	* @Description:修改教师信息
	* @param @param param
	* @param @return    参数
	* @return ResponseInfo    返回类型
	* @throws
	 */
	@RequestMapping(value="/modifyInfo")
	public @ResponseBody ResponseInfo modifyTeacherInfo(TeacherDomain param){
		ResponseInfo responseInfo = new ResponseInfo(1, "修改信息成功");
		if (StringUtil.isBlank(param.getTeacher_id())) {
			responseInfo.setRetCode(0).setRetMsg("数据有误,接收教师编号为空!");
			return responseInfo;
		}
		int mdfStatus = teacherService.modifyTeacher(param);
		if (mdfStatus == 0) {
			responseInfo.setRetCode(0).setRetMsg("修改教师信息失败!");
		}
		return responseInfo;
	}
	
	/**
	 * 
	* @Title: deleteTeacherInfo
	* @Description:接收页面回传教师编号 删除教师信息
	* @param @param id
	* @param @return    参数
	* @return ResponseInfo    返回类型
	* @throws
	 */
	@RequestMapping(value="/deleteTeacherInfo")
	public @ResponseBody ResponseInfo deleteTeacherInfo(String teacher_id){
		ResponseInfo responseInfo = new ResponseInfo(1, "删除信息成功");
		if (StringUtil.isBlank(teacher_id)) {
			responseInfo.setRetCode(0).setRetMsg("数据有误,接收教师编号为空!");
			return responseInfo;
		}
		TeacherDomain param = new TeacherDomain();
		param.setTeacher_id(teacher_id);
		int delStatus = teacherService.deleteTeacher(param);
		if (delStatus == 0) {
			responseInfo.setRetCode(0).setRetMsg("删除教师信息失败!");
		}
		return responseInfo;
	}
	
}
