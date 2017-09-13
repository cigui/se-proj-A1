$(function() {
	$("button.bs-delete").click(
		function(){
			var r_id = $(this).data("bid");
			var item = $(this).parent().parent();
			bootbox.confirm({
					buttons : {
						confirm : {
							label : 'Delete'
						},
						cancel : {
							label : 'Cancel'
						}
					},
					message : 'Serious?',
					callback : function(result) {
						if (result) {
							$.getJSON('deleteFromShoppingCart',
								{
								id : id,
								r_id : r_id	
								},
								function(json) {
									if (json.error=="undefined") {
										bootbox.alert({
											message : '未知错误！',
											callback : function() {
												location.reload();
											}
										});
									} else {
										bootbox.alert({
											message : '成功删除！',
											callback : function() {
												item.remove();
											}
										});
									}
								}
							)
						}
					}
			});
		}
	);
	
	$("button.bs-place").click(
			function() {
				var checkedItems = [];
				$("[name='checkbox']").each(
					function() {
						if (this.checked) {
							var r_id = $(this).data("bid");
							checkedItems.push(r_id);
						}
					}
				);
				
				var jsonstr = JSON.stringify(checkedItems);
				console.log(jsonstr);
				
				bootbox.prompt({
					title : "请输入您的收货地址",
					callback : function(result) {
						$.getJSON("placeOrder", {
							id : id,
							json : jsonstr,
							location : result
						}, function(json) {
							if (json.error=="undefined") {
								bootbox.alert({
									message : '未知错误！',
									callback : function() {
										location.reload();
									}
								});
							} else {
								bootbox.alert({
									message : '借书成功！',
									callback : function() {
										location.href = "index";
									}
								});
							}
						});
					}
				});
				});
	})