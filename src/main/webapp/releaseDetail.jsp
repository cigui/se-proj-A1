<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.BookRelease"%>
<%@ page import="model.Book"%>
<%@ page import="model.User"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>阅享</title>
<%
	String path = request.getContextPath();
%>
<script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/bootbox.js/4.4.0/bootbox.min.js"></script>
<script src="<%=path%>/js/index.js"></script>
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<%=path%>/css/login_style.css" rel="stylesheet">
<link href="<%=path%>/css/yxdefault.css" rel="stylesheet">
<link href="<%=path%>/css/index.css" rel="stylesheet">
<!-- <script>
	var userId = "<s:property value='#session.userId' />";
	var logined = "<s:property value='#session.logined' />"; 
</script> -->
</head>
<body>
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
	<div
		class="yx-nav navbar navbar-default navbar-left navbar-static-top yx-nav style="
		width:100%; margin-bottom:0""
		style="width: 100%; margin-bottom: 0">
		<a class="yx-brand navbar-brand" href="index" style="color: cadetblue">阅享图书交流平台</a>
		<div class="yx-toolbar">
			<a class="btn btn-default btn-sm" href="<%=path%>/ReleaseBook">发布图书</a>
			<form class="yx-search-bar">
				<input type="text" name="searchString" placeholder="查询图书" />
				<button class="btn btn-sm btn-primary btn-block" type="submit">Search</button>
			</form>
			<s:if test="#session.logined">
				<span>Hi, <s:property value='#session.userName' />!
				</span>
				<a href="profile" class="btn btn-default btn-sm" role="button">个人信息</a>
				<a href="logout" class="btn btn-default btn-sm" role="button">登出</a>
			</s:if>
			<s:else>
				<button class="btn btn-default btn-sm" data-toggle="modal"
					data-target="#myModal">登录</button>
				<span> or </span>
				<a href="<%=path%>/register.jsp" class="btn btn-default btn-sm"
					role="button">注册</a>
			</s:else>
		</div>
	</div>

	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="Login" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel"></h4>
				</div>
				<form class="modal-body form-signin" action="login">
					<h2 class="form-signin-heading">Please login</h2>
					<input type="email" class="form-control" name="email"
						placeholder="Email Address" required="true" autofocus="" /> <input
						type="password" class="form-control" name="pwd"
						placeholder="Password" required="true" />
					<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
				</form>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>

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
	<div
		class="yx-nav navbar navbar-default navbar-left navbar-static-bottom yx-nav"
		style="width: 100%; margin-bottom: 0">
		<div>联系我们：</div>
		<span>QQ: 123456789</span> <span>Tel: 12345678</span> <span>Email:
			123456789@qq.com</span>
	</div>
</body>
</html>