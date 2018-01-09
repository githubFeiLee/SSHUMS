$(function() {
	$("input[name='user']").on("click", function() {
		// 获取当前元素，指的是获取check-all-btn元素
        var $this = $(this);
        // 让所有checkbox的状态与当前元素保持一致
        $("input[name='usercheck']").prop("checked", $this.prop("checked"));
     });
	$(".button-add").on("click", function() {
			$(".buttom-menu").load("queryRoleAndDepartment");
	});
	
	$("#likeForm").submit(function() {
		$(this).ajaxSubmit({
			target: "#like-panel",
			url : "queryLikeUser",
			type : "post"
		});
		return false;
	});
	
	$(".user-remove").on("click", function() {
		if (confirm("是否确定删除？")) {
			var $this = $(this);
			var userid = $this.data("id")
			$.ajax({
				url : "removeUser",
				type : "post",
				async : "false",
				data : {
					userid : userid
				},
				success : function() {
					$("#page").trigger("click");
					$(".user-remove").unbind('clock');
				}
			})
			
		}
	})
	$(".user-update").on("click", function() {
		var $select = $("input[name='user.department.id']:selected")
		var $this = $(this);
		var userid = $this.data("id")
		$(".buttom-menu").load("queryUpdateUser",{userid:userid});
//		if ($("option").prop("selected") === "selected") {
//			$(this).css("background","green");
//		}
		
	});
	
	$(".button-remove").on("click", function() {
		if ($("input[type='checkbox']:checked").length <= 0) {
			alert("请选择删除项！")
		} else if(confirm("是否确定删除？")){
			
			$("input[type='checkbox']:checked").each(function() {
				var checkedId = new Array();
				var $this = $(this)
				checkedId = $this.data("id")
				$.ajax({
					url : "deleteAllUser",
					type : "post",
					async : "false",
					traditional : "true",
					data : {
						checkedId : checkedId
					},
					success : function() {
						
						$("#page").trigger("click");
						$(".button-remove").unbind('clock');
					}
				})
			})
		}
	})
});