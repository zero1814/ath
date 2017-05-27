<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/header.jsp" %>
<div  class="wrapper wrapper-content">
	<div class="row">
		<div class="ibox">
			<div class="ibox-content">
				<form id="addPermissionFrm" method="post" class="form-horizontal">
					<input type="hidden" name="menuCode" id="menuCode" value="${menuCode }">
					<div class="form-group">
						<label class="col-sm-4 control-label">名称</label>
						<div class="col-sm-4">
							<input name="name" id="name" value="" type="text" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">类型</label>
						<div class="col-sm-4">
							<select id="permissionType" name="permissionType" class="form-control m-b">
								<option value="">请选择</option>
								<c:forEach var="type" items="${types }">
									<option value="${type.code }">${type.name }</option>						
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">是否可用</label>
						<div class="col-sm-4">
							<select id="flagAble" name="flagAble" class="form-control m-b">
								<option value="0">是</option>
								<option value="1">是</option>
							</select>
						</div>
					</div>
					<div style="text-align: center;" class="form-group">
						<a href="javascript:void(0)" class="btn btn-w-m btn-info" onclick="MenuPermission.add('${menuCode}')">保存</a>
						<a href="javascript:void(0)" class="btn btn-w-m btn-default" onclick="MenuPermission.closeLayer('${menuCode}')">取消</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script src="assets/commons/js/system/menu/menu.permission.js"></script>
<%@ include file="../../../common/footer.jsp" %>