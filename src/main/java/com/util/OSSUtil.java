package com.util;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;  

public class OSSUtil{
	private static String endpoint = "http://oss-cn-beijing.aliyuncs.com";  //内网
	//private static String endpoint =  "http://oss-cn-beijing-internal.aliyuncs.com"; //外网
	private static String accessKeyId = "LTAIb7ibuLQWDSIm";
	private static String accessKeySecret = "Pa3gsiNAHC2FlFc0oKgCO3j70R6m8m";
	private static String serviceName = "http://www.niceyuwen.com";
	private static String bucketName1 = "img-1-yudao";
	private static String bucketName2 = "video-yudao-1";
	private static String bucketName;
	private boolean succeed = false;
	String callbackUrl = "http://oss-cn-beijing.aliyuncs.com";
	String key = "";
	// 单例，只需要建立一次链接  
	private static OSSClient client = null;  
	// 是否使用另外一套本地账户  
	public static final boolean MINE = false;  
	//配置参数  
	static ClientConfiguration config() {  
		ClientConfiguration conf = new ClientConfiguration();  
		conf.setMaxConnections(100);  
		conf.setConnectionTimeout(5000);  
		conf.setMaxErrorRetry(3);  
		conf.setSocketTimeout(2000);  
		return conf;  
	} 

	//客户端  
	public static OSSClient client() {  
		if (client == null) {  
			ClientConfiguration conf = config();  
			client = new OSSClient(endpoint, accessKeyId, accessKeySecret, conf);  
			makeBucket(client, bucketName);  
		}  
		return client;  
	}  

	//创建Bucket  
	public static void makeBucket(OSSClient client, String bucketName) {  
		boolean exist = client.doesBucketExist(bucketName);  
		if (exist) {  
			System.out.println("The bucket exist.");  
			return;  
		}  
		client.createBucket(bucketName);  
	}  

	//创建Bucket  
	public static void makeBucket(String bucketName) {  
		OSSClient client = client();  
		makeBucket(client, bucketName);  
	}  

	//上传一个文件，InputStream  
	public String uploadInput(String fileName,InputStream input) throws Exception {

		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret); 
		isVideo(fileName);
		String ossFileName = getOSSName(fileName);
		try {
			ossClient.putObject(bucketName,ossFileName, input);  
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println("end");
		ossClient.shutdown();  
		return fileName;
	}


	//上传一个文件，File  //image ,ppt ,
	public String upload(File file,String fileName) throws Exception {
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret); 
		String filetype= fileName.substring(fileName.lastIndexOf("."));
		String ossFileName = getOSSName(filetype);
		isVideo(ossFileName);
		System.out.println("start");
		try {
			ossClient.putObject(bucketName,ossFileName, file);  
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println("end");
		ossClient.shutdown();  
		System.out.println("stop");
		return ossFileName;
	}

	//下载一个文件到本地  
	public void download(String ossFileName,String localFile) throws Exception{
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);  
		isVideo(ossFileName);
		ossClient.getObject(new GetObjectRequest(bucketName,ossFileName), new File(localFile));
		System.out.println("end");
		ossClient.shutdown();
	}
	// 判断文件是否存在。
	public boolean isExit(String ossFileName) {
		// 创建OSSClient实例。
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		isVideo(ossFileName);
		// 判断文件是否存在。
		boolean found = ossClient.doesObjectExist(bucketName, ossFileName);
		System.out.println(found);

		// 关闭OSSClient。
		ossClient.shutdown();
		return found;
	}

	//下载一个文件到本地  
	public InputStream downloadInputStram(HttpServletRequest request, HttpServletResponse resp,String ossFileName) throws Exception{
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);  
		isVideo(ossFileName);
		OSSObject obj=ossClient.getObject(new GetObjectRequest(bucketName, ossFileName ));
		InputStream input =obj.getObjectContent();
		int index;
		byte[] bytes = new byte[1024];
		FileOutputStream downloadFile = new FileOutputStream("D://upload//"+ossFileName);
		while ((index = input.read(bytes)) != -1) {
			downloadFile.write(bytes, 0, index);
			downloadFile.flush();
		}
		downloadFile.close();
		input.close();
		System.out.println("end");
		ossClient.shutdown();
		return input;
	}
	//删除一个文件  
	public void delectFile(String yourObjectName) {
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);  
		isVideo(yourObjectName);
		ossClient.deleteObject(bucketName, yourObjectName);
		ossClient.shutdown();
	}
	//获得视频时长
	public String getVideoTime(int size) {
		System.out.println("videoTime");		
		StringBuffer length =new StringBuffer("");
		try {	        		
			int ls = size;
			int hour = (int) (ls/3600);
			length.append(hour+":");			
			int minute = (int) (ls%3600)/60;
			if( minute<10) {
				length.append("0"+minute+":");
			}else {
				length.append(minute+":");
			}
			int second = (int) (ls-hour*3600-minute*60);
			if( second<10) {
				length.append("0"+second);
			}else {
				length.append(second);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return length.toString();
	}

	public String getOSSFileURL(String fileName) {
		isVideo(fileName);
		String path = "http://"+bucketName+"."+endpoint.substring(7)+"/"+fileName;
		//		String style = "?x-oss-process=image/resize,w_1000";
		return path;
	}
	public String getWebURL(String fileName) {
		String path = "";
		if (fileName.endsWith("mp4") || fileName.endsWith("mp3") ||fileName.endsWith("MP4")) {
			path = serviceName+"/video/"+fileName;		
		}else {		
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

		if(fileName.endsWith("mp4") || fileName.endsWith("mp3") || fileName.endsWith("MP4")|| fileName.endsWith("flv")|| fileName.endsWith("avi")) {			
			bucketName = bucketName2;
		}else {				
			bucketName = bucketName1;
		};
	}

	public boolean isSucceed() {
		return succeed;
	}

	public void getcallback() {

	}   

	public static String getUUID(){ 
		String uuid = UUID.randomUUID().toString(); 	
		return uuid.replaceAll("-", "");
	}
	public static String getOSSName(String filetype) {
		return getUUID()+filetype;	
	}

	public static void main(String[] args) throws Exception {
		OSSUtil oss = new OSSUtil();
		/*InputStream input = oss.downloadInputStram("ea5162fc3f7a4d07b93d0bf8564e05af.MP4");
		System.out.println(input.toString());*/
		oss.upload(new File("D:\\filedownload\\2017高考语文秋季长线拯救班_第15节_20161124223004.mp4"), "zftest.mp4");
		//		System.out.println(oss.getVideoTime(new File("D:\\filedownload\\2017高考语文秋季长线拯救班_第15节_20161124223004.mp4")));
		//		String filename = "yuwen.mp4";
		//		oss.isVideo(filename);
		//		String fileName = oss.upload(new File("D:\\filedownload\\演示文稿1.pptx"), "测试ppt1.pptx");
		//		String path = oss.getWebURL(fileName);
		//		System.out.println(oss.getVideoTime(Long.parseLong("5.12321")));
	}
}
