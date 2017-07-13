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
	if (request.getAttribute("searchResult")!= null) {
		books = (ArrayList<Book>) request.getAttribute("searchResult");
	}
%>

<!-- Body -->
<div class="yx-container container">



</div>


<!-- Footer -->
<%@ include file="layouts/footer.jsp"%>