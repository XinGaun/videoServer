
package com.web;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSON;
import com.entity.UserTab;
import com.service.UserService;
import com.util.MD5;
import com.util.OSSUtil;


/**  

* <p>Title: UserController</p>  

* <p>Description: </p>  

* @author sxm  

* @date 2018年6月17日  

*/  
@ResponseBody
@Controller
@RequestMapping("/front/User")
public class UserControllers {
	@Autowired
	UserService aService;
	
	//添加用户
	@RequestMapping(value="/saveuser",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String saveuser(@RequestBody String data,HttpServletResponse response){
		UserTab ut = JSON.parseObject(data,UserTab.class);
		int a=aService.addUser(ut);
		
		return JSON.toJSONString(ut.getUser_id());
	}
	//根据手机号查找是否有该用户

	@RequestMapping(value="/queryuser",method=RequestMethod.POST)
	public String queryuser(@RequestBody String user_phone,HttpServletResponse response){
		HashMap<String,Object> map = JSON.parseObject(user_phone,HashMap.class);		
		String json ="";
		try{
			ArrayList<HashMap<String, Object>> aList=aService.queryUser(map.get("user_phone").toString());
			json = JSON.toJSONString(aList);
		}catch(Exception e){
			e.getMessage();
		}
		return json;
	}
	//登录验证账号密码
	@RequestMapping(value="/selectuser")
	public String selectuser(@RequestBody String data,HttpServletResponse response){
		UserTab ut = JSON.parseObject(data,UserTab.class);
		//System.out.println("aaaaaaaaa");
		String spwd=ut.getUser_pwd();
		String smi=MD5.md5(spwd);
		ut.setUser_pwd(smi);
		ArrayList<HashMap<String, Object>> aList=aService.selectUser(ut);
		System.out.println(aList);
		int flag=aList.size();
		if(flag==1){
			return JSON.toJSONString(aList);
		}
		return JSON.toJSONString("账号和密码不一致！");
	}
	//根据手机号更改用户密码
	@RequestMapping(value="/updateuser",method=RequestMethod.POST)
	public String updateuser(@RequestBody String data,HttpServletResponse response){
		//System.out.println("cjxnvmcxb");
		UserTab ut = JSON.parseObject(data,UserTab.class);
		System.out.println(ut.toString());
		String spwd=ut.getUser_pwd();
		String smi=MD5.md5(spwd);
		ut.setUser_pwd(smi);
		ut.setUser_phone(ut.getUser_phone());
		int flag=aService.updateUser(ut);
		System.out.println(aService.updateUser(ut));
		if(flag==1){
			return JSON.toJSONString("更新成功！");
		}
		return JSON.toJSONString("更新失败！");
		//return JSON.toJSONString(flag);
	}
	//个人中心上传头像
	@RequestMapping(value="/addfile",method=RequestMethod.POST)
	public String addfile(@RequestParam(value="file",required=false)MultipartFile file,HttpServletRequest request){
		OSSUtil ou=new OSSUtil();
        String fileName=file.getOriginalFilename();//获取文件名加后缀    
        String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());//文件后缀   
        fileName=new Date().getTime()+"_"+new Random().nextInt(1000)+fileF;//新的文件名    
        CommonsMultipartFile cf= (CommonsMultipartFile)file; //这个myfile是MultipartFile的
		DiskFileItem fi = (DiskFileItem)cf.getFileItem(); 
		File image = fi.getStoreLocation(); 
        String ossFileName = "";
        try {
        	System.out.println(file.getSize());
        	ossFileName =ou.upload(image, fileName);
        	System.out.println(ossFileName);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println(e1.getMessage());
		}
        System.out.println(ou.getWebURL(ossFileName));
        return JSON.toJSONString(ou.getWebURL(ossFileName));
	}
	//个人中心更改用户信息
	@RequestMapping(value="/updatemessages",method=RequestMethod.POST)
	public String updatemessage(@RequestBody String data,HttpServletResponse response){
		System.out.println("bbbbb");
		UserTab ut = JSON.parseObject(data,UserTab.class);
		int flag=aService.updatemessage(ut);
		System.out.println(aService.updatemessage(ut));
		if(flag==1){
			return JSON.toJSONString("信息已保存！");
		}
		return JSON.toJSONString("信息保存失败！");
	}
	//修改手机号
	@RequestMapping(value="/updatephone",method=RequestMethod.POST)
	public String updatephone(@RequestBody String data,HttpServletResponse response){
		System.out.println("bbbbccccccb");
		UserTab ut = JSON.parseObject(data,UserTab.class);
		System.out.println(aService.updatephone(ut));
		return JSON.toJSONString(aService.updatephone(ut));
		
	}
	//根据手机号查找是否有该用户

	@RequestMapping(value="/isfirst",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String isfirst(@RequestBody String user_phone,HttpServletResponse response){
		System.out.println("ssdfgghgfghgf");
		HashMap<String,Object> map = JSON.parseObject(user_phone,HashMap.class);
		ArrayList<HashMap<String, Object>> aList=aService.isfirst(map.get("user_phone").toString());
		System.out.println(aList);
		System.out.println(JSON.toJSONString(aList));
		return JSON.toJSONString(aList);
	}	
	
}
