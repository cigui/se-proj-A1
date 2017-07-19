<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>阅享 - 借书车</title>
<%
	String ctx = request.getContextPath();
%>

<script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/bootbox.js/4.4.0/bootbox.min.js"></script>
<script
	src="https://cdn.bootcss.com/jquery-validate/1.16.0/jquery.validate.min.js"></script>

<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<%=ctx%>/css/login_style.css" rel="stylesheet">
<link href="<%=ctx%>/css/yxdefault.css" rel="stylesheet">
<link href="<%=ctx%>/css/releasebook.css" rel="stylesheet">
<style type="text/css">
.error {
	color: red;
	font-weight: normal
}
</style>
</head>
<body>
	<div
		class="yx-nav navbar navbar-default navbar-left navbar-static-top yx-nav" style="width:100%; margin-bottom:0">
		<a class="yx-brand navbar-brand" href="index" style="color: cadetblue">阅享图书交流平台</a>
		<div class="yx-toolbar">
			<a class="btn btn-default btn-sm" href="<%=ctx%>/ReleaseBook">发布图书</a>
			<form class="yx-search-bar">
				<input type="text" name="searchString" placeholder="查询图书" />
				<button class="btn btn-sm btn-primary btn-block" type="submit">Search</button>
			</form>
			<span>Hi, <s:property value='#session.userName' />!
			</span> <a href="profile" class="btn btn-default btn-sm" role="button">个人信息</a>
			<a href="logout" class="btn btn-default btn-sm" role="button">登出</a>
		</div>
	</div>

	
   
<div id='cart' class="container">
    
    <h2>我的购物车</h2>
    <form id="cart-form" role="form" method="POST" action="<%=ctx%>/cart/checkout">
        <div v-if="items.length > 0">
            <table class="table table-striped table-bordered">
                <thead>
                <tr>
                    <td>
                        <button type="button" class="btn btn-default btn-sm" v-if="all_checked" v-on:click="uncheck_all()">全不选</button>
                        <button type="button" class="btn btn-default btn-sm" v-else v-on:click="check_all()">全选</button>
                    </td>
                    <td>封面</td>
                    <td>书名</td>
                    <td>单价</td>
                    <td>数量</td>
                    <td>小计</td>
                    <td>操作</td>
                </tr>
                </thead>
                <tbody>
                    <tr v-for="item in items">
                        <td class="vmid"><input type="checkbox" v-model="item.checked"></td>
                        <td><img v-bind:src="'<%=ctx%>/cover?id=' + item.bookId" class="cart-cover"></td>
                        <td class="vmid">{{item.book.name}}</td>
                        <td class="vmid">{{item.book.price}}</td>
                        <td class="vmid">
                            <div class="input-group cart-num">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button" v-on:click="sub_one($index)">-</button>
                                </span>
                                <input type="text" class="form-control" v-bind:name="item.checked ? item.bookId : null" v-model="item.num" number>
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button" v-on:click="add_one($index)">+</button>
                                </span>
                            </div>
                        </td>
                        <td class="vmid">{{item.book.price * item.num}}</td>
                        <td class="vmid">
                            <button class="btn btn-danger" v-on:click="remove_item($index)">
                                <span class="glyphicon glyphicon-trash"></span>
                            </button>
                        </td>
                    </tr>
                </tbody>
            </table>
            <div class="clearfix">
                <a href="<%=ctx%>/index" class="btn btn-info pull-left">返回购书</a>
                <button class="btn btn-success pull-left" v-on:click="save_cart()">暂存</button>
                <button class="btn btn-primary pull-right" v-bind:disabled="!allow_checkout" v-on:click="checkout()">提交订单</button>
                <p class="cart-sum pull-right">合计: {{total}}元</p>
            </div>
        </div>
        <div v-else>
            您的购物车还是空的！
            <a href="<%=ctx%>/index" class="btn btn-info">马上去购书</a>
        </div>
    </form>
</div>

<script type="text/javascript" src="<%=ctx%>/js/vue.js"></script>
<script type="text/javascript">
    $.get('<%=ctx%>/cart/data', function(data, status) {
        items = JSON.parse(data);
        items.forEach(function (item) {
            item.checked = true;
        });

        var vm = new Vue({
            el: '#cart',
            data: {
                items: items,
                allow_checkout: true,
                msg: null
            },
            computed: {
                total: function () {
                    var res = 0;
                    this.items.forEach(function(item) {
                        if (item.checked) {
                            res += item.book.price * item.num;
                        }
                    });
                    return res;
                },
                all_checked: function () {
                    return this.items.every(function (item) {
                        return item.checked;
                    });
                }
            },
            methods: {
                remove_item: function (id) {
                    this.items.splice(id, 1);
                },
                add_one: function (id) {
                    this.items[id].num += 1;
                },
                sub_one: function (id) {
                    if (this.items[id].num > 1) {
                        this.items[id].num -= 1;
                    }
                },
                check_all: function () {
                    this.items.forEach(function (item) {
                        item.checked = true;
                    });
                },
                uncheck_all: function () {
                    this.items.forEach(function (item) {
                        item.checked = false;
                    });
                },
                clear_msg: function() {
                    this.msg = null;
                },
                encode_cart: function () {
                    var res = {};
                    this.items.forEach(function(item) {
                        res[item.bookId] = item.num;
                    });
                    return res;
                },
                save_cart: function () {
                    var self = this;
                    $.post('<%=ctx%>/cart/save', self.encode_cart(), function(data, status) {
                        var response = JSON.parse(data);
                        if (response.success) {
                            self.msg = {
                                type: 'success',
                                text: '暂存成功'
                            };
                        } else {
                            self.msg = {
                                type: 'danger',
                                text: '暂存失败'
                            };
                        }
                    });
                },
                checkout: function () {
                    console.log("called");
                    this.allow_checkout = false;
                    var cart = {};
                    this.items.forEach(function(item) {
                        if (!item.checked) {
                            cart[item.bookId] = item.num;
                        }
                    });

                    var self = this;
                    $.post('<%=ctx%>/cart/save', cart, function(data, status) {
                        var response = JSON.parse(data);
                        if (response.success) {
                            document.getElementById("cart-form").submit();
                        } else {
                            self.allow_checkout = true;
                            self.msg = {
                                type: 'danger',
                                text: '提交失败'
                            };
                        }
                    });
                }
            }
        });
    });
</script>
    