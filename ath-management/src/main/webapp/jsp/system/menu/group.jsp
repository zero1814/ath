<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/commons/header.jsp"%>
<div class="row">
	<div class="col-sm-12">
		<div class="float-e-margins">
			<div class="hidden-xs" id="tools" role="group">
				<form id="searchFrm" class="form-horizontal" action="">
					<div class="form-group">
						<label class="col-sm-3 control-label">编码：</label>
						<div class="col-sm-3">
							<input id="code" name="code" class="form-control" type="text">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">名称：</label>
						<div class="col-sm-3">
							<input id="name" name="name" class="form-control" type="text">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-3"></div>
						<div class="col-sm-3" style="text-align: center;">
							<a href="javascript:void(0)" onclick="MenuGroup.search();"
								class="btn btn-primary">查询</a>
						</div>
					</div>
				</form>
				<div>
					<a onclick="MenuGroup.openLayer($('#addLayer'));" class="btn btn-info" href="javascript:void(0)">添加</a> 
					<a class="btn btn-info" href="javascript:void(0)">批量删除</a>
				</div>
			</div>
			<table id="table" data-height="400" data-mobile-responsive="true">
			</table>
		</div>
	</div>
</div>
<div id="addLayer" class="ibox col-sm-10" style="margin: 40px;display: none;">
	<div class="ibox-content">
		<form id="addFrm" class="form-horizontal" action="">
			<div class="form-group">
				<label class="col-sm-3 control-label">名称：</label>
				<div class="col-sm-6">
					<input id="addName" name="addName" type="text" class="form-control">
				</div>
				<div class="form-group">
					<div class="col-sm-12"
						style="text-align: center; margin-top: 25px;">
						<a onclick="MenuGroup.add();" class="btn btn-primary" href="javascript:void(0)">保存</a> 
						<a onclick="MenuGroup.closeLayer();" class="btn btn-default" href="javascript:void(0)">取消</a>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
<div id="editLayer" class="ibox col-sm-10" style="margin: 40px;display: none;">
	<div class="ibox-content">
		<form id="editFrm" class="form-horizontal" action="">
			<input type="hidden" name="editCode" id="editCode" value="">
			<div class="form-group">
				<label class="col-sm-3 control-label">名称：</label>
				<div class="col-sm-6">
					<input id="editName" name="editName" type="text" class="form-control" value="">
				</div>
				<div class="form-group">
					<div class="col-sm-12"
						style="text-align: center; margin-top: 25px;">
						<a onclick="MenuGroup.edit();" class="btn btn-primary" href="javascript:void(0)">保存</a> 
						<a onclick="MenuGroup.closeLayer();" class="btn btn-default" href="javascript:void(0)">取消</a>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
<%@ include file="/jsp/commons/footer.jsp"%>
<script src="assets/module/system/menu/menu.group.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		MenuGroup.data();
	});
</script>
