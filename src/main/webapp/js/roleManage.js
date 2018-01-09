$(function() {
	var $rolename = $("input[name='role.name']");
	var $description = $("textarea[name='role.description']");
	
	// 点击保存将数据保存到数据库中
	$(".btn-save").unbind("click").on("click", function() {
		var rolenameLength = $rolename.val().length;
		var descriptionLength = $description.val().length;
		if(rolenameLength==0){
			$rolename.css("border-color","red");
			$("#message")[0].innerHTML = "<font color='red'>角色不能为空！</font>";
			return false;
		    }
		
		if(descriptionLength==0){
			$description.css("border-color","red");
			$("#messages")[0].innerHTML = "<font color='red'>描述不能为空！</font>";
			return false;
		    }
		
		var $this = $(this);
		var jurisdictionId = $this.data("id")
		$.ajax({
			type : "POST",
			url : "saveRole",
			data : $('#formId').serialize(),
			async : true,
			success : function(data) {
				$(".queryRole").trigger("click", {
					jurisdictionId : jurisdictionId
				});
			}
		});
	});

	// 点击取消返回角色信息界面
	$(".btn-cancel").unbind("click").on("click", function() {
		$.ajax({
			type : "POST",
			url : "queryRole",
			success : function(data) {
				$(".queryRole").trigger("click");
			}
		});
	});
});

$(function() {
	// 删除角色信息
	$(".removeRole").unbind("click").on("click", function() {
		if (confirm("是否确定删除？")) {
		var $this = $(this)
		var roleId = $this.data("id");
		$.ajax({
			url : "removeRole",
			type : "post",
			async : "true",
			data : {
				roleId : roleId
			},
			success : function(data) {
				$(".queryRole").trigger("click");
			}
		});
		}
	});

	// 以id查询需要修改的角色信息并展示在页面
	$(".queryUpdateRole").unbind("click").on("click", function() {
		var $this = $(this)
		var updateRoleId = $this.data("id");
		$(".buttom-menu").load("queryUpdateRole", {
			updateRoleId : updateRoleId
		});
	});
});

$(function() {
	// 点击添加角色按钮
	$(".but-add").on("click", function() {
		$(".buttom-menu").load("loadAdd");
	});

	// 批量删除角色信息
	$(".but-remove").unbind("click").on("click", function() {
		if ($("input[type='checkbox']:checked").length <= 0) {
			alert("请选择您的删除项！");
		} 
			$("input[type='checkbox']:checked").each(function() {
				var checkedId = new Array();
				var $this = $(this);
				checkedId = $this.data("id")
				$.ajax({
					url : "batchRemoveRole",
					type : "post",
					async : "true",
					traditional : "true",
					data : {
						checkedId : checkedId
					},
					success : function() {
						$(".queryRole").trigger("click")
					}
				})
			});
		
	});
});

$(function() {
	// 修改角色信息并保存
	$(".btn-saves").on("click", function() {
		var $this = $(this);
		var jurisdictionId = $this.data("id")
		$.ajax({
			type : "POST",
			url : "saveOrUpdateRole",
			data : $('#updateRoleForm').serialize(),
			async : true,
			success : function(data) {
				$(".queryRole").trigger("click", {
					jurisdictionId : jurisdictionId
				});
			}
		});
	});
});
