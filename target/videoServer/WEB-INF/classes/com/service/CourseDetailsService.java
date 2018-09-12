package com.service;

public interface CourseDetailsService {
	public String queryCourseDetails(String data);
	public String queryVideoDetails(String data);
	public String queryqueryRecommendCourse();
	/**
	 * 鏌ヨ瀛﹀憳璇勮
	 * @param data
	 * @return
	 */
	public String queryStudentComments(String data);
	/**
	 * 是否已经收藏课程
	 * @param data
	 * @return
	 */
	public String queryInitEnshrine(String data);
	/**
	 * 鎻掑叆鍒版敹钘忚〃
	 * @param data
	 * @return
	 */
	public String addCollection(String data);
	/**
	 * 鏍规嵁璇剧▼ID鏌ヨ鏁欏笀淇℃伅
	 * @param data
	 * @return
	 */
	public String queryTeacherClass(String data);
}
