<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>阅享 - 注册</title>
<%
	String path = request.getContextPath();
%>
<script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
<script	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/bootbox.js/4.4.0/bootbox.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-validate/1.16.0/jquery.validate.min.js"></script>
<script src="<%=path%>/js/register.js"></script>
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<%=path%>/css/login_style.css" rel="stylesheet">
<link href="<%=path%>/css/yxdefault.css" rel="stylesheet">
<link href="<%=path%>/css/index.css" rel="stylesheet">
<style type="text/css">.error{color: red; font-weight: normal}</style>
</head>
<script>
	var path = "<%=path%>";
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
		class="yx-nav navbar navbar-default navbar-left navbar-static-top yx-nav" style="width:100%; margin-bottom:0">
		<a class="yx-brand navbar-brand" href="index" style="color: cadetblue">阅享图书交流平台</a>
	</div>
	<div class="yx-container container">
		<div class="page-header">
			<h1 class="text-primary">
				注册信息填写
			</h1>
		</div>
		<div class="row">
			<div class="col-md-12">
				<form id="registerForm" class="form-horizontal" style="text-align: center" action="register" method="post"
						enctype="multipart/form-data">
						<!-- 这里的onsubmit属性原本是通过submit后禁用提交按钮来禁止重复提交表单，但这样也会在输入不合法时禁止提交，故暂先注释掉，后期再做修改 -->
						<!-- onsubmit="document.getElementById('submit').disabled=true;" -->
					<div class="form-group">
						<div class="col-md-6">
							<div class="form-group">
								<label for="nickName" class="col-md-2 control-label">昵称(*)</label>
								<div class="col-md-6">
									<input type="text" class="form-control" id="nickName" name="nickName"
										placeholder="请输入昵称" required="true" maxlength="14">
									<p class="help-block">不超过7个汉字（即14字节）</p>
								</div>
							</div>
							<div class="form-group">
								<label for="email" class="col-md-2 control-label">电子邮箱(*)</label>
								<div class="col-md-6">
									<input type="text" class="form-control" id="email" name="email"
										placeholder="请输入电子邮箱" required="true" maxlength="50">
								</div>
							</div>
							<div class="form-group">
								<label for="password" class="col-md-2 control-label">密码(*)</label>
								<div class="col-md-6">
									<input type="password" class="form-control" id="password"
										name="password" placeholder="请输入密码" required="true" maxlength="20">
									<p class="help-block">长度在6至20字符之间</p>
								</div>
							</div>
							<div class="form-group">
								<label for="password" class="col-md-2 control-label">确认密码(*)</label>
								<div class="col-md-6">
									<input type="password" class="form-control" id="confirmPassword"
										name="confirmPassword" placeholder="请再次输入密码" required="true" maxlength="20">
									<p class="help-block">长度在6至20字符之间</p>
								</div>
							</div>
							<div class="form-group">
								<label for="location" class="col-md-2 control-label">所在地(*)</label>
								<div class="col-md-2">
									<label><select id="province" name="province" class="form-control" required="true"></select>省</label>
								</div>
								<div class="col-md-2">
									<label><select id="city" name="city" class="form-control" required="true" disabled="disabled"></select>市</label>
								</div>
								<div class="col-md-2">
									<label><select id="district" name="district" class="form-control" required="true" disabled="disabled"></select>区/县</label>
								</div>
								<p class="help-block">我们将据此为您推荐附近的书:)</p>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label">性别</label>
								<div class="col-md-2 radio">
									<label><input type="radio" class="form-control" id="male"
										name="gender" value="1">男</label>
								</div>
								<div class="col-md-2 radio">
									<label><input type="radio" class="form-control" id="female"
										name="gender" value="0">女</label>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group" style="text-align: center">
								<img id="preview" src="<%=path%>/images/picture-1.jpg" 
								 style="width:256px; height:256px; max-width:256px; max-height:256px"/>
							</div>
							<div class="form-group" style="text-align: center">
								<label for="avatar">个人头像</label>
								<input type="file" id="avatar" name="avatar" style="margin:0 auto">
								<p class="help-block">图片大小不得超过4MB</p>
							</div>
						</div>
					</div>
					<button id="submit" type="submit" class="btn btn-info">注册</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>