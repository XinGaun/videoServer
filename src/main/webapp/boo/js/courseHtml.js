$(function(){

	var user_id = $.cookie('id');

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
	$("#Collection").click(function(){
		var collection = $("#Collection").html();
		if(collection =="已收藏"){
			alert("已经收藏啦")
		}else{
			var userphone=$.cookie("phone");
			var cid = getUrlParam('cid');
			param.cid = cid;
			param.userphone = userphone;
			insertCollection(param);
			$("#Collection").html("已收藏");
		}
	});
	var cid = getUrlParam('cid');
	initCourseTop(cid);
	param.cid = cid;
	initStudentComments(param);
	judgePC();
});

//var url = "http:/127.0.0.1:8080"

var url ="";

var pages = 0;//当前页数
var nums = 3;//每页几条
var total = 0;//总条数 

//组装参数
var param = {
		page : nums,
		nums : (pages*nums)
}
//购买课程
function goumais(){

	function getistype(){
		return ($("#demo1-alipay").is(':checked') ? "1" : "2" ); 
	}
	$.ajax({
		type: "POST",
		url:"/videoServer/front/pays/pay",
		data:{
			price : $("#qians").html(), 
			istype : getistype(),
			//goodsname :$("goodsname").val(),
			user_id : $.cookie('id'),//用户ID
			video_id : getUrlParam('cid'),//课程Id

		},
		dataType: "json",
		success: function(data){
			if(data==-1){
				alert("购买成功!");
				return;
			}
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


	if($.cookie('id')==null||$.cookie('id')==""||$.cookie('id')==undefined){
		if(confirm("您还没有登录请先登录!")){
			window.location.href="logins.html";
			return false;
		}else{
			return false;
		}
	}
	var data = {
			user_id:$.cookie('id'),
			video_id:getUrlParam('cid')
	}
	$.ajax({
		type : "POST",
		url : url
		+ "/videoServer/front/Videos/queryOrder",
		contentType : 'application/json; charset=UTF-8',
		data : JSON.stringify(data), //传入组装的参数
		dataType : "json",
		success : function(result) {
			//console.log(result);
			if(result!="success"){

				if(confirm("您还没有购买课程,是否购买课程加入课程!")){
					$("#myModal").modal('show');
					return false;
				}else{
					return false;
				}
			}else{
				alert("您已加入课程!,请直接在课程目录观看课程!");
				return true;
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
		+ "/videoServer/front/Videos/queryRecommend",
		contentType : 'application/json; charset=UTF-8',
		//data : JSON.stringify(param), //传入组装的参数
		dataType : "json",
		success : function(result) {
			//console.log(result);
			if (result.length == 0) {
				$("#queryqueryRecommendCourse").html("暂无课程信息!");
				return;
			}
			for(var i = 0; i < result.length; i++ ){
				var queryqueryRecommendCourse = '<div class="col-md-4" >'
					+ '<div class="thumbnail" style="width:100%;">'
					+ '<a href="course.html?cid='+result[i].courses_id+'">'
					+ '<img data-original="'
					+ result[i].courses_img_url
					+ '" class="jpckclass lazy" style="width:100%;height:180px;" alt="...">'
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
		+ "/videoServer/front/CourseDetails/queryCourseDetails",
		contentType : 'application/json; charset=UTF-8',
		data : JSON.stringify({cid:cid}), //传入组装的参数
		dataType : "json",
		success : function(result) {
			//console.log(result);
			for(var i=0;i<result.length;i++){
				if(result[0].video_id == "" || result[0].video_id == null){
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
					$("#Collection").html("收藏");
				}else{
					$("#Collection").html("已收藏");
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
		+ "/videoServer/front/CourseDetails/queryVideoDetails",
		contentType : 'application/json; charset=UTF-8',
		data : JSON.stringify(video_arr), //传入组装的参数
		dataType : "json",
		success : function(result) {
			//console.log(result);
			for(var i=0;i<result.length;i++){
				var videos = '<li class="list-group-item">'

					+	'<div style="overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">'
					+	'<a href="javascript:void(0)" onclick="videourl(&quot;'+result[i].video_url+'&quot;,'+result[i].video_id+')")">'+result[i].video_name+'</a>'
					+'</div>'
					+'</li>';

				$("#videos").append(videos);
				var kcmls ="";
				if(result[i].video_ppt!=undefined){
					kcmls= '<li class="list-group-item">'

						+	'<div style="overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">'
						+	'<a href="javascript:void(0)" onclick="">'+result[i].video_ppt+'</a>'
						+'</div>'
						+'</li>';
					$("#kcmls").append(kcmls);
				}
				var kcxjs = '<button class="btn btn-default col-md-1"  onclick="videourl(&quot;'+result[i].video_url+'&quot;,'+result[i].video_id+')")" style="height:50px;width:50px;">'+(i+1)+'</button>';
				$("#kcxjs").append(kcxjs);
			}
		}
	});

}

//弹出播放页面
function videourl(urls,id){
	if($.cookie('id')==null||$.cookie('id')==""||$.cookie('id')==undefined){
			window.location.href="logins.html";
		
	}
	var data = {
			user_id:$.cookie('id'),
			video_id:getUrlParam('cid')
	}
	$.ajax({
		type : "POST",
		url : url
		+ "/videoServer/front/Videos/queryOrder",
		contentType : 'application/json; charset=UTF-8',
		data : JSON.stringify(data), //传入组装的参数
		dataType : "json",
		success : function(result) {
			//console.log(result);
			if(result!="success"){
				if(confirm("您还没有购买课程,是否购买课程加入课程!")){
					$("#myModal").modal('show');
					return false;
				}else{
					return false;
				}
			}else{
				$("#myModalvideo").modal('show');
				var videoObject = {
						container: '.video',//“#”代表容器的ID，“.”或“”代表容器的class
						variable: 'player',//该属性必需设置，值等于下面的new chplayer()的对象
						autoplay:true,//自动播放
						video:urls,//视频地址,
						h:'1',
						m:'0'
				};
				var player=new ckplayer(videoObject);
				//查询评论信息
				videoComment(id);
			}
		}

	});

}



//初始化学员评论
function initStudentComments(param){
	$
	.ajax({
		type : "POST",
		url : url+"/videoServer/front/CourseDetails/queryStudentComments",
		contentType : 'application/json; charset=UTF-8',
		data: JSON.stringify(param),  //传入组装的参数
		dataType : "json",
		success : function(result) {
			if (result.list.length == 0) {
				$("#excellent").append("暂无评论!");
				return;
			}else {
				for (var i = 0; i < result.list.length; i++) {
					if(result.list[i].reply_text == '' || result.list[i].reply_text == null){
						var excellent = '<div class="col-md-3" style="width:100%;float:left;">'
							+ '<div class="media-left">'
							+ '<div>'
							+ '<a href="#">' + '<img data-original="'
							+  result.list[i].user_photo
							+ '" class="jpckclass lazy" style="width:20%;" alt="...">'
							+ '</a>'
							+ '</div>'
							+ '<div class="media-body"><h4 class="media-heading"><span><a href="#">'
							+ result.list[i].user_name
							+ '</a>&nbsp;</span>评论了:&nbsp;' 
							+ '<span><a href="#">'
							+ result.list[i].video_name
							+ '</a></span></h4>'
							+ '<p class="col-md-12" >'
							+ result.list[i].comment_text
							+ '</p>'
							+ '<p style="font-weight: bold;">'
							+ result.list[i].comment_date
							+ '</p>'
							+ '</div>'
							+ '</div>'
							+ '</div>';
						$("#excellent").append(excellent);
						$("img.lazy").lazyload({effect: "fadeIn",offset:300});
						total=result.total;
						page(pages,nums,result.total);
					}else{
						var excellent ='<div class="col-md-3" style="width:100%;float:left;">'
							+ '<div class="media-left">'
							+ '<div>'
							+ '<a href="#">' + '<img data-original="'
							+  result.list[i].user_photo
							+ '" class="jpckclass lazy" style="width:20%;" alt="...">'
							+ '</a>'
							+ '</div>'
							+ '<div class="media-body"><h4 class="media-heading"><span><a href="#">'
							+ result.list[i].user_name
							+ '</a>&nbsp;</span>评论了:&nbsp;' 
							+ '<span><a href="#">'
							+ result.list[i].video_name
							+ '</a></span></h4>'
							+ '<p class="col-md-12" >'
							+ result.list[i].comment_text
							+ '</p>'
							+ '<p style="font-weight: bold;">'
							+ result.list[i].comment_date
							+ '</p>'
							+ '<div class="media-body" style="text-align:30px;"><h5 class="media-heading"><span><a href="#">'
							+ result.list[i].teacher_name
							+ '</a>&nbsp;</span>回复了:&nbsp;'
							+ '<span><a href="#">'
							+ result.list[i].user_name
							+ '</a></span></h5>'
							+ '<p class="col-md-12" >'
							+ result.list[i].reply_text
							+ '</p>'
							+ '<p style="font-weight: bold;">'
							+ result.list[i].reply_date
							+ '</p>'
							+ '</div>'
							+ '</div>'
							+ '</div>'
							+ '</div>';
						$("#excellent").append(excellent);
						$("img.lazy").lazyload({effect: "fadeIn",offset:300});
						total=result.total;
						page(pages,nums,result.total);
					}

				}
			}
		}
	});	
}

//收藏课程
function insertCollection(param){
	$.ajax({
		type : "POST",
		url : url
		+ "/videoServer/front/CourseDetails/addCollection",
		contentType : 'application/json; charset=UTF-8',
		data : JSON.stringify(param), //传入组装的参数
		dataType : "json",
		success : function(result) {
			alert("success");
		}

	});
}

//生成分页条
function page(pages, nums, total) {
	var next = "";
	var previous = "";
	var pageStr = "";
	if (pages == 0) {
		previous = "";
	} else {
		previous = '<li>'
			+ '<a href="javascript:void(0)" onclick="shangye()" aria-label="Previous">'
			+ '<span aria-hidden="true">&laquo;</span>'
			+ '</a>' + '</li>';
	}
	if (pages == total-1) {
		next = "";
	} else {
		next = '<li>' + '<a href="javascript:void(0)" onclick="xiaye()" >'
		+ '<span aria-hidden="true">&raquo;</span>'
		+ '</a>' + '</li>';
	}
	if (total <= 5 || pages <= 4) {
		var totalnum = 5;
		if(total<=5){
			totalnum = total
		}
		for (var i = 1; i <= totalnum; i++) {
			pageStr = pageStr + '<li><a href="javascript:void(0)" onclick="custom('+i+')">' + i
			+ '</a></li>';

		}
	} else if (total - pages <= 2) {
		for (var i = 0; i < 5; i++) {
			pageStr = '<li><a href="javascript:void(0)" onclick="custom('+(total - i)+')">' + (total - i)
			+ '</a></li>' + pageStr;
		}
	} else {
		for (var i = -1; i <= 3; i++) {
			pageStr = pageStr + '<li><a href="javascript:void(0)" onclick="custom('+(pages + i)+')">'
			+ (pages + i) + '</a></li>';
		}
	}

	//console.log(pageStr);

	var fanye = '<nav aria-label="Page navigation">'
		+ '<ul class="pagination">' + previous + pageStr
		+ next + '<li><a>当前第'+(pages+1)+'页</a></li></ul>' + '</nav>'
		$("#fanye").html(fanye);
}

//获取传递参数
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象  
	var r = window.location.search.substr(1).match(reg); // 匹配目标参数  
	if (r != null)
		return unescape(r[2]);
	return null; // 返回参数值  
}	

//下一页
function xiaye(){
	pages++;
	param.nums=pages*nums;	
	$("#excellent").html("");
	//console.log(pages+1);
	initStudentComments(param);
	return false;
}
//上页
function shangye(){
	pages--;
	param.nums=pages*nums;
	$("#excellent").html("");
	//console.log(pages);
	initStudentComments(param);
	return false;
}
//页数换页
function custom(number){
	pages=number-1;
	param.nums=(pages)*nums;
	$("#excellent").html("");
	initStudentComments(param);
	//console.log(pages);
	return false;
}
//查询评论信息
function videoComment(video_id){
	var data ={video_id:video_id};
	$.ajax({
		type : "POST",
		url : url+"/videoServer/front/Videos/queryComment",
		contentType : 'application/json; charset=UTF-8',
		data: JSON.stringify(data),  //传入组装的参数
		dataType : "json",
		success : function(result) {
			console.log(result);
			if(result.list.length<=0){
				$("#pingliu").html("暂无评论信息");
			}else{
				$("#pingliu").html("");
				for(var i=0;i<result.list.length;i++){
					var pinglun = '<div class="media">'
						  +	'<div class="media-left">'
						  +		'<a href="#"> <img class="media-object" src="img/tx4.png" alt="..."></a>'
						  +	'</div>'
						  +	'<div class="media-body">'
						  +		'<h4 class="media-heading">'
						  +		'<span>'+result.list[i].courses_date+'</span>&nbsp;&nbsp;<span>'+result.list[i].user_name+'</span>:</h4>'
						  +		'<div>'+result.list[i].comment_text+'</div>'
						  +		'<div>&nbsp;</div>'
						  +		'<div class="media">'
						  +		'<div class="media-left">'
						  +			'<a href="#"> <img class="media-object" src="img/tx1.png" alt="..."></a>'
						  +		'</div>'
						  +		'<div class="media-body">'
						  +			'<h4 class="media-heading">'
						  +			'<span>2017-06-25 12:00:00</span>&nbsp;&nbsp;<span>教师名</span>&nbsp;回复&nbsp;<span>用户名</span>:</h4>'
						  +			'<div>点赞!</div>'
						  +		'</div></div>'
						  +	'</div>'
						  +'</div>';
					$("#pingliu").append(pinglun);
				}
				
			}
		}
	});
}