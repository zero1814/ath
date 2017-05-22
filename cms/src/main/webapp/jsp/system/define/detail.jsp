<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/header.jsp"%>
<div class="wrapper wrapper-content">
	<div class="row" style="font-size:18px;">
        <ul class="list-group">
            <li class="list-group-item">
            	编码:<strong style="margin:15px;">${define.code }</strong>
            </li>
            <li class="list-group-item ">
          	  	名称:<strong style="margin:15px;">${define.name }</strong>
            </li>
        </ul>
	</div>
	<div class="row" style="text-align: center;">
		<a href="javascript:void(0)" style="margin: 15px;" class="btn btn-w-m btn-info" onclick="Define.openAdd();">添加子项</a>
		<a href="javascript:void(0)" style="margin: 15px;" class="btn btn-w-m btn-warning" onclick="alert();">编辑</a>
		<a href="javascript:void(0)" style="margin: 15px;" class="btn btn-w-m btn-danger" onclick="alert();">删除</a>
	</div>
</div>
<div id="addDiv" class="wrapper wrapper-content" style="display: none;overflow: hidden;">
	<div class="row">
		<form id="addFrm" method="post" class="form-horizontal">
			<input type="hidden" id="parentCode" name="parentCode" value="${define.code }">
			<div class="form-group">
				<label class="col-sm-4 control-label">名称</label>
				<div class="col-sm-4">
					<input name="name" id="name" value="" type="text" class="form-control">
				</div>
			</div>
			<div style="text-align: center;" class="form-group">
				<a href="javascript:void(0)" class="btn btn-w-m btn-info" onclick="Define.add()">保存</a>
				<a href="javascript:void(0)" class="btn btn-w-m btn-default" onclick="Define.closeLayer();">取消</a>
			</div>
		</form>
	</div>
</div>
<script src="assets/commons/js/system/system/define.js"></script>
<%@ include file="../../common/footer.jsp"%>