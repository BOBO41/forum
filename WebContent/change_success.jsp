<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>


<head lang="en">
	<meta charset="UTF-8">
	<title>ChenDiDi's Rocks</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="format-detection" content="telephone=no">
	<meta name="renderer" content="webkit">
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="format-detection" content="telephone=no">
	<meta name="renderer" content="webkit">
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<link rel="alternate icon" type="image/png" href="assets/i/favicon.png">
	<link rel="stylesheet" href="assets/css/amazeui.min.css" />

	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/default.css">
	<link href="css/fileinput.css" media="all" rel="stylesheet" type="text/css" />
	<script src="http://libs.useso.com/js/jquery/2.1.1/jquery.min.js"></script>
	<script src="js/fileinput.js" type="text/javascript"></script>
	<script src="js/fileinput_locale_zh.js" type="text/javascript"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js" type="text/javascript"></script>



	<link rel="alternate icon" type="image/png" href="assets/i/favicon.png">
	<link rel="stylesheet" href="assets/css/amazeui.min.css" />
	<link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css">
	<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<style type="text/css">
		.header {
			text-align: center;
		}
		
		.header h1 {
			font-size: 200%;
			color: #333;
			margin-top: 30px;
		}
		
		.header p {
			font-size: 14px;
		}
		
		.table th,
		.table td {
			text-align: center;
			width: 33%;
			overflow: hidden;
			white-space: nowrap;
			text-overflow: ellipsis;
		}
	</style>
	
</script>


</head>

<body>

	<nav class="navbar navbar-default" role="navigation">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#example-navbar-collapse">
			<span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
			<a class="navbar-brand" href="#">ChenDiDi's Rocks</a>
		</div>
		<div class="collapse navbar-collapse" id="example-navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="./Message_PageAction.action?page=1">首页</a></li>
				<li><a href="./Message_AddAction.action">添加文章</a></li>
				<li><a href="./MAndRAction.action?page=1">我的回复</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"> 更多 <b class="caret"></b>
			</a>
					<ul class="dropdown-menu pull-right">
						<li><a href="#">jmeter</a></li>
						<li><a href="#">EJB</a></li>
						<li><a href="#">Jasper Report</a></li>
						<li class="divider"></li>
						<li><a href="#">分离的链接</a></li>
						<li class="divider"></li>
						<li><a href="#">另一个分离的链接</a></li>
					</ul>
				</li>
			</ul>
			<!--用户下拉列表-->
			<ul class="nav pull-right">

				<li class="dropdown"><a data-toggle="dropdown" class="dropdown-toggle " href="#">${sessionScope.u.name}<strong
					class="caret"></strong></a>
					<ul class="dropdown-menu pull-right">
						<li><a href="./PasswordChange.action">更改密码</a></li>
						<li class="divider"></li>
						<li><a href="./Login_OutAction.action">退出登录</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
	</br>
	</br>
	</br>
	<div class="header">
		<div class="am-g">
			<h1>修改成功</h1>
		</div>
		<hr />
	</div>
	<div class="am-g">
		<div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">

			<form name="change" action="Login_ReturnAction.action" method="post" class="am-form" >
				
				<div class="am-cf ">
					<input type="submit" name="" value="返回登陆" class="am-btn am-btn-primary am-btn-sm am-fl am-u-sm-centered">
				</div>
			</form>
			<hr>
			<p>© 2016 ChenDiDi.</p>
		</div>
	</div>

</body>

</html>