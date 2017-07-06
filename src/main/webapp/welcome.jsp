<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>欢迎~:)</title>
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
</head>

<!-- role为0时才显示欢迎页（只对未进行邮箱验证的用户显示欢迎页） -->
<s:if test="#session.role!=0">
	<%
		response.sendRedirect("index");
	%>
</s:if>
<s:else>
	<body>
		<div
			class="yx-nav navbar navbar-default navbar-left navbar-fixed-top yx-nav">
			<a class="yx-brand navbar-brand" href="index"
				style="color: cadetblue">阅享图书交流平台</a>
			<div class="yx-toolbar">
				<a class="btn btn-default btn-sm" href="<%=path%>/ReleaseBook">发布图书</a>
				<form class="yx-search-bar">
					<input type="text" name="searchString" placeholder="查询图书" />
					<button class="btn btn-sm btn-primary btn-block" type="submit">Search</button>
				</form>
				<span>Hi, <s:property value='#session.userName' />!
				</span> <a href="profile" class="btn btn-default btn-sm" role="button">个人信息</a>
				<a href="logout" class="btn btn-default btn-sm" role="button">登出</a>
			</div>
		</div>
		<div class="container">
			<div class="page-header">
				<h1 class="text-primary">
					欢迎来到阅享！<br> <small>我猜我们会发送一封邮件到您注册所用的邮箱，请尽快查看邮箱点击邮件中的链接激活账号:)</small>
				</h1>
			</div>
			<div class="row">
				<div class="col-md-4" style="font-size: 24px; color: #777">或者您也可以：</div>
			</div>
			<div class="row">
				<div class="col-md-6" style="text-align: center">
					<a href="profile" class="btn btn-primary btn-lg">编辑个人信息</a>
				</div>
				<div class="col-md-6" style="text-align: center">
					<a href="index" class="btn btn-primary btn-lg">回到首页</a>
				</div>
			</div>
		</div>
	</body>
</s:else>
</html>