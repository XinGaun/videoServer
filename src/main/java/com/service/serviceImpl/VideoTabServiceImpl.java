package com.service.serviceImpl;

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
	private OSSUploadVideo ossUpload = new OSSUploadVideo();

	@Override
	@Transactional
	public  void uploadVideo(String video_name, String video_introduce,String video_url, String video_image_url,Integer video_form_id,Integer teacher_id) throws Exception {
		HashMap<String,String> map =videoUpload(video_url,video_image_url,video_name,null);
		String videoUrl = map.get("video_url");
		String videoImageUrl = map.get("video_image_url");
		System.out.println("create");
		createVideoTab(video_name,videoUrl,videoImageUrl,video_introduce,video_form_id,teacher_id);
	}

	public HashMap<String,String> videoUpload(String video_url, String video_image_url,String video_name,String imageName)throws Exception {
		System.out.println(video_name);
		HashMap<String,String> map = new HashMap<>();
		/*ossUpload.uploadInput(video_name,video);
		ossUpload.uploadInput(imageName,video_image);*/

		String ossVideoName =ossUpload.upload(video_url,video_name);
		String ossImageName = ossUpload.upload(video_image_url,video_name);
		System.out.println("oss end");
		String viderUrl = ossUpload.getWebURL(ossVideoName);
		String imageUrl = ossUpload.getWebURL(ossImageName);
		System.out.println("service"+viderUrl);
		System.out.println("service"+ imageUrl);
		map.put("video_url", viderUrl);
		map.put("video_image_url", imageUrl);
		return map;
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
