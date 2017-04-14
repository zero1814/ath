<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath %>" />
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title> - 500 页面</title>
		<meta name="keywords" content="">
		<meta name="description" content="">
		<link href="assets/font/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
		<link href="assets/plugins/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet" />
		<link href="assets/commons/css/animate.css" rel="stylesheet" />
		<link href="assets/commons/css/style.css" rel="stylesheet" />
	</head>
	<body class="gray-bg">
		<div class="middle-box text-center animated fadeInDown">
			<h1>500</h1>
			<h3 class="font-bold">服务器内部错误</h3>
			<div class="error-desc">
				服务器好像出错了...
				<br/>您可以返回主页看看
				<br/>
				<a href="index.html" class="btn btn-primary m-t">主页</a>
			</div>
		</div>
	</body>
</html>