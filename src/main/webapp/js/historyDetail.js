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
});
