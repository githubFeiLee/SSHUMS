<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<base href="<%=basePath%>">
<%@taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript" src="./plugins/jquery_2.1.3.js"></script>
<script type="text/javascript" src="./plugins/jquery.form.js"></script>
<script type="text/javascript" src="./js/queryUser.js"></script>

  <link rel="stylesheet" type="text/css" href="iconfont/icon-css/iconfont.css">
  <link rel="stylesheet" type="text/css" href="./css/userCss/queryUser.css">
<body>
	<div class="top-menu">
		<button class="button-add" value="添加用户">添加用户</button>
		<button class="button-remove">删除用户</button>
		<form id="likeForm">
		<input type="text" name="name" placeholder="请输入姓名">
		<button class="button-like">查询用户</button>
		</form>
	</div>
	<div id="like-panel">
	<table>
		<thead>
			<tr>
				<th><input type="checkbox" name="user">全选</th>
				<th>姓名</th>
				<th>性别</th>
				<th>账号</th>
				<th>电话</th>
				<th>状态</th>
				<th>部门</th>
				<th>角色</th>
				<th>创建时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${listUser}" varStatus="status">
				<tr class="user-remove-id" data-id="${user.id }">
					<td><input type="checkbox" name="usercheck" data-id="${user.id }">${user.id }</td>
					<td id="userName">${user.name}</td>
					<td>${user.sex}</td>
					<td id="">${user.username}</td>
					<td>${user.phone}</td>
					<td>${user.status}</td>
					<td>${user.department.name}</td>
					<td>${user.role.name}</td>
					<td>${user.createDate }</td>
					<td><button class="user-update" data-id="${user.id }">编辑</button>
						<button class="user-remove" data-id="${user.id }">删除${sessionScope.user }</button></td>
				</tr>
			</c:forEach>

		</tbody>
		<div class="page-parent">
		<div class="page-content">
			共${page.totalPage }页&nbsp;&nbsp;当前是第${page.pageNow }页
			<c:if test="${page.hasFirst }">
				<a class="firstPage" href="javascript:;" target="main">首页</a>
			</c:if>
			<c:if test="${page.hasPre }">
				<a href="javascript:;" class="pageNow">上一页</a>
			</c:if>
			
			<c:if test="${page.hasNext }">
				<a href="javascript:;" class="pagenext">下一页</a>
			</c:if>
			<c:if test="${page.hasLast }">
				<a href="javascript:;" class="lastpage"> 尾页</a>
			</c:if>
		</div>
	</div>
	</table>
	</div>
	
	<script type="text/javascript">
		$(function() {
			$(".firstPage").on("click", function() {
				$(".buttom-menu").load("pageUser?pageNow=1");
			})
			$(".pageNow").on("click", function() {
				$(".buttom-menu").load("pageUser?pageNow=${page.pageNow-1}");
			})
			$(".pagenext").on("click", function() {
				$(".buttom-menu").load("pageUser?pageNow=${page.pageNow+1}");
			})
			$(".lastpage").on("click", function() {
				$(".buttom-menu").load("pageUser?pageNow=${page.totalPage}");
			})
		});
	</script>