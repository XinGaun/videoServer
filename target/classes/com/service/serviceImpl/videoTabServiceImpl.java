package com.service.serviceImpl;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.VideoTabDao;
import com.entity.VideoTab;
import com.service.VideoTabService;
import com.util.OSSUploadVideo;
@Service
public class VideoTabServiceImpl implements VideoTabService{
	
	@Autowired
	private VideoTabDao videoDao;
	private OSSUploadVideo ossUpload; 
	
	@Override
	public void uploadVideo(HashMap<String,Object> videoinfo) {
		//
			
	}
	
	@Transactional
	public  void uploadVideo(String video_name, String video_introduce,String video_url, String video_image_url,Integer video_form_id,Integer teacher_id) throws Exception {
		ossUpload.upload(video_url);
		ossUpload.upload(video_image_url);
	    String viderUrl = ossUpload.getOSSFileURL(video_name);
		String imageUrl = ossUpload.getOSSFileURL(new File(video_image_url).getName());
		
		VideoTab video = new VideoTab();	
		video.setVideo_img_url(imageUrl);
		video.setVideo_introduce(video_introduce);
		video.setVideo_name(video_name);
		video.setTeacher_id(teacher_id);
		video.setVideo_url(viderUrl);
		video.setVideo_status(0);
		video.setVideo_click(0);
		video.setVideo_grade(0);
		video.setVideo_form_id(video_form_id);
		videoDao.createVideo(video);
	}
	
	@Override
	public List<VideoTab> getVideoList() {
		return videoDao.getVideoList();
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

	@Override
	public void downloadVideo(HashMap<String, Object> videoinfo) {
		// TODO Auto-generated method stub
		
	}
	
}
