package com.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.runner.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.entity.videoTab;
import com.service.videoTabService;

@Controller
@RequestMapping("/videoTab")
public class videoTabController {
	 
	@Autowired
	private videoTabService vdservice;
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
	public void uploadflv(String video_name, String video_introduce,String video_url, String video_img_url,int video_form_id){
		/*SimpleDateFormat ff1=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String video_date=ff1.format(new Date());*/
		videoTab vt=new videoTab();
		vt.setVideo_img_url(/*"F:\\qycache\\download"+*/video_img_url.substring(10));
		vt.setVideo_introduce(video_introduce);
		vt.setVideo_name(video_name);
		vt.setTeacher_id(1);
		vt.setVideo_url(/*"F:\\qycache\\download"+*/video_url.substring(10));
		vt.setVideo_grade(0);
		vt.setVideo_form_id(video_form_id);
		vdservice.uploadVideo(vt);
	}
   @RequestMapping(value="/getVideoTabs.do",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
   @ResponseBody
   public String getVideoTabs(){
	   
	   return JSON.toJSONString(vdservice.getVideoList());
   }
   @RequestMapping(value="/getVideoById.do",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
   @ResponseBody
   public String getVideoById(int id){
	   
	   return JSON.toJSONString(vdservice.getVideoById(id));
   }
   
   @RequestMapping(value="/selVideo.do",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
   @ResponseBody
   public String selVideo(/*int video_id,*/String video_name,int video_form_id){
	   videoTab vt=new videoTab();
	   vt.setVideo_form_id(video_form_id);
	   //vt.setVideo_id(video_id);
	   vt.setVideo_name(video_name);
	   return JSON.toJSONString(vdservice.selVideo(vt));
   }

   @RequestMapping(value="/updetVideoById.do",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
   @ResponseBody
   public void updetVideoById(int video_id,String video_name,String video_url,String video_img_url,String video_introduce){
	   videoTab vt=new videoTab();
	   vt.setVideo_id(video_id);
	   vt.setVideo_img_url(video_img_url);
	   vt.setVideo_url(video_url);
	   vt.setVideo_introduce(video_introduce);
	   vt.setVideo_name(video_name);
	   vdservice.updetVideoById(vt);
   }
   
   @RequestMapping(value="/delVideoById.do",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
   @ResponseBody
   public void delVideoById(int video_id){
	   vdservice.delVideoById(video_id);
   }
}
