<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Book"%>
<%@ page import="model.Category"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- Header -->
<%@ include file="../layouts/header.jsp"%>
<!-- Body -->
<div class="yx-container container">
	<div class="page-header">
		<h1 class="text-primary">
			发布成功！<br> <small>请耐心等待管理员的审核:)</small>
		</h1>
	</div>
	<div class="row">
		<div class="col-md-4" style="font-size: 24px; color: #777">您现在可以：</div>
	</div>
	<div class="row">
		<div class="col-md-6" style="text-align: center">
			<a href="<%=path%>/releasebook.jsp" class="btn btn-primary btn-lg">继续发布</a>
		</div>
		<div class="col-md-6" style="text-align: center">
			<a href="index" class="btn btn-primary btn-lg">回到首页</a>
		</div>
	</div>
</div>
<!-- Footer -->
<%@ include file="../layouts/footer.jsp"%>