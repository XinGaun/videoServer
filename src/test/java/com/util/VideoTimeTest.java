package com.util;

import java.io.File;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;

public class VideoTimeTest {
	@Test
	public void testVideoTime() {
		//http://www.niceyuwen.com/video/bfce9b3f-8523-47e7-81ba-ede54dc1a1ca.mp4
		//d://filedownload//基本演绎法第六季01.mp4

		//新文件		
		/*File source = new File("http://www.niceyuwen.com/video/bfce9b3f-8523-47e7-81ba-ede54dc1a1ca.mp4");
		System.out.println(source.getName());*/
		try {					
			URL httpurl = new URL("d://filedownload//基本演绎法第六季01.mp4");  
			File tmpFile = File.createTempFile("temp", ".tmp");//创建临时文件
			FileUtils.copyURLToFile(httpurl, tmpFile );  
			Encoder encoder = new Encoder();		
			MultimediaInfo m = encoder.getInfo(tmpFile);
			long ls = m.getDuration();
			System.out.println("此视频时长为:"+ls/1000+"秒！");
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}
