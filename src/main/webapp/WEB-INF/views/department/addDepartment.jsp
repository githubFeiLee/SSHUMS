<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<link rel="stylesheet" type="text/css"
	href="./css/departmentCss/addDepartment.css">

<div class="top-menu">
	<div class="but">
		<h5>添加部门</h5>
	</div>
</div>
<form id="form" method="post">
	<div class="content-cont">
		<div class="buttom-but">
			<div class="name-department">
				部 门：<input type="text" name="department.name" id="form-department"
					placeholder="请输入部门！" size="30px"> <span id="message"></span><br>
				<br>
			</div>
			<div class="name-descrape">
				描 述：<br>
				　　　<textarea cols="80" rows="10" name="department.description"
					id="form-description" style="resize: none"></textarea><br>
					<span id="messages"></span>
			</div>
		</div>
		<div class="forget">
			<button type="button" class="btn-add">提交</button>　
			<button type="button" class="cancel">取消</button>
		</div>
	</div>
</form>

<script type="text/javascript" src="./plugins/jquery_2.1.3.js"></script>
<script type="text/javascript" src="./js/addDepartment.js"></script>
