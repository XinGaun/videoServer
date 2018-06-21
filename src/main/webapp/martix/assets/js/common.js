/*!
 * 通用js文件
 * 1.加载前端是否显示的页面控制
 * 2.页面退出功能 
 */
var url = "/videoServer/";
 
function loadRoleInfo(){
	$.ajax({
		type: "POST",
		url: url+"roleRight/httpPageEle",
		datatype:'json',
		async:true,
		cache: false,  //禁用缓存
		data: {
			"teacher_id":12
		},  
		dataType: "json",
		success: function (data) {
			if(data.retMsg == 'admin'){	//加载成功
				//页面显示
				$(".role").css("display","block");
			}
		}
	});
}

function teacherLoginOut(){
	$.ajax({
		type: "POST",
		url: url+"teacher/teacherLogout",
		datatype:'json',
		async:true,
		cache: false,  //禁用缓存
		data: {
			"teacher_id":12
		},  
		dataType: "json",
		success: function (data) {
			window.location.href = url+'martix/login.html';  
		}
	});
}