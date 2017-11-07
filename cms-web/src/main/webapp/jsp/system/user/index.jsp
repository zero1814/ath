<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/commons/header.jsp" %>
<div class="wrapper wrapper-content">
	<div class="row">
		<div class="col-sm-12">
			<form method="get" class="form-horizontal">
				<div class="form-group">
					<label class="col-sm-4 control-label">用户名</label>
					<div class="col-sm-4">
						<input name="userName" id="userName" value="" type="text" class="form-control">
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
					<label class="col-sm-4 control-label"></label>
					<div class="col-sm-4">
						<a style="float: right;" href="javascript:void(0)" onclick="User.search();" class="btn btn-w-m btn-info">查询</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="btn-group hidden-xs" role="table">
				<a href="system/user/addindex.htm" class="btn btn-w-m btn-info">添加</a>
			</div>
			<table id="table" data-height="400" data-mobile-responsive="true">
			</table>
		</div>
	</div>
</div>
<script type="text/javascript" src="assets/commons/js/table.js"></script>
<script type="text/javascript" src="assets/module/system/user.js"></script>
<script type="text/javascript">
$(function(){
	User.init();
})
</script>
<%@ include file="/jsp/commons/footer.jsp" %>