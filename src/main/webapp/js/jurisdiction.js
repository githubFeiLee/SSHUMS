$(function() {
	var $content = $("#content");
	$table = $content.find("table");

	// 全选
	$table.find(".checkAll").on("click", function() {
		// 获取列表中所有checkbox
		var checkboxItems = $table.find("input[name='checkbox']");
		// alert("").html;
		// 获取列表中选中的checkbox
		var checkedboxItems = $table.find("input[name='checkbox']:checked");

		// 如果两个列表的数量相等，表示所有checkbox都被选中，则反选
		// 反之，则全选
		var isChecked = checkboxItems.length === checkedboxItems.length;

		// 取两个列表长度判断的反值
		checkboxItems.prop("checked", !isChecked);
	});

	

});

/* 添加权限 */
$(function() {
	var $jurisdictionname = $("input[name='jurisdiction.name']");
	var $description = $("textarea[name='jurisdiction.description']");
	$(".btn-confirm").on("click", function() {

		var jurisdictionnameLength = $jurisdictionname.val().length;
		var descriptionLength = $description.val().length;
		if (jurisdictionnameLength == 0) {
			$jurisdictionname.css("border-color", "red");
			$("#message")[0].innerHTML = "<font color='red'>权限不能为空！</font>";
			return false;
		}

		if (descriptionLength == 0) {
			$description.css("border-color", "red");
			$("#messages")[0].innerHTML = "<font color='red'>描述不能为空！</font>";
			return false;
		}

		var $this = $(this);
		var jurisdictionId = $this.data("id");
		$.ajax({
			url : "savejurisdiction",
			type : "post", // 提交的方式
			dataType : "text", // 服务器返回的数据类型
			data : $("#savejurisdicted").serialize(),
			success : function(data) {
				$(".jurisdictionmanage").trigger("click");
			}
		});
	});
});

/* 更新权限信息 */
$(function() {
	$(".btn-submit").on("click", function() {
		$this = $(this);
		var updateId = $this.data("id");
		$.ajax({
			url : "updatejurisdiction", // 数据的提交路径
			type : "post", // 提交的方式
			data : $("#confirmjurisdicted").serialize(),
			success : function(data) {
				$(".jurisdictionmanage").trigger("click", {
					updateId : updateId
				});
			}
		});
	});
});

/* 删除权限 */
$(function() {
	$(".btn-rmv").on("click", function() {
		if (confirm("是否确定删除？")) {
		var jurisdictionId = $(this).data("id");
		$.ajax({
			url : "removejurisdiction", // 数据的提交路径
			type : "post", // 提交的方式
			data : {
				jurisdictionId : jurisdictionId
			},
			success : function() {
				$(".buttom-menu").load("queryjurisdiction");
			}
		});
			}
	});
	/* 批量删除 */
	$(".btn-remove").on("click", function() {
		if ($("input[type='checkbox']:checked").length <= 0) {
			alert("请选择需要删除的权限")
		} else if (confirm("是否确定删除？")) {
			$("input[type='checkbox']:checked").each(function() {
				var jurisdictionid = new Array();
				var $this = $(this)
				checkedId = $(this).data("id");
				$.ajax({
					url : "BatchRemoveJurisdiction", // 数据的提交路径
					type : "post", // 提交的方式
					async : "true",
					traditional : "true",
					data : {
						checkedId : checkedId
					},
					success : function() {
						$(".jurisdictionmanage").trigger("click");
					}
				});
			})
		}
	})
	/* 点击添加跳转页面 */
	$(".btn-save").on("click", function() {
		$(".buttom-menu").load("addjurisdiction")
	});
});
/* 编辑权限信息，获取原来的信息展示在页面上 */
$(".btn-compile").on("click", function() {
	var updateId = $(this).data("id");
	$(".buttom-menu").load("compilejurisdiction", {
		updateId : updateId
	});

});
