<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>阅享</title>
<%
	String path = request.getContextPath();
%>
<script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/bootbox.js/4.4.0/bootbox.min.js"></script>
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<%=path%>/css/login_style.css" rel="stylesheet">
<link href="<%=path%>/css/home.css" rel="stylesheet">
<link href="<%=path%>/css/index.css" rel="stylesheet">
</head>
<body>
	<div
		class="yx-nav navbar navbar-default navbar-left navbar-fixed-top yx-nav">
		<a class="yx-brand navbar-brand" href="index" style="color: cadetblue">阅享图书交流平台</a>
		<div class="yx-toolbar">
			<form class="yx-search-bar">
				<input type="text" name="searchString" placeholder="查询图书" />
				<button class="btn btn-sm btn-primary btn-block" type="submit">Search</button>
			</form>
			<button class="btn btn-default btn-sm" data-toggle="modal"
				data-target="#myModal">sign in</button>
			<span> or </span> <a href="<%=path%>/register.jsp"
				class="btn btn-default btn-sm" role="button">sign up</a>
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
				<form class="modal-body form-signin" action="loginAction">
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

	<div class="container">
		<div class="row">
			<div class="col-md-2">
				<ul class="nav nav-list">
					<li class="yx-header nav-header">图书分类</li>
					<li class="active"><a href="#">文学</a></li>
					<li><a href="#">小说</a></li>
					<li><a href="#">传记</a></li>
				</ul>
			</div>
			<div class="col-md-5">
				<div class="row yx-header nav-header">首页推荐</div>
				<div class="covers">
					<a href='#'><img src="<%=path%>/images/404.png" /></a>
					<a href='#'><img src="<%=path%>/images/404.png" /></a>
					<a href='#'><img src="<%=path%>/images/404.png" /></a>
				</div>

			</div>
			<div class="col-md-5">
				<div class="row yx-header nav-header">猜你喜欢</div>
				<div class="covers">
					<a href='#'><img src="<%=path%>/images/404.png" /></a>
					<a href='#'><img src="<%=path%>/images/404.png" /></a>
					<a href='#'><img src="<%=path%>/images/404.png" /></a>
				</div>
			</div>
		</div>
	</div>
	<div
		class="yx-nav navbar navbar-default navbar-left navbar-fixed-bottom yx-nav">
		<div> 联系我们：</div>
		<span>QQ: 123456789</span>
		<span>Tel: 12345678</span>
		<span>Email: 123456789@qq.com</span>
	</div>
</body>
</html>