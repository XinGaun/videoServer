package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.FrontCouponService;

@Controller
@RequestMapping("/front/coupon")
@ResponseBody
public class FrontCouponController {
	@Autowired
	private FrontCouponService couponService;
	/**
	 * 根据优惠卷ID查询优惠卷信息
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/queryCouponIDList", produces="application/json;charset=utf-8", method=RequestMethod.POST)
	public String queryCouponIDList(@RequestBody String data) {
		return couponService.queryCouponIDList(data);
	}
	/**
	 * 查询是否领取过优惠卷
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/queryUseridCoupon", produces="application/json;charset=utf-8", method=RequestMethod.POST)
	public String queryUseridCoupon(@RequestBody String data) {
		return couponService.queryUseridCoupon(data);
	}
	/**
	 * 领取优惠卷
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateUseridCoupon", produces="application/json;charset=utf-8", method=RequestMethod.POST)
	public String updateUseridCoupon(@RequestBody String data) {
		return couponService.updateUseridCoupon(data);
	}
	/**
	 * 用户查询自己优惠卷信息
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/queryUseridCouponAll", produces="application/json;charset=utf-8", method=RequestMethod.POST)
	public String queryUseridCouponAll(@RequestBody String data) {
		return couponService.queryUseridCouponAll(data);
	}
	/**
	 * 用户根据优惠码领取优惠卷
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateCodeCoupon", produces="application/json;charset=utf-8", method=RequestMethod.POST)
	public String updateCodeCoupon(@RequestBody String data) {
		return couponService.updateCodeCoupon(data);
	}
	/**
	 * 购买时查询优惠卷信息
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/queryPurchaseCoupon", produces="application/json;charset=utf-8", method=RequestMethod.POST)
	public String queryPurchaseCoupon(@RequestBody String data) {
		return couponService.queryPurchaseCoupon(data);
	}
}
