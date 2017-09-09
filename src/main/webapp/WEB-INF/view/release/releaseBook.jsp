<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="service.CategoryService"%>
<%@page import="java.util.List"%>
<%@page import="model.Category"%>
<!DOCTYPE HTML>
<style type="text/css">

/* 定义输入验证出错时显示的错误提示样式 */
.error {
	color: red;
	font-weight: normal
}

/* 去除number类型的输入框右边的上下小箭头 */
input::-webkit-outer-spin-button, input::-webkit-inner-spin-button {
	-webkit-appearance: none;
}

input[type="number"] {
	-moz-appearance: textfield;
}
</style>
<!-- Header -->
<%@ include file="../layouts/header.jsp"%>


<script>
	var logined = "<s:property value='#session.logined'/>";
	var path = "<%=path%>";
	$(document).ready(function() {
		if (logined == "") {
			bootbox.alert("您尚未登录，请先登录！", function() {
				location.href = "index";
			})
		}
	});
</script>

<script src="<%=path%>/js/releasebook.js"></script>

<%
	ApplicationContext ctx = WebApplicationContextUtils
			.getWebApplicationContext(request.getSession().getServletContext());
	CategoryService categoryService = (CategoryService) ctx.getBean("categoryService");
	List<Category> categories = categoryService.getCategories();
%>


<!-- Body -->
<div class="yx-container container">
	<div class="page-header">
		<h2 class="text-primary">
			书籍信息填写<br> <small>您只需填写书籍的ISBN码，我们会获取书籍的标题、作者等信息:)</small>
		</h2>
	</div>

	<div class="row">
		<div class="col-md-12">
			<form id="releaseForm" class="form-horizontal"
				style="text-align: center" action="releaseBook" method="post"
				enctype="multipart/form-data">
				<!-- 这里的onsubmit属性原本是通过submit后禁用提交按钮来禁止重复提交表单，但这样也会在输入不合法时禁止提交，故暂先注释掉，后期再做修改 -->
				<!-- onsubmit="document.getElementById('submit').disabled=true;" -->
				<div class="form-group">
					<div class="col-md-8">
						<div class="form-group">
							<label for="isbn" class="col-md-2 control-label">ISBN(*)</label>
							<div class="col-md-8">
								<input type="number" class="form-control" id="isbn" name="isbn"
									placeholder="请输入13位ISBN码" required="true" maxlength="13">
							</div>
							<div class="col-md-2">
								<button id="previewInfo" data-toggle="modal"
									class="btn btn-info btn-sm" data-target="#previewModal">预览图书信息</button>
							</div>
						</div>
						<div class="form-group">
							<label for="publishDate" class="col-md-2 control-label">出版日期(*)</label>
							<div class="col-md-8">
								<input type="date" class="form-control" id="publishDate"
									name="publishDate" placeholder="请输入出版日期" required="true">
							</div>
						</div>
						<div class="form-group">
							<label for="discription" class="col-md-2 control-label">书籍描述(*)</label>
							<div class="col-md-8">
								<textarea maxlength="140" rows="8" required="true"
									class="form-control" id="discription" name="discription"
									placeholder="请输入书籍描述（该书新旧程度、注意事项等等，不超过140字符）"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label for="categories" class="col-md-2 control-label">图书分类</label>
							<div class="col-md-2">
								<label> <select id="category1" name="category1"
									class="form-control" required="true">
									<option disabled selected value></option>
								<% for (Category c : categories) { %>
									<option value="<%=c.getCate_id()%>"><%=c.getName()%></option>
								<% } %>
									</select></label>
							</div>
							<div class="col-md-2">
								<label> <select id="category2" name="category2"
									class="form-control">
									<option disabled selected value></option>
								<% for (Category c : categories) { %>
									<option value="<%=c.getCate_id()%>"><%=c.getName()%></option>
								<% } %>
									</select></label>
							</div>
							<div class="col-md-2">
								<label> <select id="category3" name="category3"
									class="form-control">
									<option disabled selected value></option>
								<% for (Category c : categories) { %>
									<option value="<%=c.getCate_id()%>"><%=c.getName()%></option>
								<% } %>
									</select></label>
							</div>
						</div>
						<div class="form-group">
							<label for="price" class="col-md-2 control-label">积分定价(*)</label>
							<div class="col-md-8">
								<input type="number" class="form-control" id="price"
									name="price" placeholder="请输入积分定价" required="true">
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group" style="text-align: center">
							<img id="preview" style="max-width: 70%; height: auto;"
								src="<%=path%>/images/picture-0.png" />
						</div>
						<div class="form-group" style="text-align: center">
							<label for="image">上传图片</label> <input type="file" id="image"
								name="image" style="margin: 0 auto">
							<p class="help-block">暂时仅支持上传1张图片，大小不得超过4MB</p>
						</div>
					</div>
				</div>
				<button id="submit" type="submit" class="btn btn-info"
					style="width: 20%">提交</button>
			</form>
		</div>
	</div>
</div>

<div class="modal fade" id="previewModal" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">书籍信息</h4>
			</div>
			<div class="modal-body">
				<div class="container" style="max-width: 100%">
					<div class="row">
						<div class="col-md-8">
							<dl>
								<dt>ISBN</dt>
								<dd id="infoIsbn">加载中...</dd>
								<dt>题名</dt>
								<dd id="infoTitle">加载中...</dd>
								<dt>作者</dt>
								<dd id="infoAuthor">加载中...</dd>
								<dt>出版商</dt>
								<dd id="infoPublisher">加载中...</dd>
								<dt>译者</dt>
								<dd id="infoTranslator">加载中...</dd>
							</dl>
							<p class="help-block">数据源自豆瓣</p>
						</div>
						<div class="col-md-4">
							<img id="cover" class="img-responsive"
								src="<%=path%>/images/picture-0.png" />
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal -->
</div>

<!-- Footer -->
<%@ include file="../layouts/footer.jsp"%>