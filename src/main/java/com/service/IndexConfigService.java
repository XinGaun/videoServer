package com.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface IndexConfigService {
	/**
	 * 添加首页通知信息
	 * @param data
	 * @return
	 */
	public String addinform(String data,HttpServletRequest request);
	/**
	 * 查询首页通知信息
	 * @param data
	 * @return
	 */
	public String queryinformAll(String data);
	/**
	 * 删除首页通知信息
	 * @param data
	 * @return
	 */
	public String deleteinfo(String data);
	/**
	 * 修改首页通知信息
	 * @param data
	 * @return
	 */
	public String updateinfo(String data);
	/**
	 * 添加首页滚播信息
	 */
	public String addRollplayTab(String roll_url,Integer roll_weight,MultipartFile roll_img) throws Exception;
	/**
	 * 查询首页滚播信息
	 * @param map
	 * @return
	 */
	public String queryRollplayRab(String data);
	/**
	 * 删除首页滚播信息
	 */
	public String deleteRollplayTab(String data);
	/**
	 * 修改首页滚播信息
	 */
	public String updateRollplayTab(Integer roll_id,String roll_url,Integer roll_weight,@RequestParam(value="roll_img",required=false)  MultipartFile roll_img);
	/**
	 * 添加展示教师信息
	 */
	public String addTeachershowTab(MultipartFile teac_show_img,String teac_show_name,String teac_show_introduce,String teac_show_url,Integer teac_show_weight)throws Exception;
	/**
	 * 查询展示教师信息
	 * @param data
	 * @return
	 */
	public String queryTeachershowTab(String data);
	/**
	 * 删除展示教师信息
	 * @param data
	 * @return
	 */
	public String deleteTeachershowTab(String data);
	/**
	 * 修改展示教师信息
	 * @param data
	 * @return
	 */
	public String updateTeachershowTab(@RequestParam(value="teac_show_img",required=false)MultipartFile teac_show_img,String teac_show_name,String teac_show_introduce,String teac_show_url,Integer teac_show_weight,Integer teac_show_id)throws Exception;
	/**
	 * 首页查询滚播内容
	 * @param data
	 * @return
	 */
	public String queryrRollplaTabAll(String data);
	/**
	 * 首页查询全部通知内容
	 * @param data
	 * @return
	 */
	public String queryinformList(String data);
}
