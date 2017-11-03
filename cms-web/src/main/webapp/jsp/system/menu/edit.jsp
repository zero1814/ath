<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/commons/header.jsp" %>
<div class="wrapper wrapper-content">
	<div class="row">
		<div class="col-sm-12">
			<form class="form-horizontal m-t" id="edit">
				<input type="hidden" id="code" name="code" value="${group.code }">
				<div class="form-group">
					<label class="col-sm-3 control-label">名称：</label>
					<div class="col-sm-8">
						<input value="${group.name }" id="name" name="name" class="form-control" type="text">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12" style="text-align: center;">
						<a href="javascript:MenuGroup.edit();" class="btn btn-info">提交</a>
						<a href="/system/menu/group/index.htm" class="btn btn-default">取消</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<%@ include file="/jsp/commons/footer.jsp" %>