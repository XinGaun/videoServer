package com.service.serviceImpl;


import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSON;
import com.dao.VideoTabDao;
import com.entity.VideoTab;
import com.service.VideoTabService;
import com.util.HttpReq;
import com.util.OSSUtil;

@Service
public class VideoTabServiceImpl implements VideoTabService{

	@Autowired
	private VideoTabDao videoDao;

	private OSSUtil ossUpload = new OSSUtil();
	private String url = "http://www.niceyuwen.com:2020/videoffmpeg/transcoding/transcodingm3u8";
	@Override
	@Transactional
	public String uploadVideo(String videoName,String imageName,String pptName,int video_form_id,String video_introduce,String videoPath,MultipartFile image,MultipartFile ppt,int video_qz,int teacher_id,String video_time) throws Exception {
		HashMap<String,String> data = new HashMap<>();
 
		CommonsMultipartFile cf2= (CommonsMultipartFile)image; //这个myfile是MultipartFile的
		DiskFileItem fi2 = (DiskFileItem)cf2.getFileItem(); 
		File imageFile = fi2.getStoreLocation(); 
		String ossImageName = ossUpload.upload(imageFile,imageName);
		
		CommonsMultipartFile cf3= (CommonsMultipartFile)ppt; //这个myfile是MultipartFile的
		DiskFileItem fi3 = (DiskFileItem)cf3.getFileItem(); 
		File pptFile = fi3.getStoreLocation(); 
		String osspptName = ossUpload.upload(pptFile,pptName);
		
		
		String imageUrl = ossUpload.getWebURL(ossImageName);
		String pptUrl = ossUpload.getWebURL(osspptName);
		String videoSuffix = videoPath.substring(videoPath.lastIndexOf("."));
		videoName = videoName+videoSuffix;
		String ossVideoName = videoPath.substring(videoPath.lastIndexOf("video")+6);
		
		System.out.println("succes");
		
		String path = "/oss/video/"+ossVideoName;
		String fileName ="/oss/video/"+ossVideoName.substring(0, ossVideoName.lastIndexOf("."));
		data.put("PATH",path);
		data.put("fileName",fileName);
		System.out.println(videoName);
		System.out.println(path);
		System.out.println(fileName);
		//HttpReq.httpRequest(url, "POST", JSON.toJSONString(data));
		
		String savevideoPath = videoPath.substring(0, videoPath.lastIndexOf("."))+".m3u8";
		System.out.println("video service"+path+"   "+fileName+"   "+savevideoPath+"   "+pptUrl+"   "+video_time);
		createVideoTab(videoName,savevideoPath,imageUrl,pptUrl,video_introduce,video_form_id,teacher_id,video_qz,video_time);


		return "succes";
	}

	public void createVideoTab(String video_name,String video_url, String video_image_url,String pptUrl, String video_introduce,Integer video_form_id,Integer teacher_id,Integer video_qz,String videoTime) {
		VideoTab video = new VideoTab();	
		video.setVideo_img_url(video_image_url);
		video.setVideo_introduce(video_introduce);
		video.setVideo_name(video_name);
		video.setTeacher_id(teacher_id);
		video.setVideo_url(video_url);
		video.setVideo_status(0);
		video.setVideo_click(0);
		video.setVideo_grade(0);
		video.setVideo_form_id(video_form_id);
		video.setVideo_ppt(pptUrl);
		video.setVideo_qz(video_qz);
		video.setVideo_time(videoTime);
		System.out.println("succes2");
		videoDao.createVideo(video);
	}
	@Override
	public List<VideoTab> getVideoList(VideoTab v) {
		return videoDao.getVideoList(v);
	}

	@Override
	public List<VideoTab> getVideoById(int id) {
		return videoDao.getVideoById(id);
	}

	@Override
	public List<VideoTab> selVideo(VideoTab vd) {
		return videoDao.selVideo(vd);
	}

	@Override
	public void delVideoById(int video_id) {
		videoDao.delVideoById(video_id);
	}

	@Override
	public void updetVideoById(int video_id,String video_name,String video_form_id,String video_introduce,MultipartFile image,MultipartFile ppt,String video_qz,int teacher_id) throws Exception {
		CommonsMultipartFile cf2= (CommonsMultipartFile)image; //这个myfile是MultipartFile的
		DiskFileItem fi2 = (DiskFileItem)cf2.getFileItem(); 
		File imageFile = fi2.getStoreLocation(); 
		String imageOldName = image.getOriginalFilename();
		String ossImageName = ossUpload.upload(imageFile,imageOldName);
		
		CommonsMultipartFile cf3= (CommonsMultipartFile)ppt; //这个myfile是MultipartFile的
		DiskFileItem fi3 = (DiskFileItem)cf3.getFileItem(); 
		File pptFile = fi3.getStoreLocation(); 
		String pptOldName = ppt.getOriginalFilename();
		String osspptName = ossUpload.upload(pptFile,pptOldName);
	
			
		String imageUrl = ossUpload.getWebURL(ossImageName);
		String pptUrl = ossUpload.getWebURL(osspptName);
		VideoTab video = new VideoTab();
		video.setVideo_id(video_id);
		video.setVideo_img_url(imageUrl);
		video.setVideo_introduce(video_introduce);
		video.setVideo_form_id(Integer.parseInt(video_form_id));
		video.setVideo_ppt(pptUrl);
		video.setVideo_qz(Integer.parseInt(video_qz));
		videoDao.updetVideoById(video);
	}

	@Override
	public List<VideoTab> selVideoByVideoForm(VideoTab vd) {
		// TODO Auto-generated method stub
		return videoDao.selVideo(vd);
	}

}
