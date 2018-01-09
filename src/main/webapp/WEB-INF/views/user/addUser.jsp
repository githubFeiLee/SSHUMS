<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="./plugins/jquery_2.1.3.js"></script>
<script type="text/javascript" src="./js/addUser.js"></script>
  <link rel="stylesheet" type="text/css" href="iconfont/icon-css/iconfont.css">
  <link rel="stylesheet" type="text/css" href="./css/userCss/addUser.css">
</head>
<body>
	<div class="user-content">
		<div class="add-user">添加用户</div>
		<div class="user-form">
			<form id="userform" method="post">
				账号：<input class="input" type="text" name="user.username"
					placeholder="请输入至少6位数字或字母..." maxlength="16"> <span
					id="message"></span> <br> 
				密码：<input type="password"
					class="input" name="user.password" placeholder="请输入至少6位数字或字母..."
					maxlength="16"><span class="password"></span><br> 
				姓名：<input
					type="text" class="input" name="user.name" placeholder="请输入姓名..."><span
					class="name"></span><br> 
				电话：<input type="text"
					name="user.phone" class="input" placeholder="请输入电话..."><span
					class="phone"></span><br> 
				性别：<input class="user-status"
					type="radio" name="user.sex" value="男" checked>男&nbsp;&nbsp;&nbsp; <input
					type="radio" name="user.sex" value="女">女<br> 
				状态：<input class="user-status"
					type="radio" name="user.status" value="启用" checked>启用 <input
					type="radio" name="user.status" value="禁用">禁用<br> 
				部门：
				<select name="user.department.id">
					<c:forEach var="list" items="${listDepartment }">
						<option value="${list.id }">${list.name }</option>
					</c:forEach>
				</select><br> 
				角色： <select name="user.role.id">
					<c:forEach var="list" items="${listRole }">
						<option value="${list.id }">${list.name }</option>
					</c:forEach>
				</select>
				<div id="user-button">
					<button type="button" id="btn-add">提交</button>　
					<button type="reset" id="btn">重置</button>
				</div>
			</form>
		</div>
	</div>
</body>