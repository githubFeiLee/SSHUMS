<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<link rel="stylesheet" type="text/css"
	href="./css/departmentCss/editDepartment.css">

<body>
	<div class="buttom-menus">
		<h2>编辑部门</h2>
		<form id="formId" method="post">
			<input type="hidden" name="department.id" value="${updatDepartment.id }">
			<div class="content-cont">
				<div class="buttom-but">
					<div class="department">
						部门： <input type="text" name="department.name"
							value="${updatDepartment.name}" size="30px">
					</div>
					<div class="description">
						描述：<br>
						　　　<textarea type="text" name="department.description" cols="80"
							rows="10" style="resize: none"
							value="${updatDepartment.description}">${updatDepartment.description}</textarea>
					</div>
					<div class="forget">
						<button type="button" class="btn-edit">提交</button>　
						<button type="button" class="cancel">取消</button>
					</div>
				</div>
			</div>
		</form>
	</div>

	<script type="text/javascript" src="./plugins/jquery_2.1.3.js"></script>
	<script type="text/javascript" src="./js/editDepartment.js"></script>
</body>
