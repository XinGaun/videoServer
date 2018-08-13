package com.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyuncs.exceptions.ClientException;
import com.util.AliBigFishSDK;

@Controller
@RequestMapping("/front/AliBigFish")
@ResponseBody
public class AliBigFishController {
	/**
	 * 短信验证码API
	 * @param data
	 * @return
	 * @throws ClientException 
	 */
	@RequestMapping(value="/verificationCode",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String verificationCode(@RequestBody String data) throws ClientException {
		return AliBigFishSDK.SendSMSAli(data);
	}
}
