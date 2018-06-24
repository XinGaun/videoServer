//登录操作
$("#login").click(function(event){
	 //正则表达式去除空格
	var reg = /^\s*|\s*$/g;
    var userName=$(".name").val();
    var userPwd=$(".password").val();
    var src=$(".code img").attr("src");
    //var  code=src.split('?')[1];
    var  code=$('#syscode').val();
    var url = "/videoServer/";
    //全局访问地址
	if($(".name").val().replace(reg,'')==''){
		alert("请输入用户名！")
	}else if($(".password").val().replace(reg,'')==''){
		alert("请输入密码！")
	}else{
		 $.ajax({ 
			 	type :'post',
                url :url+'teacher/teacherLogin',  
                data : { 
                    "teacher_phone" : userName,  
                    "teacher_pwd" : userPwd,
                    "code":code
                },  
                
                dataType : 'json',  
                success : function(data) { 
                	console.info(data);
                  if (data.retCode == 1) {  
                      window.location.href = url+'martix/videoInfo.html';  
                  } else {  
                	 $("#errorInfo").text(data.retMsg);
                  	//异常信息提示 
                  }  
                },  
                error : function() {  
                    alert("系统错误uuu");  
                }  
            });  
       }
});
//验证码点击更新
$("#imgcode").click(function(){
	this.src='../rand.jsp?d='+Math.random();
})




