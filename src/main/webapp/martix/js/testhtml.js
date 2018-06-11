$(function(){
	initTestTable(param);
});
//var url ="http://localhost:8080/"
var url="";
var pages = 0;//当前页数
var nums = 10;//每页几条
var total = 0;//总条数 	

//组装参数
var param = {
		page : nums,
		nums : (pages*nums),
		test_id : $("#test_id").val(),
		test_subject : $("#test_subject").val(),
		test_grade : $("#test_grade").val()
}

function queryparameterUserTest(){
	param.test_id = $("#test_id").val();
	param.test_subject = $("#test_subject").val(),
	param.test_grade = $("#test_grade").val()
	initTestTable(param);
}

//删除题目信息
function deleteUserTest(test_id){
	if (!window.confirm("确认删除吗?")) {

		return;
	} else {
		var data ={
				test_id:test_id	
		}
		$.ajax({
			type : "POST",
			url : url
			+ "/videoServer/UserTest/deteleUserTest",
			contentType : 'application/json; charset=UTF-8',
			data : JSON.stringify(data), //传入组装的参数
			dataType : "json",
			success : function(result) {
				if(result=="success"){
					alert("删除成功!");
					initTestTable(param);
				}else{
					alert("删除失败!");
				}
			}
		});
	}
}


//清空添加表单
function cleartest(){
	$("#topictest").val("");
	$("#answerA").val("");
	$("#answerB").val("");
	$("#answerC").val("");
	$("#answerD").val("");
	$("#difficultytest").val("");
	$("#test_type").val("");
}

//修改详情信息
function testupdate(){
	var test_answer =[]; 
	$('input[name="answerupdate"]:checked').each(function(){ 
		test_answer.push($(this).val()); 
	}); 
	var str = "";
	for(var i=0;i<test_answer.length;i++){
		str=str+","+test_answer[i]
	}
	str = str.substring(1,str.length);
	if(str==""||$("#type_calss").val()==""||$("#answerAupdate").val()==""||$("#answerBupdate").val()==""||$("#answerCupdate").val()==""||$("#answerDupdate").val()==""||$("#topictestupdate").val()==""||$("#difficultytestupdate").val()==""){
		alert("所有选项必填不能为空!");
		return;
	}
	var arr = [];
	var answerA = {
			answer_content:$("#answerAupdate").val(),
			test_answer:"A"
	}
	var answerB = {
			answer_content:$("#answerBupdate").val(),
			test_answer:"B"
	}
	var answerC = {
			answer_content:$("#answerCupdate").val(),
			test_answer:"C"
	}
	var answerD = {
			answer_content:$("#answerDupdate").val(),
			test_answer:"D"
	}
	arr[0]=answerA;
	arr[1]=answerB;
	arr[2]=answerC;
	arr[3]=answerD;
	var data = {
			test_subject : $("#topictestupdate").val(),
			test_grade : $("#difficultytestupdate").val(),
			test_id : $("#testupdate_id").val(),
			user_test_answer : arr,
			test_answer : str,
			test_type:$("#type_calss").val()
	}
	$.ajax({
		type : "POST",
		url : url
		+ "/videoServer/UserTest/updateUserTest",
		contentType : 'application/json; charset=UTF-8',
		data : JSON.stringify(data), //传入组装的参数
		dataType : "json",
		success : function(result) {
			if(result=="success"){
				alert("修改成功!");
				initTestTable(param);
				$('#modal2').modal('hide')
			}else{
				alert("修改失败!");
			}
		}
	});
}

//查询详情信息
function particulars(map){

	var data ={
			test_id:map.test_id
	}
	//alert(map);
	$.ajax({
		type : "POST",
		url : url
		+ "/videoServer/UserTest/queryUserTestAnswer",
		contentType : 'application/json; charset=UTF-8',
		data : JSON.stringify(data), //传入组装的参数
		dataType : "json",
		success : function(result) {
			//console.log(result);
			$("#topictestupdate").val(map.test_subject);
			$("#type_calss").val(map.test_type);
			$("#answerAupdate").val(result[0].answer_content);
			$("#answerBupdate").val(result[1].answer_content);
			$("#answerCupdate").val(result[2].answer_content);
			$("#answerDupdate").val(result[3].answer_content);
			$("#difficultytestupdate").val(map.test_grade);
			$("#testupdate_id").val(map.test_id);
			var arrs = map.test_answer.split(",");
			for(var i=0;i<arrs.length;i++){
				$("input:checkbox[name='answerupdate'][value='"+arrs[i]+"']").attr('checked','true');
			}
			
		}
	});
}
//清空详情内容
function emptytest(){
	$("#topictestupdate").val("");
	$("#answerAupdate").val("");
	$("#answerBupdate").val("");
	$("#answerCupdate").val("");
	$("#answerDupdate").val("");
	$("#difficultytestupdate").val("");
	$("#type_calss").val("");
}

//添加题目信息
function pushclear(){
	var test_answer =[]; 
	$('input[name="answer"]:checked').each(function(){ 
		test_answer.push($(this).val()); 
	}); 
	var str = "";
	for(var i=0;i<test_answer.length;i++){
		str=str+","+test_answer[i]
	}
	str = str.substring(1,str.length);
	if($("#test_type").val()==""||test_answer.length==0||$("#answerA").val()==""||$("#answerB").val()==""||$("#answerC").val()==""||$("#answerD").val()==""||$("#topictest").val()==""||$("#difficultytest").val()==""){
		alert("所有选项必填不能为空!");
		return;
	}

	var arr = [];
	var answerA = {
			answer_content:$("#answerA").val(),
			test_answer:"A"
	}
	var answerB = {
			answer_content:$("#answerB").val(),
			test_answer:"B"
	}
	var answerC = {
			answer_content:$("#answerC").val(),
			test_answer:"C"
	}
	var answerD = {
			answer_content:$("#answerD").val(),
			test_answer:"D"
	}
	arr[0]=answerA;
	arr[1]=answerB;
	arr[2]=answerC;
	arr[3]=answerD;
	
	var data = {
			test_subject:$("#topictest").val(),
			test_answer:str,
			test_grade:$("#difficultytest").val(),
			user_test_answer:arr,
			test_type:$("#test_type").val()
	}
	//console.log(data);
	$.ajax({
		type : "POST",
		url : url
		+ "/videoServer/UserTest/addUserTest",
		contentType : 'application/json; charset=UTF-8',
		data : JSON.stringify(data), //传入组装的参数
		dataType : "json",
		success : function(result) {
			if(result=="success"){
				alert("添加成功!")
				initTestTable(param);
				$('#modal1').modal('hide')
			}else{
				alert("添加失败!")
			}
		}
	});
}


//初始化表格信息 
function initTestTable(param){
	$("#TestTable").html("");
	$.ajax({
		type : "POST",
		url : url
		+ "/videoServer/UserTest/queryUserTest",
		contentType : 'application/json; charset=UTF-8',
		data : JSON.stringify(param), //传入组装的参数
		dataType : "json",
		success : function(result) {
			console.log(result);
			if(result.list.length==0){
				$("#TestTable").html("暂无题目信息");
			}else{
				
				for(var i=0;i<result.list.length;i++){
					var TestTable = '<tr><td>'+result.list[i].test_id+'</td>'
					+'<td style="white-space: nowrap;overflow:hidden;text-overflow:ellipsis;"  title="'+result.list[i].test_subject+'">'+result.list[i].test_subject+'</td>'
					+'<td>'+result.list[i].test_answer+'</td>'
					+'<td>'+result.list[i].test_grade+'</td>'
					+'<td>'+result.list[i].test_type+'</td>'
					+'<td><button class="btn btn-info" data-toggle="modal" data-target=".bs-example-modal-lg2" onclick="particulars('+JSON.stringify(result.list[i]).replace(/"/g, '&quot;')+')">查看详情</button>&nbsp;&nbsp;<button class="btn btn-danger" onclick="deleteUserTest('+result.list[i].test_id+')">删除题目</button></td></tr>'
					$("#TestTable").append(TestTable);
				}
				total=result.total;
				page(pages, nums, result.total);
			}
		}

	});
}
//分页
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
	param.nums=pages*nums;	
	$("#TestTable").html("");
	//console.log(pages+1);
	initTestTable(param);
	return false;
}
//上页
function shangye(){
	pages--;
	param.nums=pages*nums;
	$("#TestTable").html("");
	//console.log(pages);
	initTestTable(param);
	return false;
}
//页数换页
function custom(number){
	pages=number-1;
	param.nums=(pages)*nums;
	$("#TestTable").html("");
	initTestTable(param);
	//console.log(pages);
	return false;
}