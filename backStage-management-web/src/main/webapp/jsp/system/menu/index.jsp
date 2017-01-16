<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/commons/header.jsp"%>
<div class="row">
	<div class="ibox float-e-margins">
		<div class="ibox-title">
			<h5>新增菜单</h5>
		</div>
		<div class="ibox-content">
			<a id="demo1" href="javascript:void(0)" class="btn btn-w-m btn-info">layer警告弹出层</a><br>
			<a id="demo2" href="javascript:void(0)" class="btn btn-w-m btn-info">layer询问弹出层</a><br>
		</div>
	</div>
</div>
<%@ include file="/jsp/commons/footer.jsp"%>
<script>
	$("#demo1").click(function() {
		layer.alert('layer警告弹出层');
	});
	$("#demo2").click(function() {
		layer.confirm('您是如何看待前端开发？', {
			//按钮
			btn : [ '重要', '奇葩' ]
		}, function() {
			layer.msg('的确很重要');
		}, function() {
			layer.msg('也可以这样', {
				time : 1000, //20s后自动关闭
				btn : [ '明白了', '知道了' ]
			});
		});
	});
</script>