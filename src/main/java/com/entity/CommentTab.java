package com.entity;

import java.util.Date;

public class CommentTab{
	int commentId;		
	int videoId;
	int userId ;
	String commentText ;
	Date commentDate ;
	String replyText ;
	int replyTeacher ;
	Date replyDate ;
	
	public CommentTab() {
	
	}
	
	/*public CommentTab(HashMap<String,Object> demo) {
		if(demo.containsKey("commentId")) {
			this.commentId = (int) demo.get("commentId");
		}
		if(demo.containsKey("userId")) {
			this.userId = (int) demo.get("userId");
		}
		if(demo.containsKey("commentText")) {
			this.commentText = (String) demo.get("commentText");
		}
		if(demo.containsKey("commentDate")) {
			this.commentDate =new Date();
		}
		if(demo.containsKey("replyText")) {
			this.replyText =  demo.get("replyText").toString();
		}
		if(demo.containsKey("replyTeacher")) {
			this.replyTeacher =(int)demo.get("replyTeacher");
		}
		
	}*/
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public String getReplyText() {
		return replyText;
	}
	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}
	public int getReplyTeacher() {
		return replyTeacher;
	}
	public void setReplyTeacher(int replyTeacher) {
		this.replyTeacher = replyTeacher;
	}
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
}
