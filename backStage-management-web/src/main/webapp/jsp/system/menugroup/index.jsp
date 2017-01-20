<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/commons/header.jsp"%>
<div class="row">
	<div class="col-sm-12">
		<div class="float-e-margins">
			<div class=" hidden-xs" id="tools" role="group">
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
						<a href="javascript:void(0)" onclick="MenuGroup.search();" class="btn btn-primary">查询</a>
					</div>
				</div>
				</form>
			</div>
			<table id="table" data-height="400" data-mobile-responsive="true">
				<thead>
					<tr>
						<th data-field="state" data-checkbox="true"></th>
						<th data-field="code">编码</th>
						<th data-field="name">名称</th>
						<th data-field="create_user">创建人</th>
						<th data-field="create_time">创建时间</th>
						<th data-field="update_user">修改人</th>
						<th data-field="update_time">修改时间</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</div>
<%@ include file="/jsp/commons/footer.jsp"%>
<script src="assets/commons/js/table.js"></script>
<script src="assets/module/system/menugroup.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		MenuGroup.data();
	});
</script>
