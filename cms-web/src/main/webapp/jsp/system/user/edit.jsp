<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/commons/header.jsp" %>
<link href="assets/plugins/bootstrap/plugins/fileinput/css/fileinput.min.css" rel="stylesheet"/>
<style>
#upload_img{
width:200px;
height:200px;
}
</style>
<div class="wrapper wrapper-content">
	<div class="row">
		<div class="col-sm-12">
			<form class="form-horizontal m-t" id="edit" enctype="multipart/form-data">
				<input type="hidden" name="code" id="code" value="${entity.code }">
				<div class="form-group">
					<label class="col-sm-3 control-label">用户名：</label>
					<div class="col-sm-8">
						<input value="${entity.userName }" id="userName" name="userName" class="form-control" type="text">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">密码：</label>
					<div class="col-sm-8">
						<input value="${entity.password }" id="password" name="password" class="form-control" type="password">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">真实姓名：</label>
					<div class="col-sm-8">
						<input value="${entity.realName }" id="realName" name="realName" class="form-control" type="text">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">头像：</label>
					<div class="col-sm-8">
						<input id="headPic" name="headPic" type="hidden" value="${entity.headPic }">
						<input name="upload" id="upload" value="" type="file" class="form-control">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">手机号：</label>
					<div class="col-sm-8">
						<input value="${entity.phone }" id="phone" name="phone" class="form-control" type="text">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">邮箱地址：</label>
					<div class="col-sm-8">
						<input value="${entity.eMail }" id="eMail" name="eMail" class="form-control" type="text">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">qq：</label>
					<div class="col-sm-8">
						<input value="${entity.qq }" id="qq" name="qq" class="form-control" type="text">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">微信：</label>
					<div class="col-sm-8">
						<input value="${entity.weChat }" id="weChat" name="weChat" class="form-control" type="text">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">状态：</label>
					<div class="col-sm-8">
						<select id="status" name="status" class="form-control">
							<c:choose>
								<c:when test="${entity.status==1 }">
									<option value="0">可用</option>
									<option selected="selected" value="1">不可用</option>								
								</c:when>
								<c:otherwise>
									<option selected="selected" value="0">可用</option>
									<option value="1">不可用</option>
								</c:otherwise>
							</c:choose>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12" style="text-align: center;">
						<a href="javascript:User.edit();" class="btn btn-info">提交</a>
						<a href="system/user/index.htm" class="btn btn-default">取消</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<script src="assets/plugins/bootstrap/plugins/fileinput/js/fileinput.min.js"></script>
<script src="assets/plugins/bootstrap/plugins/fileinput/js/fileinput_locale_zh.js"></script>
<script type="text/javascript" src="assets/module/system/user.js"></script>
<script type="text/javascript">
$(function(){
	$("#upload").fileinput({
		language: "zh", //设置语言
		uploadUrl: "system/user/upload.htm", //上传的地址(访问接口地址)
		allowedFileExtensions: ["jpg", "jpeg", "png"], //接收的文件后缀
		uploadAsync: true, //默认异步上传
		showUpload: true, //是否显示上传按钮
		showRemove: true, //显示移除按钮
		showPreview: true, //是否显示预览
		showCaption: false, //是否显示标题
		browseClass: "btn btn-primary", //按钮样式 
		dropZoneEnabled: false, //是否显示拖拽区域
		maxFileSize: 20*1024,//单位为kb，如果为0表示不限制文件大小
		//minImageWidth: 200, //图片的最小宽度
		//minImageHeight: 200,//图片的最小高度
		//maxImageWidth: 200,//图片的最大宽度
		//maxImageHeight: 200,//图片的最大高度
		maxFileCount: 1, //表示允许同时上传的最大文件个数
		enctype: "multipart/form-data",
		validateInitialCount: true,
		initialPreview:[
			"<img style='width:200px;height:200px;' src='${entity.headPic}' class='file-preview-image' />"
		],
		previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
		msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
	});
	//异步上传返回结果处理
	$("#upload").on("fileuploaded", function(event, data, previewId, index) {
		var obj = data.response.list[0];
		$("#headPic").val(obj.url);
	});

});
</script>
<%@ include file="/jsp/commons/footer.jsp" %>