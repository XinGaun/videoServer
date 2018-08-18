var coursetype = '高中';
var video_form_name = null;
$(function() {
	init();
	initcourse();
	$("#gaozhong").click(function() {
		var data = {
				video_form_class :'高中'
		}
		//加载高中课程分类信息
		$("#gzCourseType").html("");
		$.ajax({
			type: "POST",
			contentType : 'application/json; charset=UTF-8',
			url:"/videoServer/front/LoadIndex/queryCourseType",
			data:JSON.stringify(data),
			dataType: "json",
			success: function(data){
				//console.log(data);
				for(var i=0;i<data.length;i++){
					var CourseType = '<div class="col-md-2" style="margin-top: 5px;">'
						+'<button style="width: 100%; height: 40px;" type="button" class="btn btn-default" onclick="kctypeclick(&quot;'+data[i].video_form_name+'&quot;)">'+data[i].video_form_name+'</button>'
						+'</div>';
					$("#gzCourseType").append(CourseType);
				}
			}
		});
		$('#gzbody').css('display', 'block');
		$('#czbody').css('display', 'none');
		$('#xxbody').css('display', 'none');
		$("#gzli").addClass("active");
		$("#czli").removeClass("active");
		$("#xxli").removeClass("active");
		pages = 0;
		nums =16;
		coursetype='高中';
		$("#kcbt").html("高中精品课程");
		video_form_name = null;
		initcourse();

	});
	$("#chuzhong").click(function() {
		var data = {
				video_form_class :'初中'
		}
		//加载初中课程分类信息
		$("#czCourseType").html("");
		$.ajax({
			type: "POST",
			contentType : 'application/json; charset=UTF-8',
			url:"/videoServer/front/LoadIndex/queryCourseType",
			data:JSON.stringify(data),
			dataType: "json",
			success: function(data){
				//console.log(data);
				for(var i=0;i<data.length;i++){
					var CourseType = '<div class="col-md-2" style="margin-top: 5px;">'
						+'<button style="width: 100%; height: 40px;" type="button" class="btn btn-default" onclick="kctypeclick(&quot;'+data[i].video_form_name+'&quot;)">'+data[i].video_form_name+'</button>'
						+'</div>';
					$("#czCourseType").append(CourseType);
				}
			}
		});
		$('#gzbody').css('display', 'none');
		$('#czbody').css('display', 'block');
		$('#xxbody').css('display', 'none');
		$("#czli").addClass("active");
		$("#gzli").removeClass("active");
		$("#xxli").removeClass("active");
		pages = 0;
		nums =16;
		coursetype='初中';
		$("#kcbt").html("初中精品课程");
		video_form_name = null;
		initcourse();
	});
	$("#xiaoxue").click(function() {
		var data = {
				video_form_class :'小学'
		}
		//加载小学课程分类信息
		$("#xxCourseType").html("");
		$.ajax({
			type: "POST",
			contentType : 'application/json; charset=UTF-8',
			url:"/videoServer/front/LoadIndex/queryCourseType",
			data:JSON.stringify(data),
			dataType: "json",
			success: function(data){
				//console.log(data);
				for(var i=0;i<data.length;i++){
					var CourseType = '<div class="col-md-2" style="margin-top: 5px;">'
						+'<button style="width: 100%; height: 40px;" type="button" class="btn btn-default" onclick="kctypeclick(&quot;'+data[i].video_form_name+'&quot;)">'+data[i].video_form_name+'</button>'
						+'</div>';
					$("#xxCourseType").append(CourseType);
				}
			}
		});
		$('#gzbody').css('display', 'none');
		$('#czbody').css('display', 'none');
		$('#xxbody').css('display', 'block');
		$("#xxli").addClass("active");
		$("#gzli").removeClass("active");
		$("#czli").removeClass("active");
		pages = 0;
		nums =16;
		coursetype='小学';
		$("#kcbt").html("小学精品课程");
		video_form_name = null;
		initcourse();
	});
	$('#kcbody .thumbnail').mouseover(function(e) {
		$(this).siblings().stop().fadeTo(1000, 0.6);
	});
	$('#kcbody .thumbnail').mouseout(function(e) {
		$(this).siblings().stop().fadeTo(500, 1);
	});
})

var pages = 0;//当前页数
var nums = 16;//每页几条
var total = 0;//总条数 
//点击修改课程标题
function kctypeclick(data){
	pages = 0;
	nums =16;
	$("#kcbt").html(data);
	video_form_name = data;
	initcourse();
}

//初始化高中精品课程信息
function initcourse(){
	var data = {
			video_form_class:coursetype,
			nums : (pages*nums),
			page:nums,
			video_form_name:video_form_name
	}
	$("#kcbody").html("");
	$.ajax({
		type: "POST",
		contentType : 'application/json; charset=UTF-8',
		url:"/videoServer/front/LoadIndex/queryRecommendCourseList",
		data:JSON.stringify(data),
		dataType: "json",
		success: function(data){
			console.log(data);
			for(var i=0;i<data.list.length;i++){
				var CourseBody = '<div class="thumbnail col-md-3"><a href="course.html?cid='+data.list[i].courses_id+'">'
					+'<img data-original="'+data.list[i].courses_img_url+'" class="img-rounded lazy" style="width: 100%; height: 220px;">'
					+'<div class="caption">'
					+'<p>'+data.list[i].courses_name+'</p>'
					+'<p>￥'+data.list[i].courses_pricemoney+'</p>'
					+'</div>'
					+'</a></div>';
				$("#kcbody").append(CourseBody);
			}
			$("img.lazy").lazyload({effect: "fadeIn",offset:300});
			total = data.total;
			page(pages,nums,data.total);
		}
	});

}

//初始化高中课程分类
function init(){
	var data = {
			video_form_class :coursetype
	}
	$.ajax({
		type: "POST",
		contentType : 'application/json; charset=UTF-8',
		url:"/videoServer/front/LoadIndex/queryCourseType",
		data:JSON.stringify(data),
		dataType: "json",
		success: function(data){
			//console.log(data);
			for(var i=0;i<data.length;i++){
				var CourseType = '<div class="col-md-2" style="margin-top: 5px;">'
					+'<button style="width: 100%; height: 40px;" type="button" class="btn btn-default" onclick="kctypeclick(&quot;'+data[i].video_form_name+'&quot;)">'+data[i].video_form_name+'</button>'
					+'</div>';
				$("#gzCourseType").append(CourseType);
			}
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
//下一页
function xiaye(){
	pages++;
	nums=pages*nums;	
	//$("#excellent").html("");
	initcourse();
	return false;
}
//上页
function shangye(){
	pages--;
	if(pages==0){
		nums =16;
	}else{
		nums=pages*nums;
	}
	//$("#excellent").html("");
	initcourse();
	return false;
}
//页数换页
function custom(number){
	pages=number-1;
	if(pages==0){
		nums =16;
	}else{
		nums=(pages)*nums;
	}
	//$("#excellent").html("");
	initcourse();
	//console.log(pages);
	return false;
}