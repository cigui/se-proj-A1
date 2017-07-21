<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Book"%>
<%@ page import="model.Category"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- Header -->
<%@ include file="layouts/header.jsp"%>

<%
	ArrayList<Book> books = new ArrayList<Book>();
	ArrayList<Category> categories = new ArrayList<Category>();
	int currentPage = 0;
	int maxPage = 0;
	if (request.getAttribute("books") != null) {
		books = (ArrayList<Book>) request.getAttribute("books");
	}
	if (request.getAttribute("categories") != null) {
		categories = (ArrayList<Category>) request.getAttribute("categories");
	}
	if (request.getAttribute("cur") != null) {
		currentPage = (Integer) request.getAttribute("cur");
	}
	if (request.getAttribute("maxPage") != null) {
		maxPage = (Integer) request.getAttribute("maxPage");
	}
%>

<!-- Body -->
<div class="yx-container container">
	<div class="row">
	
		<!-- Category Navigator -->
		<%@ include file="layouts/navigator.jsp"%>
		
		<div class="col-xs-10 col-md-10">
			<div class="row">
				<%
					for (int i = 0; i < books.size(); i++) {
						Book book = books.get(i);
				%>
				<div class="col-xs-6 col-md-3">
					<div class="cover">
						<a href="bookdetails?isbn=<%=book.getIsbn()%>">
							<img class="img-responsive" style="margin: 2px;" src="https://img3.doubanio.com/lpic/<%=book.getCoverSrc()%>" /></a>
					</div>
				</div>
				<%
					if (i % 2 == 1) {
				%>
				<div class="clearfix visible-xs-block"></div>
				<% 		
					}
				%>
				<%
					}
				%>
			</div>
			<div class="row">
				<ul class="pager">
					<% if (currentPage == 0) { %>
					<li><span>Previous</span]></li>
					<% } else { %>
					<li><a
						href="recommended?page=<%=currentPage - 1%>">Previous</a></li>
					<% } %>
					<% if (currentPage == maxPage) { %>
					<li><span">Next</span></li>
					<% } else { %>
					<li><a href="recommended?page=<%=currentPage + 1%>">Next</a></li>
					<% } %>
				</ul>
			</div>
		</div>
	</div>
</div>

<!-- Footer -->
<%@ include file="layouts/footer.jsp"%>