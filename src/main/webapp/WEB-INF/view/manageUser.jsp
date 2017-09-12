<%@ page import="java.util.ArrayList"%>
<%@ page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<!-- Header -->
<%@ include file="layouts/header.jsp"%>
<script src="<%=path%>/js/jquery.dataTables.min.js"></script>
<script src="<%=path%>/js/dataTables.bootstrap.min.js"></script>
<script src="<%=path%>/js/manageUser.js"></script>
<link href="<%=path%>/css/dataTables.bootstrap.min.css" rel="stylesheet">

<script>
	var admin = "<s:property value='#session.role'/>";
	var path = "<%=path%>";
	var users = "<%=request.getAttribute("users")%>";
	$(document).ready(function() {
		$('#dataTables').DataTable();
		/*if (admin != 2) {
			bootbox.alert("滚吧王八羔子", function() {
				location.href = "index";
			})
		}*/
		if (users == "null") {
			location.href = "listUsers";
		}
	});
</script>

<!-- Body -->
	<%
		ArrayList<User> userList = new ArrayList<User>();
			if (request.getAttribute("users") != null) {
				userList = (ArrayList<User>) request.getAttribute("users");
			}
	%>

	<div class="yx-container container">
		<div class="row">
			<div class="col-md-2">
				<ul class="nav nav-list">
					<li class="yx-header nav-header">管理</li>
					<li class=active><a href="listUsers"><i class="fa fa-user"></i>用户管理</a></li>
					<li><a href="listBookReleases"><i class="fa fa-book"></i>图书发布管理</a></li>
					<li><a href="listCates"><i class="fa fa-bookmark"></i>图书分类管理</a></li>
				</ul>
			</div>
			<div class="covers col-md-10">
				<div class="dataTable_wrapper">
					<table class="table table-striped table-bordered"
						id="dataTables">
						<thead>
							<tr>
							    <th>ID</th>
								<th>Nickname</th>
								<th>Role</th>
								<th>Credit</th>
								<th><a href="listUsers"><i class="fa fa-refresh"></i></a></th>
							</tr>
						</thead>
						<tbody>
							<%
								for (int i = 0; i < userList.size(); i++) {
									User user = userList.get(i);
									String s = null;
									switch(user.getRole()){
									case 0: s="未激活"; break;
									case 1: s="普通用户";break;
									case 2: s="管理员";break;
									case -1: s="被禁用户";break;
									}
							%>
							<tr>
							    <td><%=user.getId()%></td>
								<td><%=user.getNickname()%></td>
								<td><%=s%></td>
								<td><%=user.getCredit()%></td>
								<td>
									<%if(user.getRole()!=2){ %>
									<button class="btn btn-default ban" type="button"
										data-id="<%=user.getId()%>">
										<i class="fa fa-ban"></i>
									</button>
									<button class="btn btn-default unban" type="button"
										data-id="<%=user.getId()%>">
										<i class="fa fa-check"></i>
									</button>
									<%} %>
								</td>
							</tr>
							<%} %>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	
<!-- Footer -->
<%@ include file="layouts/footer.jsp"%>