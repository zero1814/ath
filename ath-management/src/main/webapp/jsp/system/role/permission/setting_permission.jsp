<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/commons/header.jsp"%>
<link href="assets/plugins/switchery/css/switchery.min.css"
	rel="stylesheet">
<div class="row">
	<div class="col-sm-9">
		<table id="table" data-height="800" data-mobile-responsive="true">
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
<%@ include file="/jsp/commons/footer.jsp"%>
<script src="assets/plugins/switchery/js/switchery.min.js"></script>
<script src="assets/module/system/role.permission.js"></script>

<script type="text/javascript">
	var menuCodeVal = "${menuCode}";
	$(document).ready(function() {
		RolePermission.menuPermissionData();
	});
</script>