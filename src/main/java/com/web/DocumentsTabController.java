package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.DocumentsTabService;

/**
 * 文案模块API
 * @author vip
 *
 */
@RequestMapping("/hangrano2o/Documents")
@ResponseBody
@Controller
public class DocumentsTabController {
	@Autowired
	private DocumentsTabService documentsTabService;//调用文案模块Service层接口
	/**
	 * 添加文案模块
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addDocumentsTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addDocumentsTab(@RequestBody String data) {
		return documentsTabService.addDocumentsTab(data);
	}
	/**
	 * 查询文案模块
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryDocumentsTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryDocumentsTab(@RequestBody String data) {
		return documentsTabService.queryDocumentsTab(data);
	}
	/**
	 * 更新文案模块
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateDocumentsTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateDocumentsTab(@RequestBody String data) {
		return documentsTabService.updateDocumentsTab(data);
	}
	/**
	 * 删除文案模块
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteDocumentsTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteDocumentsTab(@RequestBody String data) {
		return documentsTabService.deleteDocumentsTab(data);
	}
}
