<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.Book"%>
<%@ page import="model.BookRelease"%>
<%@ page import="model.BookComment"%>
<%@ page import="model.User"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<!-- Header -->
<%@ include file="WEB-INF/view/layouts/header.jsp"%>

	<script>
	var user = "<s:property value='#session.userId'/>";
	var path = "<%=path%>";
	$(document).ready(function() {
		
		if (user == null) {
			
		}
	  });
    </script>
	<%
		Book book = new Book();
			if (request.getAttribute("book") != null) {
		book = (Book) request.getAttribute("book");
			}
	%>
	<%
		ArrayList<BookRelease> bookReleaseList = new ArrayList<BookRelease>();
			if (request.getAttribute("bookReleases") != null) {
		bookReleaseList = (ArrayList<BookRelease>) request.getAttribute("bookReleases");
			}
	%>
	<%
		ArrayList<BookComment> bookCommentList = new ArrayList<BookComment>();
			if (request.getAttribute("bookComments") != null) {
		bookCommentList = (ArrayList<BookComment>) request.getAttribute("bookComments");
			}
	%>
	<%
		Map<Integer,User> userList = new HashMap<Integer,User>();
			if (request.getAttribute("users") != null) {
		userList = (Map<Integer,User>) request.getAttribute("users");
			}
	%>
	<%
		Map<Integer,User> userCommentList = new HashMap<Integer,User>();
			if (request.getAttribute("userComments") != null) {
		userCommentList = (Map<Integer,User>) request.getAttribute("userComments");
			}
	%>


	<div class="yx-container container">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-7">
				<h1>
					《<%=book.getTitle()%>》
				</h1>
			</div>

		</div>

		<div class="row">
			<div class="col-md-1"></div>
			<div class="infors col-md-6">
				<div class="row">
					<div class="col-md-3">
						<h3>ISBN码:</h3>
					</div>
					<div class="col-md-7">
						<h3><%=book.getIsbn()%></h3>
					</div>
				</div>
				<p></p>
				<div class="row">
					<div class="col-md-3">
						<h3>作者:</h3>
					</div>
					<div class="col-md-7">
						<h3><%=book.getAuthor()%></h3>
					</div>
				</div>
				<p></p>
				<div class="row">
					<div class="col-md-3">
						<h3>出版社:</h3>
					</div>
					<div class="col-md-7">
						<h3><%=book.getPublisher()%></h3>
					</div>
				</div>
				<p></p>
				<div class="row">
					<div class="col-md-3">
						<h3>翻译:</h3>
					</div>
					<div class="col-md-7">
						<h3><%=book.getTranslator()%></h3>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<a href='https://img3.doubanio.com/lpic/<%=book.getCoverSrc() %>'><img
					class="img-responsive" id="cover1"
					src="https://img3.doubanio.com/lpic/<%=book.getCoverSrc() %>" /></a>
			</div>

		</div>
		<div class="row">
			<p></p>
		</div>
		<div class="row">
			
		</div>
		<div class="row">
			<div class="row">
				<div class="col-md-1"></div>
				<div class="covers col-md-5">
					<div class="row">
						<div class="col-md-9">
							<span class="yx-header nav-header">图书借阅</span>
						</div>
						<div class="col-md-1">
							<span><a class="btn btn-default btn-sm"
								href="moreRelease?isbn=<%=book.getIsbn()%>">更多</a></span>
						</div>
						<div class="dataTable_wrapper">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables">
						<thead>
								<tr>
						<th>借出人</th>
						<th>信用积分</th>
						<th>积分</th>
						<th></th>
						</tr>
						</thead>
						<tbody>
						    <%
											for (int i = 0; (i < 4) && i < bookReleaseList.size(); i++) {
																				BookRelease bookRelease = bookReleaseList.get(i);
																				int id = bookRelease.getId();
																				User user = userList.get(id);
										%>
							<tr>
								<td><%=user.getNickname()%></td>
								<td><%=user.getCredit()%></td>
								<td><%=bookRelease.getPrice()%></td>
								<p> </p>
								<td><a href='releaseDetail?r_id=<%=bookRelease.getR_id()%>'>
								    <button class="btn btn-default btn-sm" data-toggle="modal" data-target="#">去看看</button></td>
								</tr>
										<%
											}
										%>
									</tbody>
								</table>
							</div>
					</div>
					

				</div>
				<div class="covers col-md-5">
					<div class="row">
						<div class="col-md-7">
							<span class="yx-header nav-header">图书评论</span>
						</div>
						<div class="col-md-2">
							<button class="btn btn-default btn-sm" data-toggle="modal"
								data-target="#myComment">我也想评</button>
						</div>
						<div class="col-md-2">
							<button class="btn btn-default btn-sm" ><a href="moreBookComment?isbn=<%=book.getIsbn()%>">更多评论</a></button>
						</div>
					</div>
					<div class="dataTable_wrapper">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables">
						<thead>
								<tr>
						<th width = 20%>评论人</th>
						<th width = 55%>TA的评论</th>
						<th width = 25%>TA的评分</th>
						</tr>
						</thead>
						<tbody>
						    <%
											for (int i = 0;i < bookCommentList.size(); i++) {
																				BookComment bookComment = bookCommentList.get(i);
																				int id = bookComment.getId();
																				User userComment = userCommentList.get(id);
										%>
							<tr>
								<td><%=userComment.getNickname()%></td>
								<td style="word-break:break-all"><%=bookComment.getDiscription()%></td>
								<td><%=bookComment.getScore()%></td>
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

		<div class="modal fade" id="myComment" tabindex="-1" role="dialog"
			aria-labelledby="BookComment" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel"></h4>
					</div>
					
					<div id="registerForm" class="form-horizontal"
				        style="text-align: center" >
						<h2 class="form-bookcomment-heading">我的评论</h2>
						<div class="form-group">
							<label for="isbn" class="col-md-2 control-label">ISBN</label>
							<div class="col-md-9">
								<input type="number" class="form-control" id="isbn"
									name="isbn" value = "<%=book.getIsbn() %>" readonly>
							</div>
						</div>
						<div class="form-group">
							<label for="score" class="col-md-2 control-label">我的评分</label>
							<div class="col-md-9">
								<input type="text" class="form-control" id="score" name = "score"
							            placeholder=" 请输入评分（0-10分）" min="0" max="10"/>
							</div>
						</div>
						<div class="form-group">
							<label for="nickName" class="col-md-2 control-label">书籍评价</label>
							<div class="col-md-9">
								<textarea maxlength="140" rows="10" required="true"
							         class="form-control" id="discription" name="discription"
							         placeholder="请输入书籍评价（不超过140字符）" maxlength="140"></textarea>
							</div>
						</div>
						
						<div class="form-group">
						    <div class="col-md-3"></div>
						    <div class="col-md-6"><button id = "comment" class="btn btn-sm btn-primary btn-block">发表评论</button></div>
							
						</div>
						
						
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>
	</div>
	<!-- Footer -->
<script>
$("#comment").click(function(){
	var isbn = $("#isbn").val();
	var score = $("#score").val();
	var discription = $("#discription").val();
	var logined = "<s:property value='#session.logined'/>";
	if (logined == false){
		bootbox.alert("请先登陆");
	}
	else{
		$.getJSON("sendBookComment",
	
			{
		      isbn: isbn,
		      score: score,
		      discription: discription
		      
			},function(data){
				  if (data == "good"){
					  bootbox.alert("评论成功",
							  function(){
						  location.reload();
					  });
				  }
				   if (data == "error"){
					  bootbox.alert("评论失败,请核对评分是否正确输入");
				  } 
			  });
	}
})
</script>
<%@ include file="WEB-INF/view/layouts/footer.jsp"%>
