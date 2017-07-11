<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<head>
<%
	String path = request.getContextPath();
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>阅享</title>
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
</head>
<body>
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