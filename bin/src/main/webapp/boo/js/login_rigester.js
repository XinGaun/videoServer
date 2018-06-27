/**
 * http://usejsdoc.org/
 */

	//var url="http:127.0.0.1:8080/";
	var url="";
	var code="";
	//获取验证码
	$('#hmac').click(function(){  
		
		var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
		//	    获取输入框内容
		var phonenumber = $("#phone").val();
		var phoneflag=1;//标记手机号是正确的
		//alert(phonenumber);
		if (!myreg.test(phonenumber)){
			$("#phone").attr('placeholder','请输入正确的手机号');
			$("#phone").css('color','red'); 
			$("#phone").focus(function(){
				$("#phone").css('color','black');
			});
			return phoneflag=0; 
		}
	         var codeflag = 60;//点击时间间隔60s
	         
	        if(phoneflag == 1&&codeflag==60){  
	            var timeflag = setInterval(function(){  
	                codeflag--;  
	
	                if(codeflag>0){ 
	                	
	                    $('#hmac').val('重新发送'+codeflag+'s');  
	                    $('#hmac').css({'color':'#99897A'});  
	                    $('#hmac').attr('disabled','disabled');  
	                }else{  
	                    codeflag=60;  
	                    $('#hmac').val('获取验证码');  
	                    $('#hmac').css({'color':'black'});  
	                    $('#hmac').removeAttr('disabled');  
	                    clearInterval(timeflag);  
	            	}  
	        	},1000);  
	            
	            	//随机生成六位验证码
		            //var code="";
		        	for(var i=0;i<6;i++){
		        		  code+=Math.floor(Math.random()*10);
		        	}
		        	alert(code);
	           
	          
	           var str={
	        	   	phone:phonenumber,
	        		code:code,//随机验证码
	        		TemplateCode:"SMS_135036257"//模板信息
	           }
	           //alert("str"+str);
		        $.ajax({
		        	type:"POST",
		        	url:url+"/videoServer/front/User/queryuser",
		        	data:{
		        		user_phone:phonenumber,	
		        	},		        	
		        	dataType:"json",
		        	success:function(data){
		        		
		        		if(data.length==1){
		        			alert("该号码已注册，请直接登录");
		        		}else{
		        			$.ajax({
		        	        	type:"POST",
		        	        	url:url+"/videoServer/front/AliBigFish/verificationCode",
		        	        	contentType:'application/json;charset=UTF-8',
		        	        	data:JSON.stringify(str),     	
		        	        	//data:str,
		        	        	dataType:"json",
		        	        	success:function(data){
		        	        		//alert("验证码已发送，请注意查收！");
		        	        		
		        	        	},
		        	        	error:function(){
		        	        		
		        	        	}
		        	        });
		        		}
		        	}
		        });    
	            
	        }
	        
			
			
	})
	//注册账号
  	$("#zhuce").click(function(){
  		
  		var phone = $('#phone').val();  
  		var name = $('#name').val();
  		var pwd = $('#pwd').val();
  		var repwd = $('#repwd').val();
	    var vcode = $('#vcode').val();
	    var myreg=/^[a-zA-Z0-9]{6,21}$/;
	  	if(phone == ""  ){  
	  		$("#phone").attr('placeholder','手机号不能为空！');
			$("#phone").css('color','red'); 
			$("#phone").focus(function(){
				$("#phone").css('color','black');
			});
	        return false;  
	    }  
	    if(name == ""){
	    	 
	    	$("#name").attr('placeholder','请输入昵称');
			$("#name").css('color','red'); 
			$("#name").focus(function(){
				$("#name").css('color','black');
			});
	        return false;  
	    }
	    
	    if(pwd == ""){
	    	$("#pwd").attr('placeholder','请输入密码');
			$("#pwd").css('color','red'); 
			$("#pwd").focus(function(){
				$("#pwd").css('color','black');
			});
	        return false;  
	    }else if(!myreg.test(pwd)){
	    	$("#pwd").attr('placeholder','密码格式错误！');
			$("#pwd").css('color','red'); 
			$("#pwd").focus(function(){
				$("#pwd").css('color','black');
			});
			return false; 
	    }
	    if(repwd == ""||repwd!=pwd){
	    	$("#repwd").attr('placeholder','密码不一致！');
			$("#repwd").css('color','red'); 
			$("#repwd").focus(function(){
				$("#repwd").css('color','black');
			});
	        return false;  
	    }
	    if(vcode == ""){  
	    	  
	    	$("#vcode").attr('placeholder','请输入验证码');
			$("#vcode").css('color','red'); 
			$("#vcode").focus(function(){
				$("#vcode").css('color','black');
			});
	        return false;  
	    } 
	    if(vcode!=code){
	    	$("#vcode").attr('placeholder','验证码错误！');
			$("#vcode").css('color','red'); 
			$("#vcode").focus(function(){
				$("#vcode").css('color','black');
			});
	        return false; 
	    } 
	    
	   var UserTab={
	    		"user_phone":phone,
        		"user_name":name,
        		"user_pwd":pwd,
        		
	    } 
	   // alert(JSON.stringify(UserTab));
	    if(typeof(phone)!="undefined"&&typeof(vcode)!="undefined"&&vcode==code&&typeof(name)!="undefined"&&typeof(pwd)!="undefined"&&repwd==pwd){   
	    	$.ajax({
	        	type:"POST",
	        	url:url+"/videoServer/front/User/saveuser",
	        	data:JSON.stringify(UserTab),	
	        	contentType:'application/json;charset=UTF-8',
	        	cache:false,
	        	dataType:"json",
	        	//dataType:"text",
	        	success:function(data){
	        		window.location.href="index.html"; 
	        		//alert("注册成功！");
	        	},
	        	error:function(data){
	        		alert("注册失败！");
	        	
	        	},
	        });
	     }else{  
	         
	        return false;  
	    }  
	     
  	})
	