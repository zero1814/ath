<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="renderer" content="webkit">
		<title>后台管理</title>
		<meta name="keywords" content="">
		<meta name="description" content="">
		<link href="assets/font/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
		<link href="assets/plugins/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet" />
		<link href="assets/commons/css/animate.css" rel="stylesheet" />
		<link href="assets/commons/css/style.css" rel="stylesheet" />
	</head>

	<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
		<div id="wrapper">
			<!--
            	作者：zero1814@126.com
            	时间：2017-04-01
            	描述：左侧导航
            -->
			<nav class="navbar-default navbar-static-side" role="navigation">
				<div class="nav-close"><i class="fa fa-times-circle"></i>
				</div>
				<div class="sidebar-collapse">
					<ul class="nav" id="side-menu">
						<li class="nav-header">
							<div class="dropdown profile-element">
								<a data-toggle="dropdown" class="dropdown-toggle" href="#">
									<span class="clear">
                                    <span class="block m-t-xs" style="font-size:20px;">
                                        <i class="fa fa-area-chart"></i>
                                        <strong class="font-bold">ATH</strong>
                                    </span>
									</span>
								</a>
							</div>
							<div class="logo-element">ATH
							</div>
						</li>
						<li>
							<a class="J_menuItem" href="html/index.html">
								<i class="fa fa-home"></i>
								<span class="nav-label">首页</span>
							</a>
						</li>
						<li>
							<a href="#"><i class="fa fa-desktop"></i> <span class="nav-label">菜单管理</span><span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li>
									<a class="J_menuItem" href="html/system/menu/group.html">菜单组管理</a>
								</li>
								<li>
									<a class="J_menuItem" href="html/system/menu/index.html">菜单管理</a>
								</li>
								<li>
									<a class="J_menuItem" href="html/system/menu/permission.html">权限配置</a>
								</li>
							</ul>
						</li>
						<li>
							<a href="#">
								<i class="fa fa-user-o"></i>
								<span class="nav-label">用户管理</span><span class="fa arrow"></span>
							</a>
							<ul class="nav nav-second-level">
								<li>
									<a class="J_menuItem" href="html/system/user/index.html">用户管理</a>
								</li>
								<li>
									<a href="#">
										</i> <span class="nav-label">角色管理</span><span class="fa arrow"></span></a>
									<ul class="nav nav-third-level">
										<li>
											<a class="J_menuItem" href="html/system/user/role.html">角色管理</a>
										</li>
										<li>
											<a class="J_menuItem" href="html/system/user/role_permission.html">权限管理</a>
										</li>
									</ul>
								</li>
							</ul>
						</li>
						<li>
							<a href="#"><i class="fa fa-cog"></i> <span class="nav-label">系统配置</span><span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li>
									<a class="J_menuItem" href="html/system/system/param.html">参数配置</a>
								</li>
								<li>
									<a class="J_menuItem" href="form_file_upload.html">系统维护</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</nav>
			<div id="page-wrapper" class="gray-bg dashbard-1">
				<!--
                	作者：zero1814@126.com
                	时间：2017-04-05
                	描述：头部菜单栏
                -->
				<div class="row border-bottom">
					<nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
						<div class="navbar-header">
							<a class="navbar-minimalize minimalize-styl-2 btn btn-info " href="#"><i class="fa fa-bars"></i> </a>
							<form role="search" class="navbar-form-custom" method="post" action="search_results.html">
								<div class="form-group">
									<input type="text" placeholder="请输入您需要查找的内容 …" class="form-control" name="top-search" id="top-search">
								</div>
							</form>
						</div>
						<ul class="nav navbar-top-links navbar-right">
							<li class="dropdown">
								<a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
									<i class="fa fa-envelope"></i> <span class="label label-warning">16</span>
								</a>
								<ul class="dropdown-menu dropdown-messages">
									<li class="m-t-xs">
										<div class="dropdown-messages-box">
											<a href="profile.html" class="pull-left">
												<img alt="image" class="img-circle-thumb" src="data/images/head1.jpg">
											</a>
											<div class="media-body">
												<small class="pull-right">46小时前</small>
												<strong>小四</strong> 是不是只有我死了,你们才不骂爵迹
												<br>
												<small class="text-muted">3天前 2014.11.8</small>
											</div>
										</div>
									</li>
									<li class="divider"></li>
									<li>
										<div class="dropdown-messages-box">
											<a href="profile.html" class="pull-left">
												<img alt="image" class="img-circle-thumb" src="data/images/head3.jpg">
											</a>
											<div class="media-body ">
												<small class="pull-right text-navy">25小时前</small>
												<strong>二愣子</strong> 呵呵
												<br>
												<small class="text-muted">昨天</small>
											</div>
										</div>
									</li>
									<li class="divider"></li>
									<li>
										<div class="text-center link-block">
											<a class="J_menuItem" href="mailbox.html">
												<i class="fa fa-envelope"></i> <strong> 查看所有消息</strong>
											</a>
										</div>
									</li>
								</ul>
							</li>
							<li class="dropdown">
								<a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
									<i class="fa fa-bell"></i> <span class="label label-primary">8</span>
								</a>
								<ul class="dropdown-menu dropdown-alerts">
									<li>
										<a href="mailbox.html">
											<div>
												<i class="fa fa-envelope fa-fw"></i> 您有16条未读消息
												<span class="pull-right text-muted small">4分钟前</span>
											</div>
										</a>
									</li>
									<li class="divider"></li>
									<li>
										<a href="profile.html">
											<div>
												<i class="fa fa-qq fa-fw"></i> 3条新回复
												<span class="pull-right text-muted small">12分钟钱</span>
											</div>
										</a>
									</li>
									<li class="divider"></li>
									<li>
										<div class="text-center link-block">
											<a class="J_menuItem" href="notifications.html">
												<strong>查看所有 </strong>
												<i class="fa fa-angle-right"></i>
											</a>
										</div>
									</li>
								</ul>
							</li>
						</ul>
					</nav>
				</div>
				<div class="row J_mainContent" id="content-main">
					<iframe id="J_iframe" width="100%" height="100%" src="html/index.html" frameborder="0" data-id="index_v1.html" seamless></iframe>
				</div>
			</div>
		</div>
	</body>
	<script src="assets/plugins/jquery/1.12.2/jquery-1.12.2.min.js"></script>
	<script src="assets/plugins/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="assets/plugins/metisMenu/js/metisMenu.min.js"></script>
	<script src="assets/plugins/jquery/plugins/slimscroll/js/jquery.slimscroll.min.js"></script>
	<script src="assets/commons/js/index.js"></script>
	<script>
		$(function() {
			//菜单点击
			$(".J_menuItem").on('click', function() {
				var url = $(this).attr('href');
				$("#J_iframe").attr('src', url);
				return false;
			});
		});
	</script>

</html>