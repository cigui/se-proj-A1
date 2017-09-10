<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.User" %>
<%@ page import="model.District" %>
<%@ page import="model.Picture" %>
<%@ taglib prefix="s" uri="/struts-tags"%>


   
<!-- Header -->
<%@ include file="WEB-INF/view/layouts/header.jsp"%>
<script src="<%=path%>/js/updateUserInformation.js"></script>

<body>
	
	<div class="yx-container container">
			<div class="row">
			<br>
		</div>
	    <div class="page-header">
			<h1 class="text-primary">
				查看个人信息
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
									<input type="text" class="form-control" id="nickName" readonly value="<%=user.getNickname()%>" name="nickName"
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
									<select id="gender" name="gender" class="form-control" disabled="disabled">
										
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
							
						</div>
						
					
					
	              
					</div>
					
				</form>
			</div>
		</div>


</body>
<!-- Footer -->
<%@ include file="WEB-INF/view/layouts/footer.jsp"%>