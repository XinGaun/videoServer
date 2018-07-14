$(function(){
	init();
	//alert($.cookie('id'));
});

//var url = "http://127.0.0.1:8080//"
	var url ="";

//初始化选项
function init(){
	$("#onemenu").html("");
	$.ajax({
		type : "POST",
		url : url+"/videoServer/front/UserTest/queryUserTestEvaluatetypeName",
		contentType : 'application/json; charset=UTF-8',
		//data: JSON.stringify(param),  //传入组装的参数
		dataType : "json",
		success : function(result) {
			for(var i=0;i<result.length;i++){
				var str = result[i].test_type;
				var onemenu = '<li role="presentation"><a href="javascript:void(0)" onclick="selectdifficulty(&quot;'+str+'&quot;)">'+result[i].test_type+'</a></li>'
				$("#onemenu").append(onemenu);
			}
			
		}
	});
}
//生成难度选择
function selectdifficulty(test_type){
	$("#twomenu").html("");
	var data ={
		test_type:test_type	
	}
	$.ajax({
		type : "POST",
		url : url+"/videoServer/front/UserTest/queryUserTestEvaluateTestGrade",
		contentType : 'application/json; charset=UTF-8',
		data: JSON.stringify(data),  //传入组装的参数
		dataType : "json",
		success : function(result) {
			var twomenu = '<div class="form-group">'
						+'<label for="name" >选择难度</label>'
						+'<select class="form-control" onchange="changedifficulty(&quot;'+test_type+'&quot;)" id="changedifficulty">'
						+'<option value="-1">无</option>'
			for(var i=0;i<result.length;i++){
				twomenu=twomenu+'<option value="'+result[i].test_grade+'">'+result[i].test_grade+'</option>'
			}
			twomenu=twomenu+'</select></div><hr><div id="user_test"></div>';
			$("#twomenu").html(twomenu);
			
		}
	});
}
//随机抽题
function changedifficulty(test_type){
	if($("#changedifficulty").val()==-1){
		return;
	}
	$("#user_test").html("");
	var data ={
			test_grade:$("#changedifficulty").val(),
			test_type:test_type
		}
	var arr =[];
	$.ajax({
		type : "POST",
		url : url+"/videoServer/front/UserTest/queryRandomUserTestAnswer",
		contentType : 'application/json; charset=UTF-8',
		data: JSON.stringify(data),  //传入组装的参数
		dataType : "json",
		success : function(result) {
			//console.log(result);
			for(var i=0;i<result.length;i++){
				arr[i] = result[i].test_answer;
				var user_test = '<div class="col-md-12"><p style="color:red;">'+(i+1)+'.'+result[i].test_subject+'</p>';
				for(var s=0;s<result[i].user_test_answer.length;s++){
					user_test=user_test+'<p><input type="checkbox" value="'+result[i].user_test_answer[s].test_answer+'" name="answer'+i+'">'+result[i].user_test_answer[s].test_answer+'.'+result[i].user_test_answer[s].answer_content+'</p>';
				}
				user_test=user_test+'<hr></div>';
				$("#user_test").append(user_test);
			}
			data.arr = arr;
			$("#user_test").append('<button class="btn btn-primary" onclick="pushanswer('+JSON.stringify(data).replace(/"/g, '&quot;')+')">提交</button>');
			
		}
	});
		
}
//提交答案
function pushanswer(data){
	
	var flog = 0;
	var index = -1;
	for(var i=0;i<data.arr.length;i++){
		if(!$("input:checkbox[name='answer"+i+"']:checked").length > 0){
			index=1;
		}
		var str = "";
		$("input:checkbox[name='answer"+i+"']:checked").each(function() { // 遍历name=test的多选框
			 str =str+ $(this).val()+",";  // 每一个被选中项的值
		});
		str = str.substring(0,str.length-1);
		if(data.arr[i]==str){
			flog++;
		}
	}
	if(index==1){
		alert("请填写所有测试题后再提交!");
		return;
	}
	data.number = flog;
	data.user_id = $.cookie("id");
	$.ajax({
		type : "POST",
		url : url+"/videoServer/front/UserTest/queryAnswerEvaluate",
		contentType : 'application/json; charset=UTF-8',
		data: JSON.stringify(data),  //传入组装的参数
		dataType : "json",
		success : function(result) {
			
			$('#myModal').modal({
				show:true
			});
			if(result==""||result==null){
				$("#modelbody").html("暂无评价信息!");
				return;
			}
			$("#modelbody").html(result.evaluate_content)
		}
	});
}
function tiaozhuan(){
	window.location.href='index.html';
}
