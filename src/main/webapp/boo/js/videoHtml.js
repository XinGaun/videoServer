$(function() {
	
	initajax(param);
	initrecommend();
	initqueryCourseGrade();
	judgePC();
	//var user_id = getUrlParam('user_id');
});


//var url = "http:/127.0.0.1:8080"
var url = "";
var pages = 0;//当前页数
var nums = 9;//每页几条
var total = 0;//总条数 
var sort = 0;//排序方式


//导航下方筛选
function queryClassVideo(queryAlls){
	param.queryAll=queryAlls;
	$("#courseAll").html("");
	param.pages = 0;
	param.nums = 0;
	initajax(param);
}

//搜索框查询
function queryNameVideo(){
	param.keyword = $("#keyword").val();
	param.queryAll = $("#queryAll").val();
	$("#courseAll").html("");
	param.pages = 0;
	param.nums = 0;
	initajax(param);
}


//视频排序
function videosort(number){
	$("#courseAll").html("");
	param.sort = number;
	param.pages = 0;
	param.nums = 0;
	initajax(param);
}


//组装参数
var param = {
		queryAll : $("#queryAll").val(),
		keyword : $("#keyword").val(),
		page : nums,
		nums : (pages*nums),
		sort : sort
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
	$("#courseAll").html("");
	//console.log(pages+1);
	initajax(param);
	return false;
}
//上页
function shangye(){
	pages--;
	param.nums=pages*nums;
	$("#courseAll").html("");
	//console.log(pages);
	initajax(param);
	return false;
}
//页数换页
function custom(number){
	pages=number-1;
	param.nums=(pages)*nums;
	$("#courseAll").html("");
	initajax(param);
	//console.log(pages);
	return false;
}

//加载打榜好课
function initqueryCourseGrade(){
	$.ajax({
		type : "POST",
		url : url
		+ "/videoServer/front/VideoIndex/queryCourseGrade",
		contentType : 'application/json; charset=UTF-8',
		//data : JSON.stringify(param), //传入组装的参数
		dataType : "json",
		success : function(result) {

			//console.log(result);

			if (result == "" || result.length == 0) {
				$("#queryCourseGrade").append("暂无课程信息!");
				return;
			}
			for(var i=0;i<result.length;i++){
				var queryCourseGrade = '<li>'
										+'<div class="col-md-12" style="overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">'

										+	'<a href="course.html?cid='+result[i].courses_id+'">'+result[i].courses_name+'</a>'

										+	'<span style="float:right"><span class="glyphicon glyphicon-thumbs-up"></span><span style="color: red">'+result[i].courses_grade+'</span></span>'
										+	'</div>'		
										+'</li>';
				$("#queryCourseGrade").append(queryCourseGrade);				
			}
		}
	});
}

//加载推荐课程页面
function initrecommend(){
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
				$("#queryRecommend").append("暂无课程信息!");
				return;
			}
			for(var i = 0; i < result.length; i++ ){
				var queryRecommend = '<div class="" >'
					+ '<div class="thumbnail">'
					+ '<a href="#">'
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
				$("#queryRecommend").append(queryRecommend);
			}	

			$("img.lazy").lazyload({
				effect : "fadeIn",
				offset : 300
			});

		}
	});
}

//加载默认课程页面
function initajax(param) {
	$
	.ajax({
		type : "POST",
		url : url
		+ "/videoServer/front/Videos/querycoursesTabAll",
		contentType : 'application/json; charset=UTF-8',
		data : JSON.stringify(param), //传入组装的参数
		dataType : "json",
		success : function(result) {
			console.log(result);
			if (result.list.length == 0) {
				$("#courseAll").append("暂无课程信息!");
				return;
			}
			for (var i = 0; i < result.list.length; i++) {
				var querycoursesTabAll = '<div class="col-md-4" >'
					+ '<div class="thumbnail" style="width:90%;">'

					+ '<a href="course.html?cid='+result.list[i].courses_id+'">'

					+ '<img data-original="'
					+ result.list[i].courses_img_url
					+ '" class="jpckclass lazy" style="width:100%;height:180px;" alt="...">'
					+ '</a>'
					+ '<div class="caption">'
					+ '<p style="font-weight: bold;">'
					+ result.list[i].courses_name
					+ '</p>'
					+ '<p style="text-indent:2em" class="kcjs">'
					+ result.list[i].courses_introduce
					+ '</p>'
					+ '<div class="col-md-6">'

					+ '<p style="color:green;font-weight: bold;"><a href="teacher_centre.html?cid='+result.list[i].teacher_id+'">'
					+ result.list[i].teacher_name
					+ '</a></p>'
					+ '</div>'
					+ '<div class="col-md-6">'
					+ '<p style="text-align:right;">'
					+ result.list[i].courses_date
					+ '</p>'
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
				$("#courseAll").append(
						querycoursesTabAll);
			}
			$("img.lazy").lazyload({
				effect : "fadeIn",
				offset : 200
			});
			total=result.total;
			page(pages,nums,result.total);
		}

	});
}