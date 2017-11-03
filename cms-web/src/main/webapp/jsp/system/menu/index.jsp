<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/commons/header.jsp" %>
<div class="wrapper wrapper-content">
	<div class="row">
		<div class="col-sm-12">
			<form method="get" class="form-horizontal">
				<div class="form-group">
					<label class="col-sm-4 control-label">名称</label>
					<div class="col-sm-4">
						<input name="name" id="name" value="" type="text" class="form-control">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label">分组名称</label>
					<div class="col-sm-4">
						<select id="groupCode" name="groupCode" class="form-control">
							<option value=''>--请选择--</option>
							<c:forEach var="group" items="${groups }">
								<option value="${group.code }">${group.name }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label"></label>
					<div class="col-sm-4">
						<a style="float: right;" href="javascript:void(0)" onclick="Menu.search();" class="btn btn-w-m btn-info">查询</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="btn-group hidden-xs" role="table">
				<a href="/system/menu/addindex.htm" class="btn btn-w-m btn-info">添加</a>
			</div>
			<table id="table" data-height="400" data-mobile-responsive="true">
			</table>
		</div>
	</div>
</div>
<script type="text/javascript" src="assets/commons/js/table.js"></script>
<script type="text/javascript" src="assets/module/system/menu.js"></script>
<script type="text/javascript">
$(function(){
	Menu.init();
})
</script>
<%@ include file="/jsp/commons/footer.jsp" %>