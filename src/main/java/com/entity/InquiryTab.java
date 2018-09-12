package com.entity;
/**
 * 咨询留言表实体类
 * @author vip
 *
 */
public class InquiryTab {
	private Integer inqu_id;//ID
	private Integer buye_id;//买家ID
	private String inqu_title;//留言标题
	private String inqu_test;//留言内容
	private String inqu_img;//相关照片
	private String inqu_type;//留言类型
	private String inqu_date;//留言时间
	private String inqu_status;//状态
	private Integer staf_id;//答复人员ID
	private String inqu_reply;//答复内容
	private String inqu_reply_date;//答复时间
	private String inqu_phone;//买家联系电话
	private Integer orde_id;//关联订单ID
	public Integer getInqu_id() {
		return inqu_id;
	}
	public void setInqu_id(Integer inqu_id) {
		this.inqu_id = inqu_id;
	}
	public Integer getBuye_id() {
		return buye_id;
	}
	public void setBuye_id(Integer buye_id) {
		this.buye_id = buye_id;
	}
	public String getInqu_title() {
		return inqu_title;
	}
	public void setInqu_title(String inqu_title) {
		this.inqu_title = inqu_title;
	}
	public String getInqu_test() {
		return inqu_test;
	}
	public void setInqu_test(String inqu_test) {
		this.inqu_test = inqu_test;
	}
	public String getInqu_img() {
		return inqu_img;
	}
	public void setInqu_img(String inqu_img) {
		this.inqu_img = inqu_img;
	}
	public String getInqu_type() {
		return inqu_type;
	}
	public void setInqu_type(String inqu_type) {
		this.inqu_type = inqu_type;
	}
	public String getInqu_date() {
		return inqu_date;
	}
	public void setInqu_date(String inqu_date) {
		this.inqu_date = inqu_date;
	}
	public String getInqu_status() {
		return inqu_status;
	}
	public void setInqu_status(String inqu_status) {
		this.inqu_status = inqu_status;
	}
	public Integer getStaf_id() {
		return staf_id;
	}
	public void setStaf_id(Integer staf_id) {
		this.staf_id = staf_id;
	}
	public String getInqu_reply() {
		return inqu_reply;
	}
	public void setInqu_reply(String inqu_reply) {
		this.inqu_reply = inqu_reply;
	}
	public String getInqu_reply_date() {
		return inqu_reply_date;
	}
	public void setInqu_reply_date(String inqu_reply_date) {
		this.inqu_reply_date = inqu_reply_date;
	}
	public String getInqu_phone() {
		return inqu_phone;
	}
	public void setInqu_phone(String inqu_phone) {
		this.inqu_phone = inqu_phone;
	}
	public Integer getOrde_id() {
		return orde_id;
	}
	public void setOrde_id(Integer orde_id) {
		this.orde_id = orde_id;
	}
	
}
