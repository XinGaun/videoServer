$(function(){
	initRecommendTJ();
	judgePC();
});
//var url = "http:/127.0.0.1:8080"
var url = "";
var user_id = $.cookie('id');
$("img.lazy").lazyload({effect: "fadeIn"});

var pages = 0;//当前页数
var nums = 8;//每页几条
var total = 0;//总条数 

//组装参数
var paramT = {
		page : nums,
		nums : (pages*nums)
}

//生成分页条
function pageT(pages, nums, total) {
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

	var fanyeTT = '<nav aria-label="Page navigation">'
		+ '<ul class="pagination">' + previous + pageStr
		+ next + '<li><a>当前第'+(pages+1)+'页</a></li></ul>' + '</nav>'
		$("#fanyeTT").html(fanyeTT);
}

//获取传递参数
function getUrlParamT(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象  
	var r = window.location.search.substr(1).match(reg); // 匹配目标参数  
	if (r != null)
		return unescape(r[2]);
	return null; // 返回参数值  
}	

//下一页
function xiayeT(){
	pages++;
	param.nums=pages*nums;	
	$("#RecomExcellent").html("");
	initRecommendLessonClick(paramT);
	return false;
}
//上页
function shangyeT(){
	pages--;
	param.nums=pages*nums;
	$("#RecomExcellent").html("");
	initRecommendLessonClick(paramT);
	return false;
}
//页数换页
function customT(number){
	pages=number-1;
	param.nums=(pages)*nums;
	$("#RecomExcellent").html("");
	initRecommendLessonClick(paramT);
	return false;
}

//判断PC或移动
function judgePC(){
	if (navigator.userAgent.match(/mobile/i)) {
		$(".jpckclass").css("height", "500px");
		$("body").css("font-size", "50px");
	} else {
		$(".jpckclass").css("height", "220px");
	}
}

//导航下方筛选
function queryClassVideo(queryAlls){
	queryClassVideo1111(queryAlls);
	queryClassVideo2222(queryAlls);
}

//搜索框查询
function queryNameVideo(){
	paramT.queryAll = $("#dropdown").val();
	//alert(paramT.queryAll);
	paramT.keyword = $("#keyword").val();
	if(paramT.queryAll=='' && paramT.keyword==''){
		$("#RecomExcellent").html("");
		initRecommendTJ();
	}else{
	//	alert(paramT.keyword);
		$("#RecomExcellent").html("");
		initRecommendSearch(paramT);
	}
	
}

function queryClassVideo2222(queryAlls){
	paramT.queryAll=queryAlls;
	$("#RecomExcellent").html("");
	$("#buttonMore").html('精品课程<button class="btn btn-default" style="float: right" onclick="btnMore()">更&nbsp;多<span class="glyphicon glyphicon-menu-right"></span></button>');
	$("#MoreLesson22").html('推荐好课<button class="btn btn-default" style="float: right" onclick="MoreLesson()">更&nbsp;多<span class="glyphicon glyphicon-menu-right"></span></button>');
	$("#fanyeTT").html("");
	$("#fanye").html("");
	paramT.pages = 0;
	paramT.nums = 0;
	initRecommendLesson(paramT);
	//点击更多
	function MoreLesson(){
		var phone = $.cookie("phone");
		paramT.phone = phone;
		$("#RecomExcellent").html("");
		initRecommendLessonClick(paramT);
		$("#MoreLesson22").html('推荐好课<button class="btn btn-default" style="float: right" onclick="TakeBackLesson()">收&nbsp;回<span class="glyphicon glyphicon-menu-right"></span></button>');
	}
}

//点击更多
function MoreLesson(){
	var phone = $.cookie("phone");
	paramT.phone = phone;
	paramT.queryAll="";
	$("#RecomExcellent").html("");
	initRecommendLessonClick(paramT);
	$("#MoreLesson22").html('推荐好课<button class="btn btn-default" style="float: right" onclick="TakeBackLesson()">收&nbsp;回<span class="glyphicon glyphicon-menu-right"></span></button>');
}
//点击收回
function TakeBackLesson(){
	$("#RecomExcellent").html("");
	$("#fanyeTT").html("");
	$("#MoreLesson22").html('推荐好课<button class="btn btn-default" style="float: right" onclick="MoreLesson()">更&nbsp;多<span class="glyphicon glyphicon-menu-right"></span></button>');
	initRecommendTJ();
}

//index 加载默认课程
function initRecommendTJ(){
	$
	.ajax({
		type : "POST",
		url : url+"/videoServer/front/VideoIndex/queryCombo",
		contentType : 'application/json; charset=UTF-8',
		//data: JSON.stringify(param),  //传入组装的参数
		dataType : "json",
		success : function(result) {
			if (result == "" || result.length == 0) {
				$("#RecomExcellent").append("暂无课程信息!");
				$("#MoreLesson").html("推荐好课");
				return;
			}
			for (var i = 0; i < result.length; i++) {
				//alert(result[i].courses_name);
				if(result[i].courses_name == undefined || result[i].courses_name == ""){
					
				}else{
					if(result[i].kcPerson == 0){
						var RecomExcellent = '<div class="col-md-3">'
							+ '<div class="thumbnail">'
							+ '<a href="course.html?cid='+result[i].courses_id+'"><img data-original="'
							+ result[i].courses_img_url
							+ '" class="jpckclass lazy" style="width:100%;height:180px" alt="...">'
							+ '</a>'
							+ '<div class="caption">'
							+ '<p style="font-weight: bold;">'
							+ result[i].courses_name
							+ '</p>'
							+ '<p style="width:260px;height:40px; border:0px solid red;overflow:hidden; text-overflow:ellipsis;" class="kcjs">'
							+ result[i].courses_introduce
							+ '</p>'
							+ '<div class="col-md-6">'
							+ '<p style="color:green;font-weight: bold;"><a href="teacher_centre.html?cid='+result[i].teacher_id+'">'
							+ result[i].teacher_name
							+ '</a></p>'
							+ '<p><span style="color:#00BFFF;font-weight: bold;">课程时长：</span></p>'
							+ '</div>'
							+ '<div class="col-md-6">'
							+ '<p>'
							+ result[i].courses_date
							+'</P>'
							+ '<p style="text-align:right;font-weight: bold;">'
							+ result[i].courses_time
							+ '</p>'
							+ '</div>'
							+ '<p style="text-align:right;font-weight: bold;" class="col-md-12" >'
							//+ result[i].kcPerson
							+ '<span>0人已购买</span></p>'
							+ '<p style="color:#00BFFF;font-weight: bold;" class="col-md-4">'
							+ result[i].courses_pricemoney
							+ '<span>￥</span></p>'
							/*+ '<p style="text-align:right;font-weight: bold;" class="col-md-8"><span class="glyphicon glyphicon-eye-open" style="color:red"></span>'
							+ result[i].courses_click
							+ '</p>'*/
							+ '<p>&nbsp;</p>'
							+ '</div>'
							+ '</div>'
							+ '</div>';
						$("#RecomExcellent").append(RecomExcellent);
					}else{
						var RecomExcellent = '<div class="col-md-3">'
							+ '<div class="thumbnail">'
							+ '<a href="course.html?cid='+result[i].courses_id+'"><img data-original="'
							+ result[i].courses_img_url
							+ '" class="jpckclass lazy" style="width:100%;height:180px" alt="...">'
							+ '</a>'
							+ '<div class="caption">'
							+ '<p style="font-weight: bold;">'
							+ result[i].courses_name
							+ '</p>'
							+ '<p style="width:260px;height:40px; border:0px solid red;overflow:hidden; text-overflow:ellipsis;" class="kcjs">'
							+ result[i].courses_introduce
							+ '</p>'
							+ '<div class="col-md-6">'
							+ '<p style="color:green;font-weight: bold;"><a href="teacher_centre.html?cid='+result[i].teacher_id+'">'
							+ result[i].teacher_name
							+ '</a></p>'
							+ '<p><span style="color:#00BFFF;font-weight: bold;">课程时长：</span></p>'
							+ '</div>'
							+ '<div class="col-md-6">'
							+ '<p>'
							+ result[i].courses_date
							+'</P>'
							+ '<p style="text-align:right;font-weight: bold;">'
							+ result[i].courses_time
							+ '</p>'
							+ '</div>'
							+ '<p style="text-align:right;font-weight: bold;" class="col-md-12" >'
							+ result[i].kcPerson
							+ '<span>人已购买</span></p>'
							+ '<p style="color:#00BFFF;font-weight: bold;" class="col-md-4">'
							+ result[i].courses_pricemoney
							+ '<span>￥</span></p>'
							/*+ '<p style="text-align:right;font-weight: bold;" class="col-md-8"><span class="glyphicon glyphicon-eye-open" style="color:red"></span>'
							+ result[i].courses_click
							+ '</p>'*/
							+ '<p>&nbsp;</p>'
							+ '</div>'
							+ '</div>'
							+ '</div>';
						$("#RecomExcellent").append(RecomExcellent);
					}
				}
				
			}
			$("img.lazy").lazyload({effect: "fadeIn",offset:300});
		}
	});
}


//搜索的课程
function initRecommendSearch(paramT){
	$
	.ajax({
		type : "POST",
		url : url+"/videoServer/front/VideoIndex/queryComboSearch",
		contentType : 'application/json; charset=UTF-8',
		data: JSON.stringify(paramT),  //传入组装的参数
		dataType : "json",
		success : function(result) {
			if (result == "" || result.length == 0) {
				$("#RecomExcellent").append("暂无课程信息!");
				$("#MoreLesson22").html("推荐好课");
				return;
			}
			for (var i = 0; i < result.length; i++) {
			//	alert(result[i].courses_name);
				if(result[i].courses_name == undefined || result[i].courses_name == ""){
					
				}else{
					if(result[i].kcPerson == 0){
						var RecomExcellent = '<div class="col-md-3">'
							+ '<div class="thumbnail">'
							+ '<a href="course.html?cid='+result[i].courses_id+'"><img data-original="'
							+ result[i].courses_img_url
							+ '" class="jpckclass lazy" style="width:100%;height:180px" alt="...">'
							+ '</a>'
							+ '<div class="caption">'
							+ '<p style="font-weight: bold;">'
							+ result[i].courses_name
							+ '</p>'
							+ '<p style="width:260px;height:40px; border:0px solid red;overflow:hidden; text-overflow:ellipsis;" class="kcjs">'
							+ result[i].courses_introduce
							+ '</p>'
							+ '<div class="col-md-6">'
							+ '<p style="color:green;font-weight: bold;"><a href="teacher_centre.html?cid='+result[i].teacher_id+'">'
							+ result[i].teacher_name
							+ '</a></p>'
							+ '<p><span style="color:#00BFFF;font-weight: bold;">课程时长：</span></p>'
							+ '</div>'
							+ '<div class="col-md-6">'
							+ '<p>'
							+ result[i].courses_date
							+'</P>'
							+ '<p style="text-align:right;font-weight: bold;">'
							+ result[i].courses_time
							+ '</p>'
							+ '</div>'
							+ '<p style="text-align:right;font-weight: bold;" class="col-md-12" >'
							//+ result.list[i].kcPerson
							+ '<span>0人已购买</span></p>'
							+ '<p style="color:#00BFFF;font-weight: bold;" class="col-md-4">'
							+ result[i].courses_pricemoney
							+ '<span>￥</span></p>'
							/*+ '<p style="text-align:right;font-weight: bold;" class="col-md-8"><span class="glyphicon glyphicon-eye-open" style="color:red"></span>'
							+ result[i].courses_click
							+ '</p>'*/
							+ '<p>&nbsp;</p>'
							+ '</div>'
							+ '</div>'
							+ '</div>';
						$("#RecomExcellent").append(RecomExcellent);
					}else{
						var RecomExcellent = '<div class="col-md-3">'
							+ '<div class="thumbnail">'
							+ '<a href="course.html?cid='+result[i].courses_id+'"><img data-original="'
							+ result[i].courses_img_url
							+ '" class="jpckclass lazy" style="width:100%;height:180px" alt="...">'
							+ '</a>'
							+ '<div class="caption">'
							+ '<p style="font-weight: bold;">'
							+ result[i].courses_name
							+ '</p>'
							+ '<p style="width:260px;height:40px; border:0px solid red;overflow:hidden; text-overflow:ellipsis;" class="kcjs">'
							+ result[i].courses_introduce
							+ '</p>'
							+ '<div class="col-md-6">'
							+ '<p style="color:green;font-weight: bold;"><a href="teacher_centre.html?cid='+result[i].teacher_id+'">'
							+ result[i].teacher_name
							+ '</a></p>'
							+ '<p><span style="color:#00BFFF;font-weight: bold;">课程时长：</span></p>'
							+ '</div>'
							+ '<div class="col-md-6">'
							+ '<p>'
							+ result[i].courses_date
							+'</P>'
							+ '<p style="text-align:right;font-weight: bold;">'
							+ result[i].courses_time
							+ '</p>'
							+ '</div>'
							+ '<p style="text-align:right;font-weight: bold;" class="col-md-12" >'
							+ result[i].kcPerson
							+ '<span>人已购买</span></p>'
							+ '<p style="color:#00BFFF;font-weight: bold;" class="col-md-4">'
							+ result[i].courses_pricemoney
							+ '<span>￥</span></p>'
							/*+ '<p style="text-align:right;font-weight: bold;" class="col-md-8"><span class="glyphicon glyphicon-eye-open" style="color:red"></span>'
							+ result[i].courses_click
							+ '</p>'*/
							+ '<p>&nbsp;</p>'
							+ '</div>'
							+ '</div>'
							+ '</div>';
						$("#RecomExcellent").append(RecomExcellent);
					}
				}
			}
			$("img.lazy").lazyload({effect: "fadeIn",offset:300});
		}
	});
}

//index 加载推荐好课
function initRecommendLesson(paramT){
	$
	.ajax({
		type : "POST",
		url : url+"/videoServer/front/VideoIndex/queryBoutiqueVideo",
		contentType : 'application/json; charset=UTF-8',
		data: JSON.stringify(paramT),  //传入组装的参数
		dataType : "json",
		success : function(result) {
			if (result == "" || result.length == 0) {
				$("#RecomExcellent").append("暂无课程信息!");
				$("#MoreLesson").html("推荐好课");
				return;
			}
			for (var i = 0; i < result.length; i++) {
			//	alert(result[i].courses_name);
				if(result[i].courses_name == undefined || result[i].courses_name == ""){
					
				}else{
					if(result[i].kcPerson == 0 ){
						var RecomExcellent = '<div class="col-md-3">'
							+ '<div class="thumbnail">'
							+ '<a href="course.html?cid='+result[i].courses_id+'"><img data-original="'
							+ result[i].courses_img_url
							+ '" class="jpckclass lazy" style="width:100%;height:180px" alt="...">'
							+ '</a>'
							+ '<div class="caption">'
							+ '<p style="font-weight: bold;">'
							+ result[i].courses_name
							+ '</p>'
							+ '<p style="width:260px;height:40px; border:0px solid red;overflow:hidden; text-overflow:ellipsis;" class="kcjs">'
							+ result[i].courses_introduce
							+ '</p>'
							+ '<div class="col-md-6">'
							+ '<p style="color:green;font-weight: bold;"><a href="teacher_centre.html?cid='+result[i].teacher_id+'">'
							+ result[i].teacher_name
							+ '</a></p>'
							+ '<p><span style="color:#00BFFF;font-weight: bold;">课程时长：</span></p>'
							+ '</div>'
							+ '<div class="col-md-6">'
							+ '<p>'
							+ result[i].courses_date
							+'</P>'
							+ '<p style="text-align:right;font-weight: bold;">'
							+ result[i].courses_time
							+ '</p>'
							+ '</div>'
							+ '<p style="text-align:right;font-weight: bold;" class="col-md-12" >'
							//+ result[i].courses_grade
							+ '<span>0人已购买</span></p>'
							+ '<p style="color:#00BFFF;font-weight: bold;" class="col-md-4">'
							+ result[i].courses_pricemoney
							+ '<span>￥</span></p>'
							/*+ '<p style="text-align:right;font-weight: bold;" class="col-md-8"><span class="glyphicon glyphicon-eye-open" style="color:red"></span>'
							+ result[i].courses_click
							+ '</p>'*/
							+ '<p>&nbsp;</p>'
							+ '</div>'
							+ '</div>'
							+ '</div>';
					$("#RecomExcellent").append(RecomExcellent);
					}else{
						var RecomExcellent = '<div class="col-md-3">'
							+ '<div class="thumbnail">'
							+ '<a href="course.html?cid='+result[i].courses_id+'"><img data-original="'
							+ result[i].courses_img_url
							+ '" class="jpckclass lazy" style="width:100%;height:180px" alt="...">'
							+ '</a>'
							+ '<div class="caption">'
							+ '<p style="font-weight: bold;">'
							+ result[i].courses_name
							+ '</p>'
							+ '<p style="width:260px;height:40px; border:0px solid red;overflow:hidden; text-overflow:ellipsis;" class="kcjs">'
							+ result[i].courses_introduce
							+ '</p>'
							+ '<div class="col-md-6">'
							+ '<p style="color:green;font-weight: bold;"><a href="teacher_centre.html?cid='+result[i].teacher_id+'">'
							+ result[i].teacher_name
							+ '</a></p>'
							+ '<p><span style="color:#00BFFF;font-weight: bold;">课程时长：</span></p>'
							+ '</div>'
							+ '<div class="col-md-6">'
							+ '<p>'
							+ result[i].courses_date
							+'</P>'
							+ '<p style="text-align:right;font-weight: bold;">'
							+ result[i].courses_time
							+ '</p>'
							+ '</div>'
							+ '<p style="text-align:right;font-weight: bold;" class="col-md-12" >'
							+ result[i].kcPerson
							+ '<span>人已购买</span></p>'
							+ '<p style="color:#00BFFF;font-weight: bold;" class="col-md-4">'
							+ result[i].courses_pricemoney
							+ '<span>￥</span></p>'
							/*+ '<p style="text-align:right;font-weight: bold;" class="col-md-8"><span class="glyphicon glyphicon-eye-open" style="color:red"></span>'
							+ result[i].courses_click
							+ '</p>'*/
							+ '<p>&nbsp;</p>'
							+ '</div>'
							+ '</div>'
							+ '</div>';
					$("#RecomExcellent").append(RecomExcellent);
				  }
				}
			}
			$("img.lazy").lazyload({effect: "fadeIn",offset:300});
		}
	});	
}

//点击添加更多好课
function initRecommendLessonClick(paramT){
	$
	.ajax({
		type : "POST",
		url : url+"/videoServer/front/VideoIndex/queryBoutiqueVideoClick",
		contentType : 'application/json; charset=UTF-8',
		data: JSON.stringify(paramT),  //传入组装的参数
		dataType : "json",
		success : function(result) {
			if (result.list.length == 0) {
				$("#RecomExcellent").append("暂无课程详情!");
				$("#MoreLesson").html("推荐好课");
				return;
			}else {
				for (var i = 0; i < result.list.length; i++) {
					//alert(result[i].courses_name);
					if(result.list[i].courses_name == undefined || result.list[i].courses_name == ""){
						
					}else{
						if(result.list[i].kcPerson == 0 ){
							var RecomExcellent = '<div class="col-md-3">'
								+ '<div class="thumbnail">'
								+ '<a href="course.html?cid='+result.list[i].courses_id+'"><img data-original="'
								+ result.list[i].courses_img_url
								+ '" class="jpckclass lazy" style="width:100%;height:180px" alt="...">'
								+ '</a>'
								+ '<div class="caption">'
								+ '<p style="font-weight: bold;">'
								+ result.list[i].courses_name
								+ '</p>'
								+ '<p style="width:260px;height:40px; border:0px solid red;overflow:hidden; text-overflow:ellipsis;" class="kcjs">'
								+ result.list[i].teacher_introduce
								+ '</p>'
								+ '<div class="col-md-6">'
								+ '<p style="color:green;font-weight: bold;"><a href="teacher_centre.html?cid='+result.list[i].teacher_id+'">'
								+ result.list[i].teacher_name
								+ '</a></p>'
								+ '<p><span style="color:#00BFFF;font-weight: bold;">课程时长：</span></p>'
								+ '</div>'
								+ '<div class="col-md-6">'
								+ '<p>'
								+ result.list[i].courses_date
								+'</P>'
								+ '<p style="text-align:right;font-weight: bold;">'
								+ result.list[i].courses_time
								+ '</p>'
								+ '</div>'
								+ '<p style="text-align:right;font-weight: bold;" class="col-md-12" >'
								//+ result.list[i].kcPerson
								+ '<span>0人已购买</span></p>'
								+ '<p style="color:#00BFFF;font-weight: bold;" class="col-md-4">'
								+ result.list[i].courses_pricemoney
								+ '<span>￥</span></p>'
								/*+ '<p style="text-align:right;font-weight: bold;" class="col-md-8"><span class="glyphicon glyphicon-eye-open" style="color:red"></span>'
								+ result.list[i].courses_click
								+ '</p>'*/
								+ '<p>&nbsp;</p>'
								+ '</div>'
								+ '</div>'
								+ '</div>';	
							$("#RecomExcellent").append(RecomExcellent);
						}else{
							var RecomExcellent = '<div class="col-md-3">'
								+ '<div class="thumbnail">'
								+ '<a href="course.html?cid='+result.list[i].courses_id+'"><img data-original="'
								+ result.list[i].courses_img_url
								+ '" class="jpckclass lazy" style="width:100%;height:180px" alt="...">'
								+ '</a>'
								+ '<div class="caption">'
								+ '<p style="font-weight: bold;">'
								+ result.list[i].courses_name
								+ '</p>'
								+ '<p style="width:260px;height:40px; border:0px solid red;overflow:hidden; text-overflow:ellipsis;" class="kcjs">'
								+ result.list[i].teacher_introduce
								+ '</p>'
								+ '<div class="col-md-6">'
								+ '<p style="color:green;font-weight: bold;"><a href="teacher_centre.html?cid='+result.list[i].teacher_id+'">'
								+ result.list[i].teacher_name
								+ '</a></p>'
								+ '<p><span style="color:#00BFFF;font-weight: bold;">课程时长：</span></p>'
								+ '</div>'
								+ '<div class="col-md-6">'
								+ '<p>'
								+ result.list[i].courses_date
								+'</P>'
								+ '<p style="text-align:right;font-weight: bold;">'
								+ result.list[i].courses_time
								+ '</p>'
								+ '</div>'
								+ '<p style="text-align:right;font-weight: bold;" class="col-md-12" >'
								+ result.list[i].kcPerson
								+ '<span>人已购买</span></p>'
								+ '<p style="color:#00BFFF;font-weight: bold;" class="col-md-4">'
								+ result.list[i].courses_pricemoney
								+ '<span>￥</span></p>'
								/*+ '<p style="text-align:right;font-weight: bold;" class="col-md-8"><span class="glyphicon glyphicon-eye-open" style="color:red"></span>'
								+ result.list[i].courses_click
								+ '</p>'*/
								+ '<p>&nbsp;</p>'
								+ '</div>'
								+ '</div>'
								+ '</div>';	
							$("#RecomExcellent").append(RecomExcellent);
						}
					}
				}
				$("img.lazy").lazyload({effect: "fadeIn",offset:300});
				total=result.total;
				pageT(pages,nums,result.total);
			}
		}
	});	
}