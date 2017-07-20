<%@ page import="java.util.ArrayList"%>
<%@ page import="model.BookRelease"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<!-- Header -->
<%@ include file="layouts/header.jsp"%>
<script>
	var admin = "<s:property value='#session.role'/>";
	var path = "<%=path%>";
	var bookreleases = "<%=request.getAttribute("bookreleases")%>"
	$(document).ready(function() {
		/*if (admin != 2) {
			bootbox.alert("滚吧王八羔子", function() {
				location.href = "index";
			})
		}*/
	});
</script>
<script src="<%=path%>/js/manageBook.js"></script>

<body>
	<%
		ArrayList<BookRelease> bookReleaseList = new ArrayList<BookRelease>();
			if (request.getAttribute("bookrelease") != null) {
		bookReleaseList = (ArrayList<BookRelease>) request.getAttribute("bookrelease");
			}
	%>
	

	<div class="yx-container container">
		<div class="row">
			<div class="col-md-2">
				<ul class="nav nav-list">
					<li class="yx-header nav-header">管理</li>
					<li><a href="listUsers"><i class="fa fa-user"></i>用户管理</a></li>
					<li class=active><a href="listBookReleases"><i class="fa fa-book"></i>图书发布管理</a></li>
					<li><a href="listCates"><i class="fa fa-bookmark"></i>图书分类管理</a></li>
				</ul>
			</div>
			<div class="covers col-md-10">
							<div class="dataTable_wrapper">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables">
									<thead>
										<tr>
										    <th>ID</th>
											<th>isbn</th>
											<th>publish_date</th>
											<th>discription</th>
											<th>price</th>
											<th>status</th>
											<th><a href="listBookReleases"><i class="fa fa-refresh"></i></a></th>
										</tr>
									</thead>
									<tbody>
										<%
											for (int i = 0; i < bookReleaseList.size(); i++) {
																				BookRelease bookrelease = bookReleaseList.get(i);
										%>
										<tr>
										    <td><%=bookrelease.getId()%></td>
											<td><%=bookrelease.getIsbn()%></td>
											<td><%=bookrelease.getPublish_date()%></td>
											<td><%=bookrelease.getDiscription()%></td>
											<td><%=bookrelease.getPrice()%></td>
											<td><%=bookrelease.getStatus()%></td>
											<td>
												<button class="btn btn-default ban" type="button"
													data-id="<%=bookrelease.getR_id()%>">
													<i class="fa fa-ban"></i>
												</button>
												<button class="btn btn-default unban" type="button"
													data-id="<%=bookrelease.getR_id()%>">
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