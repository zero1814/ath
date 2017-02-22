<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/commons/header.jsp"%>
<link href="assets/plugins/bootstrap/plugins/bootstrap-treeview/css/bootstrap-treeview.min.css" rel="stylesheet">
<div class="row">
	<div class="col-sm-4">
		<div class="ibox">
           <div class="ibox-content">
               <div id="menus"></div>
           </div>
		</div>
	</div>
	<div class="col-sm-12">
		<div id="page-wrapper" class="gray-bg">
			<div class="row J_mainContent" id="content-main">
				<iframe id="role_permission" width="100%" height="100%" src=""
					frameborder="0" data-id="" seamless></iframe>
			</div>
		</div>	
	</div>
</div>
<%@ include file="/jsp/commons/footer.jsp"%>
<script src="assets/plugins/bootstrap/plugins/bootstrap-treeview/js/bootstrap-treeview.min.js"></script>
<script type="text/javascript" src="assets/module/system/role.permission.js"></script>
<script>
$(document).ready(function() {
	RolePermission.initMenus();
});
</script>