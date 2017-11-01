<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/commons/header.jsp" %>
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
            	关联页面名称:<strong style="margin:15px;">${menu.page.name }</strong>
            </li>
            <li class="list-group-item">
            	页面链接:<strong style="margin:15px;">${menu.page.url }</strong>
            </li>
            <li class="list-group-item">
            	图标:<strong style="margin:15px;"><c:if test="${menu.icon !='' }"><i class="fa ${menu.icon }"></i></c:if></strong>
            </li>
            <li class="list-group-item">
            	是否可用:<strong style="margin:15px;">
            		<c:choose>
            			<c:when test="${menu.flagAble ==0 }">可用</c:when>
            			<c:otherwise>不可用</c:otherwise>
            		</c:choose>
            	</strong>
            </li>
            <li class="list-group-item">
            	排序:<strong style="margin:15px;">${menu.sort }</strong>
            </li>
        </ul>
	</div>
	<div class="row" style="text-align: center;">
		<c:if test="${menu.pageCode == '' }">
			<a href="system/menu/addindex.htm?code=${menu.code }&group=${menu.groupCode}" style="margin: 15px;" class="btn btn-w-m btn-info">添加子项</a>
		</c:if>
		<a href="system/menu/editindex.htm?code=${menu.code }" style="margin: 15px;" class="btn btn-w-m btn-warning">编辑</a>
		<a href="javascript:void(0)" style="margin: 15px;" class="btn btn-w-m btn-danger" onclick="Menu.del('${menu.code}','${menu.groupCode}')">删除</a>
	</div>
</div>
<%@ include file="/jsp/commons/footer.jsp" %>