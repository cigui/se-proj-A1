<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>阅享 - 发布图书</title>
<%
	String path = request.getContextPath();
%>
<script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/bootbox.js/4.4.0/bootbox.min.js"></script>
<script src="<%=path%>/js/releasebook.js"></script>
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<%=path%>/css/login_style.css" rel="stylesheet">
<link href="<%=path%>/css/yxdefault.css" rel="stylesheet">
<link href="<%=path%>/css/releasebook.css" rel="stylesheet">
</head>
<script>
	var logined = "<s:property value='#session.logined'/>";
/* 	$(document).ready(function() {
		if (logined == "") {
			bootbox.alert("您尚未登录，请先登录！", function(){
				location.href = "index";
			})
		}
	}); */
</script>
<body>
	<div
		class="yx-nav navbar navbar-default navbar-left navbar-fixed-top yx-nav">
		<a class="yx-brand navbar-brand" href="index" style="color: cadetblue">阅享图书交流平台</a>
		<div class="yx-toolbar">
			<a class="btn btn-default btn-sm" href="<%=path%>/ReleaseBook">发布图书</a>
			<form class="yx-search-bar">
				<input type="text" name="searchString" placeholder="查询图书" />
				<button class="btn btn-sm btn-primary btn-block" type="submit">Search</button>
			</form>
			<span>Hi, <s:property value='#session.userName' />!</span>
				<a href="profile" class="btn btn-default btn-sm"
					role="button">个人信息</a>
				<a href="logout" class="btn btn-default btn-sm"
					role="button">登出</a>
		</div>
	</div>

	<div class="container">
		<div class="page-header">
			<h1 class="text-primary">
				书籍信息填写<br> <small>您只需填写书籍的ISBN码，我们会获取书籍的标题、作者等详细信息:)</small>
			</h1>
		</div>

		<div class="row">
			<div class="col-md-8">
				<div role="form">
					<div class="form-group">
						<label for="ISBN">书籍编码</label> 
						<input type="number" maxlength="13" step="1"
							class="form-control" name="ISBN" placeholder="请输入13位ISBN">
					</div>
					<div class="form-group">
						<label for="discription">书籍描述</label> 
						<textarea type="text" maxlength="140" rows="10"
							class="form-control" name="discription"
							placeholder="请输入书籍描述（该书新旧程度、注意事项等等，不超过140字符）"></textarea>
					</div>
					<div class="form-group">
						<label for="price">积分定价</label> 
						<input type="number" maxlength="13" step="1"
							class="form-control" name="price" placeholder="请输入书籍积分定价">
					</div>
				</div>
			</div>
			<div class="col-md-4" style="text-align:center">
				 <br>
				 <div>
				 	<img src="<%=path%>/images/picture-0.png" />
				 </div>
				 <br>
				 <button class="btn btn-info" data-toggle="modal"
						data-target="#uploadPicture" style="width:200px">上传</button>
			</div>
		</div>
		<br>
		<div class="row" style="text-align:center">
			<button class="btn btn-info" data-toggle="modal"
						data-target="#preview" style="width:200px">提交</button>
		</div>
	</div>
	
</body>
</html>