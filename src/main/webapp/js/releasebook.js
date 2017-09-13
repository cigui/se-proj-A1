$(function(){
	/* 添加验证规则，单个汉字占两个字节 */
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
	/* 输入验证 */
	$("#releaseForm").validate({
		/* 验证规则 */
		rules : {
			isbn : {
				required : true,
				rangelength : [13,13]
			},
			discription : {
				required : true,
				byteRangeLength : 140
			},
			price : {
				required : true,
				digits : true,
				min : 0,
				max : 2147483647
			},
			publishDate : "required",
			category1 : "required"	
		},
		/* 验证错误信息  */
		messages : {
			isbn : {
				required : "请输入isbn码",
				rangelength : "请输入13位isbn码"
			},
			discription : {
				required : "请输入书籍描述",
				byteRangeLength : "描述不能超过140字节！（单个汉字占两个字节）"
			},
			price : "请输入正整数积分定价",
			publishDate : "请输入出版日期",
			category1 : "请至少输入1个分类"
		}
	});
	
	/* 获取图书信息并展示  */
	$("#previewInfo").click(function() {
		var value = $('#isbn').val();
		var len = value.length;
		var resultFlag = false;
		/* 检查输入是否为13位 */
		if (len != 13) {
			bootbox.alert("请输入13位isbn码！");
			return false;
		}
		
		/* 首先查找本地数据库中是否有这本书 */
		$.getJSON("getBook", {
			isbn : value
		}, function(data){
			if (data!=null) {
				console.log(data);
				resultFlag = true;
				$('#infoIsbn').text(value);
				$('#infoTitle').text(data.title);
				$('#infoAuthor').text(data.author);
				$('#infoPublisher').text(data.publisher);
				$('#infoTranslator').text(data.translator);
				$('#cover').attr("src","https://img3.doubanio.com/lpic/"+data.coverSrc);
				return true;
			} else {
				/* 如果本地数据库中没有，则需要通过豆瓣api获取书籍信息 */
				$.ajax({
					url : "https://api.douban.com/v2/book/isbn/:"+value,
					type : "GET",
					/* 这里需要设置数据类型为JSONP防止跨域请求不被允许 */
					dataType : "JSONP", 
					success : function(data){
						$('#infoIsbn').text(value);
						$('#infoTitle').text(data.title);
						$('#infoAuthor').text(data.author);
						$('#infoPublisher').text(data.publisher);
						$('#infoTranslator').text(data.translator);
						$('#cover').attr("src",data.images.large);
						/*console.log(data);*/
					},
					error : function() {
						bootbox.alert("请求失败，请检查输入是否正确！");
					}
				});
			}
		})
	})
	
	/* 图片输入验证以及预览 */
	$("#image").change(function() {
		var fileSize = this.files[0].size;
		// 使用正则表达式检查图片格式，如果不是合法图片格式则清空文件输入
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