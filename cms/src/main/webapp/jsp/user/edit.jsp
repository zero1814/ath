<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>
<div  class="wrapper wrapper-content animated fadeInRight">
	<div class="row">
		<form id="addFrm" method="post" class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-4 control-label">名称</label>
				<div class="col-sm-4">
					<input name="name" id="name" value="${store.name }" type="text" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">店铺首页链接地址</label>
				<div class="col-sm-4">
					<input name="storeUrl" id="storeUrl" value="${store.storeUrl }" type="text" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">店铺图片链接地址</label>
				<div class="col-sm-4">
					<input type="hidden" name="storePicUrl" id="storePicUrl" value="${store.storePicUrl }">
					<input name="storePicUrlFile" id="storePicUrlFile" type="file" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">状态</label>
				<div class="col-sm-4">
					<select class="form-control m-b" name="flagAble">
						<option value="">请选择</option>
						<c:forEach var="s" items="${status }">
							<option value="${s.code }" <c:if test="${store.code == s.code }">selected="selected"</c:if>>${s.name }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div style="text-align: center;" class="form-group">
				<a href="javascript:void(0)" class="btn btn-w-m btn-info" onclick="Store.edit()">保存</a>
				<a href="user/store/index.htm" class="btn btn-w-m btn-default">取消</a>
			</div>
		</form>
	</div>
</div>
<script src="assets/commons/js/user/store.js"></script>
<%@ include file="../common/footer.jsp" %>