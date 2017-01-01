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
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="assets/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">
<link href="assets/font/font-awesome/4.7.0/css/font-awesome.css"
	rel="stylesheet">
<link href="assets/commons/css/animate.css" rel="stylesheet">
<link href="assets/commons/css/style.css?v=1.0.0" rel="stylesheet">
<link href="assets/bootstrap/plugins/fileinput/css/fileinput.css"
	media="all" rel="stylesheet" type="text/css" />
<script src="assets/jquery/3.1.1/jquery-3.1.1.min.js"></script>
<script src="assets/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="assets/bootstrap/plugins/fileinput/js/fileinput.js"></script>
<script
	src="assets/bootstrap/plugins/fileinput/js/fileinput_locale_zh.js"></script>
<script src="assets/commons/js/file_upload.js"></script>
</head>
<body class="gray-bg">
	<div class="kv-main wrapper wrapper-content">