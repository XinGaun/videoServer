package com.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.entity.VideoTab;
import com.service.VideoTabService;

@Controller
@RequestMapping("/videoTab")
public class videoTabController {
	 
	@Autowired
	private VideoTabService vdservice;
	private File ssfile;
	private String ssfileFileName;

	public File getSsfile() {
		return ssfile;
	}
	public void setSsfile(File ssfile) {
		this.ssfile = ssfile;
	}

	public String getSsfileFileName() {
		return ssfileFileName;
	}
	public void setSsfileFileName(String ssfileFileName) {
		this.ssfileFileName = ssfileFileName;
	}
	
	
	@RequestMapping(value="/uploadflv.do",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void uploadflv(String video_name, String video_introduce,String video_url, String video_img_url,Integer video_form_id,@RequestParam MultipartFile[] myfiles,HttpServletRequest request) throws Exception{
		//如果只是上传一个文件，则只需要MultipartFile类型接收文件即可，而且无需显式指定@RequestParam注解   
        //如果想上传多个文件，那么这里就要用MultipartFile[]类型来接收文件，并且还要指定@RequestParam注解   
        //并且上传多个文件时，前台表单中的所有<input type="file"/>的name都应该是myfiles，否则参数里的myfiles无法获取到所有上传的文件   
          
        for(MultipartFile myfile : myfiles){   
            if(myfile.isEmpty()){   
                System.out.println("文件未上传");   
            }else{   
                System.out.println("文件长度: " + myfile.getSize());   
                System.out.println("文件类型: " + myfile.getContentType());   
                System.out.println("文件名称: " + myfile.getName());   
                System.out.println("文件原名: " + myfile.getOriginalFilename());   
                System.out.println("========================================");   
                //如果用的是Tomcat服务器，则文件会上传到  
                String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");   
                //这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉，我是看它的源码才知道的   
                FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realPath, myfile.getOriginalFilename()));   
            }   
        }   
          
		vdservice.uploadVideo(new HashMap<String,Object>());
	}
	
	
   @RequestMapping(value="/getVideoTabs.do",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
   @ResponseBody
   public String getVideoTabs(){
	   
	   return JSON.toJSONString(vdservice.getVideoList());
   }
   @RequestMapping(value="/getVideoById.do",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
   @ResponseBody
   public String getVideoById(Integer id){
	   
	   return JSON.toJSONString(vdservice.getVideoById(id));
   }
   
   @RequestMapping(value="/selVideo.do",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
   @ResponseBody
   public String selVideo(/*int video_id,*/String video_name,Integer video_form_id){
	   VideoTab vt=new VideoTab();
	   vt.setVideo_form_id(video_form_id);
	   //vt.setVideo_id(video_id);
	   vt.setVideo_name(video_name);
	   return JSON.toJSONString(vdservice.selVideo(vt));
   }

   @RequestMapping(value="/updetVideoById.do",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
   @ResponseBody
   public void updetVideoById(Integer video_id,String video_name,String video_url,String video_img_url,String video_introduce){
	   VideoTab vt=new VideoTab();
	   vt.setVideo_id(video_id);
	   vt.setVideo_img_url(video_img_url);
	   vt.setVideo_url(video_url);
	   vt.setVideo_introduce(video_introduce);
	   vt.setVideo_name(video_name);
	   vdservice.updetVideoById(vt);
   }
   
   @RequestMapping(value="/delVideoById.do",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
   @ResponseBody
   public void delVideoById(Integer video_id){
	   vdservice.delVideoById(video_id);
   }
}
