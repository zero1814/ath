<#-- 公共宏定义 -->
<#-- 页面头部 -->
<#assign basePath=request.contextPath />
<macro page_header>
<!DOCTYPE html>
<html>
	<head>
		<base href='${basePath}' />
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="keywords" content="">
		<meta name="description" content="">
		<link href="assets/font/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
		<link href="assets/plugins/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet" />
		<link href="assets/plugins/bootstrap/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet" />
		<link href="assets/commons/css/animate.css" rel="stylesheet" />
		<link href="assets/commons/css/style.css" rel="stylesheet" />
		<script src="assets/plugins/jquery/1.12.2/jquery-1.12.2.min.js"></script>
		<script src="assets/plugins/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<script src="assets/plugins/bootstrap/plugins/bootstrap-table/bootstrap-table.js"></script>
		<script src="assets/plugins/bootstrap/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
		<script src="assets/plugins/layer/layer.js"></script>
		<script src="assets/commons/js/usepublic.js"></script>
	</head>
	<body>
</macro>
<#-- 页面底部 -->
<macro page_footer>
	</body>
</html>
</macro>

<#-- 添加页面 -->
<macro page_add e_list>
<@page_header />
<div  class="wrapper wrapper-content animated fadeInRight">
	<div class="row">
		<form id="addFrm" method="post" class="form-horizontal">
			<#list e_list as e>
				<div class="form-group">
					<label class="col-sm-4 control-label">${e.name}</label>
					<div class="col-sm-4">
						<input name="name" id="${e.code}" value="${e.code}" type="text" class="form-control">
					</div>
				</div>
			</#list>
		</form>
	</div>
</div>
<@page_footer />
</macro>
<#-- 编辑页面 -->
<macro page_edit>
<@page_header />
<@page_footer />
</macro>
<#-- 数据详情页面 -->
<macro page_detail>
<@page_header />
<@page_footer />
</macro>
<#-- 数据集合页面 -->
<macro page_data>
<@page_header />
<@page_footer />
</macro>
<#-- 树型数据页面 -->
<macro page_tree>
<@page_header />
<@page_footer />
</macro>
