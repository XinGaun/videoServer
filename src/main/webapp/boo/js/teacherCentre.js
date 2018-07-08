$(function(){
	var cid = null;
	cid = getUrlParam('cid');
	initCourseTop(cid);
	param.cid=cid;
	initBoutique(param);
	judgePC();
});
var url ="";

$("img.lazy").lazyload({effect: "fadeIn"});

var pages = 0;//当前页数
var nums = 8;//每页几条
var total = 0;//总条数 

//搜索框查询
function queryVideoName(){
	param.keywordthree = $("#keywordthree").val();
	//param.queryAll = $("#queryAll").val();
	$("#excellent").html("");
	param.pages = 0;
	param.nums = 0;
	initBoutique(param);
}

//组装参数
var param = {
		keywordthree : $("#keywordthree").val(),
		page : nums,
		nums : (pages*nums)
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
	initBoutique(param);
	return false;
}
//上页
function shangye(){
	pages--;
	param.nums=pages*nums;
	$("#excellent").html("");
	//console.log(pages);
	initBoutique(param);
	return false;
}
//页数换页
function custom(number){
	pages=number-1;
	param.nums=(pages)*nums;
	$("#excellent").html("");
	initBoutique(param);
	//console.log(pages);
	return false;
}

//初始化课程头部信息
function initCourseTop(cid){
	$.ajax({
		type : "POST",
		url : url
		+ "/videoServer/front/TeacherCentre/queryTeacherCentre",
		contentType : 'application/json; charset=UTF-8',
		data : JSON.stringify({cid:cid}), //传入组装的参数
		dataType : "json",
		success : function(result) {
			//console.log(result);
			for(var i=0;i<result.length;i++){
				$("#teacher_name").html(result[i].teacher_name);
				$("#video_form_class").html(result[i].video_form_class);
				$("#video_form_name").html(result[i].video_form_name);
				$("#teacher_introduce").html(result[i].teacher_introduce);
				//$("#video_form_name").html(result[0].video_form_name);
				//$("#video_form_class").html(result[0].video_form_class);
				$("#teacher_imgurl").html('<img data-original="'+result[i].teacher_imgurl+'"  alt="..." style="width:65%;" class="img-rounded lazy">');
				//$("#teacher_name").html(result[0].teacher_name);
				//$("#teacher_introduce").html(result[0].teacher_introduce);
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

//index加载在线课程
function initBoutique(param){
	$
	.ajax({
		type : "POST",
		url : url+"/videoServer/front/TeacherCentre/queryTeacherCentreVideo",
		contentType : 'application/json; charset=UTF-8',
		data: JSON.stringify(param),  //传入组装的参数
		dataType : "json",
		success : function(result) {
			if (result.list.length == 0) {
				$("#excellent").append("暂无课程信息!");
				return;
			}
			for (var i = 0; i < result.list.length; i++) {
				var excellent = '<div class="col-md-3" >'
						+ '<div class="thumbnail" style="width:90%;">'
						+ '<a href="#">' 
						+ '<img data-original="'
						+ result.list[i].courses_img_url
						+ '" class="jpckclass lazy" style="width:100%;height:180px;" alt="...">'
						+ '</a>'
						+ '<div class="caption">'
						+ '<p style="color:green;font-weight: bold;font-size:18px;"><a href="course.html?cid='+result.list[i].teacher_id+'">'
						+ result.list[i].courses_name
						+ '</a></p>'
						+ '<p style="font-weight: bold;">'
						+ result.list[i].courses_date
						+ '</p>'
						+ '<div class="col-md-6">'
						+ '</div>'
						+ '<p style="text-align:right;font-weight: bold;" class="col-md-12" ><span class="glyphicon glyphicon-star" style="color:yellow;"></span>'
						+ result.list[i].courses_grade
						+ '</p>'
						+ '<p style="color:#00BFFF;font-weight: bold;" class="col-md-4">'
						+ result.list[i].courses_pricemoney
						+ '<span>￥</span></p>'
						+ '<p style="text-align:right;font-weight: bold;" class="col-md-8"><span class="glyphicon glyphicon-eye-open" style="color:red"></span>'
						+ result.list[i].courses_click
						+ '</p>'
						+ '<p>&nbsp;</p>'
						+ '</div>'
						+ '</div>'
						+ '</div>';
				$("#excellent").append(excellent);
			}
			$("img.lazy").lazyload({effect: "fadeIn",offset:300});
			total=result.total;
			page(pages,nums,result.total);
		}
	});	
}