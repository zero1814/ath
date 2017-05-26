<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:set var="level" value="${level }" scope="request" />
<c:if test="${fn:length(menus) > 0}">
<c:forEach var="m" items="${menus}">
	<li>
		<c:choose>
			<c:when test="${m.url == '' }">
				<a href="#"> 
					<c:if test="${m.icon != '' }">
						<i class="fa ${m.icon }"></i>
					</c:if> 
					<span class="nav-label">${m.name }</span> <!-- 遍历二级菜单 -->
					<c:if test="${fn:length(m.childMenu) > 0}">
						<span class="fa arrow"></span>
					</c:if>
				</a>
				<c:if test="${fn:length(m.childMenu) > 0}">
					<ul class="nav nav-second-level">
						<c:set var="level" value="${level + 1}" scope="request" />
						<c:set var="menus" value="${m.childMenu}" scope="request" />
						<c:import url="jsp/system/menu/menu.jsp" />
					</ul>
				</c:if>
			</c:when>
			<c:otherwise>
				<a class="J_menuItem" href="${m.url }"> <c:if
						test="${m.icon != '' }">
						<i class="fa ${m.icon }"></i>
					</c:if> <span class="nav-label">${m.name }</span>
				</a>
			</c:otherwise>
		</c:choose>
	</li>
</c:forEach>
</c:if>
