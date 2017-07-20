$(function() {

	$(".ban").click(function(e) {
		bootbox.confirm({
			buttons : {
				confirm : {
					label : 'Ban'
				},
				cancel : {
					label : 'Cancel'
				}
			},
			message : 'Sure to ban this BookRelease?',
			callback : function(result) {
				if (result) {
					var dataset = e.currentTarget.dataset;
					var id = dataset.id;
					jQuery.ajax({
						url : 'manageBook',
						processData : true,
						dataType : "text",
						data : {
							r_id : id,
							status : 0
						},
						success : function(data) {
							bootbox.alert({
								message : 'Ban Successfully! ',
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
	
	$(".unban").click(function(e) {
		bootbox.confirm({
			buttons : {
				confirm : {
					label : 'Pass'
				},
				cancel : {
					label : 'Cancel'
				}
			},
			message : 'Sure to pass this BookRelease?',
			callback : function(result) {
				if (result) {
					var dataset = e.currentTarget.dataset;
					var id = dataset.id;
					jQuery.ajax({
						url : 'manageBook',
						processData : true,
						dataType : "text",
						data : {
							r_id : id,
							status : 1
						},
						success : function(data) {
							bootbox.alert({
								message : 'Pass Successfully! ',
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
