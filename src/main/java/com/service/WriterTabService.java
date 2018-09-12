package com.service;



import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.WriterTab;

/**
 * 文案表Service层接口
 * @author vip
 *
 */
public interface WriterTabService {
	/**
	 * 添加文案信息
	 * @param data
	 * @return
	 */
	public String addWriterTab(MultipartFile writ_imgs,WriterTab writerTab);
	/**
	 * 查询文案信息
	 * @param data
	 * @return
	 */
	public String queryWriterTab(String data);
	/**
	 * 更新文案信息
	 * @param data
	 * @return
	 */
	public String updateWriterTab(@RequestParam(value="writ_imgs",required=false) MultipartFile writ_imgs,WriterTab writerTab);
	/**
	 * 删除文案信息
	 * @param data
	 * @return
	 */
	public String deleteWriterTab(String data);

}
