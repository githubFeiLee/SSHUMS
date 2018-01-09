<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="./plugins/jquery_2.1.3.js"></script>
<script type="text/javascript" src="./js/updateUser.js"></script>
<link rel="stylesheet" type="text/css"
	href="iconfont/icon-css/iconfont.css">
<link rel="stylesheet" type="text/css"
	href="./css/userCss/updateUser.css">
<style>
</style>

<body>
	<div class="parent">
		<form action="" id="updateUserForm" method="post">
			<div class="add-users">
				<h2>修改用户信息</h2>
			</div>
			<div class="user-form">
				<div class="content-form">
					<div class="input-password">
						账号： <input type="text" style="height: 24PX;" size="30px"
							name="user.username" value="${user.username }"> 密码： <input
							type="password" style="height: 24PX;" size="30px"
							name="user.password" value="${user.password }">
					</div>
					<div class="input-phone">
						姓名： <input type="text" style="height: 24PX;" size="30px"
							name="user.name" value="${user.name }"> 电话： <input
							type="text" style="height: 24PX;" size="30px" name="user.phone"
							value="${user.phone }">
					</div>
					<div class="input-user">
						性别：
						<c:if test="${user.sex == '男' }">
							<input type="radio" name="user.sex" value="男" checked>男
					<input type="radio" name="user.sex" value="女">女
					</c:if>
						<c:if test="${user.sex == '女' }">
							<input type="radio" name="user.sex" value="男">男
					<input type="radio" name="user.sex" value="女" checked>女
					</c:if>
						状态： 
						<c:if test="${user.status == '禁用' }">
							<input type="radio" name="user.status" value="启用">启用
						<input type="radio" name="user.status" value="禁用" checked>禁用
					</c:if>
						<c:if test="${user.status == '启用' }">
							<input type="radio" name="user.status" value="启用" checked>启用
						<input type="radio" name="user.status" value="禁用">禁用
					</c:if>
						&nbsp;&nbsp;&nbsp;部门： <select id="select"
							name="user.department.id">
							<c:forEach var="list" items="${listDepartment }">
							<c:if test="${list.userDepartment == true }">
							   <option value="${list.id }" selected>${list.name }</option>
							 </c:if>
							 <c:if test="${list.userDepartment == false }">
							   <option value="${list.id }">${list.name }</option>
							 </c:if>
							</c:forEach>
						</select>
						<div class="role">
							角色： <select id="select" name="user.role.id">
								<c:forEach var="list" items="${listRole }">
								<c:if test="${list.userRole == true }">
									<option value="${list.id }" selected>${list.name }</option>
								</c:if>
								<c:if test="${list.userRole == false }">
									<option value="${list.id }">${list.name }</option>
								</c:if>
								</c:forEach>
							</select>
						</div>
						<input type="text" name="user.id" value="${user.id }"
							style="display: none;"> <input type="text"
							name="user.createDate" value="${user.createDate }"
							style="display: none;">
					</div>
					<div id="User-button">
						<button type="button" class="update-user">修改</button>　
						<button type="reset" class="abandon-update">重置</button>
					</div>
				</div>
			</div>

		</form>
	</div>
</body>
<script type="text/javascript">
	$(function() {

	})
</script>
