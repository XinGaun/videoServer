package com.service;
/**
 * 销售奖励service层接口
 * @author 87518
 *
 */
public interface SalesIncentiveService {
	/**
	 * 添加销售团队类型
	 * @param data
	 * @return
	 */
	public String addSalesteamTypeTab(String data);
	/**
	 * 查询销售团队类型
	 * @param data
	 * @return
	 */
	public String querySalesteamTypeTab(String data);
	/**
	 * 更新销售团队类型
	 * @param data
	 * @return
	 */
	public String updateSalesteamTypeTab(String data);
	/**
	 * 删除销售团队类型
	 * @param data
	 * @return
	 */
	public String deleteSalesteamTypeTab(String data);
	/**
	 * 添加销售团队信息
	 * @param data
	 * @return
	 */
	public String addSalesteamTab(String data);
	/**
	 * 查询销售团队信息
	 * @param data
	 * @return
	 */
	public String querySalesteamTab(String data);
	/**
	 * 更新销售团队信息
	 * @param data
	 * @return
	 */
	public String updateSalesteamTab(String data);
	/**
	 * 删除销售团队信息
	 * @param data
	 * @return
	 */
	public String deleteSalesteamTab(String data);
	/**
	 * 添加团队员工信息
	 * @param data
	 * @return
	 */
	public String addSalesteamStaffMiddleTab(String data);
	/**
	 * 删除团队员工信息
	 * @param data
	 * @return
	 */
	public String deleteSalesteamStaffMiddleTab(String data);
	/**
	 * 查询团队成员信息
	 * @param data
	 * @return
	 */
	public String querySalesteamStaffMiddleTab(String data);
	/**
	 * 添加品类提成配置信息
	 * @param data
	 * @return
	 */
	public String addCommissionsTab(String data);
	/**
	 * 查询品类提成配置信息
	 * @param data
	 * @return
	 */
	public String queryCommissionsTab(String data);
	/**
	 * 更新品类提成配置信息
	 * @param data
	 * @return
	 */
	public String updateCommissionsTab(String data);
	/**
	 * 删除品类提成配置信息
	 * @param data
	 * @return
	 */
	public String deleteCommissionsTab(String data);
	/**
	 * 添加考核额度信息
	 * @param data
	 * @return
	 */
	public String addAssessTab(String data);
	/**
	 * 查询考核额度信息
	 * @param data
	 * @return
	 */
	public String queryAssessTab(String data);
	/**
	 * 修改考核额度表信息
	 * @param data
	 * @return
	 */
	public String updateAssessTab(String data);
	/**
	 * 删除考核额度表信息
	 * @param data
	 * @return
	 */
	public String deleteAssessTab(String data);
}
