$(function(){
	initCoupon(0);
})
var urls="/videoServer/"
//初始化优惠卷信息
function initCoupon(number){
	var data = {
		user_id:$.cookie("id")
	}
	if(number==1){
		var now = new Date();
		var time = now.getFullYear() + "-" +((now.getMonth()+1)<10?"0":"")+(now.getMonth()+1)+"-"+(now.getDate()<10?"0":"")+now.getDate();
		data.time = time;
		data.status="未使用";
	}else if(number==2){
		data.status="已使用";
	}else if(number==3){
		var now = new Date();
		var time = now.getFullYear() + "-" +((now.getMonth()+1)<10?"0":"")+(now.getMonth()+1)+"-"+(now.getDate()<10?"0":"")+now.getDate();
		data.endtime=time;
	}
	$.ajax({
		type : "POST",
		url : urls+"/front/coupon/queryUseridCouponAll",
		contentType : 'application/json; charset=UTF-8',
		datatype : 'json',
		cache : false, //禁用缓存
		data :JSON.stringify(data),
		dataType : "json",
		success : function(data) {
			$("#couponbody").html("");
			//console.log(data);
			for(var i=0;i<data.list.length;i++){
				var couponbody = '<tr>'
					+'<td>'+data.list[i].discounts_text+'</td>'
					+'<td>'+data.list[i].discounts_money+'</td>'
					+'<td><a href="http://www.niceyuwen.com/course.html?cid='+data.list[i].courses_id+'">'+data.list[i].courses_name+'</a></td>'
					+'<td>'+data.list[i].discounts_date+'</td>'
					+'<td>'+data.list[i].discounts_status+'</td>'
					+'</tr>';
				$("#couponbody").append(couponbody);
			}
			if($("#yhj").height()<700){
				$("#yhj").css("height","700px");
			}
		}
	});
}
//打开领取优惠卷模态框
function openModel(){
	$('#myModal2').modal('show');
}
//优惠码领取优惠卷
function discountscode(){
	if($("#discounts_code").val()!=""){
		var data = {
			discounts_code:$("#discounts_code").val(),
			user_id:$.cookie("id")
		}
		$.ajax({
			type : "POST",
			url : urls+"/front/coupon/updateCodeCoupon",
			contentType : 'application/json; charset=UTF-8',
			datatype : 'json',
			cache : false, //禁用缓存
			data :JSON.stringify(data),
			dataType : "json",
			success : function(data) {
				if(data.code==200){
					alert("领取成功!");
					$("#discounts_code").val("");
					$('#myModal2').modal('hide');
					initCoupon(0);
				}else{
					alert(data.msg);
				}
			}
		});
	}else{
		alert("请输入优惠码!");
	}
}