package com.util;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.event.ProgressEvent;
import com.aliyun.oss.event.ProgressEventType;
import com.aliyun.oss.event.ProgressListener;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.PutObjectRequest;  

public class OSSUtil implements ProgressListener{
	private static String endpoint = "http://oss-cn-beijing.aliyuncs.com";  
	private static String accessKeyId = "LTAIb7ibuLQWDSIm";
	private static String accessKeySecret = "Pa3gsiNAHC2FlFc0oKgCO3j70R6m8m";
	private static String serviceName = "http://www.niceyuwen.com";
	private static String bucketName1 = "img-1-yudao";
	private static String bucketName2 = "video-yudao-1";
	private static String bucketName = "";
	private long bytesWritten = 0;
	private long totalBytes = -1;
	private boolean succeed = false;
	private String fileName = "";
	private long size=0;
	private long progress = 0;
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
		ossClient.putObject(bucketName,fileName,input );
		System.out.println(ossClient.putObject(bucketName,fileName,input ));
		System.out.println("end");
		ossClient.shutdown();  
		System.out.println(fileName);
		System.out.println(input);
		return fileName;
	}


	//上传一个文件，File  
	public static void uploadFile(File file, String key) {  
		OSSClient client = client();  
		isVideo(file.getName());
		PutObjectRequest putObjectRequest = new PutObjectRequest(  
				bucketName, key, file);  
		client.putObject(putObjectRequest);  
	}  

	//上传一个文件，path  
	public String upload(File file,String fileName) throws Exception {
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret); 
		isVideo(fileName);
		ossClient.putObject(bucketName,fileName, file);  
		ossClient.shutdown();  
		return fileName;
	}
	// 带进度条的上传。
	public String uploadJD(InputStream inputStream,String fileName,long fileSize) {
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		this.size = fileSize;
		this.fileName = fileName;
		ProgressSingleton.put(fileName+"size", size);
		ProgressSingleton.put(fileName+"progress", progress);
		isVideo(fileName);
		try {
		
			ossClient.putObject(new PutObjectRequest(bucketName, this.fileName, inputStream).
					<PutObjectRequest>withProgressListener(this));

		} catch (Exception e) {
			e.printStackTrace();
		}
		//当文件上传完成之后，从单例中移除此次上传的状态信息
		System.out.println("oss end");
		ProgressSingleton.remove(fileName + "size");
		ProgressSingleton.remove(fileName + "progress");
		// 关闭OSSClient。
		ossClient.shutdown();
		
		return fileName;
	}

	//下载一个文件到本地  
	public void download(String ossFileName,String localFile) throws Exception{
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);  
		isVideo(ossFileName);
		ossClient.getObject(new GetObjectRequest(bucketName,ossFileName), new File(localFile));
		System.out.println("end");
		ossClient.shutdown();
	}
	//删除一个文件  
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
		System.out.println(path);
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

	public static void isVideo(String fileName) {
		if (fileName.endsWith("mp4") || fileName.endsWith("mp3")) {			
			bucketName = bucketName2;
		}
		if (fileName.endsWith("jpg") || fileName.endsWith("png")) {		
			bucketName = bucketName1;
		}
	}

	@Override
	public void progressChanged(ProgressEvent progressEvent) {
		// TODO Auto-generated method stub
		long bytes = progressEvent.getBytes();
		ProgressEventType eventType = progressEvent.getEventType();
		switch (eventType) {
		case TRANSFER_STARTED_EVENT:
			System.out.println("Start to upload......");
			break;
		case REQUEST_CONTENT_LENGTH_EVENT:
			this.totalBytes = bytes;
			System.out.println(this.totalBytes + " bytes in total will be uploaded to OSS");
			break;

		case REQUEST_BYTE_TRANSFER_EVENT:
			progress += bytes;
			ProgressSingleton.put(fileName+"progress", progress);			
			this.bytesWritten += bytes;
			if (this.totalBytes != -1) {
				int percent = (int)(this.bytesWritten * 100.0 / this.totalBytes);
				System.out.println(bytes + " bytes have been written at this time, upload progress: " + percent + "%(" + this.bytesWritten + "/" + this.totalBytes + ")");
			} else {
//				System.out.println(bytes + " bytes have been written at this time, upload ratio: unknown" + "(" + this.bytesWritten + "/...)");
			}
			break;
		case TRANSFER_COMPLETED_EVENT:
			this.succeed = true;
			System.out.println("Succeed to upload, " + this.bytesWritten + " bytes have been transferred in total");
			break;
		case TRANSFER_FAILED_EVENT:
			System.out.println("Failed to upload, " + this.bytesWritten + " bytes have been transferred");
			break;
		default:
			break;
		}

	}

	public boolean isSucceed() {
		return succeed;
	}

	public void getcallback() {

	}   



	public static void main(String[] args) throws Exception {
		OSSUtil oss = new OSSUtil();
		//		C:\\bxwlw\\home\\test.log
		/*oss.upload("D:\\filedownload\\基本演绎法第六季01.mp4","基本演绎法第六季01");
		oss.upload("D:\\filedownload\\2.jpg",null);*/
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
