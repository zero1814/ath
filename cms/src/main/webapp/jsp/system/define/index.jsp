<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/header.jsp"%>
<div style="padding-top: 20px;"
	class="row wrapper border-bottom white-bg page-heading">
	<div class="col-sm-4">
		<ol class="breadcrumb">
			<li>系统相关</li>
			<li>系统配置</li>
			<li><strong>参数配置</strong></li>
		</ol>
	</div>
</div>

<div class="wrapper wrapper-content">
	<div class="row">
		<div class="col-sm-5">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>参数列表</h5>
				</div>
				<div class="ibox-content">
					<div id="treeview"></div>
				</div>
			</div>
		</div>
		<div class="col-sm-5">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>详情</h5>
				</div>
				<div class="ibox-content" style="height: 800px;">
					<iframe id="P_iframe" width="100%" height="100%" src="" frameborder="0" data-id="index_v1.html" seamless></iframe>
				</div>
			</div>
		</div>
	</div>
</div>
<script src="assets/plugins/bootstrap/plugins/bootstrap-treeview/js/bootstrap-treeview.min.js"></script>
<script src="assets/commons/js/system/system/define.js"></script>
<script>
	$(document).ready(function() {
		Define.initTree();
	});
</script>
<%@ include file="../../common/footer.jsp"%>