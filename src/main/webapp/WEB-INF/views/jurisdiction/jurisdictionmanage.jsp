<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="./css/jurisdictionCss/jurisdictionindex.css">
<div class="top-menu">
	<div class="but">
		<button type="button" class="btn-save">添加权限</button>
		<button type="button" class="btn-remove">删除权限</button>
	</div>
</div>

<table>
	<tr>
		<th>序号</th>
		<th>权限名称</th>
		<th>权限描述</th>
		<th>创建时间</th>
		<th>操作</th>
	</tr>
	<c:forEach var="jurisdiction" items="${jurisdictions }"
		varStatus="status">
		<input type="hidden" name="roleJurisdictions"
								value="${jurisdiction.roleJurisdiction }">
		<tr>
			<!-- count获取当前序号，从1开始 -->
			<!-- index获取当前索引，从0开始 -->
			<td><input type="checkbox" name="checkbox"
				data-id="${jurisdiction.id}">${jurisdiction.id}</td>
			<td>${jurisdiction.name }</td>
			<td>${jurisdiction.description }</td>
			<td>${jurisdiction.createDate }</td> 
			<td><button class="btn-compile" data-id="${jurisdiction.id}">编辑</button>
				<button class="btn-rmv" data-id="${jurisdiction.id}">删除</button></td>
		</tr>
	</c:forEach>

</table>
<script type="text/javascript" src="./plugins/jquery_2.1.3.js"></script>
<script type="text/javascript" src="./js/jurisdiction.js">
	
</script>
