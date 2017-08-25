$(function() {
	var city = null;
	var district = null;
	if ("geolocation" in navigator) {
		var geolocation = new BMap.Geolocation();
		geolocation.getCurrentPosition(getLocation, showError, {
            // 指示浏览器获取高精度的位置，默认为false
            enableHighAccuracy: true,
            // 指定获取地理位置的超时时间，默认不限时，单位为毫秒
            timeout: 5000,
            // 最长有效期，在重复获取地理位置时，此参数指定多久再次获取位置。
            maximumAge: 3000
        })
	} else {
		bootbox.alert("很不幸！你的浏览器并不支持Geolocation API功能", function() {
			location.href = "index";
		});
	}
	
	function getLocation(position) {
		$.getJSON("location", {
			latitude : position.point.lat,
			longitude : position.point.lng
		}, function(result) {
			city = result.city;
			district = result.district;
			$("div.yx-msg").text(
					"根据定位结果，您所在位置为" + city + district + "，下面为您推荐该市借出的图书");
			
			$('#dataTables').DataTable({
				serverSide: true,// 从服务器端获取数据动态加载
				processing: true,// 载入数据时显示“载入中”
	            paging: true,// 分页
	            ordering: false,// 是否启用排序
	            searching: false,// dataTables搜索
	            ajax : {
	            	 type: "post", // 默认get，但据说datatable默认构造的参数很长，有可能超过get的最大长度。
	                 url: "<%=path%>/getPagedBooksbyCity",
	                 dataSrc: "data", // 默认data，也可以写其他的，格式化table的时候取里面的数据
	                 data: function (d) { // d是原始的发送给服务器的数据，默认很长。
	                        var param = {};
	                        param.draw = d.draw; 
	                        param.start = d.start; // 开始的序号
	                        param.length = d.length; // 要取的数据的条数
	                        param.cate = cate;
	                        /* 下面一段代码用于实现页面表单搜索并提交，但这里暂不实现 */
	                        /* var formData = $("#queryForm").serializeArray(); // 把form里面的数据序列化成数组
	                        formData.forEach(function (e) {
	                            param[e.name] = e.value;
	                        }); */
	                        return param; // 自定义需要传递的参数。
	                 }
	            },
	            columns: [ // 对应上面thead里面的序列
	                {"data": "isbn" },
	                {"data": "titleHref" },
	                {"data": "author"}
	            ]
			});
		});
	}
	
	function showError(error) {
		console.log(error.message);
		switch (error.code) {
		case error.PERMISSION_DENIED:
			$("div.yx-msg").text("定位失败，请检查浏览器是否允许定位");
			console.log("User denied the request for Geolocation.");
			break;
		case error.POSITION_UNAVAILABLE:
			$("div.yx-msg").text("定位失败，请稍后再试");
			console.log("Location information is unavailable.");
			break;
		case error.TIMEOUT:
			$("div.yx-msg").text("定位超时，请检查连接");
			console.log("The request to get user location timed out.");
			break;
		case error.UNKNOWN_ERROR:
			$("div.yx-msg").text("定位失败，请稍后再试");
			console.log("An unknown error occurred.");
			break;
		}
	}
});