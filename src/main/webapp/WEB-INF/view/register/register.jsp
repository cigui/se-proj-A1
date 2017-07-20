<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE>

<!-- Header -->
<%@ include file="../layouts/header.jsp"%>

<script>
	var path = "<%=path%>";
	$(document).ready(function() {
		var logined = "<s:property value='#session.logined' />";
		if (logined) {
			bootbox.alert("您已登录，无需注册！", function() {
				location.href = "index";//location.href实现客户端页面的跳转  
			})
		}
	});
</script>

<script src="<%=path%>/js/register.js"></script>

<!-- Body -->
<div class="yx-container container">
	<div class="page-header">
		<h1 class="text-primary">注册信息填写</h1>
	</div>
	<div class="row">
		<div class="col-xs-12 col-md-12">
			<form id="registerForm" class="form-horizontal"
				style="text-align: center" action="register" method="post"
				enctype="multipart/form-data">
				<!-- 这里的onsubmit属性原本是通过submit后禁用提交按钮来禁止重复提交表单，但这样也会在输入不合法时禁止提交，故暂先注释掉，后期再做修改 -->
				<!-- onsubmit="document.getElementById('submit').disabled=true;" -->
				<div class="form-group">
					<div class="col-xs-12 col-md-6">
						<div class="form-group">
							<label for="nickName" class="col-xs-4 col-md-2 control-label">昵称(*)</label>
							<div class="col-xs-8 col-md-6">
								<input type="text" class="form-control" id="nickName"
									name="nickName" placeholder="请输入昵称" required="true"
									maxlength="14">
								<p class="help-block">不超过7个汉字（即14字节）</p>
							</div>
						</div>
						<div class="form-group">
							<label for="email" class="col-xs-4 col-md-2 control-label">电子邮箱(*)</label>
							<div class="col-xs-8 col-md-6">
								<input type="text" class="form-control" id="email" name="email"
									placeholder="请输入电子邮箱" required="true" maxlength="50">
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-xs-4 col-md-2 control-label">密码(*)</label>
							<div class="col-xs-8 col-md-6">
								<input type="password" class="form-control" id="password"
									name="password" placeholder="请输入密码" required="true"
									maxlength="20">
								<p class="help-block">长度在6至20字符之间</p>
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-xs-4 col-md-2 control-label">确认密码(*)</label>
							<div class="col-xs-8 col-md-6">
								<input type="password" class="form-control" id="confirmPassword"
									name="confirmPassword" placeholder="请再次输入密码" required="true"
									maxlength="20">
								<p class="help-block">长度在6至20字符之间</p>
							</div>
						</div>
						<div class="form-group">
							<label for="location" class="col-xs-3 col-md-2 control-label">所在地(*)</label>
							<div class="col-xs-3 col-md-2">
								<label><select id="province" name="province"
									class="form-control" required="true"></select>省</label>
							</div>
							<div class="col-xs-3 col-md-2">
								<label><select id="city" name="city"
									class="form-control" required="true" disabled="disabled"></select>市</label>
							</div>
							<div class="col-xs-3 col-md-2">
								<label><select id="district" name="district"
									class="form-control" required="true" disabled="disabled"></select>区/县</label>
							</div>
							<p class="help-block">我们将据此为您推荐附近的书:)</p>
						</div>
						<div class="form-group">
							<label class="col-xs-3 col-md-2 control-label">性别</label>
							<div class="col-xs-4 col-md-2">
								<label>
									<select id="gender" name="gender" class="form-control">
										<option disabled selected value></option>
										<option value="1">男</option>
										<option value="0">女</option>
									</select>
								</label>
							</div>
						</div>
					</div>
					<div class="col-xs-12 col-md-6">
						<div class="form-group" style="text-align: center">
							<img id="preview" src="<%=path%>/images/picture-1.jpg"
								style="width: 256px; height: 256px; max-width: 256px; max-height: 256px" />
						</div>
						<div class="form-group" style="text-align: center">
							<label for="avatar">个人头像</label> <input type="file" id="avatar"
								name="avatar" style="margin: 0 auto">
							<p class="help-block">图片大小不得超过4MB</p>
						</div>
					</div>
				</div>
				<button id="submit" type="submit" class="btn btn-info">注册</button>
			</form>
		</div>
	</div>
</div>

<!-- Footer -->
<%@ include file="../layouts/footer.jsp"%>