$(function(){
	initBoutique();
	initRecommend();
	judgePC();
	initClick();
	initGrade();
	$("#videoHtml").click(function(){
		window.location.href = "video.html";
	});

});
//var url = "http:/127.0.0.1:8080"
var url = "";
var user_id = $.cookie('id');
$("img.lazy").lazyload({effect: "fadeIn"});



//判断PC或移动
function judgePC(){
	if (navigator.userAgent.match(/mobile/i)) {
		$(".jpckclass").css("height", "500px");
		$("body").css("font-size", "50px");
	} else {
		$(".jpckclass").css("height", "220px");
	}
}
//index 加载课程评分榜
function initGrade(){
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
	
}

//index 加载课程点击榜
function initClick(){
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
}

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
				$("#excellent").append(excellent);
			}
			$("img.lazy").lazyload({effect: "fadeIn",offset:300});
		}
	});	
}