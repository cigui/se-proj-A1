<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
	<div
		class="yx-nav navbar navbar-default navbar-left navbar-static-top yx-nav style="width:100%; margin-bottom:0""
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
				<h1>书籍名</h1>
			</div>

		</div>

		<div class="row">
			<div class="col-md-1"></div>
			<div class="infors col-md-6">
				<div class="row">
					<div class="col-md-3">
						<h3>ISBN码:</h3>
					</div>
					<div class="col-md-7">
						<h3>假装有码</h3>
					</div>
				</div>
				<p></p>
				<div class="row">
					<div class="col-md-3">
						<h3>作者:</h3>
					</div>
					<div class="col-md-7">
						<h3>假装有作者</h3>
					</div>
				</div>
				<p></p>
				<div class="row">
					<div class="col-md-3">
						<h3>出版社:</h3>
					</div>
					<div class="col-md-7">
						<h3>假装有出版社</h3>
					</div>
				</div>
				<p></p>
				<div class="row">
					<div class="col-md-3">
						<h3>翻译:</h3>
					</div>
					<div class="col-md-7">
						<h3>翻译</h3>
					</div>
				</div>
			</div>
			<div class="col-md-5">
				<a id="link1" href='#'><img class="img-responsive" id="cover1"
					src="<%=path%>/images/picture-0.png" /></a>
			</div>

		</div>
		<div class="row">
			<p></p>
		</div>
		<div class="row">
			<p></p>
		</div>
		<div class="row">
			<p></p>
			<div class="row">
				<div class="col-md-1"></div>
				<div class="covers col-md-5">
					<div class="row">
						<div class="col-md-9">
							<span class="yx-header nav-header">图书借阅</span>
						</div>
						<div class="col-md-1">
							<span><a class="btn btn-default btn-sm"
								href="<%=path%>/Recommend">更多</a></span>
						</div>
					</div>
					<div class="cover">
						<a href='#'><p></a>
					</div>
					<div class="cover">
						<a href='#'><p></a>
					</div>
					<div class="cover">
						<a href='#'><p></a>
					</div>

				</div>
				<div class="covers col-md-5">
					<div class="row">
						<div class="col-md-9">
							<span class="yx-header nav-header">图书评论</span>
						</div>
						<div class="col-md-1">
							<button class="btn btn-default btn-sm" data-toggle="modal"
								data-target="#myComment">我也想评</button>
						</div>
					</div>
					<div class="cover">
						<p></p>
					</div>
					<div class="cover">
						<p></p>
					</div>
					<div class="cover">
						<p></p>
					</div>
				</div>
			</div>
		</div>

		<div class="modal fade" id="myComment" tabindex="-1" role="dialog"
			aria-labelledby="BookComment" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel"></h4>
					</div>
					<form class="modal-body form-bookcomment" action="sendBookComment">
						<h2 class="form-bookcomment-heading">我的评论</h2>
						<input type="number" class="form-bookcontrol" name="score"
							placeholder=" 请输入评分（0-10分）" required="true" autofocus="" />
						<textarea maxlength="140" rows="10" required="true"
							class="form-control" id="discription" name="discription"
							placeholder="请输入书籍评价（不超过140字符）"></textarea>
						<button class="btn btn-lg btn-primary btn-block" type="submit">发表评论</button>
					</form>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>
	</div>
	<div
		class="yx-nav navbar navbar-default navbar-left navbar-static-bottom yx-nav" style="width:100%; margin-bottom:0">
		<div>联系我们：</div>
		<span>QQ: 123456789</span> <span>Tel: 12345678</span> <span>Email:
			123456789@qq.com</span>
	</div>
</body>
</html>