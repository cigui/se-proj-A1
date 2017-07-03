<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%-- <%@ taglib prefix="s" uri="/struts-tags"%> --%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>阅享 - 发布图书</title>
<%
	String path = request.getContextPath();
%>
<script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/bootbox.js/4.4.0/bootbox.min.js"></script>
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<%=path%>/css/login_style.css" rel="stylesheet">
<link href="<%=path%>/css/yxdefault.css" rel="stylesheet">
<link href="<%=path%>/css/releasebook.css" rel="stylesheet">
</head>
<body>
	<div
		class="yx-nav navbar navbar-default navbar-left navbar-fixed-top yx-nav">
		<a class="yx-brand navbar-brand" href="index"
			style="color: cadetblue">阅享图书交流平台</a>
		<div class="yx-toolbar">
			<form class="yx-search-bar">
				<input type="text" name="searchString" placeholder="查询图书" />
				<button class="btn btn-sm btn-primary btn-block" type="submit">Search</button>
			</form>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<br>
		</div>
		<div class="row">
			<div class="col-md-9">
				<span class="yx-header nav-header">书籍信息</span>
			</div>
		</div>
		<hr />

		<div class="row">
			<div class="col-md-8">
				<div class="row">
					<div class="col-md-12">
						<span style="font-size: 16px">您只需填写书籍的ISBN码，我们会获取书籍的标题、作者等详细信息:)</span>
					</div>
				</div>
				<div role="form">
					<div class="form-group">
						<label for="ISBN">书籍编码</label> <input type="number" maxlength="13"
							step="1" class="form-control" name="ISBN"
							placeholder="请输入13位ISBN">
					</div>
					<div class="form-group">
						<label for="discription">书籍描述</label>
						<textarea type="text" maxlength="140" rows="10"
							class="form-control" name="discription"
							placeholder="请输入书籍描述（该书新旧程度、注意事项等等，不超过140字符）"></textarea>
					</div>
					<div class="form-group">
						<label for="price">积分定价</label> <input type="number"
							maxlength="13" step="1" class="form-control" name="price"
							placeholder="请输入书籍积分定价">
					</div>
				</div>
			</div>
			<div class="col-md-4" style="text-align: center">
				<br>
				<div>
					<img src="<%=path%>/images/picture-0.png" />
				</div>
				<br>
				<button class="btn btn-info" data-toggle="modal"
					data-target="#uploadPicture" style="width: 200px">上传相关照片</button>
			</div>
		</div>
		<br>
		<div class="row" style="text-align: center">
			<button class="btn btn-info" data-toggle="modal"
				data-target="#preview" style="width: 200px">提交</button>
		</div>
	</div>

	<div class="modal fade" id="preview" tabindex="-1" role="dialog"
		aria-labelledby="preview" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="previewModalLabel"></h4>
				</div>
				<form class="modal-body form-signin">
					<h2 class="form-signin-heading">信息确认</h2>
					<div class="form-group">
						<label for="isbn">isbn</label> 
						<input type="number" class="form-control" id="isbn"
							 readonly="readonly" value="9784758010634"/> 
					</div>
					<div class="form-group">
						<label for="title">书籍名称</label> 
						<input type="text" class="form-control" id="title"
							 readonly="readonly" value="东方求闻史记"/> 
					</div>
					<div class="form-group">
						<label for="author">书籍作者</label> 
						<input type="text" class="form-control" id="author"
							 readonly="readonly" value="ZUN"/> 
					</div>
					<div class="form-group">
						<label for="publisher">出版社</label> 
						<input type="text" class="form-control" id="publisher"
							 readonly="readonly" value="一迅社"/> 
					</div>
					<button class="btn btn-lg btn-primary btn-block" type="submit">确认提交</button>
				</form>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>

</body>
</html>