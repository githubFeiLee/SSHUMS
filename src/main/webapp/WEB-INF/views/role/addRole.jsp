<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" type="text/css"
	href="./css/roleCss/addRoleStyle.css">
<script type="text/javascript" src="./plugins/jquery_2.1.3.js"></script>
<script type="text/javascript" src="./js/roleManage.js"></script>
<div class="buttom-menus">
	<h2>添加角色</h2>
	<form id="formId" method="post">
		<div class="content-cont">
			<div class="buttom-but">
				<div class="role">
					角色： <input type="text" name="role.name" size="30px"
						placeholder="请输入角色名称"> <span id="message"></span>
				</div>
				<div class="description">
					描述：<br>
					　　　<textarea type="text" name="role.description" cols="80" rows="10"
						style="resize: none"></textarea>
					<span id="messages"></span>
				</div>
				<div class="jur-Panel">
					权限：
					<c:forEach var="list" items="${listJurisdiction }">
						<input type="checkbox" name="role.jurisdictions.id"
							value="${list.id }"> ${list.name }
                                </c:forEach>
				</div>
				<div class="forget">
					<button type="button" class="btn-cancel">取消</button>　
					<button type="button" class="btn-save">保存</button>
				</div>
			</div>
		</div>
	</form>
</div>
