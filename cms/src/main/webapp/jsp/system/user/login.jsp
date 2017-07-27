<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">

<head>
	<base href=<%=basePath %> />
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <title>登录</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
	<link href="assets/font/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
	<link href="assets/plugins/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet" />
	<link href="assets/plugins/bootstrap/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet" />
	<link href="assets/commons/css/animate.css" rel="stylesheet" />
	<link href="assets/commons/css/style.css" rel="stylesheet" />
	<link href="assets/commons/css/login.css" rel="stylesheet" />
	<link href="assets/plugins/layer/skin/default/layer.css" rel="stylesheet" />
    <script>
        if (window.top !== window.self) {
            window.top.location = window.location;
        }
    </script>

</head>

<body class="signin">
	<div class="signinpanel">
	    <div class="middle-box text-center loginscreen  animated fadeInDown">
	        <div>
	            <h3>欢迎使用 ATH</h3>
	            <form class="m-t" role="form" id="loginFrm">
	                <div class="form-group">
	                    <input value="admin" type="text" name="userName" class="form-control" placeholder="用户名">
	                </div>
	                <div class="form-group">
	                    <input value="888888" type="password" name="password" class="form-control" placeholder="密码">
	                </div>
	                <a id="login_sub" href="javascript:void(0)" onclick="User.login();" class="btn btn-primary block full-width m-b">登 录</a>
	                <p class="text-muted text-center"> <a href="<%=basePath %>jsp/system/user/forget_password.jsp"><small>忘记密码了？</small></a> | <a href="jsp/system/user/register.jsp">注册一个新账号</a>
	                </p>
	            </form>
	        </div>
	    </div>
    </div>
<script src="assets/plugins/jquery/1.12.2/jquery-1.12.2.min.js"></script>
<script src="assets/plugins/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="assets/commons/js/system/user/user.js" type="text/javascript"></script>
<script src="assets/plugins/layer/layer.js"></script>
<script src="assets/commons/js/usepublic.js"></script>
<script type="text/javascript">
document.onkeydown = function(e){
    if(!e) e = window.event;//火狐中是 window.event
    if((e.keyCode || e.which) == 13){
    	User.login();
    }
}
</script>
</body>

</html>
