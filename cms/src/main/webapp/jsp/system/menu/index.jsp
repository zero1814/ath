<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../common/header.jsp" %>
<div style="padding-top:20px;" class="row wrapper border-bottom white-bg page-heading">
	<div class="col-sm-4">
		<ol class="breadcrumb">
			<li>
				系统相关
			</li>
			<li>
				菜单管理
			</li>
			<li>
				<strong>菜单管理</strong>
			</li>
		</ol>
	</div>
</div>
<div class="wrapper wrapper-content">
	<div class="row">
		<div class="col-sm-5">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>菜单列表</h5>
				</div>
				<div class="ibox-content">
					<div id="treeview"></div>
				</div>
			</div>
		</div>
		<div class="col-sm-5">
			<div class="ibox float-e-margins">
				<div class="ibox-title"></div>
				<div class="ibox-content" style="height: 800px;">
					<iframe id="m_iframe" width="100%" height="100%" src="" frameborder="0" seamless></iframe>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="../../common/footer.jsp" %>
<script src="assets/plugins/bootstrap/plugins/bootstrap-treeview/js/bootstrap-treeview.min.js"></script>
<script src="assets/commons/js/tree.js"></script>
<script src="assets/commons/js/system/menu/menu.js"></script>
<script>
	$(document).ready(function() {
		Menu.init('${groupCode}');
	});
</script>