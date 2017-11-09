<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/commons/header.jsp" %>
<div class="wrapper wrapper-content">
	<input type="hidden" id="userCode" name="userCode" value="${userCode }">
	<div class="row">
		<div class="col-sm-12">
			<form method="get" class="form-horizontal">
				<div class="form-group">
					<label class="col-sm-4 control-label">用户名</label>
					<div class="col-sm-4">
						<input name="name" id="name" value="" type="text" class="form-control">
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="btn-group hidden-xs" role="table">
				<a href="system/user/role/addindex.htm?userCode=${userCode }" class="btn btn-w-m btn-info">添加</a>
			</div>
			<table id="table" data-height="400" data-mobile-responsive="true">
			</table>
		</div>
	</div>
</div>
<script type="text/javascript" src="assets/commons/js/table.js"></script>
<script type="text/javascript" src="assets/module/system/user.role.js"></script>
<script type="text/javascript">
$(function(){
	UserRole.init();
})
</script>
<%@ include file="/jsp/commons/footer.jsp" %>