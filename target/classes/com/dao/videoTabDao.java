package com.dao;

import java.util.List;

import com.entity.VideoTab;

public interface VideoTabDao {
	public void createVideo(VideoTab vd);
	public List<VideoTab> getVideoList(VideoTab v);
	public List<VideoTab> getVideoById(int id);
	public List<VideoTab> selVideo(VideoTab vd);
	public void delVideoById(int video_id);
	public void updetVideoById(VideoTab vd);
}
