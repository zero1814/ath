<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../../common/header.jsp" %>
<div  class="wrapper wrapper-content animated fadeInRight">
	<div class="row">
		<form id="editFrm" method="post" class="form-horizontal">
			<input type="hidden" name="code" id="code" value="${page.code }">
			<div class="form-group">
				<label class="col-sm-4 control-label">名称</label>
				<div class="col-sm-4">
					<input name="name" id="name" value="${page.name }" type="text" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">链接地址</label>
				<div class="col-sm-4">
					<input name="url" id="url" value="${page.url }" type="text" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">参数</label>
				<div class="col-sm-4">
					<input name="param" id="param" value="${page.param }" type="text" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">是否可用</label>
				<div class="col-sm-4">
					<select class="form-control m-b" name="flagAble">
						<option  value="0" <c:if test="${page.flagAble == 0 }">selected="selected"</c:if>>可用</option>
						<option value="1" <c:if test="${page.flagAble == 1 }">selected="selected"</c:if>>不可用</option>					
					</select>
				</div>
			</div>
			<div style="text-align: center;" class="form-group">
				<a href="javascript:void(0)" class="btn btn-w-m btn-info" onclick="Page.edit('${page.groupCode }')">保存</a>
				<a href="system/page/detail.htm?code=${parentCode }" class="btn btn-w-m btn-default">取消</a>
			</div>
		</form>
	</div>
</div>
<script src="assets/commons/js/system/page/page.js"></script>
<%@ include file="../../../../common/footer.jsp" %>