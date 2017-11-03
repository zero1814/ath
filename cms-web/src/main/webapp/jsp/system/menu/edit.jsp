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
					<label class="col-sm-3 control-label">父级菜单：</label>
					<div class="col-sm-8">
						<select id="parentCode" name="parentCode" class="form-control">
							<option value="">--请选择--</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">所属分组：</label>
					<div class="col-sm-8">
						<select id="groupCode" name="groupCode" class="form-control">
							<option value="">--请选择--</option>
							<c:forEach var="group" items="${groups }">
								<c:choose>
									<c:when test="${entity.groupCode==group.code }">
										<option selected="selected" value="${group.code }">${group.name}</option>
									</c:when>
									<c:otherwise>
										<option value="${group.code }">${group.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">图标：</label>
					<div class="col-sm-8">
						<input value="${entity.icon }" id="icon" name="icon" class="form-control" type="text">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">关联页面：</label>
					<div class="col-sm-8">
						<select id="pageCode" name="pageCode" class="form-control">
							<option value="">--请选择--</option>
							<c:forEach var="page" items="${pages }">
								<c:choose>
									<c:when test="${entity.pageCode=page.code }">
										<option selected="selected"  value="${page.code }">${page.name }</option>									
									</c:when>
									<c:otherwise>
										<option value="${page.code }">${page.name }</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">是否可用：</label>
					<div class="col-sm-8">
						<select id="flagAble" name="flagAble" class="form-control">
							<option value="">--请选择--</option>
							<option value="0">可用</option>
							<option value="1">不可用</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">排序：</label>
					<div class="col-sm-8">
						<input id="sort" name="sort" class="form-control" type="text">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12" style="text-align: center;">
						<a href="javascript:Menu.edit();" class="btn btn-info">提交</a>
						<a href="system/menu/index.htm" class="btn btn-default">取消</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript" src="assets/module/system/menu.js"></script>
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