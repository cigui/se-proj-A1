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
	if (request.getAttribute("searchResult") != null) {
		books = (ArrayList<Book>) request.getAttribute("searchResult");
	}
%>

<!-- Body -->
<div class="yx-container container">
	<div class="row">
		<div class="covers col-xs-12 col-md-12">
			<div class="page-header">
				<h2 class="text-primary">搜索结果</h2>
			</div>
			<div class="table-responsive">
				<table class="table table-striped table-bordered table-hover"
					id="dataTables">
					<thead>
						<tr>
							<td>ISBN</td>
							<td>书籍名称</td>
							<td>作者</td>
						</tr>
					</thead>
					<tbody>
						<%
							for (int i = 0; i < books.size(); i++) {
								Book book = books.get(i);
						%>
						<tr>
							<td><%=book.getIsbn()%></td>
							<td><a href="bookdetails?isbn=<%=book.getIsbn()%>"><%=book.getTitle()%></a></td>
							<td><%=book.getAuthor()%></td>
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


<!-- Footer -->
<%@ include file="layouts/footer.jsp"%>