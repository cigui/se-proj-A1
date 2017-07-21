<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Book"%>
<%@ page import="model.Category"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	ArrayList<Book> books = new ArrayList<Book>();
	ArrayList<Category> categories = new ArrayList<Category>();
	if (request.getAttribute("bestBooks") != null) {
		books = (ArrayList<Book>) request.getAttribute("bestBooks");
	}
	if (request.getAttribute("categories") != null) {
		categories = (ArrayList<Category>) request.getAttribute("categories");
	}
%>
<!-- Header -->
<%@ include file="layouts/header.jsp"%>
<script src="<%=path%>/js/index.js"></script>

<!-- Body -->
<div class="yx-container container">
	<div class="row">
	
		<!-- Category Navigator -->
		<%@ include file="layouts/navigator.jsp"%>
		
		<!-- Content -->
		<div class="covers col-xs-5 col-md-5">
			<div class="row">
				<div class="col-xs-7 col-md-9">
					<span class="yx-header nav-header">首页推荐</span>
				</div>
				<div class="col-xs-1 col-md-1">
					<span><a class="btn btn-default btn-sm"
						href="<%=path%>/recommended">更多</a></span>
				</div>
			</div>
			<div class="row">
				<%
					for (int i = 0; (i < 6) && (i < books.size()); i++) {
						Book book = books.get(i);
				%>
				<div class="col-xs-12 col-md-6">
					<div class="cover">
						<a href='<%=path%>/bookdetails?isbn=<%=book.getIsbn()%>'><img
							class="img-responsive"
							src="https://img3.doubanio.com/lpic/<%=book.getCoverSrc()%>" /></a>
					</div>
				</div>
				<%
					}
				%>
			</div>
		</div>
		<div class="covers col-xs-5 col-md-5">
			<div class="row">
				<div class="col-xs-7 col-md-9">
					<span class="yx-header nav-header">猜你喜欢</span>
				</div>
				<div class="col-xs-1 col-md-1">
					<span><button class="btn btn-default btn-sm yx-guess">换一批</button></span>
				</div>
			</div>
			<div class="row">
				<%
					for (int i = 0; (i < 6) && (i < books.size()); i++) {
						Book book = books.get(i);
				%>
				<div class="col-xs-12 col-md-6">
					<div class="cover">
						<a id="link<%=i%>" href='#'><img class="img-responsive"
							src="https://img3.doubanio.com/lpic/<%=book.getCoverSrc()%>"
							id="cover<%=i%>" /></a>
					</div>
				</div>
				<%
					}
				%>
			</div>
		</div>
	</div>
</div>

<!-- Footer -->
<%@ include file="layouts/footer.jsp"%>