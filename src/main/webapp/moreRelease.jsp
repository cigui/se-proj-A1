<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.Book"%>
<%@ page import="model.BookRelease"%>
<%@ page import="model.BookComment"%>
<%@ page import="model.User"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<!-- Header -->
<%@ include file="WEB-INF/view/layouts/header.jsp"%>

	<script>
	var user = "<s:property value='#session.id'/>";
	var path = "<%=path%>";
	$(document).ready(function() {
		
		if (user == null) {
			
		}
	  });
    </script>
	<%
		Book book = new Book();
			if (request.getAttribute("book") != null) {
		book = (Book) request.getAttribute("book");
			}
	%>
	<%
		ArrayList<BookRelease> bookReleaseList = new ArrayList<BookRelease>();
			if (request.getAttribute("bookReleases") != null) {
		bookReleaseList = (ArrayList<BookRelease>) request.getAttribute("bookReleases");
			}
	%>
	<%
		Map<Integer,User> userList = new HashMap<Integer,User>();
			if (request.getAttribute("users") != null) {
		userList = (Map<Integer,User>) request.getAttribute("users");
			}
	%>


	<div class="yx-container container">
	<div class="col-md-1"></div>
				<div class="covers col-md-10">
					<div class="row">
						<div class="col-md-9">
							<span class="yx-header nav-header">《<%=book.getTitle() %>》</span>
						</div>
						<div class="col-md-1">
							<span><a class="btn btn-default btn-sm"
								href="bookdetails?isbn=<%=book.getIsbn()%>">书籍页面</a></span>
						</div>
						<div class="dataTable_wrapper">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables">
						<thead>
								<tr>
						<th>借出人</th>
						<th>信用积分</th>
						<th>积分</th>
						<th></th>
						</tr>
						</thead>
						<tbody>
						    <%
											for (int i = 0; i < bookReleaseList.size(); i++) {
																				BookRelease bookRelease = bookReleaseList.get(i);
																				int id = bookRelease.getId();
																				User user = userList.get(id);
										%>
							<tr>
								<td><%=user.getNickname()%></td>
								<td><%=user.getCredit()%></td>
								<td><%=bookRelease.getPrice()%></td>
								<p> </p>
								<td><a href='releaseDetail?r_id=<%=bookRelease.getR_id()%>'>
								    <button class="btn btn-default btn-sm" data-toggle="modal" data-target="#">去看看</button></td>
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
