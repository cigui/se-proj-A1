$(function() {
	// 中文字两个字节
	$.validator.addMethod("byteRangeLength", function(value, element, param) {
		var length = value.length;
		for(var i = 0; i < value.length; i++) {
			if(value.charCodeAt(i) > 127) {
				length++;
			}
		}
		if (length > param) {
			return false;
		}
		else {
			return true;
		}
	});
	$("#UpdateUserInformationForm").validate({
		rules : {
			nickName : {
				required : true,
				byteRangeLength : 14
			},
			
			oldpassword : {
				
				minlength : 6,
				equalTo : prepassword
				
				
				
			},
				password : {
					
					minlength : 6
					
					
				},
				confirmPassword : {
					
					minlength : 6,
					equalTo : "#password"
		},
		province : "required",
		city : "required",
		district : "required"
			},
			
		messages : {
			nickName : {
				required : "请输入昵称",
				byteRangeLength : 14
			},
           oldpassword : {
				
				minlength : "密码不能小于6个字符",
				equalTo : "与旧密码不一致"
					
			},
			password : {
				
				minlength : "密码不能小于6个字符"
					
			},
			confirmPassword : {
				minlength : "确认密码不能小于6个字符",
				equalTo : "两次输入密码不一致"
			}
		},
		});
	
    
    
    
    $("#gender option[value='" + pregender + "']").attr("selected","selected");
    


	$("#avatar").change(function() {
		var objUrl = getObjectURL(this.files[0]);
		var fileSize = this.files[0].size;
		// 使用正则表达式检查图片格式
		if(!/image\/\w+/.test(this.files[0].type)){
			bootbox.alert("请上传图片类型文件！", function(){
				/* 此方法暂未支持IE */
				$("#avatar").val("");
			});
			return false;
        }
		// console.log("objUrl = " + objUrl);
		if (fileSize > 4 * 1024 * 1024) {
			bootbox.alert("上传的图片不能超过4M！", function(){
				/* 此方法暂未支持IE */
				$("#avatar").val("");
			});
			return false;
		}
		if (objUrl) {
			$("#preview").attr("src", objUrl);
		}
		return true;
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
	};
});