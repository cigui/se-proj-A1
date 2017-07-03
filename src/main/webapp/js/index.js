$(function() {
	$("button.yx-guess").click(
			function() {
				$.getJSON(path+"/testdata/guess.json"/*, {
					id : userId
				}*/, function(json) {
					/* 
					 * format of the return json data:
					 * {
					 * 		link1 : #,
					 * 		cover1 : #,
					 * 		link2 : #,
					 * 		cover2 : #,
					 * 		link3 : #,
					 * 		cover3 : #,
					 * }
					 */
					$("#cover1").attr('src',json.cover1); 
					$("#cover2").attr('src',json.cover2); 
					$("#cover3").attr('src',json.cover3); 
					
					$("#link1").attr('href',json.link1); 
					$("#link2").attr('href',json.link2); 
					$("#link3").attr('href',json.link3); 
					
				});
			}
	)
});