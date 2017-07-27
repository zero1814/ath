<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>
<div  class="wrapper wrapper-content animated fadeInRight">
	<div class="row">
		<form id="addFrm" method="post" class="form-horizontal">
			<input type="hidden" name="storeCode" id="storeCode" value="${storeCode }">
			<div class="form-group">
				<label class="col-sm-4 control-label">名称</label>
				<div class="col-sm-4">
					<input name="name" id="name" value="" type="text" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">商品类型</label>
				<div class="col-sm-4">
					<select class="form-control m-b" name="pageCode">
						<option value="">请选择</option>
						<c:forEach var="type" items="${productType }">
							<option value="${type.code }">${type.name }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">成本价</label>
				<div class="col-sm-4">
					<input name="costPrice" id="costPrice" value="" type="text" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">商品链接地址</label>
				<div class="col-sm-4">
					<input name="productUrl" id="productUrl" value="" type="text" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">商品图片</label>
				<div class="col-sm-4">
					<input name="productPic" id="productPic" value="" type="file" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">商品标签</label>
				<div class="col-sm-4">
					<input name="productLabel" id="productLabel" value="" type="text" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">商品规格</label>
				<div class="col-sm-4">
					<input name="productSpecification" id="productSpecification" value="" type="text" class="form-control">
				</div>
			</div>
			<div style="text-align: center;" class="form-group">
				<a href="javascript:void(0)" class="btn btn-w-m btn-info" onclick="Menu.add('${groupCode}')">保存</a>
				<a href="system/menu/detail.htm?code=${parentCode }" class="btn btn-w-m btn-default">取消</a>
			</div>
		</form>
	</div>
</div>
<script src="assets/commons/js/system/menu/menu.js"></script>
<%@ include file="../common/footer.jsp" %>