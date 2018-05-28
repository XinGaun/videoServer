package com.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.PutObjectResult;  
  
import java.io.*;  

public class OSSUploadVideo {
	private static String endpoint = "http://oss-cn-beijing.aliyuncs.com";  
	private static String accessKeyId = "LTAILTZtDu4Cd81w";
	private static String accessKeySecret = "V0dqav2h0k8Fo7ZZizGAHaLPznVV6M";
	private static String bucketName = "tmz8023";
//	private static String key = "80bcefda64cbdaff855434efdf2ec8cf.mp4";
	
	public void upload(String fileName,String filePath) throws Exception {
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);  
		PutObjectResult result = ossClient.putObject(bucketName,fileName, new File(filePath));  
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
	public static void main(String[] args) throws Exception {
		OSSUploadVideo upload = new OSSUploadVideo();
		upload.upload("test.log", "C:\\bxwlw\\home\\test.log");
		upload.download("offile.docx","D:\\filedownload\\2.docx");
	}
}
