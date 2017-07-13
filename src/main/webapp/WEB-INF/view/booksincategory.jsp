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
/* 	ArrayList<Book> books = new ArrayList<Book>();
	if (request.getAttribute("booksInCate") != null) {
		books = (ArrayList<Book>) request.getAttribute("booksInCate");
	} */

	ArrayList<Category> categories = new ArrayList<Category>();
	if (request.getAttribute("categories") != null) {
		categories = (ArrayList<Category>) request.getAttribute("categories");
	}

	Category currentCate = new Category();
	if (request.getAttribute("currentCate") != null) {
		currentCate = (Category) request.getAttribute("currentCate");
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
					<%=currentCate.getName()%>
				</h2>
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
<%-- 					<tbody>
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
					</tbody> --%>
				</table>
			</div>
		</div>
	</div>
</div>

<!-- JavaScript -->
<script>
	$(document).ready(function() {
		var cate = '<%=currentCate.getCate_id()%>';
		$('#dataTables').DataTable({
			serverSide: true,// 从服务器端获取数据动态加载
			processing: true,// 载入数据时显示“载入中”
            paging: true,// 分页
            ordering: false,// 是否启用排序
            searching: false,// dataTables搜索
            language: {
                lengthMenu: '每页 <select class="form-control input-xsmall">' + 
                '<option value="5">5</option>' + 
                '<option value="10">10</option>' + 
                '<option value="20">20</option>' + 
                '<option value="30">30</option>' + 
                '<option value="40">40</option>' + 
                '<option value="50">50</option>' + 
                '</select>条记录',// 分页大小显示。
                
                paginate: {//分页的样式内容。
                    previous: "上一页",
                    next: "下一页",
                    first: "第一页",
                    last: "最后"
                },

                zeroRecords: "没有内容",//table tbody内容为空时，tbody的内容。
                //下面三者构成了总体的左下角的内容。
                info: "总共 _PAGES_ 页，显示第 _START_ 到第 _END_ 条 ，共 _MAX_ 条 ",// 左下角的信息显示，大写的词为关键字。
                infoEmpty: "0条记录",// 为空时左下角的显示。
                infoFiltered: ""
            },
            ajax : {
            	 type: "post", // 默认get，但据说datatable默认构造的参数很长，有可能超过get的最大长度。
                 url: "<%=path%>/getPagedBooksbyCategory",
                 dataSrc: "data", // 默认data，也可以写其他的，格式化table的时候取里面的数据
                 data: function (d) { // d是原始的发送给服务器的数据，默认很长。
                        var param = {};
                        param.draw = d.draw; 
                        param.start = d.start; // 开始的序号
                        param.length = d.length; // 要取的数据的条数
                        param.cate = cate;
                        /* 下面一段代码用于实现页面表单搜索并提交，但这里暂不实现 */
                        /* var formData = $("#queryForm").serializeArray(); // 把form里面的数据序列化成数组
                        formData.forEach(function (e) {
                            param[e.name] = e.value;
                        }); */
                        return param; // 自定义需要传递的参数。
                 }
            },
            columns: [ // 对应上面thead里面的序列
                {"data": "isbn" },
                {"data": "title" },
                {"data": "author"}
            ]
		});
	});
</script>

<!-- Footer -->
<%@ include file="layouts/footer.jsp"%>