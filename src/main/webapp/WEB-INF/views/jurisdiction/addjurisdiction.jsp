<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>添加权限</title>
<link rel="stylesheet" type="text/css"
	href="./css/jurisdictionCss/addstyle.css">
</head>
<body>
	<div id="container">

		<h2>添加权限</h2>
		<form id="savejurisdicted" method="post">
			<div class="content-cont">
				<div class="buttom-but">
					<div class="jurisdiction">
						权限：<input type="text" name="jurisdiction.name" size="30px"
						placeholder="请输入权限名称"> <span id="message"></span>
					</div>
					<div class="description">
						描述：<br>
						　　　<textarea rows="10" cols="80" name="jurisdiction.description"
							style="resize: none;"></textarea><br><span id="messages"></span>
					</div>
					<div class="forget">
						<button type="reset" class="btn-reset">重置</button>　
						<button type="button" class="btn-confirm">确定</button>
					</div>
				</div>
			</div>
		</form>
	</div>

</body>

<script type="text/javascript" src="./plugins/jquery_2.1.3.js"></script>
<script src="./js/jurisdiction.js">
	
</script>
</html>
