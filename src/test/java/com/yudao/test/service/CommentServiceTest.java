package com.yudao.test.service;

import java.util.HashMap;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.service.CommentTabService;
import com.yudao.test.BaseTest;

public class CommentServiceTest extends BaseTest{
   @Autowired
   private CommentTabService service;
   @Test
   public void testComment() {
	   HashMap<String,Object> hashMap = new HashMap<>();
	   hashMap.put("limit", 10);
	   hashMap.put("start", 0);
	   hashMap.put("page", 1);
	   service.queryCommentTab(hashMap);
   }
}
