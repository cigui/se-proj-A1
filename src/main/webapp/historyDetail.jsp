<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.BorrowHistory"%>
<%@ page import="model.Book"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- Header -->
<%@ include file="WEB-INF/view/layouts/header.jsp"%>

<div class="yx-container container">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-7">
			<h1>A<!-- book name --></h1>
		</div>
	</div>

	<div class="row">
		<div class="col-md-1"></div>
		<div class="infors col-md-6">
			<div class="row">
				<div class="col-md-3">
					<h3>状态</h3>
				</div>
				<div class="col-md-7">
					<h3><!-- status --></h3>
				</div>
			</div>
			<p></p>
			<div class="row">
				<div class="col-md-3">
					<h3>时间</h3>
				</div>
				<div class="col-md-7">
					<h3><!-- timestamp --></h3>
				</div>
			</div>
			<p></p>
			<div class="row">
				<div class="col-md-3">
					<h3>借出者</h3>
				</div>
				<div class="col-md-7">
					<h3><!-- user --></h3>
				</div>
			</div>
			<p></p>
			<div class="row">
				<div class="col-md-3">
					<h3>花费</h3>
				</div>
				<div class="col-md-7">
					<h3><!-- price --></h3>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Footer -->
<%@ include file="WEB-INF/view/layouts/footer.jsp"%>