<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.BookRelease"%>
<%@ page import="model.Book"%>
<%@ page import="model.User"%>
<%@ page import="model.Location"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<!-- Header -->
<%@ include file="../layouts/header.jsp"%>
<%
	BookRelease bookRelease = new BookRelease();
	if (request.getAttribute("bookRelease") != null) {
		bookRelease = (BookRelease) request.getAttribute("bookRelease");
	}
%>
<%
	Book book = new Book();
	if (request.getAttribute("book") != null) {
		book = (Book) request.getAttribute("book");
	}
%>
<%
	User user = new User();
	if (request.getAttribute("user") != null) {
		user = (User) request.getAttribute("user");
	}
%>
<%
	Location location = null;
	if (request.getAttribute("location") != null) {
		location = (Location) request.getAttribute("location");
	}
%>


<div class="yx-container container">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-7">
			<h1>
				《<%=book.getTitle()%>》
			</h1>
		</div>
	</div>

	<div class="row">
		<div class="col-md-1"></div>
		<div class="infors col-md-7">
			<div class="row">
				<div class="col-md-3">
					<h3>ISBN码:</h3>
				</div>
				<div class="col-md-7">
					<h3><%=book.getIsbn()%></h3>
				</div>
			</div>
			<p></p>
			<div class="row">
				<div class="col-md-3">
					<h3>作者:</h3>
				</div>
				<div class="col-md-7">
					<h3><%=book.getAuthor()%></h3>
				</div>
			</div>
			<p></p>
			<div class="row">
				<div class="col-md-3">
					<h3>出版社:</h3>
				</div>
				<div class="col-md-7">
					<h3><%=book.getPublisher()%></h3>
				</div>
			</div>
			<p></p>
			<div class="row">
				<div class="col-md-3">
					<h3>翻译:</h3>
				</div>
				<div class="col-md-7">
					<h3><%=book.getTranslator()%></h3>
				</div>
			</div>
			<p></p>
			<div class="row">
				<div class="col-md-3">
					<h3>借出人:</h3>
				</div>
				<div class="col-md-7">
					<h3><%=user.getNickname()%></h3>
				</div>
			</div>
			<p></p>
			<div class="row">
				<div class="col-md-3">
					<h3>借出人所在地:</h3>
				</div>
				<div class="col-md-7">
				<% if (location.getProvince() != null) {%>
					<h3><%=location.getProvince()%>省<%=location.getCity()%>市<%=location.getDistrict()%>区</h3>
				<%} else {%>
					<h3><%=location.getCity()%>市<%=location.getDistrict()%>区</h3>
				<% } %>
				</div>
			</div>
			<p></p>
			<div class="row">
				<div class="col-md-3">
					<h3>信用等级</h3>
				</div>
				<div class="col-md-7">
					<h3><%=user.getCredit()%></h3>
				</div>
			</div>
			<p></p>
			<div class="row">
				<div class="col-md-3">
					<h3>积分</h3>
				</div>
				<div class="col-md-7">
					<h3><%=bookRelease.getPrice()%></h3>
				</div>
			</div>
		</div>
		<div class="col-md-4">
			<a href='releasePicture?r_id=<%=bookRelease.getR_id()%>'><img
				class="img-responsive" id="cover1"
				src='releasePicture?r_id=<%=bookRelease.getR_id()%>' /></a>
			<h4>书籍描述：</h4>
			<p><%=bookRelease.getDiscription()%></p>
			<div class=row>

				<div class="col-md-5">
				<%
				    int id = bookRelease.getId();
					Integer userIdI = (Integer) session.getAttribute("userId");
				    int userId = userIdI==null ? 0 : userIdI;
				    if (id != userId){  %>
				    	<button id="join" class="btn btn-sm btn-primary btn-block">加入借书车</button>
				<%     }
				%>
					
					<script>
						var id = "<s:property value='#session.userId'/>";
						var r_id = <%=bookRelease.getR_id()%>;
						var logined = "<s:property value='#session.logined'/>";
						var r_id =<%=bookRelease.getR_id()%>;
					
						
						$(document).on("click", "#join", function(e) {
							if (logined == false){
								bootbox.alert("请先登陆");
							}
							else{
								jQuery.ajax({
							
								url : 'addBookToCart',
								processData : true,
								dataType : "json",
								data : {
									id : id,
									r_id : r_id
								},
								success : function(data) {
									/* console.log(data); */
									if (data == "good") {
										bootbox.alert("加入成功");
									}
									if (data == "error") {
										bootbox.alert("加入失败：请检查借出车是否已存在该书籍");
									}

								}
							});
							}
        
						});
					</script>
				</div>
				<div class="col-md-5">
				<%
				   
				    if (id != userId){  %>
				    	<button id="borrowNow" class="btn btn-sm btn-primary btn-block" role="button">立即借书</button>
				<%     }
				%>
					
					<script>
 						$("#borrowNow").click(function(){
 							if (logined == false) {
 								bootbox.alert("请先登录！", function() {
 									location.href = "<%=path%>/index";//location.href实现客户端页面的跳转  
 								});
 							} else {
 								bootbox.prompt({
									title : "请输入您的收货地址",
									callback : function(result) {
										$.getJSON("borrowNow", {
											id : id,
											r_id : r_id,
											location : result
										}, function(data) {
											var result = data.result;
											if (result == "success") {
												bootbox.alert("借书成功！", function(){
													location.href = "<%=path%>/index";
												});
											} else if (result == "points") {
												bootbox.alert("积分不足，无法借书:(");
											} else if (result == "borrowed") {
												bootbox.alert("该书已被借出:(");
											} else if (result == "location") {
												bootbox.alert("请先输入收货地址！");
											} else {
												bootbox.alert("未知错误:(");
											}
										});
									}
								});
 							}
						}); 
					</script>
				</div>
				<div class="col-md-1"></div>
			</div>
		</div>
	</div>
</div>
<!-- Footer -->
<%@ include file="../layouts/footer.jsp"%>