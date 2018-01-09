
			 $(function(){
				 //取消
				 $(".cancel").on("click",function(){
					 $(".buttom-menu").load("showDepartment");
				 });
				$(".btn-add").unbind("click").on("click", function() {
					var $this = $(this);
					 var department = $("#form-department").val();
			          var description = $("#form-description").val();
					 //验证用户输入信息有效性
			        if ($.trim(department) === "") {
			            $("#form-department").focus();
			            alert("部门不允许为空！");
			            return false;
			        } else if ($.trim(description) === "") {
			            $("#form-description").focus();
			            alert("描述不允许为空！");
			            return false;
			        } else {
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
			 								$("#department").trigger("click");
			 					 	}
			 				 });  
			 			}); 
			 		});
			 $(function() {
					//添加页面转跳
					$(".loadadd").on("click",function(){
						$(".buttom-menu").load("loadadd"); 
					}); 
					
					//编辑页面转跳
					$(".btn-edit").unbind("click").on("click", function() {
							var $this=$(this)
							var updateId = $this.data("id");
							$("..buttom-menu").load("edit-Department",{updateId:updateId});
						}); 

						// 批量删除部门信息
						$(".btn-delete").unbind("click").on("click",function(){
							 if ($("input[type='checkbox']:checked").length<=0) {
								 alert("请选择待删除项");
							}else {
								if(confirm("是否确定删除？")){
									$("input[type='checkbox']:checked").each(function(i){
										var checkedId=new Array();
										var $this = $(this);
										// 获取部门id
										 checkedId = $this.data("id")
										// 异步刪除部門信息
										$.ajax({
										url : "batchDeleteDepartment", 
										type : "post",
										dataType : "json", 
										async:"true",
										traditional:"true",
										data : {
											checkedId : checkedId,
										},
										success : function(data) {
											$("#department").trigger("click");
									  	}
									 });  
									});
								}
							}
						 });
						
						//单选删除
						 $(".btn-remove").unbind("click").on("click", function() {
							var $this = $(this);
							// 获取部门id
							var departmentId = $this.data("id");
							 if (confirm("确定需要删除？")) {
								// 异步刪除部門信息
								$.ajax({
								url : "deleteDepartment", 
								type : "post", 
								dataType : "json", 
								data : {
									departmentId : departmentId,
								},
								success : function(data) {
									$("#department").trigger("click");
							  	}
							 });  
							}else{
								alert("删除失败")
							} 
						}); 
						
					});