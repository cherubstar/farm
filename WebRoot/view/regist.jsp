<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
	<head lang="en">
		<meta charset="UTF-8">
		<title>登录</title>
		<meta name="renderer" content="webkit">
		<style type="text/css">
        .mandatory{
            color: red;
        }
    </style>
	<link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
	<link type="text/css" rel="stylesheet" href="<%=basePath%>static/css/reset.css">
	<link type="text/css" rel="stylesheet" href="<%=basePath%>static/css/login.css">
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	
	<script type="text/javascript">
		function regist() {
			var username = $("#username").val();
			var password = $("#password").val();
			var department = $('#department').val();
			var name = $('#name').val();
			var position = $("#position").val();
			$.ajax( {
				type : 'POST',
				url : '<%=basePath%>RegistServlet.action',
				data : {
					"account" : username,
					"password" : password,
					'permission' :　position,
					"department" : department,
					"name" : name,
				},
				success : function(c) {
					alert(c);
				}
			})
		}
	</script>
	</head>
	
	<body>
		<div class="main-content">
			<div class="common">
				<div class="login-content-input">
					<div class="login-content-input mt-30">
						姓名：<input type="text" id="name" name="name" placeholder="姓名" required="required">
					</div>
				</div>
				<div class="login-content-input">
					<div class="login-content-input mt-30">
						账号：<input type="text" name="username" id="username" placeholder="账号" required="required">
					</div>
				</div>
				<div class="login-content-input">
					<div class="login-content-input mt-30">
						密码：<input type="password" id="password" name="password" placeholder="密码" required="required">
					</div>
				</div>
				<div class="login-content-input">
					<div class="login-content-input mt-30">
						部门：<input type="text" id="department" name="department" placeholder="部门" required="required">
					</div>
				</div>
				<div class="login-content-input">
					<div class="login-content-input mt-30">
						职位：<select id="position">
								<option value="0">请选择</option>
								<option value="1">管理员</option>
								<option value="2">普通职员</option>
							</select>
					</div>
				</div>
				<div class="login-content-input">
					<div class="login-content-input mt-30">
						&nbsp;&nbsp;&nbsp;
						<input id='regist' type="submit" value="申请注冊" onclick="regist()" />
					</div>
				</div>
			</div>
<script>$('[required]').after('<span class="mandatory">*</span>');</script>
		</div>
	</body>
</html>


