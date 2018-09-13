package com.web;


import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.disk.DiskFileItem;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.eclipse.jetty.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.entity.TeacherDomain;
import com.service.ITeacherService;
import com.util.MD5;

import com.util.OSSUtil;

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
@RequestMapping("teacher")
public class TeacherController {
	@Autowired
	private ITeacherService teacherService;//调用订单Service层接口
	@Autowired
	private HttpSession session;
	

	/**
	 * 
	* @Title: teacherImgUpload
	* @author hcb
	* @Description:教师头像上传
	* @param @return    参数
	* @return ResponseInfo    返回类型
	* @date 2018年7月7日 下午6:47:45
	* @throws
	 */
	@RequestMapping("/teacherImgUpload")
	public @ResponseBody ResponseInfo teacherImgUpload(MultipartFile imgFile){
		ResponseInfo responseInfo = new ResponseInfo(1, "图片上传成功");
		OSSUtil ou=new OSSUtil();
		String fileName=imgFile.getOriginalFilename();//获取文件名加后缀    
        String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());//文件后缀   
        fileName=new Date().getTime()+"_"+new Random().nextInt(1000)+fileF;//新的文件名    
        CommonsMultipartFile cf= (CommonsMultipartFile)imgFile; //这个myfile是MultipartFile的
		DiskFileItem fi = (DiskFileItem)cf.getFileItem(); 
		File image = fi.getStoreLocation(); 
        String ossFileName = "";
        try {
        	System.out.println(imgFile.getSize());
        	ossFileName =ou.upload(image, fileName);
        	System.out.println(ossFileName);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println(e1.getMessage());
		}
        System.out.println(ou.getWebURL(ossFileName));
        responseInfo.setRetMsg(ou.getWebURL(ossFileName));
		return responseInfo;
	}
	
	/**
	 * 
	* @Title: logout
	* @author hcb
	* @Description:退出登录
	* @param @param redirectAttributes
	* @param @return    参数
	* @return ResponseInfo    返回类型
	* @date 2018年7月7日 下午6:45:55
	* @throws
	 */
	@RequestMapping("/teacherLogout")    
    public @ResponseBody ResponseInfo logout(RedirectAttributes redirectAttributes ){   
        //使用权限管理工具进行用户的退出，跳出登录，给出提示信息  
		ResponseInfo responseInfo = new ResponseInfo(1, "登录成功!");
        SecurityUtils.getSubject().logout();    
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
	@RequestMapping("/teacherLogin")
	public @ResponseBody ResponseInfo userLogin(TeacherDomain param,String code){
		ResponseInfo responseInfo = new ResponseInfo(1, "登录成功!");
		Subject subject = SecurityUtils.getSubject();
		String password = MD5.md5(param.getTeacher_pwd());
		String sessionCode = (String)session.getAttribute("key");
        UsernamePasswordToken token = new UsernamePasswordToken(param.getTeacher_phone(), password);
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
        	TeacherDomain user = (TeacherDomain) subject.getPrincipal();
        	session.setAttribute("user", user);
//		ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
		}else {
			responseInfo.setRetCode(0).setRetMsg("验证码错误!");
		}
        return responseInfo;
		
	}
	
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
		responseInfo.setRetObject(page);
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
