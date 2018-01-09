<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录系统</title>
    <link rel="stylesheet" type="text/css" href="css/loginStyle.css">
</head>

<body>
<div id="login-form">
        <div class="top-login">
            <span><img src="image/group.png" alt=""/></span>
        </div>
        <h1>UMS Login</h1>
        <div class="login-top">
            <form  class="form" action="login" method="post">
                <div class="login-ic">
                    <i></i>
                    <input type="text" name="user.username" minlength="6" maxlength="20" required color="blue" placeholder = "请输入用户名" required><span class="inputTip"></span>
                    <div class="clear"> </div>
                </div>
                <div class="login-ic">
                    <i class="icon"></i>
                    <input type="password" minlength="6" maxlength="20" name="user.password" placeholder = "请输入密码" required><span class="inputTip"></span>
                    <div class="clear"> </div>
                </div>
                <br> <font color="red">　　　　　　　<c:if test="${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message =='Bad credentials' }">
                    用户名或密码不正确！
                    </c:if> 
                    <c:if test="${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message !='Bad credentials' }">
                   ${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message }
                    </c:if></font>
                <div class="log-bwn">
                    <input type="submit" value="Login">
                </div>
                <div class="forget"><a href="toFindPassword">忘记密码？</a></div>
            </form>
        </div>
        <p class="copy">Copyright&copy; 疯狂Debug小组</p>
    </div>
</body>

</html>