package com.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.entity.Coupon;
import com.service.CouponService;

@Controller
@RequestMapping("coupon")
public class CouponController {
	@Autowired
	private CouponService couponService;
	
	@ResponseBody
	@RequestMapping(value="addCoupon", method=RequestMethod.POST)
	public String addCoupon(Coupon coupon) {
		return couponService.addCoupon(coupon);
	}
	@RequestMapping(value="delCoupon", method=RequestMethod.POST)
	public String delCoupon(Coupon coupon) {
		return couponService.deleteCoupon(coupon);
	}
	@ResponseBody
	@RequestMapping(value="queryCoupon", produces="application/json;charset=utf-8", method=RequestMethod.POST)
	public String queryCoupon(@RequestBody String data) {
		return couponService.queryCoupon(data);
	}
	/**
	 * 据年级查询课程分类信息
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="queryvideoFormClass", produces="application/json;charset=utf-8", method=RequestMethod.POST)
	public String queryvideoFormClass(@RequestBody String data) {
		return couponService.queryvideoFormClass(data);
	}
	/**
	 * 根据课程分类ID查询所属课程信息
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="queryCoursesTabAll", produces="application/json;charset=utf-8", method=RequestMethod.POST)
	public String queryCoursesTabAll(@RequestBody String data) {
		return couponService.queryCoursesTabAll(data);
	}
	/**
	 * 添加优惠码信息
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="addDiscountsTab", produces="application/json;charset=utf-8", method=RequestMethod.POST)
	public String addDiscountsTab(@RequestBody String data) {
		return couponService.addDiscountsTab(data);
	}
	/**
	 * 查询优惠码信息
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="queryDiscountsTab", produces="application/json;charset=utf-8", method=RequestMethod.POST)
	public String queryDiscountsTab(@RequestBody String data) {
		return couponService.queryDiscountsTab(data);
	}
	/**
	 * 修改优惠码信息
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="updateDiscountsTab", produces="application/json;charset=utf-8", method=RequestMethod.POST)
	public String updateDiscountsTab(@RequestBody String data) {
		return couponService.updateDiscountsTab(data);
	}
	/**
	 * 根据优惠卷ID查询优惠码信息
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="queryDiscountsNumberTab", produces="application/json;charset=utf-8", method=RequestMethod.POST)
	public String queryDiscountsNumberTab(@RequestBody String data) {
		return couponService.queryDiscountsNumberTab(data);
	}
	/**
	 * 根据优惠卷ID追加优惠码信息
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="addDiscountsNumberTab", produces="application/json;charset=utf-8", method=RequestMethod.POST)
	public String addDiscountsNumberTab(@RequestBody String data) {
		return couponService.addDiscountsNumberTab(data);
	}
}
