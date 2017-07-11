<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Book"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>阅享</title>
<%
	String path = request.getContextPath();
	ArrayList<Book> books = new ArrayList<Book>();
	if (request.getAttribute("bestBooks") != null) {
		books = (ArrayList<Book>) request.getAttribute("bestBooks");
	}
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
	<!-- Header -->
	<div
		class="yx-nav navbar navbar-default navbar-left navbar-static-top yx-nav"
		style="width: 100%; margin-bottom: 0">
		<a class="yx-brand navbar-brand" href="index" style="color: cadetblue">阅享图书交流平台</a>
		<div class="yx-toolbar">
			<a class="btn btn-default btn-sm" href="<%=path%>/releasebook.jsp">发布图书</a>
			<form class="yx-search-bar">
				<input type="text" name="searchString" placeholder="查询图书" />
				<button class="btn btn-sm btn-primary btn-block" type="submit">Search</button>
			</form>
			<s:if test="#session.logined">
<<<<<<< HEAD
				<span>Hi, <s:property value='#session.userName' />!</span>
				<a href="GetBeforeUpdateUserInformation" class="btn btn-default btn-sm"
					role="button">个人信息</a>
				<a href="logout" class="btn btn-default btn-sm"
					role="button">登出</a>
=======
				<span>Hi, <s:property value='#session.userName' />!
				</span>
				<a href="profile" class="btn btn-default btn-sm" role="button">个人信息</a>
				<a href="logout" class="btn btn-default btn-sm" role="button">登出</a>
>>>>>>> 03f7a833cb565f8f6cca655bf7af104c6f2349fa
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

	<!-- Modal for login -->
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

	<!-- Body -->
	<div class="yx-container container">
		<div class="row">
			<div class="col-xs-2 col-md-2">
				<ul class="nav nav-list">
					<li class="yx-header nav-header">图书分类</li>
					<li class="active"><a href="#">文学</a></li>
					<li><a href="#">小说</a></li>
					<li><a href="#">传记</a></li>
				</ul>
			</div>
			<div class="covers col-xs-5 col-md-5">
				<div class="row">
					<div class="col-xs-5 col-md-9">
						<span class="yx-header nav-header">首页推荐</span>
					</div>
					<div class="col-xs-1 col-md-1">
						<span><a class="btn btn-default btn-sm"
							href="<%=path%>/Recommend">更多</a></span>
					</div>
				</div>
				<div class="row">
					<%
						for (int i = 0; (i < 3) && (i < books.size()); i++) {
							Book book = books.get(i);
					%>
					<div class="col-xs-6 col-md-6">
						<div class="cover">
							<a href='bookdetails?isbn=<%=book.getIsbn()%>'><img
								src="https://img3.doubanio.com/lpic/<%=book.getCoverSrc()%>" /></a>
						</div>
					</div>
					<%
						}
					%>
				</div>

			</div>
			<div class="covers col-xs-5 col-md-5">
				<div class="row">
					<div class="col-xs-5 col-md-9">
						<span class="yx-header nav-header">猜你喜欢</span>
					</div>
					<div class="col-xs-1 col-md-1">
						<span><button class="btn btn-default btn-sm yx-guess">换一批</button></span>
					</div>
				</div>
				<div class="row">
					<%
						for (int i = 0; (i < 3) && (i < books.size()); i++) {
							Book book = books.get(i);
					%>
					<div class="col-xs-6 col-md-6">
						<div class="cover">
							<a id="link<%=i%>" href='#'><img
								src="https://img3.doubanio.com/lpic/<%=book.getCoverSrc()%>"
								id="cover<%=i%>" /></a>
						</div>
					</div>
					<%
						}
					%>
				</div>
			</div>
		</div>
	</div>

	<!-- Footer -->
	<div
		class="yx-nav navbar navbar-default navbar-left navbar-static-bottom yx-nav"
		style="width: 100%; margin-bottom: 0">
		<div>联系我们：</div>
		<span>QQ: 123456789</span> <span>Tel: 12345678</span> <span>Email:
			123456789@qq.com</span>
	</div>
</body>
</html>