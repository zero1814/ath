<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>- 500错误</title>
<meta name="keywords" content="">
<meta name="description" content="">
<link rel="shortcut icon" href="favicon.ico">
<link href="assets/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">
<link href="assets/font/font-awesome/4.7.0/css/font-awesome.css"
	rel="stylesheet">
<link href="assets/commons/css/animate.css" rel="stylesheet">
<link href="assets/commons/css/style.css?v=1.0.0" rel="stylesheet">
</head>
<body class="gray-bg">
	<div class="middle-box text-center animated fadeInDown">
		<h1>500</h1>
		<h3 class="font-bold">服务器内部错误</h3>

		<div class="error-desc">
			服务器好像出错了... <br />您可以返回主页看看 <br /> <a href="index.htm"
				class="btn btn-primary m-t">主页</a>
		</div>
	</div>
</body>
</html>
