$(function(){
	initBoutique();
	initRecommend();
	judgePC();
	$("#videoHtml").click(function(){
		window.location.href = "video.html";
	});
});
//var url = "http:/127.0.0.1:8080"
var url = "";
var user_id = $.cookie('id');
$("img.lazy").lazyload({effect: "fadeIn"});

var pages = 0;//当前页数
var nums = 8;//每页几条
var total = 0;//总条数 

//组装参数
var param = {
		page : nums,
		nums : (pages*nums)
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
	initBoutiqueVideoClick(param);
	return false;
}
//上页
function shangye(){
	pages--;
	param.nums=pages*nums;
	$("#excellent").html("");
	initBoutiqueVideoClick(param);
	return false;
}
//页数换页
function custom(number){
	pages=number-1;
	param.nums=(pages)*nums;
	$("#excellent").html("");
	initBoutiqueVideoClick(param);
	//console.log(pages);
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

function btnMore(){
	var phone = $.cookie("phone");
	param.phone = phone;
	$("#excellent").html("");
	$("#buttonMore").html("");
	initBoutiqueVideoClick(param);
}

//index 加载课程评分榜
/*function initGrade(){
	$.ajax({
		type : "POST",
		url : url+"/videoServer/front/VideoIndex/queryCourseGrade",
		contentType : 'application/json; charset=UTF-8',
		//data: JSON.stringify(param),  //传入组装的参数
		dataType : "json",
		success : function(result) {
			if (result == "" || result.length == 0) {
				$("#queryCourseGrade").append("暂无课程信息!");
				return;
			}
			for(var i=0;i<result.length;i++){
				var queryCourseGrade = '<li>'
										+'<div class="col-md-12" style="overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">'
										+	'<a href="course.html?cid='+result[i].courses_id+'">'+result[i].courses_name+'</a>'
										+	'<span style="float:right"><span class="glyphicon glyphicon-thumbs-up"></span><span style="color: red">'+result[i].courses_grade+'</span></span>'
										+'</div>'		
										+'</li>';
				$("#queryCourseGrade").append(queryCourseGrade);				
			}
		}
	});
	
}*/

//index 加载课程点击榜
/*function initClick(){
	$.ajax({
		type : "POST",
		url : url+"/videoServer/front/VideoIndex/queryCourseClick",
		contentType : 'application/json; charset=UTF-8',
		//data: JSON.stringify(param),  //传入组装的参数
		dataType : "json",
		success : function(result) {
			if (result == "" || result.length == 0) {
				$("#queryCourseClick").append("暂无课程信息!");
				return;
			}
			for(var i=0;i<result.length;i++){
				var queryCourseClick = '<li>'
										+'<div class="col-md-12" style="overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">'
										+	'<a href="course.html?cid='+result[i].courses_id+'">'+result[i].courses_name+'</a>'
										+	'<span style="float:right"><span class="glyphicon glyphicon-hand-right"></span><span style="color: red">'+result[i].courses_click+'</span></span>'
										+'</div>';
										+'</li>';
				$("#queryCourseClick").append(queryCourseClick);				
			}
		}
		
	});
}*/

//index 加载推荐套餐
function initRecommend(){
	$
	.ajax({
		type : "POST",
		url : url+"/videoServer/front/VideoIndex/queryCombo",
		contentType : 'application/json; charset=UTF-8',
		//data: JSON.stringify(param),  //传入组装的参数
		dataType : "json",
		success : function(result) {
			if (result == "" || result.length == 0) {
				$("#querycombo").append("暂无课程信息!");
				return;
			}
			for (var i = 0; i < result.length; i++) {
				var querycombo = '<div class="col-md-3" >'
						+ '<div class="thumbnail">'
						+ '<a href="#">' 
						+ '<img data-original="'
						+ result[i].combo_imgs
						+ '" class="jpckclass lazy" style="width:100%;height:180px;" alt="...">'
						+ '</a>'
						+ '<div class="caption">'
						+ '<p style="font-weight: bold;">'
						+ result[i].combo_name
						+ '</p>'
						+ '<p style="text-indent:2em" class="kcjs">'
						+ result[i].combo_introduce
						+ '</p>'
						+ '<div class="col-md-6">'
						+ '<p style="color:green">'
						+ result[i].teacher_name
						+ '</p>'
						+ '</div>'
						+ '<div class="col-md-6">'
						+ '<p style="text-align:right;">'
						+ result[i].combo_date
						+ '</p>'
						+ '</div>'
						+ '<p style="color:#00BFFF;" class="col-md-4">'
						+ result[i].combo_price
						+ '<span>￥</span></p>'
						+ '<p>&nbsp;</p>'
						+ '</div>'
						+ '</div>'
						+ '</div>';
				$("#querycombo").append(querycombo);
			}
			$("img.lazy").lazyload({effect: "fadeIn",offset:300});
		}
	});
}


//index 加载精品课程
function initBoutique(){
	$
	.ajax({
		type : "POST",
		url : url+"/videoServer/front/VideoIndex/queryBoutiqueVideo",
		contentType : 'application/json; charset=UTF-8',
		//data: JSON.stringify(param),  //传入组装的参数
		dataType : "json",
		success : function(result) {
			if (result == "" || result.length == 0) {
				$("#excellent").append("暂无课程信息!");
				return;
			}
			for (var i = 0; i < result.length; i++) {
				var excellent = '<div class="col-md-3">'
						+ '<div class="thumbnail">'
						+ '<a href="course.html?cid='+result[i].courses_id+'"><img data-original="'
						+ result[i].courses_img_url
						+ '" class="jpckclass lazy" style="width:100%;height:180px" alt="...">'
						+ '</a>'
						+ '<div class="caption">'
						+ '<p style="font-weight: bold;">'
						+ result[i].courses_name
						+ '</p>'
						+ '<p style="text-indent:2em;" class="kcjs">'
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
						+ '<p style="text-align:right;font-weight: bold;" class="col-md-12" ><span>3622人已购买</span>'
						//+ result.list[i].courses_grade
						+ '</p>'
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
				$("#excellent").append(excellent);
			}
			$("img.lazy").lazyload({effect: "fadeIn",offset:300});
		}
	});	
}

//点击添加更多精品课程
function initBoutiqueVideoClick(param){
	$
	.ajax({
		type : "POST",
		url : url+"/videoServer/front/VideoIndex/queryBoutiqueVideoClick",
		contentType : 'application/json; charset=UTF-8',
		data: JSON.stringify(param),  //传入组装的参数
		dataType : "json",
		success : function(result) {
			if (result.list.length == 0) {
				$("#excellent").append("暂无课程详情!");
				return;
			}else {
				for (var i = 0; i < result.list.length; i++) {
						var excellent = '<div class="col-md-3">'
							+ '<div class="thumbnail">'
							+ '<a href="course.html?cid='+result.list[i].courses_id+'"><img data-original="'
							+ result.list[i].courses_img_url
							+ '" class="jpckclass lazy" style="width:100%;height:180px" alt="...">'
							+ '</a>'
							+ '<div class="caption">'
							+ '<p style="font-weight: bold;">'
							+ result.list[i].courses_name
							+ '</p>'
							+ '<p style="text-indent:2em;" class="kcjs">'
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
							+ '<p style="text-align:right;font-weight: bold;" class="col-md-12" ><span>3622人已购买</span>'
							//+ result.list[i].courses_grade
							+ '</p>'
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
						$("#excellent").append(excellent);
				}
				$("img.lazy").lazyload({effect: "fadeIn",offset:300});
				total=result.total;
				page(pages,nums,result.total);
			}
		}
	});	
}