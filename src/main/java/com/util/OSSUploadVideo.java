package com.util;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;  

public class OSSUploadVideo {
	private static String endpoint = "http://oss-cn-beijing.aliyuncs.com";  
	private static String accessKeyId = "LTAIb7ibuLQWDSIm";
	private static String accessKeySecret = "Pa3gsiNAHC2FlFc0oKgCO3j70R6m8m";
	private static String serviceName = "http://www.niceyuwen.com";
	//	private static String bucketName = "tmz8023";
	private static String bucketName1 = "img-1-yudao";
	private static String bucketName2 = "video-yudao-1";
	private String bucketName = "";
	public String upload(String filePath,String fileName) throws Exception {
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret); 
		/*if (!ossClient.doesBucketExist(bucketName)) {
			ossClient.createBucket(bucketName);
		}*/
		System.out.println("oss  "+fileName);
		File file = new File(filePath);
		String fileNameStr = file.getName();
//		System.out.println(fileNameStr);
		if(fileName == null || fileName == "" )   {    	
			
			fileName = fileNameStr;
		}else if(!fileName.contains(".")) {
			fileName = fileName+fileNameStr.substring(fileNameStr.indexOf("."));
		}
		System.out.println(fileName);
		isVideo(fileName);
		System.out.println("bucketName "+bucketName);
		ossClient.putObject(bucketName,fileName, file);  
		System.out.println("end");
		ossClient.shutdown();  
		return fileName;
	}

	public void uploadInput(String fileName,InputStream input) throws Exception {
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret); 
		isVideo(fileName);
		ossClient.putObject(bucketName,fileName,input );
		System.out.println("end");
		ossClient.shutdown();  
	}

	public void download(String ossFileName,String localFile) throws Exception{
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);  
		isVideo(ossFileName);
		ossClient.getObject(new GetObjectRequest(bucketName,ossFileName), new File(localFile));
		System.out.println("end");
		ossClient.shutdown();
	}
	public void delectFile(String yourObjectName) {
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);  
		isVideo(yourObjectName);
		ossClient.deleteObject(bucketName, yourObjectName);
		ossClient.shutdown();
	}

	public String getOSSFileURL(String fileName) {
		isVideo(fileName);
		String path = "http://"+bucketName+"."+endpoint.substring(7)+"/"+fileName;
//		String style = "?x-oss-process=image/resize,w_1000";
		return path;
	}
	public String getWebURL(String fileName) {
		String path = "";
		if (fileName.endsWith("mp4") || fileName.endsWith("mp3")) {
			path = serviceName+"/video/"+fileName;		
		}
		if (fileName.endsWith("jpg") || fileName.endsWith("png")) {
			path = serviceName+"/image/"+fileName;		
		}
		return path;
	}

	public URL getOSSURL(String fileName) {
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

		// 设置URL过期时间为1小时
		Date expiration = new Date(new Date().getTime() + 3600 * 1000 * 24);
		isVideo(fileName);
		// 生成URL。
		URL url = ossClient.generatePresignedUrl(bucketName, fileName, expiration, HttpMethod.PUT);

		// 关闭Client。
		ossClient.shutdown();
		return url;
	}

	public void isVideo(String fileName) {
		if (fileName.endsWith("mp4") || fileName.endsWith("mp3")) {			
			bucketName = bucketName2;
		}
		if (fileName.endsWith("jpg") || fileName.endsWith("png")) {		
			bucketName = bucketName1;
		}
	}

	public static void main(String[] args) throws Exception {
		OSSUploadVideo oss = new OSSUploadVideo();
		//		C:\\bxwlw\\home\\test.log
		oss.upload("D:\\filedownload\\基本演绎法第六季01.mp4","基本演绎法第六季01");
		oss.upload("D:\\filedownload\\2.jpg",null);
		//		oss.upload("D:\\filedownload\\3.mp4");
		//		oss.upload("D:\\filedownload\\许嵩 - 庐州月.mp3");
		//		oss.upload("D:\\filedownload\\2.jpg");
		//		oss.upload("D:\\filedownload\\3.jpg");
		//		oss.upload("D:\\filedownload\\4.jpg");
		//		oss.upload("D:\\filedownload\\5.jpg");
		//		oss.upload("D:\\filedownload\\1.png");
		//		oss.upload("D:\\filedownload\\2.png");
		//		oss.upload("D:\\filedownload\\3.png");
		//		oss.download("test.log","D:\\filedownload\\test.log");
		//		URL url =oss.getURL();
		//		String path = oss.getFileURL("2.jpg");
		//		System.out.println(path.toString());

	}
}
