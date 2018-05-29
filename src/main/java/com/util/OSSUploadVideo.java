package com.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.PutObjectResult;  
  
import java.io.*;  

public class OSSUploadVideo {
	private static String endpoint = "http://oss-cn-beijing.aliyuncs.com";  
	private static String accessKeyId = "LTAIb7ibuLQWDSIm";
	private static String accessKeySecret = "Pa3gsiNAHC2FlFc0oKgCO3j70R6m8m";
	private static String bucketName = "tmz8023";

	public void upload(String filePath) throws Exception {
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret); 
		if (!ossClient.doesBucketExist(bucketName)) {
			ossClient.createBucket(bucketName);
        }
		PutObjectResult result = ossClient.putObject(bucketName,new File(filePath).getName(), new File(filePath));  
		System.out.println(result.getRequestId());
		
		ossClient.shutdown();  
	}
	public void download(String ossFileName,String localFile) throws Exception{
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);  
		ossClient.getObject(new GetObjectRequest(bucketName,ossFileName), new File(localFile));
		System.out.println("end");
		ossClient.shutdown();
	}
	public void delectFile(String yourObjectName) {
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);  
		ossClient.deleteObject(bucketName, yourObjectName);
		ossClient.shutdown();
	}
	
	public String  showImg(String imgName) {
		String path = "http://"+bucketName+"."+endpoint+"/"+imgName+"?x-oss-process=image/resize,w_1000";
		return path;
	}
	
	public static void main(String[] args) throws Exception {
		OSSUploadVideo upload = new OSSUploadVideo();
//		C:\\bxwlw\\home\\test.log
		upload.upload("D:\\filedownload\\3.jpg");
//		upload.download("test.log","D:\\filedownload\\test.log");
	}
}
