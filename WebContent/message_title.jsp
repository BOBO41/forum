<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>ChenDiDi's Rocks</title>
<link rel="stylesheet"
	href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css">
<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<style type="text/css">
.table th, .table td {
	text-align: center;
	width: 33%;
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}
</style>
<script type="text/javascript">
	$(document)
			.ready(
					function() {

						$('#search_article')
								.click(
										function() {

											var keyword = $('#keyword').val();
											location.href = "./Searching_TitleAction.action?page=1&keyword="
													+ encodeURI(encodeURI(keyword));
											// $('#messages').bootstrapTable('refresh', { url: './SearchingAction.action?keyword=' + keyword  });
										});
					});
</script>
</head>

<body>

	<nav class="navbar navbar-default" role="navigation">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#example-navbar-collapse">
			<span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="#">ChenDiDi's Rocks</a>
	</div>
	<div class="collapse navbar-collapse" id="example-navbar-collapse">
		<ul class="nav navbar-nav">
			<li class="active"><a href="./Message_PageAction.action?page=1">首页</a></li>
			<li><a href="./Message_AddAction.action">添加文章</a></li>
			<li><a href="#">我的回复</a></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"> 更多 <b class="caret"></b>
			</a>
				<ul class="dropdown-menu pull-right">
					<li><a href="#">jmeter</a></li>
					<li><a href="#">EJB</a></li>
					<li><a href="#">Jasper Report</a></li>
					<li class="divider"></li>
					<li><a href="#">分离的链接</a></li>
					<li class="divider"></li>
					<li><a href="#">另一个分离的链接</a></li>
				</ul></li>
		</ul>
		<!--用户下拉列表-->
		<ul class="nav pull-right">

			<li class="dropdown"><a data-toggle="dropdown"
				class="dropdown-toggle " href="#">${sessionScope.u.name}<strong
					class="caret"></strong></a>
				<ul class="dropdown-menu pull-right">
					<li><a href="./PasswordChange.action">更改密码</a></li>
					<li class="divider"></li>
					<li><a href="./Login_OutAction.action">退出登录</a></li>
				</ul></li>
		</ul>
	</div>
	</nav>



	<!--搜索栏-->
	<div class="container-fluid pull-right">


		<div class="input-append ">
			<input id="keyword" class="span2 " type="text"
				placeholder="输入 标题,作者id,日期" style="width: 339px; height: 26px">

			<div class="btn-group ">
				<button class="btn dropdown-toggle" data-toggle="dropdown">
					Search <span class="caret"></span>
				</button>
				<ul class="dropdown-menu pull-right">
					<li role="presentation"><a id="search_article" role="menuitem"
						tabindex="-1" href="#">标题</a></li>
					<li role="presentation"><a role="menuitem" tabindex="-1"
						href="#">作者id</a></li>
					<li role="presentation"><a role="menuitem" tabindex="-1"
						href="#">日期</a></li>
				</ul>
			</div>

		</div>

	</div>
	<!--表格-->
	<div class="container-fluid">
		<table id="messages" class="table table-hover"
			style="table-layout: fixed">
			<thead>
				<tr>
					<th>标题</th>
					<th>作者id</th>
					<th>日期</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${message}" var="message">
					<tr>
						<td class="center"><span class="center"><a
								href="./Message_ReplyAction.action?messageid=${message.messageid}&page=1">${message.title}</a></span></td>
						<td class="center"><span class="center">${message.id}</span></td>
						<td class="center"><span class="center">${message.createdate}</span></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<nav style="text-align: center">
		<ul class="pagination ">
			<li><a
				href="./Searching_TitleAction.action?page=1&keyword=${keyword}">&laquo;</a></li>
			<li><a
				href="./Searching_TitleAction.action?page=${page-2}&keyword=${keyword}">${page-2}</a></li>
			<li><a
				href="./Searching_TitleAction.action?page=${page-1}&keyword=${keyword}">${page-1}</a></li>
			<li><a
				href="./Searching_TitleAction.action?page=${page}&keyword=${keyword}">${page}</a></li>
			<li><a
				href="./Searching_TitleAction.action?page=${page+1}&keyword=${keyword}">${page+1}</a></li>
			<li><a
				href="./Searching_TitleAction.action?page=${page+2}&keyword=${keyword}">${page+2}</a></li>
			<li><a
				href="./Searching_TitleAction.action?page=-1&keyword=${keyword}">&raquo;</a></li>
		</ul>
		</nav>
	</div>
</body>

</html>