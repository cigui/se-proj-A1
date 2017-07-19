<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.BorrowHistory"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<!-- Header -->
<%@ include file="WEB-INF/view/layouts/header.jsp"%>
<body>
	<%
		ArrayList<BorrowHistory> historyList = new ArrayList<BorrowHistory>();
		if (request.getAttribute("history") != null) {
			historyList = (ArrayList<BorrowHistory>) request.getAttribute("history");
		}
	%>
	<!-- Header -->
	
	
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
									<a href="borrowDetail?id=<%=history.getH_id()%>">Detail</a>
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