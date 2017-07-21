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
									r_id : r_id,
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
							var cnt = $(this).data("num");
							checkedItems.push(isbn);
						}
					}
				);
				var jsonstr = JSON.stringify(checkedItems);
				console.log(jsonstr);
				$.getJSON("commitOrder",
				{	
					id : id,
					json : jsonstr
				},
				function(data){
					if (data.error == "stock") {
						bootbox.alert({
							message : '部分书籍库存不足，请至订单页面查看详细信息！',
							callback : function() {
								location.reload();
							}
						});
					} else {
						bootbox.alert({
							message : '成功下单！',
							callback : function() {
								location.reload();
							}
						});
					}
				});
			}
		)
	})