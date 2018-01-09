<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>修改权限</title>
<link rel="stylesheet" type="text/css"
	href="./css/jurisdictionCss/updateJurisdictionStyle.css">
</head>
<body>
	<div id="container">
		<h2>修改权限</h2>
		<form id="confirmjurisdicted" method="post">
			<!-- 添加一个input输入框，将其隐藏，将获取来的当前的id设为它的初始值，当表单提交的时候它也跟着提交了 -->
			<input type="hidden" name="jurisdiction.id"
				value="${updatejurisdiction.id }">
			<div class="content-cont">
				<div class="buttom-but">
					<div class="jurisdiction">
						权限：<input type="text" name="jurisdiction.name"
							value="${updatejurisdiction.name }" size="30px">
					</div>
					<div class="description">
						描述：<br>
						　　　<textarea rows="10" cols="80" name="jurisdiction.description"
							style="resize: none;" value="${updatejurisdiction.description }">${updatejurisdiction.description }</textarea>
					</div>
					<div class="forget">
						<button type="reset" class="reset">重置</button>　
						<button type="button" class="btn-submit">提交</button>
					</div>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript" src="./plugins/jquery_2.1.3.js"></script>
	<script type="text/javascript" src="./js/jurisdiction.js"></script>
</body>
</html>