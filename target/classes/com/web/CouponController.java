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

}
