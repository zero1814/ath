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
							<a href="javascript:void(0)" onclick="Menu.search();"
								class="btn btn-primary">查询</a>
						</div>
					</div>
				</form>
				<div>
					<a onclick="Menu.openAdd();" class="btn btn-info"
						href="javascript:void(0)">添加</a> <a class="btn btn-info"
						href="javascript:void(0)">批量删除</a>
				</div>
			</div>
			<table id="table" data-height="400" data-mobile-responsive="true">
			</table>
		</div>
	</div>
</div>
<%@ include file="/jsp/commons/footer.jsp"%>
<script src="assets/module/system/menu/menu.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		Menu.data();
	});
</script>
