package server;

import java.util.HashMap;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.util.HttpReq;


public class m3u8 extends BaseTest{
	
	@Test
	public void testTokeM3u8() throws Exception{
		String url = "http://www.niceyuwen.com:2020/videoffmpeg/transcoding/transcodingm3u8";
		String path = "/oss/video/8b8f2f86056d493cbad561373ac43d3a_高中数学视频1.mp4";
		String fileName ="/oss/video/languge1";
		HashMap<String,String> data = new HashMap<>();
		data.put("PATH",path);
		data.put("fileName",fileName);
		HttpReq.httpRequest(url, "POST", JSON.toJSONString(data));
	}
}
