<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/commons/header.jsp" %>
<div class="wrapper wrapper-content">
	<div class="row">
		<div class="col-sm-12">
			<form class="form-horizontal m-t" id="edit">
				<input type="hidden" id="code" name="code" value="${entity.code }">
				<div class="form-group">
					<label class="col-sm-3 control-label">名称：</label>
					<div class="col-sm-8">
						<input value="${entity.name }" id="name" name="name" class="form-control" type="text">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">英文简称：</label>
					<div class="col-sm-8">
						<input value="${entity.enName }" id="enName" name="enName" class="form-control" type="text">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">状态：</label>
					<div class="col-sm-8">
						<select id="status" name="status" class="form-control">
							<c:choose>
								<c:when test="${entity.status == 1 }">
									<option value="0">可用</option>
									<option selected="selected" value="1">不可用</option>
								</c:when>
								<c:otherwise>
									<option selected="selected" value="0">可用</option>
									<option value="1">不可用</option>								
								</c:otherwise>
							</c:choose>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12" style="text-align: center;">
						<a href="javascript:Role.edit();" class="btn btn-info">提交</a>
						<a href="javascript:Role.closeLayer()" class="btn btn-default">取消</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript" src="assets/module/system/role.js"></script>
<%@ include file="/jsp/commons/footer.jsp" %>