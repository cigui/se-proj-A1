<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%@ page import="model.District" %>
<%@ page import="model.Picture" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>阅享 - 编辑个人信息</title>
<%
	String path = request.getContextPath();
%>
<script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
<script	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/bootbox.js/4.4.0/bootbox.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-validate/1.16.0/jquery.validate.min.js"></script>
<script src="<%=path%>/js/updateUserInformation.js"></script>

<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<%=path%>/css/login_style.css" rel="stylesheet">
<link href="<%=path%>/css/yxdefault.css" rel="stylesheet">
<link href="<%=path%>/css/index.css" rel="stylesheet">
<link href="<%=path%>/css/register.css" rel="stylesheet">
<style type="text/css">.error{color: red; font-weight: normal}</style>
</head>

<body>
	<div
		class="yx-nav navbar navbar-default navbar-left navbar-fixed-top yx-nav">
		<a class="yx-brand navbar-brand" href="index" style="color: cadetblue">阅享图书交流平台</a>
	</div>
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
								<input type="text" class="form-control" id="email" name="email" disabled value="<%=user.getEmail()%>">
								</div>
							</div>
							
							<div class="form-group">
								<label for="email" class="col-md-2 control-label">积分(*)</label>
								<div class="col-md-6">
								<input type="text" class="form-control" id="points" name="points" disabled value="<%=user.getPoints()%>">
								</div>
							</div>
							
							<div class="form-group">
								<label for="email" class="col-md-2 control-label">信用(*)</label>
								<div class="col-md-6">
								<input type="text" class="form-control" id="credit" name="credit" disabled value="<%=user.getCredit()%>">
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
									<label><select id="province"  name="province" class="form-control" required="true"></select>省</label>
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
										name="gender"   value="1">
										男</label>
								</div>
								<div class="col-md-2 radio">
									<label><input type="radio" class="form-control" id="female"
										name="gender" value="0">女</label>
								</div>
							</div>
						</div>
						
						<div class="col-md-6">
							<div class="form-group" style="text-align: center">
								<img id="preview" src="GetAvatar?id" 
								 style="width:256px; height:256px; max-width:256px; max-height:256px"/>
							</div>
							<div class="form-group" style="text-align: center">
								<label for="avatar">个人头像</label>
								<input type="file" id="avatar" name="avatar" style="margin:0 auto">
								<p class="help-block">图片大小不得超过4MB</p>
							</div>
						</div>
						<button class="btn btn-default btn-sm" data-toggle="modal"
					                data-target="#myModal">修改密码</button>
					                
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
					             <h2 class="form-signin-heading">重置密码</h2>
					               <input type="password" class="form-control" id="oldpassword" name="oldpassword"
				           		 placeholder="请输入旧密码" required="true" autofocus="" /> 
				           		<input type="password" class="form-control" id="password"
										name="password" placeholder="请输入新密码(长度在6至20字符之间)" required="true" maxlength="20">
									
								<input type="password" class="form-control" id="confirmPassword"
										name="confirmPassword" placeholder="请再次输入新密码(长度在6至20字符之间)" required="true" maxlength="20">
									
					           <button class="btn btn-lg btn-primary btn-block" type="submit">提交修改</button>
				               </form>
			              </div>
		                     	<!-- /.modal-content -->
		             </div>
		                       <!-- /.modal -->
	              </div>     
	               <button  type="submit" class="btn btn-info" >提交修改</button>   
					</div>
					
				</form>
			</div>
		</div>
	</div>

</body>
</html>