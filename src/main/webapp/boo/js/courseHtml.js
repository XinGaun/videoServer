$(function(){
	var user_id = $.cookie('user_id');
	$("#kcml").hide();
	$("#xypl").hide();
	initRecommendCourse();
	$("#jjclassify").click(function(){
		$("#kcjjs").show();
		$("#kcml").hide();
		$("#xypl").hide();
	});
	$("#kcclassify").click(function(){
		$("#kcjjs").hide();
		$("#kcml").show();
		$("#xypl").hide();
	});
	$("#xyclassify").click(function(){
		$("#kcjjs").hide();
		$("#kcml").hide();
		$("#xypl").show();
	});
	var cid = getUrlParam('cid');
	initCourseTop(cid);
	judgePC();
	//alert(cid);
});

//var url = "http:/127.0.0.1:8080"
	var url ="";

//购买课程
function goumais(){
	 function getistype(){
	        return ($("#demo1-alipay").is(':checked') ? "1" : "2" ); 
	 }
	 $.ajax({
			type: "POST",
			url:"/videoServer/pays/pay",
			data:{
			price : $("#qians").html(), 
             istype : getistype(),
             //goodsname :$("goodsname").val(),
             user_id : $.cookie('user_id'),//用户ID
             video_id : getUrlParam('cid'),//课程Id

			},
			dataType: "json",
			success: function(data){
				 $("#goodsname").val(data.data.goodsname);
                 $("#istype").val(data.data.istype);
                 $('#key').val(data.data.key);
                 $('#notify_url').val(data.data.notify_url);
                 $('#orderid').val(data.data.orderid);
                 $('#orderuid').val(data.data.orderuid);
                 $('#price').val(data.data.price);
                 $('#return_url').val(data.data.return_url);
                 $('#uid').val(data.data.uid);
                 $('#submitdemo1').click();
			},
			error:function(){
				 alert(data.msg);
			}
		});
	 
}

//加入课程
function joincourse(){
	var data = {
		user_id:$.cookie('user_id'),
		video_id:getUrlParam('cid')
	}
	$.ajax({
		type : "POST",
		url : url
		+ "/videoServer/Videos/queryOrder",
		contentType : 'application/json; charset=UTF-8',
		data : JSON.stringify(data), //传入组装的参数
		dataType : "json",
		success : function(result) {
			console.log(result);
			if(result!="success"){
				if(confirm("是否购买课程加入课程!")){
					$("#myModal").modal('show');
				}else{
					
				}
			}else{
				alert("您已加入课程!,请直接在课程目录观看课程!");
			}
		}
		
	});
}
	
	
//判断PC或移动
function judgePC(){
	if (navigator.userAgent.match(/mobile/i)) {
		$(".jpckclass").css("height", "500px");
		$("body").css("font-size", "50px");
		$("#btpbq").css("font-size","50px");
	} else {
		$(".jpckclass").css("height", "220px");
	}
}

//获取传递参数
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象  
	var r = window.location.search.substr(1).match(reg); // 匹配目标参数  
	if (r != null)
		return unescape(r[2]);
	return null; // 返回参数值  
}	

//初始化推荐课程信息
function initRecommendCourse(){
	$.ajax({
		type : "POST",
		url : url
		+ "/videoServer/Videos/queryRecommend",
		contentType : 'application/json; charset=UTF-8',
		//data : JSON.stringify(param), //传入组装的参数
		dataType : "json",
		success : function(result) {
			//console.log(result);
			if (result.length == 0) {
				$("#queryqueryRecommendCourse").append("暂无课程信息!");
				return;
			}
			for(var i = 0; i < result.length; i++ ){
				var queryqueryRecommendCourse = '<div class="col-md-4" >'
					+ '<div class="thumbnail">'
					+ '<a href="course.html?cid='+result[i].courses_id+'">'
					+ '<img data-original="'
					+ result[i].courses_img_url
					+ '" class="jpckclass lazy" style="width:100%;" alt="...">'
					+ '</a>'
					+ '<div class="caption">'
					+ '<p style="font-weight: bold;">'
					+ result[i].courses_name
					+ '</p>'
					+ '<p style="text-indent:2em" class="kcjs">'
					+ result[i].courses_introduce
					+ '</p>'
					+ '<div class="col-md-6">'
					+ '<p style="color:green;font-weight: bold;">'
					+ result[i].teacher_name
					+ '</p>'
					+ '</div>'
					+ '<div class="col-md-6">'
					+ '<p style="text-align:right;">'
					+ result[i].courses_date
					+ '</p>'
					+ '</div>'
					+ '<p style="text-align:right;font-weight: bold;" class="col-md-12" ><span class="glyphicon glyphicon-star" style="color:yellow;"></span>'
					+ result[i].courses_grade
					+ '</p>'
					+ '<p style="color:#00BFFF;font-weight: bold;" class="col-md-4">'
					+ result[i].courses_pricemoney
					+ '<span>￥</span></p>'
					+ '<p style="text-align:right;font-weight: bold;" class="col-md-8"><span class="glyphicon glyphicon-eye-open" style="color:red"></span>'
					+ result[i].courses_click
					+ '</p>'
					+ '<p>&nbsp;</p>'
					+ '</div>'
					+ '</div>'
					+ '</div>';
				$("#queryqueryRecommendCourse").append(queryqueryRecommendCourse);
			}
			$("img.lazy").lazyload({
				effect : "fadeIn",
				offset : 300
			});
		}
	});
}


//初始化课程头部信息
function initCourseTop(cid){
	$.ajax({
		type : "POST",
		url : url
		+ "/videoServer/CourseDetails/queryCourseDetails",
		contentType : 'application/json; charset=UTF-8',
		data : JSON.stringify({cid:cid}), //传入组装的参数
		dataType : "json",
		success : function(result) {
			//console.log(result);
			for(var i=0;i<result.length;i++){
				$("#courses_name").html(result[0].courses_name);
				$("#courses_names").html(result[0].courses_name);
				$("#courses_grade").html(result[0].courses_grade);
				$("#qian").html(result[0].courses_pricemoney);
				$("#qians").html(result[0].courses_pricemoney);
				$("#courses_click").html(result[0].courses_click);
				$("#courses_introduce").html(result[0].courses_introduce);
				$("#video_form_name").html(result[0].video_form_name);
				$("#video_form_class").html(result[0].video_form_class);
				$("#videoimg").html('<img data-original="'+result[0].courses_img_url+'"  alt="..." style="width:100%;" class="img-rounded lazy">');
				$("#teacher_name").html(result[0].teacher_name);
				$("#teacher_introduce").html(result[0].teacher_introduce);
			}
			$("img.lazy").lazyload({
				effect : "fadeIn",
				offset : 300
			});
			var arr = result[0].courses_video.replace("[","");
			arr = arr.replace("]","");
			arr =arr.split(",");
			initVideo(arr);
		}

	});
}

//初始化课程视频信息
function initVideo(video_arr){
	$.ajax({
		type : "POST",
		url : url
		+ "/videoServer/CourseDetails/queryVideoDetails",
		contentType : 'application/json; charset=UTF-8',
		data : JSON.stringify(video_arr), //传入组装的参数
		dataType : "json",
		success : function(result) {
			//console.log(result);
			for(var i=0;i<result.length;i++){
				var videos = '<li>'
							+	'<div style="overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">'
							+	'<a href="javascript:void(0)">'+result[i].video_name+'</a>'
							+'</div>'
							+'</li>';
				$("#videos").append(videos);
			}
		}
	});

}