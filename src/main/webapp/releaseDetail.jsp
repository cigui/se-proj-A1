<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.BookRelease"%>
<%@ page import="model.Book"%>
<%@ page import="model.User"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<!-- Header -->
<%@ include file="WEB-INF/view/layouts/header.jsp"%>
	<%
		BookRelease bookRelease = new BookRelease();
			if (request.getAttribute("bookRelease") != null) {
		bookRelease =(BookRelease) request.getAttribute("bookRelease");
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
					src='releasePicture?r_id=<%=bookRelease.getR_id()%>'/></a>
				<h4>书籍描述：</h4>
				<p><%=bookRelease.getDiscription() %></p>
				<div class = row>
				 
				    <div class = "col-md-5">
				       <button id="join" class="btn btn-sm btn-primary btn-block" >加入借书车</button>
				       <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>  
                       <script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>  
                       <script src="http://bootboxjs.com/bootbox.js"></script>
                       <script>
                       var id = "<s:property value='#session.userId'/>";
                       var r_id = <%=bookRelease.getR_id()%>;
                       $(document).on("click", "#join", function (e){
                    	   jQuery.ajax({
       						url : 'addBookToCart',
       						processData : true,
       						dataType :  "json",
       						data : {
       							id : id,
       							r_id : r_id
       						},
                    	   success : function(data) {
                    		   console.log(data);
                    		if (data == "good"){
                    			 bootbox.alert("加入成功"); 
   							}
   							if (data == "error"){
   								bootbox.alert("加入失败：请检查借出车是否已存在该书籍");
   							}
   							
   							}
                          });
                    	   
                       });
                       </script>  
				    </div>
				    <div class = "col-md-5">
				       <a href="#" class="btn btn-sm btn-primary btn-block" role="button">立即借书</a>
				    </div>
				    <div class = "col-md-1"></div>
				</div>
			</div>
			

		</div>
		

		
		
	</div>
	<!-- Header -->
<%@ include file="WEB-INF/view/layouts/footer.jsp"%>