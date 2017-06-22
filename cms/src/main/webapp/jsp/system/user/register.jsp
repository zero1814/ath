<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../common/header.jsp" %>
<div  class="wrapper wrapper-content animated fadeInRight">
	<div class="row">
		<form id="addFrm" method="post" class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-4 control-label">名称</label>
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
			<div style="text-align: center;" class="form-group">
				<a href="javascript:void(0)" class="btn btn-w-m btn-info" onclick="Menu.add('${groupCode}')">注册</a>
				<a href="index.htm" class="btn btn-w-m btn-default">取消</a>
			</div>
		</form>
	</div>
</div>
<script src="assets/commons/js/system/user.js"></script>
<%@ include file="../../common/footer.jsp" %>