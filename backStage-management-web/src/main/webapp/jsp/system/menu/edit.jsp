<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/commons/header.jsp"%>
<div class="row">
	<div class="ibox float-e-margins">
		<div class="ibox-title">
			<h5>编辑菜单</h5>
		</div>
		<div class="ibox-content">
			<form class="form-horizontal" method="post">
				<input type="hidden" name="code" id="code" value="${menu.code }" />
				<div class="form-group">
					<label class="col-sm-3 control-label">菜单名称：</label>
					<div class="col-sm-8">
						<input id="name" name="name" type="text" value="${menu.name }"
							class="form-control">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">父级菜单：</label>
					<div class="col-sm-8">
						<select class="form-control m-b" id="parent_code"
							name="parent_code">
							<option value="">请选择</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">所属菜单组：</label>
					<div class="col-sm-8">
						<select class="form-control m-b" id="group_code" name="group_code">
							<option value="">请选择</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">链接地址：</label>
					<div class="col-sm-8">
						<input id="url" name="url" type="text" class="form-control">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">是否可用：</label>
					<div class="col-sm-8">
						<select class="form-control m-b" id="group_code" name="group_code">
							<option value="0">可用</option>
							<option value="1">不可用</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-3"></div>
					<div class="col-sm-8" style="text-align: center;">
						<a class="btn btn-primary">保存</a> <a class="btn btn-white">取消</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<%@ include file="/jsp/commons/footer.jsp"%>
