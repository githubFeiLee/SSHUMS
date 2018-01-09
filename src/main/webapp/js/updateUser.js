$(function() {
	/*
	修改用户信息
	将用户信息修改后使用ajax将修改后的信息传送到后台进行修改
	 */
	$(".update-user").on("click", function() {
		$.ajax({
			url : "saveOrUpdateUser",
			async : "false",
			type : "post",
			data : $("#updateUserForm").serialize(),
			success : function() {
				$("#page").trigger("click");
			}
		})
	})
});