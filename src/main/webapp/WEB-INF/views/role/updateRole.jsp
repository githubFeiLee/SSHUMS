<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" type="text/css"
	href="./css/roleCss/updateRoleStyle.css">
<script type="text/javascript" src="./plugins/jquery_2.1.3.js"></script>
<script type="text/javascript" src="./js/roleManage.js"></script>

<body>
	<div class="buttom-menus">
		<h2>修改角色信息</h2>
		<form id="updateRoleForm" method="post">
			<input type="hidden" name="role.id" value="${role.id }">
			<div class="content-cont">
				<div class="buttom-but">
					<div class="role">
						角色： <input type="text" name="role.name" 
							size="30px" autofocus
							value="${role.name }">
					</div>
					<div class="description">
						描述：<br>
						　　　<textarea type="text" name="role.description" cols="80" rows="10"
							style="resize: none" value="${role.description }">${role.description }</textarea>
					</div>
					<div class="jur-Panel">
						权限：
						<c:forEach var="list" items="${listJurisdiction }">
						<c:if test="${list.roleJurisdiction == true }">
						   <input type="checkbox" name="role.jurisdictions.id"
								value="${list.id }" checked>
					${list.name }
						</c:if>
						<c:if test="${list.roleJurisdiction == false }">
						   <input type="checkbox" name="role.jurisdictions.id"
								value="${list.id }">
					${list.name }
						</c:if>
				</c:forEach>
					</div>
					<div class="forget">
						<button type="reset" class="btn-cancel">重置</button>　
						<button type="button" class="btn-saves">提交</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>