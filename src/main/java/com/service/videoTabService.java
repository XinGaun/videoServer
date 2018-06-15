package com.service;

import java.util.HashMap;
import java.util.List;

import com.entity.VideoTab;

public interface VideoTabService {
	public void uploadVideo(HashMap<String,Object> videoinfo);
	public void downloadVideo(HashMap<String,Object> videoinfo);
	public List<VideoTab> getVideoList();
	public List<VideoTab> getVideoById(int id);
	public List<VideoTab> selVideo(VideoTab vd);
	public void delVideoById(int video_id);
	public void updetVideoById(VideoTab vd);
}
