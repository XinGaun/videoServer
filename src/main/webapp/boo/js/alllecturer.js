$(function(){
	initBoutique(param);
	judgePC();
	/*$("#videoHtml").click(function(){
		window.location.href = "video.html?user_id="+user_id;
	});*/
});
//var url = "http:/127.0.0.1:8080"
var url = "";
var user_id = 1;
$("img.lazy").lazyload({effect: "fadeIn"});
var url = "";
var pages = 0;//当前页数
var nums = 8;//每页几条
var total = 0;//总条数 

//搜索框查询
function queryNameVideo(){
	param.keywordtwo = $("#keywordtwo").val();
	//param.queryAll = $("#queryAll").val();
	$("#excellent").html("");
	param.pages = 0;
	param.nums = 0;
	initBoutique(param);
}

//组装参数
var param = {
		//keyword : $("#keyword").val(),
		page : nums,
		nums : (pages*nums)
		//sort : sort
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
/*function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象  
	var r = window.location.search.substr(1).match(reg); // 匹配目标参数  
	if (r != null)
		return unescape(r[2]);
	return null; // 返回参数值  
}*/

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

//index 加载所有教师
function initBoutique(param){
	$
	.ajax({
		type : "POST",
		url : url+"/videoServer/front/Alllecturer/queryTeacherInformation",
		contentType : 'application/json; charset=UTF-8',
		data: JSON.stringify(param),  //传入组装的参数
		dataType : "json",
		success : function(result) {
			if (result.list.length == 0) {
				$("#excellent").append("暂无课程信息!");
				return;
			}
			for (var i = 0; i < result.list.length; i++) {
				var excellent = '<div class="col-md-3">'
						+ '<div class="thumbnail" style="width:90%;">'
						+ '<a href="#">' 
						+ '<img data-original="'
						+ result.list[i].teacher_imgurl
						+ '" class="jpckclass lazy" style="width:100%;height:180px;" alt="...">'
						+ '</a>'
						+ '<div class="caption">'
						+ '<p style="color:green;font-weight: bold;font-size:18px;"><a href="teacher_centre.html?cid='+result.list[i].teacher_id+'">'
						+ result.list[i].teacher_name
						+ '</a></p>'
						+ '<p style="text-indent:2em;" class="kcjs">'
						+ result.list[i].teacher_introduce
						+ '</p>'
						+ '<div class="col-md-6">'
						+ '</div>'
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