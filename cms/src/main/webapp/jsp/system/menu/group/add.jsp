<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../common/header.jsp" %>
<div  class="wrapper wrapper-content animated fadeInRight">
	<div class="row">
		<form id="addFrm" method="post" class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-4 control-label">名称</label>
				<div class="col-sm-4">
					<input name="name" id="name" value="" type="text" class="form-control">
				</div>
			</div>
			<div style="text-align: center;" class="form-group">
				<a href="javascript:void(0)" class="btn btn-w-m btn-info" onclick="MenuGroup.add()">保存</a>
				<a href="javascript:void(0)" class="btn btn-w-m btn-default" onclick="MenuGroup.closeLayer()">取消</a>
			</div>
		</form>
	</div>
</div>
<script src="assets/commons/js/system/menu/menu.group.js"></script>
<%@ include file="../../../common/footer.jsp" %>