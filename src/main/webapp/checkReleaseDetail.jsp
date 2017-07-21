<%@ page import="model.BookRelease"%>
<%@ page import="model.Book"%>
<%@ page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<!-- Header -->
<%@ include file="WEB-INF/view/layouts/header.jsp"%>
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

<body>
	<%
		BookRelease bookRelease = new BookRelease();
			if (request.getAttribute("bookRelease") != null) {
		bookRelease = (BookRelease) request.getAttribute("bookRelease");
			}
	%>
	<%
		Book book = new Book();
	    if (request.getAttribute("book")!=null){
	    	book = (Book) request.getAttribute("book");
	    }
	%>
	<%
	User user = new User();
	if (request.getAttribute("user") != null) {
		user = (User) request.getAttribute("user");
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
							<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-7">
			<h1>
				《<%=book.getTitle()%>》
			</h1>
		</div>
	</div>

	<div class="row">
		<div class="col-md-1"></div>
		<div class="infors col-md-7">
			<div class="row">
				<div class="col-md-3">
					<h3>ISBN码:</h3>
				</div>
				<div class="col-md-7">
					<h3><%=book.getIsbn()%></h3>
				</div>
			</div>
			<p></p>
			<div class="row">
				<div class="col-md-3">
					<h3>作者:</h3>
				</div>
				<div class="col-md-7">
					<h3><%=book.getAuthor()%></h3>
				</div>
			</div>
			<p></p>
			<div class="row">
				<div class="col-md-3">
					<h3>出版社:</h3>
				</div>
				<div class="col-md-7">
					<h3><%=book.getPublisher()%></h3>
				</div>
			</div>
			<p></p>
			<div class="row">
				<div class="col-md-3">
					<h3>翻译:</h3>
				</div>
				<div class="col-md-7">
					<h3><%=book.getTranslator()%></h3>
				</div>
			</div>
			<p></p>
			<div class="row">
				<div class="col-md-3">
					<h3>借出人:</h3>
				</div>
				<div class="col-md-7">
					<h3><%=user.getNickname()%></h3>
				</div>
			</div>
			<p></p>
			<div class="row">
				<div class="col-md-3">
					<h3>信用等级</h3>
				</div>
				<div class="col-md-7">
					<h3><%=user.getCredit()%></h3>
				</div>
			</div>
			<p></p>
			<div class="row">
				<div class="col-md-3">
					<h3>积分</h3>
				</div>
				<div class="col-md-7">
					<h3><%=bookRelease.getPrice()%></h3>
				</div>
			</div>
		</div>
		<div class="col-md-4">
			<a href='releasePicture?r_id=<%=bookRelease.getR_id()%>'><img
				class="img-responsive" id="cover1"
				src='releasePicture?r_id=<%=bookRelease.getR_id()%>' /></a>
			<h4>书籍描述：</h4>
			<p><%=bookRelease.getDiscription()%></p>	
							</div>
			</div>
		</div>
	</div>
	</div>
	</div>
	
<!-- Footer -->
<%@ include file="WEB-INF/view/layouts/footer.jsp"%>