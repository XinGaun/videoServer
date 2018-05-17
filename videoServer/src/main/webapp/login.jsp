<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>LOGIN页面</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
	<script src="http://static.runoob.com/assets/vue/1.0.11/vue.min.js"></script>
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
	#login-head{
		width:100%;
		height:6%;
		
		background:rgba(255,255,255,1);
		border:1px blue solid;
	}
	#head-style{
		margin-top:5px;
		
	}
	
	#logo{
		padding-left:20%;
		
	}
	#search{
		margin-left:24%;
		width:320px;
	}
	#loginbtn{
		margin-left:33%;
		margin-right:15px;
	}
	#login-center{
		width:100%;
		height:70%;
		border:1px red solid;
	}
	#login-bottom{
		width:100%;
		height:24%;
		border:1px yellow solid;
	}
</style>
<body>
	<!-- 头部 -->
	<div id="login-head" class="container">
	    <div class="row" id="head-style">
			<!-- logo标 -->
			<div id="logo" class="col-xs-6 col-sm-4" >
			    <a href="login.jsp">
			    	<img :src="loginUrl">
			    </a>
			</div>
			<!-- 搜索框 --> 
			<div class="col-xs-6 col-sm-4" >
				<div id="search" class="input-group input-group-sm">
				    <div class="input-group-btn">
				        <button type="button" class="btn btn-default 
				        dropdown-toggle" data-toggle="dropdown">数学
				        	<span class="caret"></span>
				        </button>
				        <ul class="dropdown-menu">
				        	<li>
				            	<a href="#">功能</a>
				            </li>
				        </ul>
				    </div><!-- /btn-group -->
				    <input type="text" class="form-control">
				    <span class="input-group-btn">
						<button class="btn btn-info" type="button">
					    	<span class="glyphicon glyphicon-search"></span>
					    </button>
				    </span>
				</div><!-- /input-group -->
			</div>
			<!-- 登录|注册 -->
			<div class="col-xs-6 col-sm-4" >
			<!-- 登录按钮触发模态框 -->
				<button id="loginbtn" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal">登录</button>
				<a href="#" data-toggle="modal" data-target="#myModal1">注册</a>
			</div>	
		</div><!-- /.row -->
	</div>
	<!-- 登录模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">模态框（Modal）标题</h4>
				</div>
				<div class="modal-body">在这里添加一些文本</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary">提交更改</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>
	<!-- 注册模态框（Modal） -->
	<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">模态框（Modal）标题</h4>
				</div>
				<div class="modal-body">在这里添加一些文本</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary">提交更改</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>
	<!-- 中间内容 -->
	<div id="login-center">
	
	</div>
	<!-- 尾部 -->
	<div id="login-bottom">
	
	</div>
</body>
<script>
	//logo图标
	var logo=new Vue({
		el:'#logo',
		data:{
			loginUrl:'photos/LoginPhoto/logo.png'
		}
	})
	
</script>
</html>
