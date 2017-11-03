<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/commons/header.jsp" %>
<div class="wrapper wrapper-content">
	<div class="row">
		<div class="col-sm-12">
			<form class="form-horizontal m-t">
				<input type="hidden" name="code" id="code" value="${entity.code }">
				<div class="form-group">
					<label class="col-sm-3 control-label">名称：</label>
					<div class="col-sm-8">
						<span>${entity.name }</span>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">url地址：</label>
					<div class="col-sm-8">
						<span>${entity.url }</span>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">参数：</label>
					<div class="col-sm-8">
						<span>${entity.param }</span>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">是否可用：</label>
					<div class="col-sm-8">
						<c:choose>
							<c:when test="${flagAble == 0 }">
								<span>可用</span>
							</c:when>
							<c:otherwise>
								<span>不可用</span>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12" style="text-align: center;">
						<a target="_self" href="system/menu/page/index.htm" class="btn btn-default">返回</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript" src="assets/module/system/page.js"></script>
<%@ include file="/jsp/commons/footer.jsp" %>