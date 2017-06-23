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
			<form id="registerFrm" method="post" class="form-horizontal" >
				<div class="form-group">
					<label class="col-sm-4 control-label">用户名</label>
					<div class="col-sm-4">
						<input name="userName" id="userName" value="" type="text" class="form-control" required>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label">密码</label>
					<div class="col-sm-4">
						<input name="password" id="password" value="" type="password" class="form-control" required>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label">重复密码</label>
					<div class="col-sm-4">
						<input name="r_password" id="r_password" value="" type="password" class="form-control" required>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label">真实姓名</label>
					<div class="col-sm-4">
						<input name="realName" id="realName" value="" type="text" class="form-control" required>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label">手机号</label>
					<div class="col-sm-4">
						<input name="phone" id="phone" value="" type="text" class="form-control" required>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label">电子邮箱</label>
					<div class="col-sm-4">
						<input name="eMail" id="eMail" value="" type="text" class="form-control" required>
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
					<!--
						<a href="javascript:void(0)" class="btn btn-w-m btn-info" onclick="User.register();">注册</a> 
					 -->
					<button class="btn btn-primary" type="submit">提交</button>
					<a href="<%=basePath %>jsp/system/user/login.jsp" class="btn btn-w-m btn-default">取消</a>
				</div>
			</form>
		</div>
	</div>
	<script src="assets/plugins/jquery/1.12.2/jquery-1.12.2.min.js"></script>
	<script src="assets/plugins/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="assets/plugins/layer/layer.js"></script>
	<script src="assets/commons/js/upload.js"></script>
	<script src="assets/plugins/jquery/plugins/validate/jquery.validate.min.js"></script>
	<script src="assets/commons/js/system/user/user.js"></script>
	<script>
    $.validator.setDefaults({
        highlight: function (element) {
            $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
        },
        success: function (element) {
            element.closest('.form-group').removeClass('has-error').addClass('has-success');
        },
        errorElement: "span",
        errorPlacement: function (error, element) {
            if (element.is(":radio") || element.is(":checkbox")) {
                error.appendTo(element.parent().parent().parent());
            } else {
                error.appendTo(element.parent());
            }
        },
        errorClass: "help-block m-b-none",
        validClass: "help-block m-b-none"
    });
	$(document).on('ready', function() {
		$("#registerFrm").validate({
			rules : {
				userName : {
					required : true,
					minlength : 6
				},
				password : {
					required : true,
					minlength : 6
				},
				r_password : {
					required : true,
					minlength : 6,
					equalTo : "#password"
				},
				realName : {
					required : true
				},
				phone : {
					required : true,
					minlength : 11,
					maxlength : 11
				},
				eMail : {
					required : true,
					email : true
				}
			},
			messages : {
				userName : {
					required : "请输入用户名",
					minlength : "用户名不能小于6个字符"
				},
				password : {
					required : "请输入密码",
					minlength : "密码长度不能小于 6个字符"
				},
				r_password : {
					required : "请输入密码",
					minlength : "密码长度不能小于 6个字符",
					equalTo : "两次密码输入不一致"
				},
				realName : "请输入真实姓名",
				phone : {
					required : "请输入手机号",
					minlength : "请输入11位手机号",
					maxlength : "请输入11位手机号"
				},
				eMail : "请输入一个正确的邮箱"
			},
			submitHandler:function(){
				User.register();
			}
		});
		Upload.init({id:"upload",url:"upload/image.htm",backfillId:"headPic"});
	});
	</script>
</body>