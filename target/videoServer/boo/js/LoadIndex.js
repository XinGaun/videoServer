var coursetype = '高中';
var video_form_name = null;
$(function() {
	initrollplay();
	initinform();
	initteachershow();
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
		$("#gaozhong").addClass("actives");
		$("#chuzhong").removeClass("actives");
		$("#xiaoxue").removeClass("actives");
		pages = 0;
		nums =8;
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
		$("#chuzhong").addClass("actives");
		$("#gaozhong").removeClass("actives");
		$("#xiaoxue").removeClass("actives");
		pages = 0;
		nums =8;
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
		$("#xiaoxue").addClass("actives");
		$("#gaozhong").removeClass("actives");
		$("#chuzhong").removeClass("actives");
		pages = 0;
		nums =8;
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
var nums = 8;//每页几条
var total = 0;//总条数 
//点击修改课程标题
function kctypeclick(data){
	pages = 0;
	nums =8;
	$("#kcbt").html(data);
	video_form_name = data;
	initcourse();
}

//初始化高中精品课程信息
function initcourse(){
	var data = {
			video_form_class:coursetype,
			nums : pages*nums,
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
			//console.log(data);
			for(var i=0;i<data.list.length;i++){
				var CourseBody = '<div class="thumbnail" style="width: 290px; height: 224px;float:left;margin-right: 12px;"><a href="course.html?cid='+data.list[i].courses_id+'">'
					+'<img data-original="'+data.list[i].courses_img_url+'" class="img-rounded lazy" style="width: 290px; height:158px;">'
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
//初始化滚播图片
function initrollplay(){
	var data ={
		name:1
	}
	$.ajax({
		type: "POST",
		async:false, 
		contentType : 'application/json; charset=UTF-8',
		url:"/videoServer/front/IndexConfig/queryrRollplaTabAll",
		data:JSON.stringify(data),
		dataType: "json",
		success: function(data){
			//console.log(data);
			for(var i=0;i<data.list.length;i++){
				var listbox ="";
				if(i==0){
					listbox = '<div class="item active">'
						+'<a href="'+data.list[i].roll_url+'" target="view_window" ><img src="http://www.niceyuwen.com/image/'+data.list[i].roll_img+'" class="" style="height: 340px; width: 100%;"></a>'
					+'</div>';	
				}else{
					listbox = '<div class="item">'
								+'<a href="'+data.list[i].roll_url+'" target="view_window" ><img src="http://www.niceyuwen.com/image/'+data.list[i].roll_img+'" class="" style="height: 340px; width: 100%;"></a>'
							+'</div>';
				}
				$("#listbox").append(listbox);
				if(i==0){
					var yuandian ='<li data-target="#carousel-example-generic" data-slide-to="'+i+'" class="active"></li>';
					$("#yuandian").append(yuandian);
				}else{
					var yuandian ='<li data-target="#carousel-example-generic" data-slide-to="'+i+'" ></li>';
					$("#yuandian").append(yuandian);
				}
			}
		}
	});
}
//初始化通知消息
function initinform(){
	var data ={
		name:1
	}
	$.ajax({
		type: "POST",
		async:false, 
		contentType : 'application/json; charset=UTF-8',
		url:"/videoServer/front/IndexConfig/queryinformList",
		data:JSON.stringify(data),
		dataType: "json",
		success: function(data){
			//console.log(data);
			for(var i=0;i<data.list.length;i++){
				var inform = '<p style="line-height: 44px; width: 180px;" class="tzl">'
							+'<a href="'+data.list[i].info_url+'" target="view_window">'+data.list[i].info_text+'</a>'
							+'</p>';
				$("#colee1").append(inform);
			}
		}
	});
}

//初始化教师展示信息
function initteachershow(){
	var data ={
		name:1
	}
	$.ajax({
		type: "POST",
		async:false, 
		contentType : 'application/json; charset=UTF-8',
		url:"/videoServer/front/IndexConfig/queryTeachershowTabAll",
		data:JSON.stringify(data),
		dataType: "json",
		success: function(data){
			console.log(data);
			for(var i=0;i<data.list.length;i++){
				var teachershow = '<td class="tdclass"><div style="width: 290px; float: left; margin-left: 12px;">'
									+'<a href="'+data.list[i].teac_show_url+'" target="view_window" ><img src="http://www.niceyuwen.com/image/'+data.list[i].teac_show_img+'" style="width: 290px; height: 195px;"></a>'
									+'<div style="height: 71px; width: 290px; border: 2px solid #f5f5f5;">'
									+'<p style="font-weight: bold; margin-left: 10px; margin-top: 10px;">'+data.list[i].teac_show_name+'</p>'
									+'<p style="margin-left: 10px;">'+data.list[i].teac_show_introduce+'</p>'
									+'</div>'
									+'</div></td>';
					
				$("#teachershow").append(teachershow);
			}
			var speed = 30//速度数值越大速度越慢
			var colee_left2 = document.getElementById("colee_lefts2");
			var colee_left1 = document.getElementById("colee_lefts1");
			var colee_left = document.getElementById("colee_lefts");
			var elements = $('.tdclass');
			var len = elements.length;
			if(len>4){
				colee_left2.innerHTML = colee_left1.innerHTML
			}
			
			function Marquee3() {
				if (colee_left2.offsetWidth - colee_left.scrollLeft <= 0)//offsetWidth 是对象的可见宽度
					colee_left.scrollLeft -= colee_left1.offsetWidth//scrollWidth 是对象的实际内容的宽，不包边线宽度
				else {
					colee_left.scrollLeft++
				}
			}
			var MyMar3 = setInterval(Marquee3, speed)
			colee_left.onmouseover = function() {
				clearInterval(MyMar3)
			}
			colee_left.onmouseout = function() {
				MyMar3 = setInterval(Marquee3, speed)
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
	//$("#excellent").html("");
	initcourse();
	return false;
}
//上页
function shangye(){
	pages--;
	//$("#excellent").html("");
	initcourse();
	return false;
}
//页数换页
function custom(number){
	pages=number-1;
	//$("#excellent").html("");
	initcourse();
	//console.log(pages);
	return false;
}


/*var speed = 60;
var colee2 = document.getElementById("colee2");
var colee1 = document.getElementById("colee1");
var colee = document.getElementById("colee");
colee2.innerHTML = colee1.innerHTML; //克隆colee1为colee2
function Marquee1() {
	//当滚动至colee1与colee2交界时
	if(colee2.offsetTop-colee.scrollTop<=0){
	colee.scrollTop-=colee1.offsetHeight; //colee跳到最顶端
	}else{
	colee.scrollTop++
	}
	//无限循环
	if (colee.scrollTop >= colee1.offsetHeight) {
		colee.scrollTop = 0;
	} else {
		var ss = colee.scrollTop;
		colee.scrollTop=colee.scrollTop+1;
		if(ss==colee.scrollTop){
			ss = -1;
			colee.scrollTop = 0;
		}
	}
}
var MyMar1 = setInterval(Marquee1, speed)//设置定时器
//鼠标移上时清除定时器达到滚动停止的目的
colee.onmouseover = function() {
	clearInterval(MyMar1);
}
//鼠标移开时重设定时器
colee.onmouseout = function() {
	MyMar1 = setInterval(Marquee1, speed);
}*/