<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/header.jsp" %>
<div  class="wrapper wrapper-content animated fadeInRight">
	<div class="row">
		<form id="addFrm" method="post" class="form-horizontal">
			<input type="hidden" name="menuCode" id="menuCode" value="${menuCode }">
			<div class="form-group">
				<label class="col-sm-4 control-label">名称</label>
				<div class="col-sm-4">
					<input name="name" id="name" value="" type="text" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">链接地址</label>
				<div class="col-sm-4">
					<input name="url" id="url" value="" type="text" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">类型</label>
				<div class="col-sm-4">
					<select class="form-control m-b" name="flagAble">
						<option value="">请选择</option>
						<c:forEach var="type" items="${types }">
							<option value="${type.code }">${type.name }</option>						
						</c:forEach>
					</select>
				</div>
			</div>
			<div style="text-align: center;" class="form-group">
				<a href="javascript:void(0)" class="btn btn-w-m btn-info" onclick="MenuPermission.add()">保存</a>
				<a href="system/menu/detail.htm?code=${menuCode }" class="btn btn-w-m btn-default">取消</a>
			</div>
		</form>
	</div>
</div>
<script src="assets/commons/js/system/menu/menu.permission.js"></script>
<%@ include file="../../../common/footer.jsp" %>