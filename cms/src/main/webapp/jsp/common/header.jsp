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
		<link href="assets/plugins/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet" />
		<link href="assets/plugins/bootstrap/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet" />
		<link href="assets/commons/css/animate.css" rel="stylesheet" />
		<link href="assets/commons/css/style.css" rel="stylesheet" />
		<script src="assets/plugins/jquery/1.12.2/jquery-1.12.2.min.js"></script>
		<script src="assets/plugins/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<script src="assets/plugins/bootstrap/plugins/bootstrap-table/bootstrap-table.min.js"></script>
		<script src="assets/plugins/bootstrap/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
		<script src="assets/plugins/layer/layer.js"></script>
		<script src="assets/commons/js/usepublic.js"></script>
	</head>

	<body class="gray-bg">
