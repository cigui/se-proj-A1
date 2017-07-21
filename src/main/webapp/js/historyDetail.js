$(function() {

	$("#submit").click(function(e) {
		var id = $("input[name='id']").val()
		var score = $("input[name='score']").val();
		console.log(id, score);

		jQuery.ajax({
			url : 'score',
			processData : true,
			dataType : "text",
			data : {
				id : id,
				score : score
			},
			success : function(data) {
				bootbox.alert({
					message : '打分成功',
					callback : function() {
						location.reload();
					}
				});
			}
		})
		
		$('#modal').modal('hide');
	});
	
	$("#confirm").click(function(e) {
		bootbox.confirm({
			buttons : {
				confirm : {
					label : '确认'
				},
				cancel : {
					label : '取消'
				}
			},
			message : '确认收货？',
			callback : function(result) {
				if (result) {
					var id = $("input[name='hid']").val()
					console.log(id);
					jQuery.ajax({
						url : 'confirm',
						processData : true,
						dataType : "text",
						data : {
							id : id
						},
						success : function(data) {
							bootbox.alert({
								message : '确认收货',
								callback : function() {
									location.reload();
								}
							});
						}
					});
				}
			}
		});
	});
	
});
