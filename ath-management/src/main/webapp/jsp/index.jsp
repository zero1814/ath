<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="assets/plugins/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="assets/plugins/bootstrap/plugins/bootstrap-table/bootstrap-table.min.css"
	rel="stylesheet">
<link href="assets/font/font-awesome/4.7.0/css/font-awesome.css"
	rel="stylesheet">
<link href="assets/commons/css/animate.css" rel="stylesheet">
<link href="assets/commons/css/style.css?v=1.0.0" rel="stylesheet">
<script type="text/javascript">
	var basePath = "<%=basePath%>";
</script>
</head>
<body class="fixed-sidebar full-height-layout gray-bg"
	style="overflow: hidden">
	<div id="wrapper">
		<nav id="nav" class="navbar-default navbar-static-side"
			role="navigation">
		<div class="nav-close">
			<i class="fa fa-times-circle"></i>
		</div>
		<div class="sidebar-collapse">
			<ul class="nav" id="side-menu">
				<c:if test="${fn:length(menugroups)>0}">
					<c:forEach var="group" items="${menugroups}">
						<c:choose>
							<c:when test="${fn:length(group.menus)>0}">
								<li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
									<span class="ng-scope">${group.name}</span> <c:forEach
										var="menu" items="${group.menus }">
										<c:choose>
											<c:when test="${fn:length(menu.childMenu)>0}">
												<li><a href="#"> <i class="fa ${menu.icon }"></i> <span
														class="nav-label">${menu.name }</span> <span
														class="fa arrow"></span>
														<ul class="nav nav-second-level">
															<c:forEach var="childMenu" items="${menu.childMenu }">
																<c:choose>
																	<c:when test="${fn:length(childMenu.childMenu)>0}">
																		<li><a href="#">${childMenu.name} <span
																				class="fa arrow"></span></a></li>
																		<ul class="nav nav-third-level">
																			<c:forEach var="item" items="${childMenu.childMenu}">
																				<li><a class="J_menuItem" href="${item.url }">${item.name }</a>
																				</li>
																			</c:forEach>
																		</ul>
																	</c:when>
																	<c:otherwise>
																		<li><a class="J_menuItem"
																			href="${childMenu.url }">${childMenu.name }</a></li>
																	</c:otherwise>
																</c:choose>
															</c:forEach>
														</ul>
												</a></li>
											</c:when>
											<c:otherwise>
												<li><a class="J_menuItem" href="${menu.url }"> <i
														class="fa ${menu.icon }"></i> <span class="nav-label">${menu.name }</span>
												</a></li>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</li>
							</c:when>
						</c:choose>
					</c:forEach>
				</c:if>
			</ul>
		</div>
		</nav>
		<div id="page-wrapper" class="gray-bg">
			<div class="row J_mainContent" id="content-main">
				<iframe id="J_iframe" width="100%" height="100%" src="system/menugroup/index.htm"
					frameborder="0" data-id="system/menugroup/index.htm" seamless></iframe>
			</div>
		</div>
	</div>
</body>
<script src="assets/plugins/jquery/3.1.1/jquery-3.1.1.min.js"></script>
<script src="assets/plugins/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script
	src="assets/plugins/bootstrap/plugins/bootstrap-table/bootstrap-table.js"></script>
<script
	src="assets/plugins/bootstrap/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="assets/plugins/metisMenu/js/metisMenu.min.js"></script>
<script
	src="assets/plugins/jquery/plugins/slimscroll/js/jquery.slimscroll.min.js"></script>
<script src="assets/plugins/layer/layer.js"></script>
<script src="assets/commons/js/commons.js"></script>
<script src="assets/commons/js/usepublic.js"></script>
<script type="text/javascript">
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