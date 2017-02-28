<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/commons/header.jsp"%>
<link href="assets/plugins/bootstrap/plugins/bootstrap-treeview/css/bootstrap-treeview.min.css" rel="stylesheet">
<div class="row">
	<div class="col-sm-3">
		<div class="ibox">
           <div class="ibox-content">
               <div id="menus"></div>
           </div>
		</div>
	</div>
	<div class="col-sm-8">
		<form class="form-horizontal m-t" id="addFrm">
			<input type="hidden" id="roleCode" name="roleCode" value="${roleCode }">
			<input type="hidden" name="menuCode" id="menuCode" value="${menuCode }"/>
			<div class="ibox">
				<div class="ibox-title">
					<h5>菜单权限列表</h5>
	            </div>
				<div class="ibox-content">
					<table id="table" data-height="500" data-mobile-responsive="true">
						<thead>
							<tr>
								<th data-field="name">名称</th>
								<th data-field="permissionName">权限类型</th>
								<th data-field="setting">权限设置</th>
							</tr>
						</thead>
					</table>
	           	</div>
			</div>
		</form>
	</div>
</div>
<%@ include file="/jsp/commons/footer.jsp"%>
<script src="assets/plugins/bootstrap/plugins/bootstrap-treeview/js/bootstrap-treeview.min.js"></script>
<script src="assets/module/system/role.permission.js"></script>
<script>
$(document).ready(function() {
	RolePermission.initMenus();
	RolePermission.menuPermissionData();
});
</script>