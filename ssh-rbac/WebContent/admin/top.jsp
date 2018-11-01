<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>top</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/font-awesome-4.7.0/css/font-awesome.min.css"/>
<style type="text/css">
	table{
		width: 100%;
		margin: auto;
		margin-top: 10px;
		
	}
	#avatar{
		width:50px;
		height:50px;
		border-radius: 100%;
		box-shadow: -3px 3px 3px 2px ;
		color:black;
	}
	
	#group-list{
		float: right;
		
		width: 420px;
		margin-top: 0;
	}
	li{
		display: inline;
	}
	i{
		color:black;
	}
	.grop-item{
		width: 100px;
		height: 50px;
		background-color: aquamarine;
		box-shadow: -5px 5px 5px 2px ;
		border-radius: 5px;
		margin-top:3px ;
		margin-right:3px ;
		float: left;
		text-align: center;
		line-height: 50px;
		cursor: pointer;
		/* display: inline; */
	}
	.grop-item:hover{
		background-color: white;
	}

</style>
</head>
<body style="background-color:#80ffbf">
	<table border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
				&nbsp;&nbsp;&nbsp;<a><img id="avatar" src="${pageContext.request.contextPath}/admin/${user.avator}" onerror="this.src='${pageContext.request.contextPath}/admin/images/logo2.png'"></a>
				<span>欢迎${user.name}登录!</span>
			</td>
			<td style="text-align:right">
				<div id="group-list">
					<div class="grop-item">
						<li class="btn-group"><a href="#"><i class="fa fa-angle-double-left fa-2x" aria-hidden="true"></i></a></li>
					</div>
					<div class="grop-item">
						<li class="btn-group"><a href="#"><i class="fa fa-angle-double-right fa-2x" aria-hidden="true"></i></a></li>
					</div>
					<div class="grop-item">
						<li class="btn-group"><a href="#"><i class="fa fa-home fa-2x"></i></a></li>
					</div>
					<div class="grop-item">
						<li class="btn-group"><a href="#"><i class="fa fa-power-off fa-2x" aria-hidden="true"></i></a></li>
					</div>
		         </div>
				
			</td>
		</tr>
	</table>
</body>
</html>