$(function() {
	$("button.yx-guess").click(
			function() {
				$.getJSON(path+"/testdata/guess.json"/*, {
					id : userId
				}*/, function(json) {
					/* 
					 * format of the return json data:
					 * {
					 * 		link0 : #,
					 * 		cover0 : #,
					 * 		link1 : #,
					 * 		cover1 : #,
					 * 		link2 : #,
					 * 		cover2 : #,
					 * }
					 */
					$("#cover0").attr('src',json.cover0); 
					$("#cover1").attr('src',json.cover1); 
					$("#cover2").attr('src',json.cover2); 
					
					$("#link0").attr('href',json.link0); 
					$("#link1").attr('href',json.link1); 
					$("#link2").attr('href',json.link2); 
					
				});
			}
	)
});