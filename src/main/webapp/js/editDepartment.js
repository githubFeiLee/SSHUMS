//编辑页面
$(function() {
			 //取消
			 $(".cancel").on("click",function(){
				 $(".buttom-menu").load("showDepartment");
			 });
			//保存编辑信息
			$(".btn-edit").on("click", function() {
				var $this = $(this);
				var updatId= $this.data("id");
					$.ajax({
							url : "update", 
							type : "POST", 
							dataType : "json", 
							data : $("#formId").serialize(),
							success : function(data) {
								$("#department").trigger("click",{
									updatId : updatId
								});
					 	}
				 });  
			}); 
		});