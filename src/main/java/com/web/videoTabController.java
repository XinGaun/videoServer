package com.web;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.TeacherDomain;
import com.entity.videoTab;

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
	
	@RequestMapping(value="/uploadflv.do", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void uploadflv(HttpServletRequest request,String video_name, String video_introduce,String video_url, String video_img_url,int video_form_id){
		TeacherDomain teacher=(TeacherDomain) request.getSession().getAttribute("user");
		int teacher_id = Integer.parseInt(teacher.getTeacher_id());
		videoTab vt=new videoTab();
		vt.setVideo_img_url(video_img_url);
		vt.setVideo_introduce(video_introduce);
		vt.setVideo_name(video_name);
		vt.setTeacher_id(teacher_id);
		vt.setVideo_url(video_url);
		vt.setVideo_grade(0);
		vt.setVideo_form_id(video_form_id);
		vdservice.uploadVideo(vt);
	}
   @RequestMapping(value="/getVideoTabs.do", method={RequestMethod.POST,RequestMethod.GET})
   @ResponseBody
   public List<videoTab> getVideoTabs(HttpServletRequest request){
	   TeacherDomain teacher=(TeacherDomain) request.getSession().getAttribute("user");
	   int teacher_id = Integer.parseInt(teacher.getTeacher_id());
	   videoTab vt=new videoTab();
	   vt.setTeacher_id(teacher_id);
	   List<videoTab> list= vdservice.getVideoList(vt);
	   return list;
   }
   @RequestMapping(value="/getVideoById.do", method={RequestMethod.POST,RequestMethod.GET})
   @ResponseBody
   public List<videoTab> getVideoById(int id){
	   
	   return vdservice.getVideoById(id);
   }
   
   @RequestMapping(value="/selVideo.do", method={RequestMethod.POST,RequestMethod.GET})
   @ResponseBody
   public List<videoTab> selVideo(int teacher_id,String video_name,int video_form_id){
	   videoTab vt=new videoTab();
	   vt.setVideo_form_id(video_form_id);
	   vt.setTeacher_id(teacher_id);
	   vt.setVideo_name(video_name);
	   return vdservice.selVideo(vt);
   }

   @RequestMapping(value="/updetVideoById.do", method={RequestMethod.POST,RequestMethod.GET})
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
   
   @RequestMapping(value="/delVideoById.do", method={RequestMethod.POST,RequestMethod.GET})
   @ResponseBody
   public void delVideoById(int video_id){
	   vdservice.delVideoById(video_id);
   }
}
