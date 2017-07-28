<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../common/header.jsp" %>
<div style="padding-top:20px;" class="row wrapper border-bottom white-bg page-heading">
	<div class="col-sm-4">
		<ol class="breadcrumb">
			<li>
				店铺相关
			</li>
			<li>
				<strong>菜单管理</strong>
			</li>
		</ol>
	</div>
</div>

<div class="wrapper wrapper-content">
	<div class="row">
		<div class="col-sm-12">
			<form method="get" class="form-horizontal">
				<div class="form-group">
					<label class="col-sm-4 control-label">店铺编码</label>
					<div class="col-sm-4">
						<input name="name" id="name" value="" type="text" class="form-control">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label">店铺名称</label>
					<div class="col-sm-4">
						<input name="name" id="name" value="" type="text" class="form-control">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label">店铺状态</label>
					<div class="col-sm-4">
						<input name="name" id="name" value="" type="text" class="form-control">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label"></label>
					<div class="col-sm-4">
						<a style="float: right;" href="javascript:void(0)" onclick="MenuGroup.search();" class="btn btn-w-m btn-info">查询</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="btn-group hidden-xs" role="table">
				<a href="javascript:void(0)" onclick="MenuGroup.openAdd();" class="btn btn-w-m btn-info">添加</a>
			</div>
			<table id="table" data-height="400" data-mobile-responsive="true">
			</table>
		</div>
	</div>
</div>
<script src="assets/commons/js/table.js"></script>
<script src="assets/commons/js/system/menu/menu.group.js"></script>
<script>
	$(document).ready(function() {
		MenuGroup.data();
	});
</script>
<%@ include file="../../common/footer.jsp" %>