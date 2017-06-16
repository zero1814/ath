<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../../common/header.jsp" %>
<div  class="wrapper wrapper-content animated fadeInRight">
	<div class="row" style="margin:0px 5px 0px 5px">
		<form id="editFrm" method="post" class="form-horizontal">
			<input type="hidden" name="code" id="code" value="${column.code }">
			<input type="hidden" name="tableCode" id="tableCode" value="${column.tableCode }">
			<div class="form-group">
				<label class="col-sm-4 control-label">字段名称</label>
				<div class="col-sm-4">
					<input name="field" id="field" value="${column.field}" type="text" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">标题</label>
				<div class="col-sm-4">
					<input name="title" id="title" value="${column.title}" type="text" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">格式化程序</label>
				<div class="col-sm-4">
					<textarea name="formatter" id="formatter" class="form-control" rows="3">${column.formatter}</textarea>
				</div>
			</div>
			<div style="text-align: center;" class="form-group">
				<a href="javascript:void(0)" class="btn btn-w-m btn-info" onclick="PageTableColumn.edit()">保存</a>
				<a href="PageTableColumn.closeLayer();" class="btn btn-w-m btn-default">取消</a>
			</div>
		</form>
	</div>
</div>
<script src="assets/commons/js/system/page/page.table.column.js"></script>
<%@ include file="../../../../common/footer.jsp" %>