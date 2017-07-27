<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../common/header.jsp" %>
<div class="wrapper wrapper-content animated fadeInRight">
	<div class="row" style="font-size:18px;">
        <ul class="list-group">
            <li class="list-group-item">
            	编码:<strong style="margin:15px;">${define.code }</strong>
            </li>
            <li class="list-group-item ">
          	  	名称:<strong style="margin:15px;">${define.name }</strong>
            </li>
        </ul>
	</div>
	<div class="row" style="text-align: center;">
		<a href="product/define/addindex.htm?parentCode=${define.code }" style="margin: 15px;" class="btn btn-w-m btn-info">添加子项</a>
		<a href="product/define/editindex.htm?code=${define.code }" style="margin: 15px;" class="btn btn-w-m btn-warning">编辑</a>
		<a href="javascript:void(0)" style="margin: 15px;" class="btn btn-w-m btn-danger" onclick="Define.del('${define.code}')">删除</a>
	</div>
</div>
<script src="assets/commons/js/product/define.js"></script>
<%@ include file="../../common/footer.jsp" %>
