package com.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.service.IndexConfigService;

@Controller
@RequestMapping("/front/IndexConfig")
@ResponseBody
public class IndexConfigController {
	@Autowired
	private IndexConfigService configService;
	/**
	 * 添加通知信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addinform",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addinform(@RequestBody String data,HttpServletRequest request) {
		return configService.addinform(data, request);
	}
	/**
	 * 查询通知信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryinformAll",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryinformAll(@RequestBody String data) {
		return configService.queryinformAll(data);
	}
	/**
	 * 删除通知信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteinfo",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteinfo(@RequestBody String data) {
		return configService.deleteinfo(data);
	}
	/**
	 * 修改通知信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateinfo",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateinfo(@RequestBody String data) {
		return configService.updateinfo(data);
	}
	/**
	 * 添加滚播信息
	 * @param data
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/addRollplayTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addRollplayTab(String roll_url,Integer roll_weight,MultipartFile roll_img) throws Exception {
		return configService.addRollplayTab(roll_url, roll_weight, roll_img);
	}
	/**
	 * 查询滚播信息
	 * @param data
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/queryRollplayRab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryRollplayRab(@RequestBody String data) {
		return configService.queryRollplayRab(data);
	}
	/**
	 * 删除滚播信息
	 * @param data
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/deleteRollplayTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteRollplayTab(@RequestBody String data) {
		return configService.deleteRollplayTab(data);
	}
	/**
	 * 修改滚播信息
	 * @param data
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/updateRollplayTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateRollplayTab(Integer roll_id,String roll_url,Integer roll_weight,@RequestParam(value="roll_img",required=false)  MultipartFile roll_img) throws Exception {
		return configService.updateRollplayTab(roll_id, roll_url, roll_weight, roll_img);
	}
	/**
	 * 添加滚播信息
	 * @param teac_show_img
	 * @param teac_show_name
	 * @param teac_show_introduce
	 * @param teac_show_url
	 * @param teac_show_weight
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/addTeachershowTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addTeachershowTab(MultipartFile teac_show_img, String teac_show_name, String teac_show_introduce,
			String teac_show_url, Integer teac_show_weight) throws Exception {
		return configService.addTeachershowTab(teac_show_img, teac_show_name, teac_show_introduce, teac_show_url, teac_show_weight);
	}
	/**
	 * 查询展示教师信息
	 * @param data
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/queryTeachershowTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryTeachershowTab(@RequestBody String data) {
		return configService.queryTeachershowTab(data);
	}
	/**
	 * 删除展示教师信息
	 * @param data
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/deleteTeachershowTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteTeachershowTab(@RequestBody String data) {
		return configService.deleteTeachershowTab(data);
	}
	/**
	 * 修改展示教师信息
	 * @param data
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/updateTeachershowTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateTeachershowTab(@RequestParam(value="teac_show_img",required=false)MultipartFile teac_show_img,String teac_show_name,String teac_show_introduce,String teac_show_url,Integer teac_show_weight,Integer teac_show_id)throws Exception {
		return configService.updateTeachershowTab(teac_show_img, teac_show_name, teac_show_introduce, teac_show_url, teac_show_weight, teac_show_id);
	}
	/**
	 * 首页查询滚播内容
	 * @param data
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/queryrRollplaTabAll",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryrRollplaTabAll(@RequestBody String data) {
		return configService.queryrRollplaTabAll(data);
	}
	/**
	 * 首页查询通知内容
	 * @param data
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/queryinformList",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryinformList(@RequestBody String data) {
		return configService.queryinformList(data);
	}
	/**
	 * 首页查询展示教师
	 * @param data
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/queryTeachershowTabAll",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryTeachershowTabAll(@RequestBody String data) {
		return configService.queryTeachershowTabAll(data);
	}
	/**
	 * 查询跳转教师ID信息
	 * @param data
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/queryTeachersUrlID",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryTeachersUrlID(@RequestBody String data) {
		return configService.queryTeachersUrlID(data);
	}
}
