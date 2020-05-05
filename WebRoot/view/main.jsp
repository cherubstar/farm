<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<!-- Tell the browser to be responsive to screen width -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>康龙集团智能农业用户管理系统</title>
	<!-- jQuery -->
	<script type="text/javascript" charset="utf8" src="<%=basePath%>static/js/jquery.min.js"></script>

	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/layer.css">
	<!--This page css - Morris CSS -->
	<link href="<%=basePath%>static/assets/plugins/c3-master/c3.min.css" rel="stylesheet">
	<!-- Custom CSS -->
	<link href="<%=basePath%>static/css/style.css" rel="stylesheet">
	<!-- You can change the theme colors from here -->
	<link href="<%=basePath%>static/css/colors/blue.css" id="theme" rel="stylesheet">
	<link href="<%=basePath%>static/assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- DataTables -->
	<script type="text/javascript" charset="utf8" src="<%=basePath%>static/js/datatables.min.js"></script>
	<script type="text/javascript" charset="utf8" src="<%=basePath%>static/js/layer.js"></script>
	<script type="text/javascript" charset="utf8" src="<%=basePath%>static/DataTables-1.10.18/js/dataTables.bootstrap.js"></script>
	<script type="text/javascript" charset="utf8"src="<%=basePath%>static/DataTables-1.10.18/js/jquery.dataTables.min.js"></script>
	
	<!-- Bootstrap Core CSS -->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/DataTables-1.10.18/css/dataTables.bootstrap.css">
	<script type="text/javascript" charset="utf8" src="<%=basePath%>static/DataTables-1.10.18/js/jquery.dataTables.js"></script>
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

<script type="text/javascript">
$(document).ready(function() {
	initDataTable();
	$('#div2').css('display', 'none');
	table2();
})
function changge(pid) {
	if (pid == "tab1") {
		$('#div1').css('display', 'block');
		$('#div2').css('display', 'none');
	} else {
		$('#div1').css('display', 'none');
		$('#div2').css('display', 'block');
	}
}
function deletes(index) {

	$.ajax({
		url : "delete.action",
		type : "POST",
		data : {
			"id" : index,
		},
		success : function(data) {
			if (data == 1) {
				layer.msg("成功删除用户" + index);
				location.reload();
			} else {
				layer.msg("刪除失敗");
			}
		}
	});
}

function ChangeData(acc) {
	layer.confirm ('是否通过该用户', {
		type: 0,
		skin : 'layui-layer-molv', //样式类名  自定义样式
		closeBtn : 1, // 是否显示关闭按钮
		anim : 4, //动画类型
		btn : [ '通过', '拒绝' ], //按钮
		icon : 6, // icon
		yes : function() {
			$.ajax( {
				'url' : 'addUser.action',
				'type' : 'post',
				'data' : {
					"username" : acc,
				},
				'success' : function(e) {
					layer.msg('成功添加用户' + acc);
					location.reload();
				}
			})
		},
		btn2 :　function() {
			$.ajax( {
				'url' : 'refuse.action',
				'type' : 'post',
				'data' : {
					"username" : acc,
				},
				'success' : function(e) {
					layer.msg('拒绝添加用户' + acc);
					location.reload();
				}
			})
		}
	});
}
function initDataTable() {
$('#table_id_examine1').DataTable( {

		"bAutoWidth": false,
		"serverSide" : true,
		"sScrollX": "200%",
		"sScrollXInner": "100%",
		"info" : false,//是否显示页脚信息
		"order": [],
		bFilter: false,    //去掉搜索框方法三：这种方法可以
        bLengthChange: false,   //去掉每页显示多少条数据方法
		"columns" : [
		
			{orderable : false,
				data: function (data, type, full, meta) {
		        	return '<input type="button" value="删除" class="btn btn-primary"  onclick="deletes(\''+ data.ID +'\')"//>';
		        }
		    },
			{orderable : false, data : 'ID'},
			{orderable : false, data : 'USERNAME'},
			{orderable : false, data : 'PASSWORD'},
			{orderable : false, data : 'NAME'},
			{orderable : false, data : 'DEPARTMENT'}
		],
		"ajax" : {
			type : 'POST',
			url : 'queryUser.action',
		}
	});
}

function table2(){

	$('#table_id_example2').DataTable({

		"bAutoWidth": false,
		"serverSide" : true,
		"info" : false,//是否显示页脚信息
		"order": [],
		bFilter: false,    //去掉搜索框方法三：这种方法可以
        bLengthChange: false,   //去掉每页显示多少条数据方法
		"columns" : [
			{orderable : false,
				data: function (data, type, full, meta) {
	        		return '<input type="button" value="操作" class="btn btn-primary"  onclick="ChangeData(\''+ data.USERNAME +'\')"//>';
	        	}
			},
			{orderable : false, data : 'NAME'},
			{orderable : false, data : 'USERNAME'},
			{orderable : false, data : 'PASSWORD'},
			{orderable : false, data : 'PERMISSION'},
			{orderable : false, data : 'DEPARTMENT'} 
		],
		"ajax" : {
			type : 'POST',
			url : 'queryRegister.action',
		}
	});
}
	$.fn.dataTable.ext.errMode = 'none';
</script>
</head>
<body class="fix-header fix-sidebar card-no-border">

	<div class="preloader">
		<svg class="circular" viewBox="25 25 50 50">
			<circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10" />
		</svg>
	</div>
	
	<div id="main-wrapper">
	
		<header class="topbar">
			<nav class="navbar navbar-toggleable-sm navbar-light">
				<div class="navbar-header">康龙集团智能农业用户管理系统</div>
				<div class="navbar-collapse">
					<ul class="navbar-nav mr-auto mt-md-0"></ul>
					<ul class="navbar-nav my-lg-0">
						<li class="nav-item dropdown">
							<a class=" nav-toggler " href="javascript:void(0)"><i class="mdi mdi-menu"></i></a>
						</li>
					</ul>
				</div>
			</nav>
		</header>
		
		<aside class="left-sidebar">
			<!-- Sidebar scroll-->
			<div class="scroll-sidebar">
				<!-- Sidebar navigation-->
				<nav class="sidebar-nav">
					<ul id="sidebarnav">
						<li onclick="changge('tab1')">
							<a class="waves-effect waves-dark" aria-expanded="false"><span class="hide-menu">用户管理</span> </a>
						</li>
						<li onclick="changge('tab2')">
							<a class="waves-effect waves-dark" aria-expanded="false"><span class="hide-menu">用户审批</span> </a>
						</li>
					</ul>
				</nav>
				<!-- End Sidebar navigation -->
			</div>
		</aside>
		
		<div id="tab">
			<div id="div1" class="page-wrapper" style="dispaly: bolck">
				<%@include file="/view/UserManage.jsp"%>
			</div>
			<div id="div2" class="page-wrapper" style="dispaly: none">
				<%@include file="/view/UserControll.jsp"%>
			</div>
		</div>
		
		<!-- Bootstrap tether Core JavaScript -->
		<script src="<%=basePath%>static/assets/plugins/bootstrap/js/tether.min.js"></script>
		<script src="<%=basePath%>static/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
		<!-- slimscrollbar scrollbar JavaScript -->
		<script src="<%=basePath%>static/js/jquery.slimscroll.js"></script>
		<!--Wave Effects -->
		<script src="<%=basePath%>static/js/waves.js"></script>
		<!-- Menu sidebar 
		<script src="<%=basePath%>static/js/sidebarmenu.js"></script>-->
		<!--stickey kit -->
		<script src="<%=basePath%>static/assets/plugins/sticky-kit-master/dist/sticky-kit.min.js"></script>
		<!--Custom JavaScript -->
		<script src="<%=basePath%>static/js/custom.min.js"></script>
		<!-- ============================================================== -->
		<!-- This page plugins -->
		<!-- ============================================================== -->
		<!-- chartist chart -->
		<script src="<%=basePath%>static/assets/plugins/chartist-js/dist/chartist.min.js"></script>
		<script src="<%=basePath%>static/assets/plugins/chartist-plugin-tooltip-master/dist/chartist-plugin-tooltip.min.js"></script>
		<!--c3 JavaScript -->
		<script src="<%=basePath%>static/assets/plugins/d3/d3.min.js"></script>
		<script src="<%=basePath%>static/assets/plugins/c3-master/c3.min.js"></script>
		<!-- Chart JS -->
		<script src="<%=basePath%>static/js/dashboard1.js"></script>
	</div>
</body>
</html>

