package com.util;

import java.io.File;
import java.net.URL;
import java.util.Date;

import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.PutObjectResult;  

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
	
	public String getImgURL(String imgName) {
		String path = "http://"+bucketName+"."+endpoint.substring(7)+"/"+imgName+"?x-oss-process=image/resize,w_1000";
		return path;
	}
	
	public URL getURL() {
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

		// 设置URL过期时间为1小时
		Date expiration = new Date(new Date().getTime() + 3600 * 1000 * 24);
		// 生成URL。
		URL url = ossClient.generatePresignedUrl(bucketName, "1.mp4", expiration, HttpMethod.PUT);

		// 关闭Client。
		ossClient.shutdown();
		return url;
	}
	
	public static void main(String[] args) throws Exception {
		OSSUploadVideo oss = new OSSUploadVideo();
//		C:\\bxwlw\\home\\test.log
//		oss.upload("D:\\filedownload\\3.jpg");
//		oss.download("test.log","D:\\filedownload\\test.log");
//		URL url =oss.getURL();
		String path = oss.getImgURL("2.jpg");
		System.out.println(path.toString());
	
	}
}
