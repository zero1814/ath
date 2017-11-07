<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/commons/header.jsp" %>
<div class="wrapper wrapper-content">
	<div class="row">
		<div class="col-sm-12">
			<form class="form-horizontal m-t" id="add">
				<div class="form-group">
					<label class="col-sm-3 control-label">用户名：</label>
					<div class="col-sm-8">
						<input id="userName" name="userName" class="form-control" type="text">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">密码：</label>
					<div class="col-sm-8">
						<input id="password" name="password" class="form-control" type="text">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">真实姓名：</label>
					<div class="col-sm-8">
						<input id="realName" name="realName" class="form-control" type="text">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">头像：</label>
					<div class="col-sm-8">
						<input id="realName" name="realName" class="form-control" type="text">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">手机号：</label>
					<div class="col-sm-8">
						<input id="phone" name="phone" class="form-control" type="text">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">邮箱地址：</label>
					<div class="col-sm-8">
						<input id="eMail" name="eMail" class="form-control" type="text">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">qq：</label>
					<div class="col-sm-8">
						<input id="qq" name="qq" class="form-control" type="text">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">微信：</label>
					<div class="col-sm-8">
						<input id="weChat" name="weChat" class="form-control" type="text">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">父级菜单：</label>
					<div class="col-sm-8">
						<select id="status" name="status" class="form-control">
							<option value="">--请选择--</option>
							<option value="0">可用</option>
							<option value="1">不可用</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12" style="text-align: center;">
						<a href="javascript:User.add();" class="btn btn-info">提交</a>
						<a href="system/user/index.htm" class="btn btn-default">取消</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript" src="assets/module/system/user.js"></script>
<%@ include file="/jsp/commons/footer.jsp" %>