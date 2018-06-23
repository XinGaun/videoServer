package com.yudao.test.dao;



import java.util.Date;
import java.util.HashMap;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dao.CommentTabDao;
import com.yudao.test.BaseTest;

public class CommentTabDaoTest extends BaseTest{
	@Autowired
	private CommentTabDao dao;
	@Test
	public void testComment() {
		/*CommentTab comment = new CommentTab();
		comment.setVideoId(2);
		comment.setUserId(1);
		comment.setCommentText("sssuuuus");
		comment.setCommentDate(new Date());
		comment.setReplyText("oooxxxxo");
		comment.setReplyTeacher(1);
		comment.setReplyDate(new Date());*/
//		dao.addCommentTabEntity(comment);
		
		HashMap<String,Object> commentmap = new HashMap<>();
		commentmap.put("video_id", 2);
		commentmap.put("user_id", 3);
		commentmap.put("comment_text", "”–∏ˆ“…Œ ");
		commentmap.put("comment_date", new Date());
		dao.addCommentTabMap(commentmap);
	}
}
