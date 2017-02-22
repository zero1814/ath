<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/commons/header.jsp"%>
<link href="assets/plugins/switchery/css/switchery.min.css" rel="stylesheet">
<div class="row">
	<div class="col-sm-12">
		<div class="float-e-margins">
			<div class="hidden-xs" id="tools" role="group">
				<form id="searchFrm" class="form-horizontal" action="">
					<div class="form-group">
						<label class="col-sm-3 control-label">菜单名称：</label>
						<div class="col-sm-3">
							<input id="menuName" name="menuName" class="form-control"
								type="text">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-3"></div>
						<div class="col-sm-3" style="text-align: center;">
							<a href="javascript:void(0)" onclick="RolePermission.search();"
								class="btn btn-primary">查询</a>
						</div>
					</div>
				</form>
			</div>
			<table id="table" data-height="400" data-mobile-responsive="true">
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
<%@ include file="/jsp/commons/footer.jsp"%>
<script src="assets/plugins/switchery/js/switchery.min.js"></script>
<script src="assets/module/system/role.permission.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		RolePermission.menuPermissionData('${menuCode}');
	});
</script>