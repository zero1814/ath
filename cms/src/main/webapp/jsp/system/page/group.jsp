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
				页面管理
			</li>
			<li>
				<strong>页面组管理</strong>
			</li>
		</ol>
	</div>
</div>

<div class="wrapper wrapper-content">
	<div class="row">
		<div class="col-sm-12">
			<form method="get" class="form-horizontal">
				<div class="form-group">
					<label class="col-sm-4 control-label">名称</label>
					<div class="col-sm-4">
						<input name="name" id="name" value="" type="text" class="form-control">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label"></label>
					<div class="col-sm-4">
						<a style="float: right;" href="javascript:void(0)" onclick="PageGroup.search();" class="btn btn-w-m btn-info">查询</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="btn-group hidden-xs" role="table">
				<a href="javascript:void(0)" onclick="PageGroup.openLayer('添加','addDiv');" class="btn btn-w-m btn-info">添加</a>
			</div>
			<table id="table" data-height="400" data-mobile-responsive="true">
			</table>
		</div>
	</div>
</div>
<div id="addDiv" class="wrapper wrapper-content" style="display: none;overflow: hidden;">
	<div class="row">
		<form method="post" class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-4 control-label">名称</label>
				<div class="col-sm-4">
					<input name="name" id="name" value="" type="text" class="form-control">
				</div>
			</div>
			<div style="text-align: center;" class="form-group">
				<a href="javascript:void(0)" class="btn btn-w-m btn-info" onclick="PageGroup.add()">保存</a>
				<a href="javascript:void(0)" class="btn btn-w-m btn-default" onclick="PageGroup.closeLayer();">取消</a>
			</div>
		</form>
	</div>
</div>
<div id="editDiv" class="wrapper wrapper-content" style="display: none;overflow: hidden;">
	<div class="row">
		<form method="post" class="form-horizontal">
			<input type="hidden" id="editCode" name="editCode" value="" />
			<div class="form-group">
				<label class="col-sm-4 control-label">名称</label>
				<div class="col-sm-4">
					<input name="editName" id="editName" value="测试" type="text" class="form-control">
				</div>
			</div>
			<div style="text-align: center;" class="form-group">
				<a href="javascript:void(0)" class="btn btn-w-m btn-info" onclick="PageGroup.edit()">保存</a>
				<a href="javascript:void(0)" class="btn btn-w-m btn-default" onclick="PageGroup.closeLayer();">取消</a>
			</div>
		</form>
	</div>
</div>
<script src="assets/commons/js/table.js"></script>
<script src="assets/commons/js/system/page/page.group.js"></script>
<script>
	$(document).ready(function() {
		PageGroup.data();
	});
</script>
<%@ include file="../../common/footer.jsp" %>