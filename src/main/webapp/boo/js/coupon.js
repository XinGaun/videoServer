var coupon = getUrlParam('coupon');
var phone = $.cookie("phone");
var url = "/videoServer/"
	$(function(){
		init();
	});

//获取传递参数
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象  
	var r = window.location.search.substr(1).match(reg); // 匹配目标参数  
	if (r != null)
		return unescape(r[2]);
	return null; // 返回参数值  
}
//初始化优惠卷信息
function init(){
	var data = coupon.split(",");
	if(data.length>0){
		$.ajax({
			type : "POST",
			url : url+"/front/coupon/queryCouponIDList",
			contentType : 'application/json; charset=UTF-8',
			datatype : 'json',
			cache : false, //禁用缓存
			data :JSON.stringify(data),
			dataType : "json",
			success : function(data) {
				if (data.code == 200) { //加载成功
					//添加数据
					//console.log(data);
					$("#bodytext").html("");
					var now = new Date();
					var time = now.getFullYear() + "-" +((now.getMonth()+1)<10?"0":"")+(now.getMonth()+1)+"-"+(now.getDate()<10?"0":"")+now.getDate();
					//alert(time);
					for(var i=0;i<data.list.length;i++){
						var discounts_money =  data.list[i].discounts_money.substring(0,data.list[i].discounts_money.lastIndexOf(".00"));
						if(data.list[i].num==0){
							var bodytext ='<div class="" style="box-shadow: 2px 2px 5px #bbb;border:1px solid #f5f5f5;height:154px;width:364px;float:left;margin-left:20px;margin-top:10px;">'
								+'<img src="'+data.list[i].courses_img_url+'" style="height:100px;width:100px;margin:27px;">'
								+'<div style="float:right;width:54px;">'
								+'<button class="btn btn-default" style="width:34px;height:154px;float:right;" onclick="">已<br>领<br>完</button>'
								+'</div>'
								+'<div style="float:right;width:154px;margin-top:15px;height:139px;">'
								+'<span><a href="course.html?cid='+data.list[i].courses_id+'" title="'+data.list[i].courses_name+'" style="width:154px;white-space:nowrap;overflow:hidden;text-overflow:ellipsis; display:block;">'
								+'<span style="font-weight:bold;color:red;font-style:normal;height:39px;position:absoult;top:0px;left:0px;">￥</span>'
								+'<strong style="font-weight:bold;color:red;font-size:35px;height:39px;">'+discounts_money+'</strong>'
								+'《'+data.list[i].courses_name+'》</a></span>'
								+'<div style="height:60px;">'+data.list[i].discounts_text+'</div>'
								+'<div style="">剩余<span style="color:green;font-weight:bold;font-size:18px;">'+data.list[i].num+'</span>张</div>'
								+'</div>'
								+'</div>';
							$("#bodytext").append(bodytext);
						}else{
							if(time>data.list[i].discounts_date){
								var bodytext ='<div class="" style="box-shadow: 2px 2px 5px #bbb;border:1px solid #f5f5f5;height:154px;width:364px;float:left;margin-left:20px;margin-top:10px;">'
									+'<img src="'+data.list[i].courses_img_url+'" style="height:100px;width:100px;margin:27px;">'
									+'<div style="float:right;width:54px;">'
									+'<button class="btn btn-default" style="width:34px;height:154px;float:right;" onclick="">已<br>过<br>期</button>'
									+'</div>'
									+'<div style="float:right;width:154px;margin-top:15px;height:139px;">'
									+'<span><a href="course.html?cid='+data.list[i].courses_id+'" title="'+data.list[i].courses_name+'" style="width:154px;white-space:nowrap;overflow:hidden;text-overflow:ellipsis; display:block;">'
									+'<span style="font-weight:bold;color:red;font-style:normal;height:39px;position:absoult;top:0px;left:0px;">￥</span>'
									+'<strong style="font-weight:bold;color:red;font-size:35px;height:39px;">'+discounts_money+'</strong>'
									+'《'+data.list[i].courses_name+'》</a></span>'
									+'<div style="height:60px;">'+data.list[i].discounts_text+'</div>'
									+'<div style="">剩余<span style="color:green;font-weight:bold;font-size:18px;">'+data.list[i].num+'</span>张</div>'
									+'</div>'
									+'</div>';
								$("#bodytext").append(bodytext);
							}else{
								var bodytext ='<div class="" style="box-shadow: 2px 2px 5px #bbb;border:1px solid #f5f5f5;height:154px;width:364px;float:left;margin-left:20px;margin-top:10px;">'
									+'<img src="'+data.list[i].courses_img_url+'" style="height:100px;width:100px;margin:27px;">'
									+'<div style="float:right;width:54px;">'
									+'<button class="btn btn-danger" style="width:34px;height:154px;float:right;" onclick="Getacoupon('+data.list[i].discounts_id+')">立<br>即<br>领<br>取</button>'
									+'</div>'
									+'<div style="float:right;width:154px;margin-top:15px;height:139px;">'
									+'<span><a href="course.html?cid='+data.list[i].courses_id+'" title="'+data.list[i].courses_name+'" style="width:154px;white-space:nowrap;overflow:hidden;text-overflow:ellipsis; display:block;">'
									+'<span style="font-weight:bold;color:red;font-style:normal;height:39px;position:absoult;top:0px;left:0px;">￥</span>'
									+'<strong style="font-weight:bold;color:red;font-size:35px;height:39px;">'+discounts_money+'</strong>'
									+'《'+data.list[i].courses_name+'》</a></span>'
									+'<div style="height:60px;">'+data.list[i].discounts_text+'</div>'
									+'<div style="">剩余<span style="color:green;font-weight:bold;font-size:18px;">'+data.list[i].num+'</span>张</div>'
									+'</div>'
									+'</div>';
								$("#bodytext").append(bodytext);
							}
							
						}
					}
					//alert($("#bodytext").height());
					if($("#bodytext").height()<700){
						$("#bodytext").css("min-height","700px");
					}
				} else {
					//alert("添加失败");
				}
			}
		});
	}
}
//确认是否可以领取优惠卷
function Getacoupon(discounts_id){
	if($.cookie("phone") == null){
		window.location.href='logins.html';
	}
	var datas={
			user_id:$.cookie("id"),
			discounts_id:discounts_id
	}
	$.ajax({
		type : "POST",
		url : url+"/front/coupon/queryUseridCoupon",
		contentType : 'application/json; charset=UTF-8',
		datatype : 'json',
		cache : false, //禁用缓存
		data :JSON.stringify(datas),
		dataType : "json",
		success : function(data) {
			if (data.code == 200) {
				getcoupon(datas);
			}else{
				alert("已领取过该优惠卷,请不要重复领取");
			}
		}
	});
}
//领取优惠卷
function getcoupon(data){
	//alert(data);
	$.ajax({
		type : "POST",
		url : url+"/front/coupon/updateUseridCoupon",
		contentType : 'application/json; charset=UTF-8',
		datatype : 'json',
		cache : false, //禁用缓存
		data :JSON.stringify(data),
		dataType : "json",
		success : function(data) {
			if (data.code == 200) {
				alert("领取成功,可以在个人中心查看使用!");
				window.location.reload();
			}else{
				alert("领取失败！");
			}
		}
	});
}