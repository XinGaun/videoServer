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
	public String uploadVideo(String video_name,String imageName, String video_introduce,MultipartFile video, MultipartFile image,Integer video_form_id,Integer teacher_id,long size) throws Exception {
		HashMap<String,String> data = new HashMap<>();
		
		CommonsMultipartFile cf= (CommonsMultipartFile)video; //这个myfile是MultipartFile的
		DiskFileItem fi = (DiskFileItem)cf.getFileItem(); 
		File videoFile = fi.getStoreLocation(); 
		String ossVideoName =ossUpload.uploadJD(videoFile,video_name,size);
		
		CommonsMultipartFile cf2= (CommonsMultipartFile)image; //这个myfile是MultipartFile的
		DiskFileItem fi2 = (DiskFileItem)cf2.getFileItem(); 
		File imageFile = fi2.getStoreLocation(); 
		String ossImageName = ossUpload.upload(imageFile,imageName);
		//		String viderUrl = ossUpload.getWebURL(ossVideoName);
		String imageUrl = ossUpload.getWebURL(ossImageName);


		String path = "/oss/video/"+ossVideoName;
		String fileName ="/oss/video/"+ossVideoName.substring(0, ossVideoName.lastIndexOf("."));
		data.put("PATH",path);
		data.put("fileName",fileName);
		HttpReq.httpRequest(url, "POST", JSON.toJSONString(data));

		String savevideoPath = fileName+".m3u8";
		System.out.println("video service"+path+"   "+fileName+"   "+savevideoPath);
		createVideoTab(video_name,savevideoPath,imageUrl,video_introduce,video_form_id,teacher_id);

		return "succes";
	}

	public void createVideoTab(String video_name,String video_url, String video_image_url, String video_introduce,Integer video_form_id,Integer teacher_id) {
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
	public void updetVideoById(VideoTab vd) {
		videoDao.updetVideoById(vd);
	}

}
