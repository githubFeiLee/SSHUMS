<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" type="text/css" href="./css/roleCss/showRoleStyle.css">
<script type="text/javascript" src="./plugins/jquery_2.1.3.js"></script>
<script type="text/javascript" src="./js/roleManage.js"></script>

<div>
	<div class="top-menu">
		<div class="but">
			<button type="submit" class="but-add">添加角色</button>
			<button type="button" class="but-remove">删除角色</button>
		</div>
	</div>
	<table>
		<thead>
			<tr>
				<th>序号</th>
				<th>名称</th>
				<th>描述</th>
				<th>创建时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="list" items="${listRole }" varStatus="status">

				<tr class="role-remove-id" data-id="${list.id }">

					<td><input type="checkbox" name="checkbox"
						data-id="${list.id }">${list.id }</td>
					<td>${list.name }</td>
					<td>${list.description }</td>
					<td>${list.createDate }</td>
					<td>
						<button class="queryUpdateRole"
							data-id="${list.id }">编辑</button>
						<button class="removeRole"
							data-id="${list.id }">删除</button>
					</td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
</div>
