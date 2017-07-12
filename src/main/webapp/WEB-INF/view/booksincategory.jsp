<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Book"%>
<%@ page import="model.Category"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- Header -->
<%@ include file="layouts/header.jsp"%>
<script
	src="https://cdn.bootcss.com/datatables/1.10.15/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.bootcss.com/datatables/1.10.15/js/dataTables.bootstrap.js"></script>

<%
	ArrayList<Book> books = new ArrayList<Book>();
	if (request.getAttribute("booksInCate") != null) {
		books = (ArrayList<Book>) request.getAttribute("booksInCate");
	}

	ArrayList<Category> categories = new ArrayList<Category>();
	if (request.getAttribute("categories") != null) {
		categories = (ArrayList<Category>) request.getAttribute("categories");
	}

	String currentCate = "";
	if (request.getAttribute("currentCate") != null) {
		currentCate = (String) request.getAttribute("currentCate");
	}
%>

<!-- Body -->
<div class="yx-container container">
	<div class="row">
		<div class="col-xs-2 col-md-2">
			<ul class="nav nav-list">
				<li class="yx-header nav-header">图书分类</li>
				<%
					for (int i = 0; i < categories.size(); i++) {
						Category cate = categories.get(i);
				%>
				<li><a href="booksInCategory?cate=<%=cate.getCate_id()%>"><%=cate.getName()%></a></li>
				<%
					}
				%>
			</ul>
		</div>
		<div class="covers col-xs-10 col-md-10">
			<div class="page-header">
				<h2 class="text-primary">
					<%=currentCate%>
				</h2>
			</div>
			<div class="table-responsive">
				<table class="table table-striped table-bordered table-hover"
					id="dataTables">
					<thead>
						<td>ISBN</td>
						<td>书籍名称</td>
						<td>作者</td>
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

<!-- JavaScript -->
<script>
	$(document).ready(function() {
		$('#dataTables').DataTable({
            paging: true,//分页
            ordering: true,//是否启用排序
            searching: true,//搜索
            language: {
                lengthMenu: '每页 <select class="form-control input-xsmall">' + '<option value="1">1</option>' + '<option value="10">10</option>' + '<option value="20">20</option>' + '<option value="30">30</option>' + '<option value="40">40</option>' + '<option value="50">50</option>' + '</select>条记录',//左上角的分页大小显示。
                search: '<span class="label label-primary">搜索：</span>',

                paginate: {//分页的样式内容。
                    previous: "上一页",
                    next: "下一页",
                    first: "第一页",
                    last: "最后"
                },

                zeroRecords: "没有内容",//table tbody内容为空时，tbody的内容。
                //下面三者构成了总体的左下角的内容。
                info: "总共 _PAGES_ 页，显示第 _START_ 到第 _END_ 条 ，共 _MAX_ 条 ",//左下角的信息显示，大写的词为关键字。
                infoEmpty: "0条记录",//筛选为空时左下角的显示。
                infoFiltered: ""//筛选之后的左下角筛选提示，
            },
			responsive : true
		});
	});
</script>

<!-- Footer -->
<%@ include file="layouts/footer.jsp"%>