<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/commons/header.jsp" %>
<div  class="wrapper wrapper-content animated fadeInRight">
	<div class="row">
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
				<label class="col-sm-4 control-label">链接页面</label>
				<div class="col-sm-4">
					<select class="form-control m-b" name="pageCode">
						<option value="">请选择</option>
						<c:forEach var="page" items="${pages }">
							<option value="${page.code }">${page.name }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">图标</label>
				<div class="col-sm-4">
					<input name="icon" id="icon" value="" type="text" class="form-control">
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
			<div class="form-group">
				<label class="col-sm-4 control-label">排序</label>
				<div class="col-sm-4">
					<input name="sort" id="sort" onkeyup="checkVal(this);" value="" type="text" class="form-control">
				</div>
			</div>
			<div style="text-align: center;" class="form-group">
				<a href="javascript:void(0)" class="btn btn-w-m btn-info" onclick="Menu.add('${groupCode}')">保存</a>
				<a href="index.htm?groupCode=${groupCode }" class="btn btn-w-m btn-default">取消</a>
			</div>
		</form>
	</div>
</div>
<script src="assets/commons/js/system/menu/menu.js"></script>
<script type="text/javascript">
 function checkVal(obj){
	 var v = $(obj).val();
	 if(UsePublic.isNumber(v)){
		 $(obj).val(v);
	 }else{
		 $(obj).val("");
	 }
 }
</script>
<%@ include file="/jsp/commons/footer.jsp" %>