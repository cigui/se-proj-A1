$(function() {
	$("#registerForm").validate({
		rules : {
			nickName : "required",
			email : {
				required : true,
				email : true
			},
			password : {
				required : true,
				minlength : 6
			},
			confirmPassword : {
				required : true,
				minlength : 6,
				equalTo : "#password"
			},
			province : "required",
			city : "required",
			district : "required"
		},
		messages : {
			nickName : "请输入姓名",
			email : {
				required : "请输入Email地址",
				email : "请输入正确的email地址"
			},
			password : {
				required : "请输入密码",
				minlength : "密码不能小于6个字 符"
			},
			province : "请输入省份",
			city : "请输入城市",
			district : "请输入区\县"
			,
			confirmPassword : {
				required : "请输入确认密码",
				minlength : "确认密码不能小于6个字符",
				equalTo : "两次输入密码不一致"
			}
		}
	});

	$.getJSON(path + "/testdata/province.json", {
		parentId : 0
	}, function(data) {
		var province = $('#province');
		province.empty();
		province.append("<option disabled selected value></option>");
		for (var i = 0; i < data.length; i++) {
			province.append("<option value='" + data[i].id + "'>"
					+ data[i].name + "</option>");
		}
	});

	$('#province').change(
			function() {
				var id = $('#province').val();
				$.getJSON(path + "/testdata/" + id + ".json", {
					parentId : id
				}, function(data) {
					var city = $('#city');
					city.removeAttr("disabled");
					city.empty();
					city.append("<option disabled selected value></option>");
					for (var i = 0; i < data.length; i++) {
						city.append("<option value='" + data[i].id + "'>"
								+ data[i].name + "</option>");
					}
				})
			});

	$('#city')
			.change(
					function() {
						var id = $('#city').val();
						$
								.getJSON(
										path + "/testdata/" + 3 + ".json",
										{
											parentId : id
										},
										function(data) {
											var district = $('#district');
											district.removeAttr("disabled");
											district.empty();
											district
													.append("<option disabled selected value></option>");
											for (var i = 0; i < data.length; i++) {
												district
														.append("<option value='"
																+ data[i].id
																+ "'>"
																+ data[i].name
																+ "</option>");
											}
										})
					})

	$("#avatar").change(function() {
		var objUrl = getObjectURL(this.files[0]);
		console.log("objUrl = " + objUrl);
		if (objUrl) {
			$("#preview").attr("src", objUrl);
		}
	});
	// 获取该文件的url
	function getObjectURL(file) {
		var url = null;
		if (window.createObjectURL != undefined) { // basic
			url = window.createObjectURL(file);
		} else if (window.URL != undefined) {
			// mozilla(firefox)
			url = window.URL.createObjectURL(file);
		} else if (window.webkitURL != undefined) {
			// webkit or chrome
			url = window.webkitURL.createObjectURL(file);
		}
		return url;
	}
	;
});