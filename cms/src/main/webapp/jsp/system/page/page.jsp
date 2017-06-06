<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:set var="level" value="${level }" scope="request" />
<c:if test="${fn:length(pages) > 0}">
<c:forEach var="p" items="${pages}">
	<li>
		<c:choose>
			<c:when test="${p.url == '' }">
				<a href="#"> 
					<c:if test="${m.icon != '' }">
						<i class="fa ${m.icon }"></i>
					</c:if>
					<span class="nav-label">${m.name }</span> <!-- 遍历二级菜单 -->
					<c:if test="${fn:length(m.childs) > 0}">
						<span class="fa arrow"></span>
					</c:if>
				</a>
				<c:if test="${fn:length(m.childs) > 0}">
					<ul class="nav nav-second-level">
						<c:set var="menus" value="${m.childs}" scope="request" />
						<c:import url="jsp/system/menu/menu.jsp" />
					</ul>
				</c:if>
			</c:when>
			<c:otherwise>
				<a class="J_menuItem" href="${m.page.url }"> <c:if
						test="${m.icon != '' }">
						<i class="fa ${m.icon }"></i>
					</c:if> <span class="nav-label">${m.name }</span>
				</a>
			</c:otherwise>
		</c:choose>
	</li>
</c:forEach>
</c:if>
