<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/header.jsp" %>
<div  class="wrapper wrapper-content animated fadeInRight">
	<div class="row" style="margin:10px;">
		<form id="addFrm" method="post" class="form-horizontal">
			<input type="hidden" name="parentCode" id="parentCode" value="${parentCode }">
			<input type="hidden" name="groupCode" id="groupCode" value="${groupCode }">
			<div class="form-group">
				<label class="col-sm-4 control-label">名称</label>
				<div class="col-sm-4">
					<input name="name" id="name" value="" type="text" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">选择页面</label>
				<div class="col-sm-4">
					<select class="form-control m-b" name="pageCode">
						<c:forEach var="page" items="${pages }">
							<option value="${page.code }">${page.name }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div style="text-align: center;" class="form-group">
				<a href="javascript:void(0)" class="btn btn-w-m btn-info" onclick="Page.add('${groupCode }')">保存</a>
				<a href="system/page/detail.htm?code=${code }" class="btn btn-w-m btn-default">取消</a>
			</div>
		</form>
	</div>
</div>
<script src="assets/commons/js/system/page/page.js"></script>
<%@ include file="../../../common/footer.jsp" %>