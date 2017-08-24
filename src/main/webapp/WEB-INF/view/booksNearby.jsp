<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>

<!-- Header -->
<%@ include file="layouts/header.jsp"%>

<script src="http://api.map.baidu.com/getscript?v=2.0&ak=SA3Q9ZknFdGWsB3niFOoZVWNY9azOOzO&services=&t=20170803155555"></script>
<script src="<%=path%>/js/booksNearby.js"></script>

<!-- Body -->
<div class="yx-container container">
	<div class="row">
		<div class="col-xs-12 col-md-12 bg-success yx-msg">正在定位中，请稍候...<i class="fa fa-spinner fa-spin"></i></div>
	</div>
	<div class="row">
		<div class="col-xs-12 col-md-12">
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
				</table>
			</div>
		</div>
	</div>
</div>


<!-- Footer -->
<%@ include file="layouts/footer.jsp"%>