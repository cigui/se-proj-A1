<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.BorrowHistory"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>阅享</title>
<%
	String path = request.getContextPath();
%>
<script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/bootbox.js/4.4.0/bootbox.min.js"></script>
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<%=path%>/css/yxdefault.css" rel="stylesheet">
<link href="<%=path%>/css/index.css" rel="stylesheet">
<!-- <script>
	var userId = "<s:property value='#session.userId' />";
	var logined = "<s:property value='#session.logined' />"; 
</script> -->
</head>
<body>
	<%
		ArrayList<BorrowHistory> historyList = new ArrayList<BorrowHistory>();
		if (request.getAttribute("history") != null) {
			historyList = (ArrayList<BorrowHistory>) request.getAttribute("history");
		}
	%>
	<!-- Header -->
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
			<span>Hi, <s:property value='#session.userName' />!</span>
			<a href="profile" class="btn btn-default btn-sm" role="button">个人信息</a>
			<a href="logout" class="btn btn-default btn-sm" role="button">登出</a>
		</div>
	</div>
	
	<div class="yx-container container">
		<div class="row">
			<div class="col-xs-2 col-md-2">
				<ul class="nav nav-list">
					<li class="yx-header nav-header">历史记录</li>
					<li><a href="#">已发布的图书</a></li>
					<li><a href="#">已借出的图书</a></li>
					<li><a href="history?id=<%=session.getAttribute("userId")%>&status=0">已下单的图书</a></li>
					<li><a href="history?id=<%=session.getAttribute("userId")%>&status=1">已借到的图书</a></li>
				</ul>
			</div>
			<div class="covers col-md-10">
				<div class="dataTable_wrapper">
					<table class="table table-striped table-bordered table-hover"
						id="dataTables">
						<thead>
							<tr>
								<th>Location</th>
								<th>Date</th>
								<th>Release id</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<%
								for (int i = 0; i < historyList.size(); i++) {
									BorrowHistory history = historyList.get(i);
							%>
							<tr>
							    <td><%=history.getLocation()%></td>
								<td><%=history.getDate()%></td>
								<td><%=history.getR_id()%></td>
								<td>
									<button class="btn btn-default ban" type="button">
										<i class="fa fa-ban"></i>
									</button>
									<button class="btn btn-default unban" type="button">
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
	
	<script src="<%=path%>/js/borrowHistory.js"></script>

	<!-- Footer -->
	<div
		class="yx-nav navbar navbar-default navbar-left navbar-static-bottom yx-nav"
		style="width: 100%; margin-bottom: 0">
		<div>联系我们：</div>
		<span>QQ: 123456789</span> <span>Tel: 12345678</span> <span>Email:
			123456789@qq.com</span>
	</div>

</body>
</html>