<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.BookComment"%>
<%@ page import="model.User"%>
<%@ page import="model.Book"%>
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
		ArrayList<BookComment> bookComments = new ArrayList<BookComment>();
			if (request.getAttribute("bookComments") != null) {
		bookComments = (ArrayList<BookComment>) request.getAttribute("bookComments");
			}
	%>
	<%
		Map<Integer,User> users = new HashMap<Integer,User>();
			if (request.getAttribute("users") != null) {
		users = (Map<Integer,User>) request.getAttribute("users");
			}
	%>


	<div class="yx-container container">
	<div class="covers col-md-12">
					<div class="row">
						<div class="col-md-9">
							<span class="yx-header nav-header">《<%=book.getTitle() %>》</span>
						</div>
						<div class="col-md-1">
							<span><a class="btn btn-default btn-sm"
								href="bookdetails?isbn=<%=book.getIsbn()%>">书籍页面</a></span>
						</div>
					</div>
					<div class="dataTable_wrapper">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables">
						<thead>
								<tr>
						<th width = 20%>评论人</th>
						<th width = 55%>TA的评论</th>
						<th width = 25%>TA的评分</th>
						</tr>
						</thead>
						<tbody>
						    <%
											for (int i = 0;i < bookComments.size(); i++) {
																				BookComment bookComment = bookComments.get(i);
																				int id = bookComment.getId();
																				User user = users.get(id);
										%>
							<tr>
								<td><%=user.getNickname()%></td>
								<td style="word-break:break-all"><%=bookComment.getDiscription()%></td>
								<td><%=bookComment.getScore()%></td>
								</tr>
										<%
											}
										%>
									</tbody>
								</table>
							</div>
				</div>
	</div>
		

<%@ include file="WEB-INF/view/layouts/footer.jsp"%>
