package com.web;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.entity.TeacherDomain;
import com.entity.VideoTab;
import com.service.VideoTabService;

@Controller
@RequestMapping("/videoTab")
public class VideoTabController {

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
	public void uploadflv(String videoName,String video_form_id,String video_introduce,MultipartFile video,MultipartFile image,MultipartFile ppt,String video_qz,String video_time,HttpServletRequest request) throws Exception{		
		TeacherDomain teacher=(TeacherDomain) request.getSession().getAttribute("user");
		int teacher_id = Integer.parseInt(teacher.getTeacher_id());
		String filePath = video.getOriginalFilename();
		String imagePath = image.getOriginalFilename();
		String pptPath = ppt.getOriginalFilename();
		long size = video.getSize();
		String ossFileName = videoName+filePath.substring(filePath.lastIndexOf("."));	
		String imageName = videoName+imagePath.substring(imagePath.lastIndexOf("."));
		String pptName = videoName+pptPath.substring(pptPath.lastIndexOf("."));
		System.out.println(ossFileName+"   "+imageName+"   "+pptName+"  "+size+"   "+"   "+video_time);
		try {
			vdservice.uploadVideo(ossFileName,imageName,pptName,Integer.parseInt( video_form_id), video_introduce, video, image, ppt,Integer.parseInt(video_qz),teacher_id,size,video_time);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		

	}


	@RequestMapping(value="/getVideoTabs.do", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<VideoTab> getVideoTabs(HttpServletRequest request){
		TeacherDomain teacher=(TeacherDomain) request.getSession().getAttribute("user");
		int teacher_id = Integer.parseInt(teacher.getTeacher_id());
		VideoTab vt=new VideoTab();
		vt.setTeacher_id(teacher_id);
		List<VideoTab> list= vdservice.getVideoList(vt);
		return list;
	}
	@RequestMapping(value="/getVideoById.do", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<VideoTab> getVideoById(int id){

		return vdservice.getVideoById(id);
	}

	@RequestMapping(value="/selVideo.do", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<VideoTab> selVideo(int teacher_id,String video_name,int video_form_id){
		VideoTab vt=new VideoTab();
		vt.setVideo_form_id(video_form_id);
		vt.setTeacher_id(teacher_id);
		vt.setVideo_name(video_name);
		return vdservice.selVideo(vt);
	}

	@RequestMapping(value="/selVideobyVideoForm.do", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<VideoTab> selVideobyVideoForm(HttpServletRequest request,int video_form_id){
		TeacherDomain teacher=(TeacherDomain) request.getSession().getAttribute("user");
		int teacher_id = Integer.parseInt(teacher.getTeacher_id());
		VideoTab vt=new VideoTab();
		vt.setTeacher_id(teacher_id);
		vt.setVideo_form_id(video_form_id);
		return vdservice.selVideo(vt);
	}

	@RequestMapping(value="/updetVideoById.do", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void updetVideoById(int video_id,String video_name,String video_url,String video_img_url,String video_introduce){
		VideoTab vt=new VideoTab();
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