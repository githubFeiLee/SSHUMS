//添加部门
$(function() {
	var $department = $("input[name='department.name']");
	var $description = $("textarea[name='department.description']");
	
	// 取消
	$(".cancel").on("click", function() {
		$(".buttom-menu").load("showDepartment");
	});
	
	$(".btn-add").on("click", function() {
		var $this = $(this);
		var departmentLength = $department.val().length;
		var descriptionLength = $description.val().length;
		// 验证用户输入信息有效性
		if (departmentLength == 0) {
			$department.css("border-color", "red");
			$("#message")[0].innerHTML = "<font color='red'>角色不能为空！</font>";
			return false;
		}

		if (descriptionLength == 0) {
			$description.css("border-color", "red");
			$("#messages")[0].innerHTML = "<font color='red'>描述不能为空！</font>";
			return false;
		}else {
		$.ajax({
			url : "addDepartment",
			type : "post",
			dataType : "json",
			data : $("#form").serialize(),
			success : function(data) {
				$("#department").trigger("click");
			}
		});
		}
	});
});