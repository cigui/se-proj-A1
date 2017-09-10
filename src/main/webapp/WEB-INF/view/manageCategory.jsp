<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Category"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<!-- Header -->
<%@ include file="layouts/header.jsp"%>
<script src="<%=path%>/js/jquery.dataTables.min.js"></script>
<script src="<%=path%>/js/dataTables.bootstrap.min.js"></script>
<link href="<%=path%>/css/dataTables.bootstrap.min.css" rel="stylesheet">
<script src="<%=path%>/js/manageCategory.js"></script>

<script>
	var admin = "<s:property value='#session.role'/>";
	$(document).ready(function() {
		/*if (admin != 2) {
			bootbox.alert("滚吧王八羔子", function() {
				location.href = "index";
			})
		}*/
		$('#dataTables').DataTable();
	});
</script>

<!-- Body -->
	<%
		ArrayList<Category> cateList = new ArrayList<Category>();
			if(request.getAttribute("categories") != null){
				cateList = (ArrayList<Category>) request.getAttribute("categories");
			}
	%>

	<div class="yx-container container">
		<div class="row">
			<div class="col-md-2">
				<ul class="nav nav-list">
					<li class="yx-header nav-header">管理</li>
					<li><a href="listUsers"><i class="fa fa-user"></i>用户管理</a></li>
					<li><a href="listBookReleases"><i class="fa fa-book"></i>图书发布管理</a></li>
					<li class=activei><a href="listCates"><i class="fa fa-bookmark"></i>图书分类管理</a></li>
				</ul>
			</div>
			<div class="covers col-md-10">
				<div class="dataTable_wrapper">
					<table class="table table-striped table-bordered"
						id="dataTables">
						<thead>
							<tr>
							    <th>Name</th>
								<th>
									<button class="btn btn-default" type="button" id="add">
										<i class="fa fa-plus"></i>
									</button>
								</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (int i = 0; i < cateList.size(); i++) {
																	Category category = cateList.get(i);
							%>
							<tr>
								<td><%=category.getName()%></td>
								<td>
									<button class="btn btn-default delete" type="button"
										data-id="<%=category.getCate_id()%>">
										<i class="fa fa-trash"></i>
									</button>
									<button class="btn btn-default edit" type="button"
										data-id="<%=category.getCate_id()%>">
										<i class="fa fa-edit"></i>
									</button>
								</td>
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
	
	<div class="modal fade" id="modal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="modalTitle"></h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-lg-12">
							<div>
								<div class="form-group">
									<label>Category</label> <input class="form-control"
										name="category">
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" id="save">Save</button>
				</div>
			</div>
		</div>
	</div>
	
<!-- Footer -->
<%@ include file="layouts/footer.jsp"%>