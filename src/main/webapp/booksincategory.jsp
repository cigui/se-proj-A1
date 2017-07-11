<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Book"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- Header -->
<%@ include file="WEB-INF/view/layouts/header.jsp"%>

<% 
	ArrayList<Book> books = new ArrayList<Book>();
	if (request.getAttribute("booksInCate") != null) {
		books = (ArrayList<Book>)request.getAttribute("booksInCate");
	}
%>

<!-- Body -->
<div class="yx-container container">
<%
	for (int i = 0; i < books.size(); i++) {
		Book book = books.get(i);
%>
<%=book.getTitle()%>
<%
	}
 %>

</div>



<!-- Footer -->
<%@ include file="WEB-INF/view/layouts/footer.jsp"%>