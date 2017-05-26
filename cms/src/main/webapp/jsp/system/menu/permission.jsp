<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../common/header.jsp" %>
<div  class="wrapper wrapper-content animated fadeInRight">
	<div class="row">
		<form method="post" class="form-horizontal">
			<input type="hidden" name="parentCode" id="parentCode" value="${parentCode }">
			<div class="form-group">
				<label class="col-sm-4 control-label">名称</label>
				<div class="col-sm-4">
					<input name="name" id="name" value="" type="text" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">是否可用</label>
				<div class="col-sm-4">
					<select class="form-control m-b" name="flagAble">
						<option value="0">可用</option>
						<option value="1">不可用</option>					
					</select>
				</div>
			</div>
			<div style="text-align: center;" class="form-group">
				<a href="javascript:void(0)" class="btn btn-w-m btn-info" onclick="MenuGroup.add()">保存</a>
				<a href="system/menu/detail.htm?code=${parentCode }" class="btn btn-w-m btn-default">取消</a>
			</div>
		</form>
	</div>
</div>
<%@ include file="../../common/footer.jsp" %>