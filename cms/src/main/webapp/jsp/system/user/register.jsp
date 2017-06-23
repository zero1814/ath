<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">

<head>
<base href=<%=basePath%> />
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<title>注册</title>
<meta name="keywords" content="">
<meta name="description" content="">
<link href="assets/font/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
<link href="assets/plugins/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet" />
<link href="assets/plugins/bootstrap/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet" />
<link href="assets/commons/css/animate.css" rel="stylesheet" />
<link href="assets/commons/css/style.css" rel="stylesheet" />
<link href="assets/commons/css/register.css" rel="stylesheet" />
<link href="assets/plugins/layer/skin/default/layer.css" rel="stylesheet" />
</head>
<body class="gray-bg">
	<div class=" wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<form id="addFrm" method="post" class="form-horizontal">
				<div class="form-group">
					<label class="col-sm-4 control-label">用户名</label>
					<div class="col-sm-4">
						<input name="userName" id="userName" value="" type="text" class="form-control">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label">密码</label>
					<div class="col-sm-4">
						<input name="password" id="password" value="" type="text" class="form-control">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label">重复密码</label>
					<div class="col-sm-4">
						<input name="r_password" id="r_password" value="" type="text" class="form-control">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label">真实姓名</label>
					<div class="col-sm-4">
						<input name="realName" id="realName" value="" type="text" class="form-control">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label">手机号</label>
					<div class="col-sm-4">
						<input name="phone" id="phone" value="" type="text" class="form-control">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label">电子邮箱</label>
					<div class="col-sm-4">
						<input name="eMail" id="eMail" value="" type="text" class="form-control">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label">qq号</label>
					<div class="col-sm-4">
						<input name="qq" id="qq" value="" type="text" class="form-control">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label">微信号</label>
					<div class="col-sm-4">
						<input name="weChat" id="weChat" value="" type="text" class="form-control">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label">头像</label>
					<div class="col-sm-4">
						<input name="headPic" id="headPic" value="" type="hidden" class="form-control">
						<input name="upload" id="upload" value="" type="file" class="file-loading">
					</div>
				</div>
				<div style="text-align: center;" class="form-group">
					<a href="javascript:void(0)" class="btn btn-w-m btn-info" onclick="Menu.add('${groupCode}')">注册</a>
					<a href="<%=basePath %>jsp/system/user/login.jsp" class="btn btn-w-m btn-default">取消</a>
				</div>
			</form>
		</div>
	</div>
	<script src="assets/plugins/jquery/1.12.2/jquery-1.12.2.min.js"></script>
	<script src="assets/plugins/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="assets/commons/js/system/user.js"></script>
	<script src="assets/commons/js/upload.js"></script>
	<script>
	$(document).on('ready', function() {
		Upload.init({id:"upload"});
	});
	</script>
</body>