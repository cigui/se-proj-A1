
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.User" %>
<%@ page import="model.District" %>
<%@ page import="model.Picture" %>
<%@ taglib prefix="s" uri="/struts-tags"%>


   
<!-- Header -->
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
<script
	src="https://cdn.bootcss.com/jquery-validate/1.16.0/jquery.validate.min.js"></script>
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<%=path%>/css/login_style.css" rel="stylesheet">
<link href="<%=path%>/css/yxdefault.css" rel="stylesheet">
<link href="<%=path%>/css/index.css" rel="stylesheet">
<link href="<%=path%>/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div
		class="yx-nav navbar navbar-default navbar-left navbar-static-top yx-nav"
		style="width: 100%; margin-bottom: 0">
		<a class="yx-brand navbar-brand" href="<%=path%>" style="color: cadetblue">阅享图书交流平台</a>
		<div class="yx-toolbar">
			<a class="btn btn-default btn-sm" href="<%=path%>/goReleaseBook">发布图书</a>
			<a class="btn btn-default btn-sm" href="<%=path%>/goBooksNearby">附近的书</a>
			<form class="yx-search-bar" action="<%=path%>/searchBook">
				<input type="text" name="searchString" placeholder="查询图书" />
				<button class="btn btn-sm btn-default btn-block" type="submit"><i class="fa fa-search"></i></button>
			</form>
			<s:if test="#session.logined">
				<span>Hi, <s:property value='#session.userName' />!
				</span>
				<s:if test="#session.isAdmin">
					<a href="listUsers" class="btn btn-default btn-sm" role="button">管理中心</a>
				</s:if>
				<div class="btn-group">
					<button type="button" class="btn btn-sm btn-default dropdown-toggle"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<i class="fa fa-navicon"></i>
					</button>
					<ul class="dropdown-menu dropdown-menu-right" style="min-width: 100%;">
						<li><a href="GetBeforeUpdateUserInformation">个人信息</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="GetBeforeUpdatePassword">修改密码</a></li>
						<li><a href="GetBeforeUpdateLocation">修改地区</a></li>
						<li><a href="history">我的历史</a></li>
						<li><a href="getCart">我的借书车</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="logout">登出</a></li>
					</ul>
				</div>
			</s:if>
			<s:else>
				<button class="btn btn-default btn-sm" data-toggle="modal"
					data-target="#myModal">登录</button>
				<span> or </span>
				<a href="<%=path%>/goRegister" class="btn btn-default btn-sm"
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

<script src="<%=path%>/js/updateUserInformation.js"></script>

<body>
	
	<div class="yx-container container">
			<div class="row">
			<br>
		</div>
	    <div class="page-header">
			<h1 class="text-primary">
				编辑个人信息
			</h1>
		</div>
		
			<div class="col-md-12">
				<div class="row">
					<br>
				</div>
				<form id="UpdateUserInformationForm" class="form-horizontal" style="text-align: center" action="updateUserInformation" method="post"
						enctype="multipart/form-data" onsubmit="document.getElementById('sub').disabled=true;">
		   
		      <% User user = new User();
              if (request.getAttribute("user") != null) {
                 user = (User) request.getAttribute("user");}%>	
<% District district = new District();
   if (request.getAttribute("district") != null) {
   district = (District) request.getAttribute("district");}%>	
<% District city = new District();
   if (request.getAttribute("city") != null) {
   city = (District) request.getAttribute("city");}%>	
<% District province = new District();
   if (request.getAttribute("province") != null) {
   province = (District) request.getAttribute("province");}%>	
		       <script>var prepassword="<%=user.getPassword()%>"
			           var pregender="<%=user.getGender()%>"
				       var predistrict="<%=district.getName()%>"
				       var precity="<%=city.getName()%>"  
				       var preprovince="<%=province.getName()%>"
					   var id=<%=user.getId()%>
			   </script>	
			  
					<div class="form-group">
					   <div class="col-md-6">
						    <div class="form-group">
							<label for="email" class="col-md-2 control-label">电子邮箱(*)</label>
								<div class="col-md-6">
								<input type="text" class="form-control" id="email" name="email" readonly value="<%=user.getEmail()%>">
								</div>
							</div>
							
							
							
							<div class="form-group">
								<label for="email" class="col-md-2 control-label">积分(*)</label>
								<div class="col-md-6">
								<input type="text" class="form-control" id="points" name="points" readonly value="<%=user.getPoints()%>">
								</div>
							</div>
							
							<div class="form-group">
								<label for="email" class="col-md-2 control-label">信用(*)</label>
								<div class="col-md-6">
								<input type="text" class="form-control" id="credit" name="credit" readonly value="<%=user.getCredit()%>">
								</div>
							</div>
							
							
							<div class="form-group">
								<label for="nickName" class="col-md-2 control-label">昵称(*)</label>
								<div class="col-md-6">
									<input type="text" class="form-control" id="nickName" value="<%=user.getNickname()%>" name="nickName"
										placeholder="请输入昵称" required="true" maxlength="14">
									<p class="help-block">不超过7个汉字（即14字节）</p>
								</div>
							</div>
							
						
							<div class="form-group">
								<label for="location" class="col-md-2 control-label">所在地(*)</label>
								<div class="col-md-2">
									<input type="text" class="form-control" id="province" name="province" readonly value="<%=province.getName()%>"><label>省</label>
								</div>
								<div class="col-md-2">
									<input type="text" class="form-control" id="city" name="city" readonly value="<%=city.getName()%>"><label>市</label>
								</div>
								<div class="col-md-2">
									<input type="text" class="form-control" id="district" name="district" readonly value="<%=district.getName()%>"><label>区/县</label>
								</div>
								<p class="help-block">我们将据此为您推荐附近的书:)</p>
							</div>
							
							<div class="form-group">
							<label class="col-xs-3 col-md-2 control-label">性别</label>
							<div class="col-xs-4 col-md-2">
								<label>
									<select id="gender" name="gender" class="form-control">
										
										<option value="1">男</option>
										<option value="0">女</option>
									</select>
								</label>
							</div>
						</div>
						
						
						</div>
						
						<div class="col-md-6">
							<div class="form-group" style="text-align: center">
							    
							    <img  id="preview"
					             src='GetAvatar?id=<%=user.getId()%>'
								 style="width:256px; height:256px; max-width:256px; max-height:256px"/>
							</div>
							<div class="form-group" style="text-align: center">
								<label for="avatar">个人头像</label>
								<input type="file" id="avatar" name="avatar" style="margin:0 auto">
								<p class="help-block">图片大小不得超过4MB</p>
							</div>
						</div>
						
					
					
	               <button  type="submit" class="btn btn-info" >提交修改</button>   
					</div>
					
				</form>
			</div>
		</div>


</body>
<!-- Footer -->
<%@ include file="WEB-INF/view/layouts/footer.jsp"%>