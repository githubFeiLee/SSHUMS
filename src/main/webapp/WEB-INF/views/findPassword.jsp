<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>忘记密码</title>
<link rel="stylesheet" type="text/css" href="css/findPasswordStyle.css">
<link rel="stylesheet" type="text/css" href="./iconfont/icon-css/iconfont.css">
</head>

<body>
<div id="whole">
    <div class="logo-panel">
    	<h5>Forget the password interfacial design</h5>
    	<div class="return">
    	<ul>
				<li><a href="toLogin"> <span><i
							class="iconfont icon-tuichu-"></i></span>
				</a></li>
			</ul>
    	</div>
    </div>
        <div class="login-box">
            <h1>找回密码！</h1>
            <form method="post" action="findPassword">
                <div class="name">
                    <label>用户名：</label>
                    <input type="text" name="user.username" placeholder="请输入您的用户名！" minlength="6" maxlength="20" required autofocus tabindex="1" autocomplete="off" />
                </div>
                <div class="password">
                    <label>手机号码：</label>
                    <input type="text" name="user.phone" placeholder="请输入您的手机号码！" minlength="6" maxlength="20"
						required autofocus maxlength="16" id="" tabindex="2" />
                </div>
             <p><font color="red">　${message }</font></p>
                <div class="login">
                    <button type="submit" tabindex="5">提交</button>
                </div>
            </form>
        </div>
    </div>
</body>

</html>