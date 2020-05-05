<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
	<style>
body,html {
	position: absolute;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	margin: 0;
	padding: 0;
}

#background {
	position: fixed;
	top: 0;
	left: 0;
	z-index: -100;
}

</style>
<style>
.title3 {      
		color: transparent;
		font-size:50px;
        -webkit-text-stroke: 1px black;
  		padding-top: 20px;
   		border-left-width: 20px;
    	padding-left: 20px;
        letter-spacing: 0.04em;
}
</style>
	<head lang="en">
	<meta charset="UTF-8">
	<title>登录</title>
	<meta name="renderer" content="webkit">
	<link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
	<link type="text/css" rel="stylesheet" href="<%=basePath%>static/css/reset.css">
	<link type="text/css" rel="stylesheet" href="<%=basePath%>static/css/login.css">
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/layer.css">
	<script type="text/javascript" charset="utf8" src="<%=basePath%>static/js/layer.js"></script>

<script type="text/javascript">
function regist() {
	layer.open( {
		type : 2,
		area : [ "30%", "60%" ],
		title : "注册",
		maxmin : true, //开启最大化最小化按钮
		content : "<%=basePath%>/view/regist.jsp",
		btn : [ '关闭' ],
		success : function(layero, index) {
			var obj = layero.find("iframe")[0].contentWindow;//获取子窗体对象
			//定义childDbClick函数
			obj.childDbClick = function() {
			var win = top.window['layui-layer-iframe' + index];
			var area = win.$("#area").val(); //获取子窗体数据
			console.log(area);
			top.layer.close(index);//关闭窗体
		}
	},
		cancel : function(index, layero) {
	
		}
	});
}
</script>
	</head>
	<body>
		<canvas id="background"></canvas>
		<h1 class="title3">康龙集团</h1>
		<div class="main-content">
			<div class="common">
				<div class="main-content-login fr">
					<div class="login-top">用户登录</div>
					<div class="login-content">
						<form action='<%=basePath%>login.action' method="post">
							<div class="login-content-input">
								<input type="text" name="username" placeholder="用户名" id="username">
							</div>
							<div class="login-content-input mt-30">
								<input type="password" name="password" placeholder="密码" id="password">
							</div>
							<div class="login-button mt-20">
								<input type="submit" value="登录" />
							</div>
						</form>
						<div class="login-content-last clear mt-30">
							<div class="login-content-reg fr">
								<a href="javaScript:regist()">免费注册</a>
							</div>
							<div class="clear"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
<script async type="text/javascript" src="<%=basePath%>static/js/background.js"></script>
	</body>
</html>

