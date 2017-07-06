$(function(){
	$("#releaseForm").validate({
		rules : {
			isbn : {
				required : true,
				rangelength : [13,13]
			},
			discription : "required"
		},
		messages : {
			isbn : {
				required : "请输入isbn码",
				rangelength : "请输入13位isbn码"
			},
			discription : "请输入书籍描述"
		}
	});
	
	$("#image").change(function() {
		var fileSize = this.files[0].size;
		// 使用正则表达式检查图片格式
		if(!/image\/\w+/.test(this.files[0].type)){
			bootbox.alert("请上传图片类型文件！", function(){
				/* 此方法暂未支持IE */
				$("#image").val("");
			});
			return false;
        }
		// console.log("objUrl = " + objUrl);
		if (fileSize > 4 * 1024 * 1024) {
			bootbox.alert("上传的图片不能超过4M！", function(){
				/* 此方法暂未支持IE */
				$("#image").val("");
			});
			return false;
		}
		var objUrl = getObjectURL(this.files[0]);
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
})