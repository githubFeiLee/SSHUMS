$(function() {
 
	var $username = $("input[name='user.username']");
	var $password = $("input[name='user.password']");
	var $phone = $("input[name='user.phone']");
	var $inputname = $("input[name='user.name']");
	var $status = $("input[name='user.status']");
	$(".button-add").on("click", function() {
		$(".buttom-menu").load("queryRoleAndDepartment");
	});

	//验证用户名是否存在
	
	$username
			.bind(
					'input propertychange',
					function() {
						var contentLength = $username.val().length;
						if (contentLength >= 6) {
							$
									.ajax({
										url : "verification",
										type : "post",
										dataType : "json",
										data : {
											name : $username.val()
										},
										success : function(data) {
											if (data.userid === 1) {
												$("#message")[0].innerHTML = "<font color='red'>用户名已存在！</font>";
											} else {
												$("#message")[0].innerHTML = "<font color='green'>用户名可以使用！</font>";
											}
										}
									})
						}
					})
	
	/*
	保存用户信息
	 */
	$("#btn-add").unbind("click").on(
			"click",
			function() {
				var usernameLength = $username.val().length;
				var passwordLength = $password.val().length;
				var phoneLength = $phone.val().length;
				var inputnameLength = $inputname.val().length;
				
			
				if(usernameLength==0){
					$username.css("border-color","red");
					$("#message")[0].innerHTML = "<font color='red'>账号不能为空！</font>";
					return false;
				}else if(usernameLength<6){
					$username.css("border-color","red");
					$("#message")[0].innerHTML = "<font color='red'>不少于6位数字或字母！</font>";	
					return false;
				}
				if(passwordLength==0){
					$password.css("border-color","red");
					$(".password")[0].innerHTML = "<font color='red'>密码不能为空！</font>";
					return false;
				}else if(passwordLength<6){
					$password.css("border-color","red");
					$(".password")[0].innerHTML = "<font color='red'>不少于6位数字或字母！</font>";	
					return false;
				}else if(passwordLength>=6){
					$password.css("border-color","");
					$(".password")[0].innerHTML = "<font color='green'>√</font>";
				}
				if(inputnameLength==0){
					$inputname.css("border-color","red");
					$(".name")[0].innerHTML = "<font color='red'>姓名不能为空！</font>";
					return false;
				}
				if(phoneLength==0){
					$phone.css("border-color","red");
					$(".phone")[0].innerHTML = "<font color='red'>电话不能为空！</font>";
					return false;
				}
				
				if (usernameLength >= 6 && passwordLength >= 6
						&& phoneLength > 0 && inputnameLength > 0) {
					$.ajax({
						url : "save",
						sync : "true",
						type : "post",
						dataType:"json",
						data : $("#userform").serialize(),
						success : function() {
							$("#page").trigger("click");
							$("#btn-add").unbind('clock');
						}
					})
				} else {
					return false;
				}

			})
});