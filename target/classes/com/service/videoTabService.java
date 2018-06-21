package com.service;

import java.util.List;

import com.entity.VideoTab;

public interface VideoTabService {
	
//	public void uploadVideo(String video_name, String video_introduce,InputStream video, InputStream video_image,String imageName,Integer video_form_id,Integer teacher_id) throws Exception;
	public void uploadVideo(String video_name, String video_introduce,String video_url, String video_image_url,Integer video_form_id,Integer teacher_id) throws Exception;

	public List<VideoTab> getVideoList(VideoTab v);
	public List<VideoTab> getVideoById(int id);
	public List<VideoTab> selVideo(VideoTab vd);
	public void delVideoById(int video_id);
	public void updetVideoById(VideoTab vd);
}
