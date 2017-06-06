<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../common/header.jsp" %>
<div class="wrapper wrapper-content animated fadeInRight">
	<div class="row" style="font-size:18px;">
        <ul class="list-group">
            <li class="list-group-item">
            	编码:<strong style="margin:15px;">${page.code }</strong>
            </li>
            <li class="list-group-item ">
          	  	名称:<strong style="margin:15px;">${page.name }</strong>
            </li>
            <li class="list-group-item">
            	链接地址:<strong style="margin:15px;">${page.url }</strong>
            </li>
            <li class="list-group-item">
            	链接参数:<strong style="margin:15px;">${page.param }</strong>
            </li>
            <li class="list-group-item">
            	是否可用:
            	<strong style="margin:15px;">
            		<c:choose>
            			<c:when test="${page.flagAble ==0 }">可用</c:when>
            			<c:otherwise>不可用</c:otherwise>
            		</c:choose>
            	</strong>
            </li>
        </ul>
	</div>
	<div class="row" style="text-align: center;">
		<a href="system/page/addindex.htm?code=${page.code }&group=${page.groupCode}" style="margin: 15px;" class="btn btn-w-m btn-info">添加子项</a>
		<a href="system/page/editindex.htm?code=${page.code }" style="margin: 15px;" class="btn btn-w-m btn-warning">编辑</a>
		<a href="javascript:void(0)" style="margin: 15px;" class="btn btn-w-m btn-danger" onclick="Page.del('${page.code}','${page.groupCode}')">删除</a>
	</div>
</div>
<script src="assets/commons/js/system/page/page.js"></script>
