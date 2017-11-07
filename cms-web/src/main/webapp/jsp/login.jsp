<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<base href=<%=basePath %> />
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="keywords" content="">
		<meta name="description" content="">
		<link href="assets/font/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
		<link href="assets/plugins/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" />
		<link href="assets/plugins/bootstrap/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet" />
		<link href="assets/commons/css/animate.css" rel="stylesheet" />
		<link href="assets/commons/css/style.css" rel="stylesheet" />
		<link href="assets/commons/css/login.css" rel="stylesheet" />
	</head>
	<body class="signin">
		<div class="signinpanel">
			<div class="row">
				<div class="col-sm-12">
					<form id="loginFrm" method="post" action="">
						<h4 class="no-margins">登录：</h4>
						<input id="userName" name="userName" type="text" class="form-control uname" placeholder="用户名" />
						<input id="password" name="password" type="password" class="form-control pword m-b" placeholder="密码" />
						<input id="vertifyCode" name="vertifyCode" type="text" class="form-control" placeholder="请输入验证码" />
						<img id="verify_code" src="verification/code.htm"/>
						<a href="">忘记密码了？</a>
						<a onclick="login();" class="btn btn-success btn-block">登录</a>
					</form>
				</div>
			</div>
			<div class="signup-footer">
				<div class="pull-left">
					&copy; CMS
				</div>
			</div>
		</div>
	</body>
	<script src="assets/plugins/jquery/3.2.1/jquery-3.2.1.min.js" type="text/javascript"></script>
	<script src="assets/plugins/layer/3.1.0/layer.js"></script>
	<script src="assets/commons/js/usepublic.js"></script>
	<script type="text/javascript">
	$(function(){
		 $('#verify_code').click(function() {$(this).attr('src','/verification/code.htm?' + Math.floor(Math.random() * 100));}); 
	});
	function login(){
		var userName = $("#userName").val();
		if(userName == ""){
			layer.alert("用户名不能为空");
			return;
		}
		var password = $("#password").val();
		if(password == ""){
			layer.alert("密码不能为空");
			return;
		}
		var vertifyCode = $("#vertifyCode").val();
		if(vertifyCode == ""){
			layer.alert("验证码不能为空");
			return;
		}
		var param = $("#loginFrm").serializeArray();
		$.ajax({
			url: "user/login.htm",
			type: "POST",
			data: param,
			dataType: "json",
			success: function(result) {
				if(result.code == UsePublic.SUCCESS){
					window.location.href = "index.htm";
				}else{
					layer.alert(result.message,function(index){
						$("#verify_code").attr('src','verification/code.htm?' + Math.floor(Math.random() * 100));
						layer.close(index);
					});
				}
			},
			error: function(result) {
				alert(JSON.stringify(result));
				window.location.href = UsePublic.ERROR_URL;
			}
		});
	
	}
	</script>
</body>
</html>
