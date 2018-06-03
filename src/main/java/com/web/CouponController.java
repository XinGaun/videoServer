package com.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Coupon;
import com.service.CouponService;

@Controller
@RequestMapping("coupon")
public class CouponController {
	
	private CouponService couponService;
	
	@ResponseBody
	@RequestMapping(value="addCoupon", method=RequestMethod.POST)
	public String addCoupon(Coupon coupon) {
		return couponService.addCoupon(coupon);
	}

}
