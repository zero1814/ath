<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../common/header.jsp" %>
<div  class="wrapper wrapper-content animated fadeInRight">
	<div class="row">
		<form id="editFrm" method="post" class="form-horizontal">
			<input type="hidden" name="code" id="code" value="${menu.code }">
			<input type="hidden" name="groupCode" id="groupCode" value="${menu.groupCode }">
			<div class="form-group">
				<label class="col-sm-4 control-label">名称</label>
				<div class="col-sm-4">
					<input name="name" id="name" value="${menu.name }" type="text" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">链接页面</label>
				<div class="col-sm-4">
					<select class="form-control m-b" name="pageCode">
						<option value="">请选择</option>
						<c:forEach var="page" items="${pages }">
							<option value="${page.code }" <c:if test="${menu.pageCode == page.code }">selected="selected"</c:if>>${page.name }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">图标</label>
				<div class="col-sm-4">
					<input name="icon" id="icon" value="${menu.icon }" type="text" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">是否可用</label>
				<div class="col-sm-4">
					<select class="form-control m-b" name="flagAble">
						<option  value="0" <c:if test="${menu.flagAble == 0 }">selected="selected"</c:if>>可用</option>
						<option value="1" <c:if test="${menu.flagAble == 1 }">selected="selected"</c:if>>不可用</option>					
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">排序</label>
				<div class="col-sm-4">
					<input name="sort" id="sort" onkeyup="checkVal(this);" value="${menu.sort }" type="text" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-8">
					<label class="col-sm-4 control-label">权限</label>
					<a href="javascript:void(0)" class="btn btn-w-m btn-info">设置</a>
				</div>
			</div>
			<div style="text-align: center;" class="form-group">
				<a href="javascript:void(0)" class="btn btn-w-m btn-info" onclick="Menu.edit()">保存</a>
				<a href="system/menu/detail.htm?code=${menu.code }" class="btn btn-w-m btn-default">取消</a>
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
<%@ include file="../../common/footer.jsp" %>