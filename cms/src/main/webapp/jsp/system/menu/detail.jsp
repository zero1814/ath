<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../common/header.jsp" %>
<div class="wrapper wrapper-content animated fadeInRight">
	<div class="row" style="font-size:18px;">
        <ul class="list-group">
            <li class="list-group-item">
            	编码:<strong style="margin:15px;">${menu.code }</strong>
            </li>
            <li class="list-group-item ">
          	  	名称:<strong style="margin:15px;">${menu.name }</strong>
            </li>
            <li class="list-group-item">
            	链接地址:<strong style="margin:15px;">${menu.url }</strong>
            </li>
            <li class="list-group-item">
            	图标:<strong style="margin:15px;"><c:if test="${menu.icon !='' }"><i class="fa ${menu.icon }"></i></c:if></strong>
            </li>
        </ul>
	</div>
	<div class="row" style="text-align: center;">
		<a href="system/menu/addindex.htm?code=${menu.code }&group=${menu.groupCode}" style="margin: 15px;" class="btn btn-w-m btn-info">添加子项</a>
		<a href="system/menu/editindex.htm?code=${menu.code }" style="margin: 15px;" class="btn btn-w-m btn-warning">编辑</a>
		<a href="javascript:void(0)" style="margin: 15px;" class="btn btn-w-m btn-danger" onclick="Menu.del('${menu.code}','${menu.groupCode}')">删除</a>
	</div>
	<div class="row" style="text-align: center;">
		<div class="ibox float-e-margins">
			<div class="ibox-title">
				<h5>菜单权限</h5>
			</div>
			<div class="ibox-content">
				<div class="row">
					<div class="col-md-4" style="text-align: left;">
						<a href="javascript:void(0)" class="btn btn-w-m btn-info" onclick="Menu.openAddPermission('${menu.code}')">添加</a>
					</div>
				</div>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th style="text-align: center;">名称</th>
							<th style="text-align: center;">类型</th>
							<th style="text-align: center;">创建人</th>
							<th style="text-align: center;">修改人</th>
							<th style="text-align: center;">操作</th>
						</tr>
					</thead>
					<tbody id="permission"></tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<script src="assets/commons/js/system/menu/menu.js"></script>
<script type="text/javascript">
$(function($) {
	Menu.permission('${menu.code}');
});
</script>