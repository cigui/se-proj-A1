<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="model.Book"%>
<%@ page import="model.BookRelease"%>
<%@ page import="model.BorrowItem"%>
<%@ page import="model.User" %>
<%@ page import="model.BorrowHistory" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	ArrayList<BorrowItem> bi = new ArrayList<BorrowItem>();
	Map<Integer, String> books = new HashMap<Integer, String>();
	Map<Integer, Integer> prices = new HashMap<Integer, Integer>();
	if (request.getAttribute("bi") != null) {
		bi = (ArrayList<BorrowItem>) request.getAttribute("bi");
	}
	if (request.getAttribute("books") != null) {
		books = (Map<Integer, String>) request.getAttribute("books");
	}
	if (request.getAttribute("prices") != null) {
		prices = (Map<Integer, Integer>) request.getAttribute("prices");
	}
%>

<!-- Header -->
<%@ include file="WEB-INF/view/layouts/header.jsp"%>
<script src="<%=path%>/js/shoppingCart.js"></script>
<script src="<%=path%>/js/jquery.dataTables.min.js"></script>
<script src="<%=path%>/js/dataTables.bootstrap.min.js"></script>
<link href="<%=path%>/css/dataTables.bootstrap.min.css" rel="stylesheet">
<script>
	var id = "<s:property value='#session.userId' />";
	var logined = "<s:property value='#session.logined' />";
</script>
<!-- Body -->
<body>	

<div class="yx-container container">
			<div class="row">
			<br>
		</div>
	    <div class="page-header">
			<h1 class="text-primary">
				我的借书车
			</h1>
		</div>
		
			<div class="col-md-12">
				<div class="row">
					<br>
				</div>
			<div class="bs-body">
			<div class="bs-center container">
				<div class="panel panel-info">
					<table class="table table-striped" id="cart-tb">
						<tr>
							<th>Title</th>
							<th>Price</th>
							<th>Operation</th>
						</tr>

						<%
								for (BorrowItem item : bi) {
						%>
						<tr class="cart-item">
							
							<td class="c-title"><%=books.get(item.getR_id())%></td>
							<td class="c-price"><%=prices.get(item.getR_id())%></td>
							<td class="c-ops">
							<button class="btn btn-default bs-delete" data-bid=<%=item.getR_id()%> >Delete</button>
							<input type="checkbox" name="checkbox" data-bid=<%=item.getR_id()%>  /></td>
						</tr>
						<%
							}
						%>
					</table>

					<hr />

					<div class="panel-body">
						<div class="row btn-row">
							<div class="col-md-3" style="float: right">
								<button class="btn btn-block btn-primary bs-place" >Place Order</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>	
				
     		
</div>
</div>		
</body>	

<!-- Footer -->
<%@ include file="WEB-INF/view/layouts/footer.jsp"%>
