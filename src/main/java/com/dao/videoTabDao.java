package com.dao;

import java.util.List;

import com.entity.videoTab;

public interface videoTabDao {
	public void uploadVideo(videoTab vd);
	public List<videoTab> getVideoList();
	public List<videoTab> getVideoById(int id);
	public List<videoTab> selVideo(videoTab vd);
	public void delVideoById(int video_id);
	public void updetVideoById(videoTab vd);
}
