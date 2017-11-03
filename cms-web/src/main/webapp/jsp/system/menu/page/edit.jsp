<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/commons/header.jsp" %>
<div class="wrapper wrapper-content">
	<div class="row">
		<div class="col-sm-12">
			<form class="form-horizontal m-t" id="edit">
				<input type="hidden" name="code" id="code" value="${entity.code }">
				<div class="form-group">
					<label class="col-sm-3 control-label">名称：</label>
					<div class="col-sm-8">
						<input value="${entity.name }" id="name" name="name" class="form-control" type="text">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">url地址：</label>
					<div class="col-sm-8">
						<input value="${entity.url }" id="url" name="url" class="form-control" type="text">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">参数：</label>
					<div class="col-sm-8">
						<input value="${entity.param }" id="param" name="param" class="form-control" type="text">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">是否可用：</label>
					<div class="col-sm-8">
						<select id="flagAble" name="flagAble" class="form-control">
							<option value="">--请选择--</option>
							<c:choose>
								<c:when test="${entity.flagAble == 0 }">
									<option selected="selected" value="0">可用</option>
									<option value="1">不可用</option>
								</c:when>
								<c:otherwise>
									<option value="0">可用</option>
									<option selected="selected" value="1">不可用</option>								
								</c:otherwise>
							</c:choose>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12" style="text-align: center;">
						<a href="javascript:Page.edit();" class="btn btn-info">提交</a>
						<a href="system/menu/page/index.htm" class="btn btn-default">取消</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript" src="assets/module/system/page.js"></script>
<%@ include file="/jsp/commons/footer.jsp" %>