<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta charset="UTF-8">
<title>Let's Rock</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="alternate icon" type="image/png" href="assets/i/favicon.png">
<link rel="stylesheet" href="assets/css/amazeui.min.css" />
<link rel="stylesheet"
	href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css">
<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>

<style>
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
</style>
</head>
<body>
	<div class="header">
		<div class="am-g">
			<h1>Let's Rock</h1>
		</div>
		<hr />
	</div>
	<div class="am-g">
		<div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">

			<form action="" method="post" class="am-form">
				<label for="id">账号:</label> <input type="text" name="user.id"
					id="id" value=""> <br> <label for="password">密码:</label>
				<input type="password" name="user.password" id="password" value="">
				<br> <label for="remember-me"> <input id="remember-me"
					type="checkbox"> 记住密码
				</label> <br />
				<div class="am-cf">
					<input type="submit" name="" value="登 录 "
						class="am-btn am-btn-primary am-btn-sm am-fl"
						onClick="this.form.action='./LoginAction.action'"> <input
						type="submit" name="" value="注 册"
						class="am-btn am-btn-primary am-btn-sm am-fl col-md-offset-1"
						onClick="this.form.action='./RegistAction.action'"> <input
						type="submit" name="" value="忘记密码 XD"
						class="am-btn am-btn-default am-btn-sm am-fr">
				</div>
			</form>
			<hr>
			<p>© 2016 ChenDiDi.</p>
		</div>
	</div>
</body>
</html>
