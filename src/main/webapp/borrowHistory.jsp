<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.BorrowHistory"%>
<%@ page import="model.BookRelease" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- Header -->
<%@ include file="WEB-INF/view/layouts/header.jsp"%>
	<%
		int release_history = 0; //0:history, 1:release
		ArrayList<BorrowHistory> historyList = new ArrayList<BorrowHistory>();
		if (request.getAttribute("history") != null) {
			historyList = (ArrayList<BorrowHistory>) request.getAttribute("history");
		}
		
		ArrayList<BookRelease> releaseList = new ArrayList<BookRelease>();
		if (request.getAttribute("release") != null) {
			releaseList = (ArrayList<BookRelease>) request.getAttribute("release");
			release_history = 1;
		}
	%>

	<div class="yx-container container">
		<div class="row">
			<div class="col-xs-2 col-md-2">
				<ul class="nav nav-list">
					<li class="yx-header nav-header">历史记录</li>
					<li><a href="release?id=<%=session.getAttribute("userId")%>&status=0">已发布的图书</a></li>
					<li><a href="release?id=<%=session.getAttribute("userId")%>&status=1">已借出的图书</a></li>
					<li><a href="history?id=<%=session.getAttribute("userId")%>&status=0">已下单的图书</a></li>
					<li><a href="history?id=<%=session.getAttribute("userId")%>&status=1">已借到的图书</a></li>
				</ul>
			</div>
			<div class="covers col-md-10">
				<div class="dataTable_wrapper">
					<%if(release_history == 0) {%>
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
					<%} else {%>
					<table class="table table-striped table-bordered table-hover"
						id="dataTables">
						<thead>
							<tr>
								<th>ISBN</th>
								<th>Description</th>
								<th>Price</th>
								<th>Status</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<%
								for (int i = 0; i < releaseList.size(); i++) {
									BookRelease release = releaseList.get(i);
									String s = null;
									switch((int)release.getStatus()){
									case 0: s="未审核"; break;
									case 1: s="审核通过";break;
									case 2: s="已借出";break;
									case -1: s="审核不通过";break;
									}
							%>
							<tr>
							    <td><%=release.getIsbn()%></td>
								<td><%=release.getDiscription()%></td>
								<td><%=release.getPrice()%></td>
								<td><%=s%></td>
								<td>
									<a href="releaseDetail?r_id=<%=release.getR_id()%>">Detail</a>
								</td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
					<%} %>
				</div>
			</div>
		</div>
	</div>
	
	<script src="<%=path%>/js/borrowHistory.js"></script>

	
<!-- Footer -->
<%@ include file="WEB-INF/view/layouts/footer.jsp"%>
