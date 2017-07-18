<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- Header -->
<%@ include file="../layouts/header.jsp"%>

<!-- Body -->
<div class="container yx-container">
	<div class="page-header">
		<h1 class="text-primary">
			激活成功！<br> <small>欢迎加入阅享:)</small>
		</h1>
	</div>
	<div class="row">
		<div class="col-xs-4 col-md-4" style="font-size: 24px; color: #777">您现在可以：</div>
	</div>
	<div class="row">
		<div class="col-xs-4 col-md-6" style="text-align: center">
			<a href="index" class="btn btn-primary btn-lg">回到首页</a>
		</div>
		
		<div class="col-xs-4 col-md-6" style="text-align: center">
			<a href="<%=path%>/recommended" class="btn btn-primary btn-lg">随便看看</a>
		</div>
	</div>
</div>

<!-- Footer -->
<%@ include file="../layouts/footer.jsp"%>