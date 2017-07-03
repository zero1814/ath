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

</head>

<body class="signin">
	<div class="wrapper wrapper-content">
		<div class="row">
			<div class="col-md-12">
				<h2>系统提示</h2>
				<hr>
				<p>您已经被系统踢出。请重新登录或者联系管理员！</p>
			</div>		
		</div>
    </div>
<script src="assets/plugins/jquery/1.12.2/jquery-1.12.2.min.js"></script>
<script src="assets/plugins/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>

</html>
