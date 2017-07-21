<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE HTML>

<div class="col-xs-2 col-md-2">
	<ul class="nav nav-list">
		<li class="yx-header nav-header">图书分类</li>
		<%
			for (int i = 0; (i < categories.size()) && (i < 6); i++) {
				Category cate = categories.get(i);
		%>
		<li><a
			href="<%=path%>/booksInCategory?cate=<%=cate.getCate_id()%>"><%=cate.getName()%></a></li>
		<%
			}
			if (categories.size() > 6) {
		%>
		<li><a id="moreCate" href="javascript:void(0)">更多</a></li>
		<script>
			$('#moreCate').click(function() {
				$('.yx-hidden').fadeIn();
				$('#moreCate').fadeOut();
			})
		</script>
		<%
			for (int i = 6; i < categories.size(); i++) {
					Category cate = categories.get(i);
		%>
		<li class="yx-hidden" style="display: none;"><a
			href="<%=path%>/booksInCategory?cate=<%=cate.getCate_id()%>"><%=cate.getName()%></a></li>
		<%
			}
		%>
		<%
			}
		%>
	</ul>
</div>