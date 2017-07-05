$(function() {
	$.getJSON(path+"/testdata/province.json", {
		parentId : 0
	}, function(data){
		var province = $('#province');
		province.empty();
		province.append("<option disabled selected value></option>");
		for(var i = 0; i < data.length; i++){
			province.append("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
        }
	});
	
	$('#province').change(function(){
		var id = $('#province').val();
		$.getJSON(path+"/testdata/"+id+".json", {
			parentId : id
		}, function(data){
			var city = $('#city');
			city.removeAttr("disabled"); 
			city.empty();
			city.append("<option disabled selected value></option>");
			for(var i = 0; i < data.length; i++){
				city.append("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
	        }
		})
	});
	
	$('#city').change(function(){
		var id = $('#city').val();
		$.getJSON(path+"/testdata/"+3+".json", {
			parentId : id
		}, function(data){
			var district = $('#district');
			district.removeAttr("disabled"); 
			district.empty();
			district.append("<option disabled selected value></option>");
			for(var i = 0; i < data.length; i++){
				district.append("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
	        }
		})
	})
	
	
	
    $("#avatar").change(function(){
        var objUrl = getObjectURL(this.files[0]) ;
        console.log("objUrl = "+objUrl) ;
        if (objUrl) 
        {
            $("#preview").attr("src", objUrl);
        }
    }) ;
    // 获取该文件的url
    function getObjectURL(file) 
    {
        var url = null ;
        if (window.createObjectURL!=undefined) 
        { // basic
            url = window.createObjectURL(file) ;
        }
        else if (window.URL!=undefined) 
        {
            // mozilla(firefox)
            url = window.URL.createObjectURL(file) ;
        } 
        else if (window.webkitURL!=undefined) {
            // webkit or chrome
            url = window.webkitURL.createObjectURL(file) ;
        }
        return url ;
    };
});