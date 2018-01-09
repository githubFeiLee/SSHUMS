<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<base href="<%=basePath%>">
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账户管理</title>
<script type="text/javascript" src="./plugins/jquery_2.1.3.js"></script>
<script type="text/javascript" src="./plugins/jquery.form.js"></script>

<script type="text/javascript" src="./js/queryUser.js"></script>
<script type="text/javascript" src="./js/jurisdiction.js"></script>
<script type="text/javascript" src="./js/roleManage.js"></script>
<script type="text/javascript" src="./js/departmentManage.js"></script>

<link rel="stylesheet" type="text/css"
	href="./iconfont/icon-css/iconfont.css">
<link rel="stylesheet" type="text/css"
	href="./css/userCss/queryUser.css">
<link rel="stylesheet" type="text/css" href="./css/userManage.css">
</head>

<body>
	<div id="contai">
		<div class="type">
			<h1>用户管理系统-UMS-deBug</h1>
		</div>
		<div class="menu-panel">
			<ul>
				<li><a href="toLogout"> <span><i
							class="iconfont icon-tuichu-"></i></span>
				</a></li>
			</ul>
		</div>
	</div>
	<div id="content">
		<div class="menu-panel">
			<div class="menu-content-panel">
				<div id="page">
					<span> <i class="iconfont icon-zhanghuguanli"></i></span>&nbsp;&nbsp;&nbsp;账户管理
				</div>
				<div class="queryRole">
					<span> <i class="iconfont icon-jiaoseguanli"></i></span>&nbsp;&nbsp;&nbsp;角色管理
				</div>
				<div class="jurisdictionmanage">
					<span><i class="iconfont icon-quanxian"></i></span>&nbsp;&nbsp;&nbsp;权限管理
				</div>
				<div id="department">
					<span><i class="iconfont icon-bumen"></i></span>&nbsp;&nbsp;&nbsp;部门管理
				</div>
			</div>
			<div class="avatar-panel">
				<div class="avatar-content-panel">
					<div class="cont5">
						<div></div>
					</div>
				</div>
				<div class="avatar-text-panel">当前登录用户</div>
			</div>
		</div>
		<div class="content-panel">
			<div class="buttom-menu">
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
									<td><input type="checkbox" name="usercheck"
										data-id="${user.id }">${user.id }</td>
									<td>${user.name}</td>
									<td>${user.sex}</td>
									<td id="">${user.username}</td>
									<td>${user.phone}</td>
									<td>${user.status}</td>
									<td>${user.department.name}</td>
									<td>${user.role.name}</td>
									<td>${user.createDate }</td>
									<td><button class="user-update" data-id="${user.id }">编辑</button>
										<button class="user-remove" data-id="${user.id }">删除</button></td>
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

			</div>
		</div>
	</div>
<div class="container">
		<ul class="pager">
		<c:if test="${page.hasFirst }">
			<li class="active"><a class="firstPage" href="javascript:;" target="main">首页</a></li>
		</c:if>
		<c:if test="${page.hasPre }">
			<li><a href="javascript:;" class="pageNow">上一页</a></li>
		</c:if>

		<c:if test="${page.hasNext }">
			<li><a href="javascript:;" class="pagenext">下一页</a></li>
		</c:if>
		<c:if test="${page.hasLast }">
			<li><a href="javascript:;" class="lastpage"> 尾页</a></li>
		</c:if>
		</ul>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		
		$(".jurisdictionmanage").on("click", function() {
			$(".buttom-menu").load("queryjurisdiction")
		});

		$("#page").on("click", function() {
			$(".buttom-menu").load("pageUser");
		});
		$("#department").on("click", function() {
			$(".buttom-menu").load("showDepartment");
		});
		// 查询所有角色信息
		$(".queryRole").on("click", function() {
			$(".buttom-menu").load("queryRole");
		});

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
</html>