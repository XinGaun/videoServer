package com.web;

import java.security.GeneralSecurityException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.serviceImpl.QQemailService;

@Controller
@RequestMapping("/email")
public class MailController {
	@Autowired
	private QQemailService qemailService;
	 /**
     * 发送邮件
	 * @throws MessagingException 
	 * @throws GeneralSecurityException 
     */

	@SuppressWarnings("static-access")
	@RequestMapping(value="/sendmail",produces="application/json;charset=utf-8",method=RequestMethod.POST)
    @ResponseBody
    public String sendMail(@RequestBody String data) throws  GeneralSecurityException, MessagingException{		
		return qemailService.emit(data);
    }
}
