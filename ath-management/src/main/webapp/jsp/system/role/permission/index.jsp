<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/commons/header.jsp"%>
<link href="assets/plugins/bootstrap/plugins/bootstrap-treeview/css/bootstrap-treeview.min.css" rel="stylesheet">
<link href="assets/plugins/switchery/css/switchery.min.css"
	rel="stylesheet">
<div class="row">
	<div class="col-sm-3">
		<div class="ibox">
           <div class="ibox-content">
               <div id="menus"></div>
           </div>
		</div>
	</div>
	<div class="col-sm-8">
		<div class="ibox">
			<div class="ibox-title">
				<h5>菜单权限列表</h5>
            </div>
			<div class="ibox-content">
				<input type="hidden" name="menuCode" id="menuCode" value="${menuCode }"/>
				<table id="table" data-height="500" data-mobile-responsive="true">
					<thead>
						<tr>
							<th data-field="code">编码</th>
							<th data-field="menuName">菜单名称</th>
							<th data-field="menuPermission">权限名称</th>
							<th data-field="menuPermissionSetting">权限设置</th>
						</tr>
					</thead>
				</table>
           	</div>
		</div>		
	</div>
</div>
<%@ include file="/jsp/commons/footer.jsp"%>
<script src="assets/plugins/bootstrap/plugins/bootstrap-treeview/js/bootstrap-treeview.min.js"></script>
<script src="assets/plugins/switchery/js/switchery.min.js"></script>
<script src="assets/module/system/role.permission.js"></script>
<script>
$(document).ready(function() {
	RolePermission.initMenus();
	RolePermission.menuPermissionData();
});
</script>