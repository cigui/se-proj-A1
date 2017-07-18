<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.BorrowHistory"%>
<%@ page import="model.Book"%>
<%@ page import="model.User"%>
<%@ page import="model.BookRelease"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<!-- Header -->
<%@ include file="WEB-INF/view/layouts/header.jsp"%>
<script src="<%=path%>/js/historyDetail.js"></script>
<%
	BorrowHistory borrowHistory = (BorrowHistory)request.getAttribute("borrowHistory");
	BookRelease br = (BookRelease)request.getAttribute("release");
	Book book = (Book)request.getAttribute("book");
	User user = (User)request.getAttribute("user");
%>

<div class="yx-container container">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-7">
			<h1><%=book.getTitle() %></h1>
		</div>
	</div>

	<div class="row">
		<div class="col-md-1"></div>
		<div class="infors col-md-6">
			<div class="row">
				<div class="col-md-3">
					<h3>状态</h3>
				</div>
				<div class="col-md-7">
					<h3><%=borrowHistory.getOrderStatus() %></h3>
				</div>
			</div>
			<p></p>
			<div class="row">
				<div class="col-md-3">
					<h3>时间</h3>
				</div>
				<div class="col-md-7">
					<h3><%=borrowHistory.getDate() %></h3>
				</div>
			</div>
			<p></p>
			<div class="row">
				<div class="col-md-3">
					<h3>借出者</h3>
				</div>
				<div class="col-md-7">
					<h3><%=user.getNickname() %></h3>
				</div>
			</div>
			<p></p>
			<div class="row">
				<div class="col-md-3">
					<h3>花费</h3>
				</div>
				<div class="col-md-7">
					<h3><%=br.getPrice() %></h3>
				</div>
			</div>
			<%if(borrowHistory.getOrderStatus() == 1){ %>
			<div class="row">
				<div class="col-md-3">
					<h3>评分</h3>
					<%if(borrowHistory.getScore()==null){ %>
					<div id="scoreForm">
						<input type="hidden" class="form-control" name="id" value="<%=borrowHistory.getH_id()%>">
						<input type="number" class="form-control" name="score"
									placeholder="请打分" required="true" min="0" max="10">
						<button id="submit" type="submit" class="btn btn-info">提交</button>
					<div>
					<%} else{ %>
					<h3><%=borrowHistory.getScore() %></h3>
					<%} %>
				</div>
			</div>
			<%} %>
		</div>
	</div>
</div>

<!-- Footer -->
<%@ include file="WEB-INF/view/layouts/footer.jsp"%>