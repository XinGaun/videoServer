function denglu(){
	var uname=$('#uname').val();
	pwd=$("#pwd").val();
	if(uname == ""){	    	  
		$("#uname").attr('placeholder','请输入手机号');
		$("#uname").css('color','red'); 
		$("#uname").focus(function(){
			$("#uname").css('color','black');
		});
		return false;  
	};

	if(pwd == ""){
		$("#pwd").attr('placeholder','请输入密码');
		$("#pwd").css('color','red'); 
		$("#pwd").focus(function(){
			$("#pwd").css('color','black');
		});
		return false;  
	};

	if(typeof(uname)!="undefined"&&typeof(pwd)!="undefined"){			
		$.ajax({
			type:"POST",
			url:"User/queryuser",
			data:{
				user_phone:uname,	
			},		        	
			dataType:"json",
			success:function(data){        		
				if(data==1){	        			
					var UserTab={
							"user_phone":uname,    	        		
							"user_pwd":pwd,
					} 
					$.ajax({
						type:"POST",
						url:"User/selectuser",
						data:JSON.stringify(UserTab),	
						contentType:'application/json;charset=UTF-8',
						cache:false,
						dataType:"json",
						success:function(data){	        	        		
							if(data=="账号和密码不一致！"){
								alert(data);
							}else{
								alert("success");
								alert(data[0].user_phone);
								window.location.href="HomeVue.html";
								var expiresDate= new Date();
								expiresDate.setTime(expiresDate.getTime() + (30 * 60 * 1000)); //设置cookie30分钟后失效
								alert(expiresDate);
								$.cookie('phone',data[0].user_phone,{ expires:expiresDate,path:'/',secure: false});//cookie中存用户注册手机号
								$.cookie('photo',data[0].user_photo,{ expires:expiresDate,path:'/',secure: false});//cookie中存用户头像
							}	        	        	
						},
						error:function(){
							alert("error");
						}
					}); 
				}else{ 
					alert("该号码未注册，请先注册！");	        			
				} 
			},
			error:function(){	        		
			}
		});   
	};
	//登录页面中注册按钮后的小图标
	var rigster=new Vue({
		el:'#header',
		data:{
			rigesterUrl:'photos/LoginPhoto/rigester.png'
		}
	});
	//登录页面中的微信登录小图标
	var weixin=new Vue({
		el:'#wxChat',
		data:{
			weixin:'photos/LoginPhoto/weixin.png'
		}
	});

}
