<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/header.jsp" %>
<div  class="wrapper wrapper-content animated fadeInRight">
	<div class="row" style="margin:10px;">
		<form id="editFrm" method="post" class="form-horizontal">
			<input type="hidden" name="code" id="code" value="${table.code }">
			<div class="form-group">
				<label class="col-sm-4 control-label">名称</label>
				<div class="col-sm-4">
					<input name="name" id="name" value="${table.name }" type="text" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">选择页面</label>
				<div class="col-sm-4">
					<select class="form-control m-b" name="pageCode">
						<c:forEach var="page" items="${pages }">
							<option value="${page.code }" <c:if test="${table.pageCode == page.code }">selected="selected"</c:if>>${page.name }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div style="text-align: center;" class="form-group">
				<a href="javascript:void(0)" class="btn btn-w-m btn-info" onclick="PageTable.edit()">保存</a>
				<a href="javascript:void(0)" class="btn btn-w-m btn-default" onclick="PageTable.closeLayer();">取消</a>
			</div>
		</form>
	</div>
</div>
<script src="assets/commons/js/system/page/page.table.js"></script>
<%@ include file="../../../common/footer.jsp" %>