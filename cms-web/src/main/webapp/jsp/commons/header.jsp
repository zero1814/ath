<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
		<script src="assets/plugins/jquery/3.2.1/jquery-3.2.1.min.js"></script>
		<script src="assets/plugins/jquery/plugins/validate/jquery.validate.min.js"></script>
		<script src="assets/plugins/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script src="assets/plugins/bootstrap/plugins/bootstrap-table/bootstrap-table.js"></script>
		<script src="assets/plugins/bootstrap/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
		<script src="assets/plugins/layer/3.1.0/layer.js"></script>
		<script src="assets/commons/js/usepublic.js"></script>
	</head>

	<body class="gray-bg">
