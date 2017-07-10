<%@ page import="java.util.ArrayList"%>
<%@ page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<script src="<%=path%>/js/manageUser.js"></script>
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<%=path%>/css/login_style.css" rel="stylesheet">
<link href="<%=path%>/css/yxdefault.css" rel="stylesheet">
<link href="<%=path%>/css/index.css" rel="stylesheet">
<link href="<%=path%>/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
</head>
<script>
	var admin = "<s:property value='#session.role'/>";
	var path = "<%=path%>";
	var users = "<%=request.getAttribute("users")%>"
	$(document).ready(function() {
		/*if (admin != 2) {
			bootbox.alert("滚吧王八羔子", function() {
				location.href = "index";
			})
		}*/
		if (users == "null") {
			location.href = "listUsers";
		}
	});
</script>

<body>
	<%
		ArrayList<User> userList = new ArrayList<User>();
			if (request.getAttribute("users") != null) {
		userList = (ArrayList<User>) request.getAttribute("users");
			}
	%>
	<div
		class="yx-nav navbar navbar-default navbar-left navbar-static-top yx-nav" style="width:100%; margin-bottom:0">
		<a class="yx-brand navbar-brand" href="index" style="color: cadetblue">阅享图书交流平台</a>
		<div>
			<span>Hi, <%=session.getAttribute("userName")%>!</span>
			<a href="profile" class="btn btn-default btn-sm"
				role="button">个人信息</a>
		</div>
	</div>

	<div class="yx-container container">
		<div class="row">
			<div class="col-md-2">
				<ul class="nav nav-list">
					<li class="yx-header nav-header">管理</li>
					<li class=active><a href="listUsers"><i class="fa fa-user"></i>用户管理</a></li>
					<li><a href="#"><i class="fa fa-book"></i>图书发布管理</a></li>
				</ul>
			</div>
			<div class="covers col-md-10">
							<div class="dataTable_wrapper">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables">
									<thead>
										<tr>
										    <th>ID</th>
											<th>Nickname</th>
											<th>Role</th>
											<th>Credit</th>
											<th><a href="listUsers"><i class="fa fa-refresh"></i></a></th>
										</tr>
									</thead>
									<tbody>
										<%
											for (int i = 0; i < userList.size(); i++) {
																				User user = userList.get(i);
										%>
										<tr>
										    <td><%=user.getId()%></td>
											<td><%=user.getNickname()%></td>
											<td><%=user.getRole()%></td>
											<td><%=user.getCredit()%></td>
											<td>
												<button class="btn btn-default ban" type="button"
													data-id="<%=user.getId()%>">
													<i class="fa fa-ban"></i>
												</button>
												<button class="btn btn-default unban" type="button"
													data-id="<%=user.getId()%>">
													<i class="fa fa-check"></i>
												</button>
											</td>
										</tr>
										<%
											}
										%>
									</tbody>
								</table>
							</div>
			</div>
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