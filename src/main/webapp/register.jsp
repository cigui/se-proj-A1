<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>阅享 - 注册</title>
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
<script>
	$(document).ready(function() {
		var logined = "<s:property value='#session.logined' />";
		if (logined) {
			bootbox.alert("您已登录，无需注册！", function() {
				location.href = "index";//location.href实现客户端页面的跳转  
			})
		}
	});
</script>
<body>
	<div
		class="yx-nav navbar navbar-default navbar-left navbar-fixed-top yx-nav">
		<a class="yx-brand navbar-brand" href="index" style="color: cadetblue">阅享图书交流平台</a>
	</div>
	<div class="container">
		<div class="row">
			<br>
		</div>
		<div class="row">
			<div class="col-md-12" style="font-size: 28px">注册信息填写</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<br>
				</div>
				<form class="form-horizontal">
					<div class="form-group">
						<div class="col-md-10">
							<div class="form-group">
								<label for="nickName" class="col-md-2 control-label">昵称(*)</label>
								<div class="col-md-6">
									<input type="text" class="form-control" id="nickName"
										placeholder="请输入昵称" required="true">
									<p class="help-block">不超过7个汉字（即14字节）</p>
								</div>
							</div>
							<div class="form-group">
								<label for="email" class="col-md-2 control-label">电子邮箱(*)</label>
								<div class="col-md-6">
									<input type="text" class="form-control" id="email"
										placeholder="请输入电子邮箱" required="true">
								</div>
							</div>
							<div class="form-group">
								<label for="password" class="col-md-2 control-label">密码(*)</label>
								<div class="col-md-6">
									<input type="password" class="form-control" id="password"
										placeholder="请输入密码" required="true">
									<p class="help-block">长度在6至20字符之间</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label">性别</label>
								<div class="col-md-2">
									<input type="radio" class="form-control" id="male"
										name="gender" value="男">男
								</div>
								<div class="col-md-2">
									<input type="radio" class="form-control" id="female"
										name="gender" value="女">女
								</div>
							</div>
						</div>
						<div class="col-md-2">
							<div class="form-group">
								<label for="avatar">个人头像</label> <input
									type="file" id="avatar">
								<p class="help-block">图片大小不得超过4MB</p>
							</div>
						</div>
						<!-- <label for="nickName" class="col-sm-2 control-label">昵称</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="nickName"
								placeholder="请输入昵称">
							<p class="help-block">不超过7个汉字（即14字节）</p>
						</div> -->
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>