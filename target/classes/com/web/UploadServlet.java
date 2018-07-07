package com.web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
			ossUtil.uploadJD(video.getInputStream(), ossFileName,size);						
			ossUtil.uploadInput(imageName,image.getInputStream());


		} catch (Exception e) {  
			e.printStackTrace();  
			System.out.println(e.getMessage());

		}  
	}
}
