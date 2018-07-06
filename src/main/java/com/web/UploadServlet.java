package com.web;

import java.io.File;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.util.OSSUtil;
@Controller
@RequestMapping("/UploadServlet")
public class UploadServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public OSSUtil ossUtil = new OSSUtil();

	@RequestMapping(value="/upload",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void uploadflv(@RequestParam(value = "videoName") String videoName,@RequestParam(value = "video") MultipartFile video,@RequestParam(value = "image") MultipartFile image,HttpServletRequest request) throws Exception{
	
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(4*1024);
		try {  

			String filePath = video.getOriginalFilename();
			String imagePath = image.getOriginalFilename();		
			long size = video.getSize();
			String ossFileName = videoName+filePath.substring(filePath.lastIndexOf("."));	
			String imageName = videoName+imagePath.substring(imagePath.lastIndexOf("."));
			CommonsMultipartFile cf= (CommonsMultipartFile)video; 
			DiskFileItem fi = (DiskFileItem)cf.getFileItem(); 
			File videoFile = fi.getStoreLocation(); 
			ossUtil.uploadJD(videoFile,ossFileName,size);	
			CommonsMultipartFile cf2= (CommonsMultipartFile)image; 
			DiskFileItem fi2 = (DiskFileItem)cf2.getFileItem(); 
			File imageFile = fi2.getStoreLocation(); 
			ossUtil.upload(imageFile,imageName);


		} catch (Exception e) {  
			e.printStackTrace();  
			System.out.println(e.getMessage());

		}  
	}
}
