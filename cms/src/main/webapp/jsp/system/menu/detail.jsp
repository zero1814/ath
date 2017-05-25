<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../common/header.jsp" %>
<div class="wrapper wrapper-content">
	<div class="row" style="font-size:18px;">
        <ul class="list-group">
            <li class="list-group-item">
            	编码:<strong style="margin:15px;">${menu.code }</strong>
            </li>
            <li class="list-group-item ">
          	  	名称:<strong style="margin:15px;">${menu.name }</strong>
            </li>
        </ul>
	</div>
	<div class="row" style="text-align: center;">
		<a href="javascript:void(0)" style="margin: 15px;" class="btn btn-w-m btn-info" onclick="alert();">添加子项</a>
		<a href="javascript:void(0)" style="margin: 15px;" class="btn btn-w-m btn-warning" onclick="alert();">编辑</a>
		<a href="javascript:void(0)" style="margin: 15px;" class="btn btn-w-m btn-danger" onclick="alert();">删除</a>
	</div>
</div>
<script src="assets/commons/js/system/menu/menu.js"></script>