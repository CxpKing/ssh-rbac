<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title></title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/font-awesome-4.7.0/css/font-awesome.min.css"/>
		<base target="right">
		<style type="text/css">
			#nav{
				width:130px;
				height: 30px;
				background:#80ffbf;
				line-height: 30px ;
				border-radius: 10px;
				font-size: 18px;
				border-bottom: 2px solid #000000;
				cursor: pointer;
				
			}
			#nav:hover{
				background:white;
			}
			a{
				text-decoration: none;
			}
			li{
				list-style-type: none;
				list-style-position: outside;
				margin-top: 3px;
			}
			ul{
				padding-left:10px ;
				background-color:#000000;
				width: 130px;
				 /*border: 1px solid #000000; */
				margin-left: 0;
				margin-top: 3px;
			}
			
			#lis{
				background-color: white;
				text-align: center;
				height:25px;
				border-bottom: 2px solid #000000;
				border-radius: 10px;
				font-size: 16px;
				line-height: 25px;
			}
			#lis:hover{
				background-color: #ff0000;
			}
		</style>
		<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery-3.3.1.min.js">
		</script>
		<script type="text/javascript">
			$(function(){
				$(".drop").find("ul").hide();
				$(".drop").hover(function() {
					$(this).children("ul").slideDown(500);
					$(this).children("div").children("i").attr("class","fa fa-minus-circle");
				}, function() {
					$(this).children("ul").stop(true,false).slideUp(500);
					$(this).children("div").children("i").attr("class","fa fa-plus-circle");
				});
			});
		</script>
	</head>
	<body  style="background-color:#000000;">
		<ul style="">
			<li class="drop">
				<div id="nav" style="">&nbsp;<a href="#">用户管理</a>
			    <i class="fa fa-plus-circle"></i>
				</div>
				<ul>
					<div id="lis" style="">
						<li><i class="fa fa-group"></i>&nbsp;<a href="${pageContext.request.contextPath}/admin/userList">查看用户</a></li>
					</div>
					<div id="lis" style="">
						<li><i class="fa fa-user-plus"></i>&nbsp;<a href="${pageContext.request.contextPath}/admin/user/user_add.jsp">添加用户</a></li>
					</div>
				</ul>
			</li>
			<li class="drop">
				<div id="nav" style="">&nbsp;<a href="#">商品管理</a>
				<i class="fa fa-plus-circle"></i>
				</div>
				<ul>
					<div id="lis" style="">
						<li><a href="#">查看用户</a></li>
					</div>
					<div id="lis" style="">
						<li><a href="#">查看用户</a></li>
					</div>
				</ul>
			</li >
			<li class="drop">
				<div id="nav" style="">&nbsp;<a href="#">数据管理</a>
				<i class="fa fa-plus-circle"></i>
				</div>
				<ul>
					<div id="lis" style="">
						<li><a href="#">查看用户</a></li>
					</div>
					<div id="lis" style="">
						<li><a href="#">查看用户</a></li>
					</div>
				</ul>
			</li>
		</ul>
	</body>
</html>