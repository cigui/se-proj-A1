<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.User" %>
<%@ page import="model.District" %>
<%@ page import="model.Picture" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- Header -->
<%@ include file="WEB-INF/view/layouts/header.jsp"%>
<script src="<%=path%>/js/shoppingCart.js"></script>

<body>  
<div class="yx-container container">
			<div class="row">
			<br>
		</div>
	    <div class="page-header">
			<h1 class="text-primary">
				我的借书车
			</h1>
		</div>
		
  <div id='cart' class="container">
     <form id="cart-form" role="form" method="POST" action="commitOrder">
        <div v-if="items.length > 0">
            <table class="table table-striped table-bordered">
                <thead>
                <tr>
                    <td>
                        
                        <button type="button" class="btn btn-default btn-sm" v-on:click="check_all()">全选</button>
                    </td>
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
                <a href="<%=path%>/index" class="btn btn-info pull-left">返回购书</a>
                <button class="btn btn-primary pull-right" v-bind:disabled="!allow_checkout" v-on:click="checkout()">提交订单</button>
                <p class="cart-sum pull-right">合计: {{total}}元</p>
            </div>
        </div>
        <div v-else>
            您的购物车还是空的！
            <a href="<%=path%>/index" class="btn btn-info">马上去购书</a>
        </div>
    </form>
</div>
</div>

<script type="text/javascript" src="<%=path%>/js/vue.js"></script>
<script type="text/javascript">
    $.get('<%=path%>/cart/data', function(data, status) {
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
                    $.post('<%=path%>/cart/save', self.encode_cart(), function(data, status) {
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
                    $.post('<%=path%>/cart/save', cart, function(data, status) {
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
    