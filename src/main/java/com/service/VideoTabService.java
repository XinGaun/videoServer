package com.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.entity.VideoTab;

public interface VideoTabService {
	
	public String uploadVideo(String videoName,String imageName,String pptName,int video_form_id,String video_introduce,String videoPath,MultipartFile image,MultipartFile ppt,int video_qz,int teacher_id,String video_time ) throws Exception;	
	
	public List<VideoTab> getVideoList(VideoTab v);
	public List<VideoTab> getVideoById(int id);
	public List<VideoTab> selVideo(VideoTab vd);
	public List<VideoTab> selVideoByVideoForm(VideoTab vd);
	public void delVideoById(int video_id);
	public void updetVideoById(int video_id,String video_name,String video_form_id,String video_introduce,MultipartFile image,MultipartFile ppt,String video_qz,int teacher_id)throws Exception;
}
