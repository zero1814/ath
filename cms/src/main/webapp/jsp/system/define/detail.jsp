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
		<a href="javascript:void(0)" style="margin: 15px;" class="btn btn-w-m btn-warning" onclick="Define.openEdit();">编辑</a>
		<a href="javascript:void(0)" style="margin: 15px;" class="btn btn-w-m btn-danger" onclick="Define.del('${define.code }');">删除</a>
	</div>
</div>
<div id="addDiv" class="col-sm-6" style="display: none;overflow: hidden;">
	<div class="ibox">
		<div class="ibox-content">
			<form id="addFrm" method="post" class="form-horizontal">
				<input type="hidden" id="parentCode" name="parentCode" value="${define.code }">
				<div class="form-group">
					<label class="col-sm-3 control-label">名称：</label>
					<div class="col-sm-8">
						<input name="name" value="" type="text" class="form-control">
					</div>
				</div>
				<div style="text-align: center;" class="form-group">
					<a href="javascript:void(0)" class="btn btn-w-m btn-info" onclick="Define.add()">保存</a>
					<a href="javascript:void(0)" class="btn btn-w-m btn-default" onclick="Define.closeLayer();">取消</a>
				</div>
			</form>
		</div>
	</div>
</div>
<div id="editDiv" class="col-sm-6" style="display: none;overflow: hidden;">
	<div class="ibox">
		<div class="ibox-content">
			<form id="editFrm" method="post" class="form-horizontal">
				<input type="hidden" id="code" name="code" value="${define.code }">
				<div class="form-group">
					<label class="col-sm-3 control-label">名称：</label>
					<div class="col-sm-8">
						<input name="name" value="${define.name }" type="text" class="form-control">
					</div>
				</div>
				<div style="text-align: center;" class="form-group">
					<a href="javascript:void(0)" class="btn btn-w-m btn-info" onclick="Define.edit()">保存</a>
					<a href="javascript:void(0)" class="btn btn-w-m btn-default" onclick="Define.closeLayer();">取消</a>
				</div>
			</form>
		</div>
	</div>
</div>
<script src="assets/commons/js/system/system/define.js"></script>
<%@ include file="../../common/footer.jsp"%>