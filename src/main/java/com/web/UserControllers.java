
package com.web;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.entity.Photo;
import com.entity.UserTab;
import com.service.UserService;
import com.util.DateUtil;
import com.util.MD5;


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
	//根据手机号查找是否有该用户

	@RequestMapping(value="/queryuser",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryuser(@RequestBody String user_phone,HttpServletResponse response){
		HashMap<String,Object> map = JSON.parseObject(user_phone,HashMap.class);
		ArrayList<HashMap<String, Object>> aList=aService.queryUser(map.get("user_phone").toString());
		System.out.println(aList);
		String json = JSON.toJSONString(aList);
		System.out.println(json);
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
	public String updateuser(@RequestBody UserTab ut,HttpServletResponse response){
		//System.out.println("bbbbb");
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
	//个人中心上传头像
	@RequestMapping(value="/addfile",method=RequestMethod.POST)
	public String addfile(@RequestParam(value="file",required=false)MultipartFile file,HttpServletRequest request){
		System.out.println("11111111111");
		File targetFile=null;
        String msg="";//返回存储路径
        int code=1;
        String fileName=file.getOriginalFilename();//获取文件名加后缀
        if(fileName!=null&&fileName!=""){   
            String returnUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() +request.getContextPath() +"/boo/photos/LoginPhoto/";//存储路径
            String path = request.getSession().getServletContext().getRealPath("/boo/photos/LoginPhoto"); //文件存储位置
            System.out.println(path);
            String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());//文件后缀
            fileName=new Date().getTime()+"_"+new Random().nextInt(1000)+fileF;//新的文件名
            System.out.println(fileName);
            
            
            //先判断文件是否存在
            String fileAdd = DateUtil.dateToStr(new Date(),"yyyyMMdd");
            File file1 =new File(path+"/"+fileAdd); 
           
            System.out.println(file1);
            //如果文件夹不存在则创建    
            if(!file1 .exists()  && !file1 .isDirectory()){       
                file1 .mkdir();  
            }
            targetFile = new File(file1, fileName);
            //targetFile = new File(path, fileName);
            try {
                file.transferTo(targetFile);
                //msg=returnUrl+fileName;
                msg=returnUrl+fileAdd+"/"+fileName;
                code=0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(JSON.toJSONString(Photo.result(code, msg)));
        return JSON.toJSONString(Photo.result(code, msg));
	}
	//个人中心更改用户信息
	@RequestMapping(value="/updatemessage",method=RequestMethod.POST)
	public String updatemessage(@RequestBody UserTab ut,HttpServletResponse response){
		//System.out.println("bbbbb");
		int flag=aService.updatemessage(ut);
		if(flag==1){
			return JSON.toJSONString("信息已保存！");
		}
		return JSON.toJSONString("信息保存失败！");
	}
	//修改手机号
	@RequestMapping(value="/updatephone",method=RequestMethod.POST)
	public String updatephone(@RequestBody UserTab ut,HttpServletResponse response){
		System.out.println("bbbbb");
		System.out.println(ut.getUser_email());
		
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
