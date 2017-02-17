<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/commons/header.jsp"%>
<div class="row">
	<div class="col-sm-12">
		<div class="ibox">
			<form class="form-horizontal m-t" id="editFrm">
				<input type="hidden" name="code" id="code" value="${menu.code }">
				<input type="hidden" name="parentCode_tmp" id="parentCode_tmp" value="${menu.parentCode }">
				<div class="form-group">
					<label class="col-sm-3 control-label">名称：</label>
					<div class="col-sm-3">
						<input id="name" name="name" class="form-control" type="text"
							value="${menu.name }">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">所属菜单组：</label>
					<div class="col-sm-3">
						<select class="form-control m-b" name="groupCode" id="groupCode"
							onchange="Menu.selParentMenus();">
							<option value="">请选择</option>
							<c:forEach items="${menuGroups }" var="group">
								<option value="${group.code }" <c:if test="${menu.groupCode == group.code }">selected="selected"</c:if>>${group.name }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">父级菜单：</label>
					<div class="col-sm-3">
						<select class="form-control m-b" name="parentCode" id="parentCode">
							<option value="">请选择</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-8" style="text-align: center;">
						<a class="btn btn-primary" onclick="Menu.edit();">保存内容</a>
						<a target="_self" href="system/menu/index.htm" class="btn btn-white">取消</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<%@ include file="/jsp/commons/footer.jsp"%>
<script src="assets/module/system/menu.js"></script>