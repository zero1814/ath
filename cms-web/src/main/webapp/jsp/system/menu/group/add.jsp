<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/commons/header.jsp" %>
<div class="wrapper wrapper-content">
	<div class="row">
		<div class="col-sm-12">
			<form class="form-horizontal m-t" id="add">
				<div class="form-group">
					<label class="col-sm-3 control-label">名称：</label>
					<div class="col-sm-8">
						<input id="name" name="name" class="form-control" type="text">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12" style="text-align: center;">
						<a href="javascript:MenuGroup.add();" class="btn btn-info">提交</a>
						<a href="javascript:MenuGroup.closeLayer()" class="btn btn-default">取消</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript" src="assets/module/system/menu.group.js"></script>
<%@ include file="/jsp/commons/footer.jsp" %>