<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="model.BookRelease"%>
<%@ page import="model.Book"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Header -->

<%@ include file="WEB-INF/view/layouts/header.jsp"%>
<script src="<%=path%>/js/jquery.dataTables.min.js"></script>
<script src="<%=path%>/js/dataTables.bootstrap.min.js"></script>
<script src="<%=path%>/js/manageUser.js"></script>
<link href="<%=path%>/css/dataTables.bootstrap.min.css" rel="stylesheet">
<script>
	var admin = "<s:property value='#session.role'/>";
	var path = "<%=path%>";
	var bookreleases = "<%=request.getAttribute("bookreleases")%>"
	$(document).ready(function() {
		$('#dataTables').DataTable();
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
	<%
		HashMap<Long,Book> books = new HashMap<Long,Book>();
	    if (request.getAttribute("books")!=null){
	    	books = (HashMap<Long,Book>) request.getAttribute("books");
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
								<table class="table table-striped table-bordered"
									id="dataTables">
									<thead>
										<tr>
										    <th>UserID</th>
										    <th>Title</th>
											<th>isbn</th>
											<th>status</th>
											<th><a href="listBookReleases"><i class="fa fa-refresh"></i></a></th>
										</tr>
									</thead>
									<tbody>
										<%
											for (int i = 0; i < bookReleaseList.size(); i++) {
																				BookRelease bookrelease = bookReleaseList.get(i);
																				long isbn = bookrelease.getIsbn();
																				Book book = books.get(isbn);
										%>
										<tr>
										    <td><%=bookrelease.getId()%></td>
										    <td><a href = "checkReleaseDetail?r_id = <%=bookrelease.getR_id()%>"><%=book.getTitle() %></a></td>
											<td><%=bookrelease.getIsbn()%></td>
											<td>未审核</td>
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
<%@ include file="WEB-INF/view/layouts/footer.jsp"%>