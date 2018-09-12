package com.entity;
/**
 * 评论表实体类
 * @author vip
 *
 */
public class DiscussTab {
	private Integer disc_id;//评论ID
	private Integer disc_comm_id;//商品ID
	private Integer disc_comm_putaway_id;//上架ID
	private Integer buye_id;//买家ID
	private Integer orde_id;//订单ID
	private Integer disc_comm_grade;//商品评分
	private Integer disc_deli_grade;//配送评分
	private Integer disc_inst_grade;//安装评分
	private String disc_content;//评论
	private String disc_reply;//答复
	private String disc_cont_date;//评价时间
	private String disc_reply_date;//答复时间
	private Integer disc_staff_id;//答复员工ID
	public Integer getDisc_id() {
		return disc_id;
	}
	public void setDisc_id(Integer disc_id) {
		this.disc_id = disc_id;
	}
	public Integer getDisc_comm_id() {
		return disc_comm_id;
	}
	public void setDisc_comm_id(Integer disc_comm_id) {
		this.disc_comm_id = disc_comm_id;
	}
	public Integer getDisc_comm_putaway_id() {
		return disc_comm_putaway_id;
	}
	public void setDisc_comm_putaway_id(Integer disc_comm_putaway_id) {
		this.disc_comm_putaway_id = disc_comm_putaway_id;
	}
	public Integer getBuye_id() {
		return buye_id;
	}
	public void setBuye_id(Integer buye_id) {
		this.buye_id = buye_id;
	}
	public Integer getOrde_id() {
		return orde_id;
	}
	public void setOrde_id(Integer orde_id) {
		this.orde_id = orde_id;
	}
	public Integer getDisc_comm_grade() {
		return disc_comm_grade;
	}
	public void setDisc_comm_grade(Integer disc_comm_grade) {
		this.disc_comm_grade = disc_comm_grade;
	}
	public Integer getDisc_deli_grade() {
		return disc_deli_grade;
	}
	public void setDisc_deli_grade(Integer disc_deli_grade) {
		this.disc_deli_grade = disc_deli_grade;
	}
	public Integer getDisc_inst_grade() {
		return disc_inst_grade;
	}
	public void setDisc_inst_grade(Integer disc_inst_grade) {
		this.disc_inst_grade = disc_inst_grade;
	}
	public String getDisc_content() {
		return disc_content;
	}
	public void setDisc_content(String disc_content) {
		this.disc_content = disc_content;
	}
	public String getDisc_reply() {
		return disc_reply;
	}
	public void setDisc_reply(String disc_reply) {
		this.disc_reply = disc_reply;
	}
	public String getDisc_cont_date() {
		return disc_cont_date;
	}
	public void setDisc_cont_date(String disc_cont_date) {
		this.disc_cont_date = disc_cont_date;
	}
	public String getDisc_reply_date() {
		return disc_reply_date;
	}
	public void setDisc_reply_date(String disc_reply_date) {
		this.disc_reply_date = disc_reply_date;
	}
	public Integer getDisc_staff_id() {
		return disc_staff_id;
	}
	public void setDisc_staff_id(Integer disc_staff_id) {
		this.disc_staff_id = disc_staff_id;
	}
	
}
