<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="../font-awesome-4.7.0/css/font-awesome.min.css"/>
<style type="text/css">
	#group-list{
		float: left;
		width: 310px;
		margin-top: 5px;
		margin-left:3px;
	}
	i{
		color:black;
	}
	li{
		display: inline;
	}
	body{
		background-color: ;
	}
	.grop-item{
		width: 100px;
		height: 50px;
		background-color: #80ffbf;
		box-shadow: 5px 5px 5px 2px ;
		border-radius: 5px;
		margin-top:3px ;
		margin-right:2px ;
		float: right;
		text-align: center;
		line-height: 50px;
		cursor: pointer;
		/* display: inline; */
	}
	.grop-item:hover{
		background-color: #ff0055;
	}
	
</style>
</head>
<body  style="background-color:#ccffe5">

				<div id="group-list">
					<div class="grop-item">
						<li class="btn-group"><a href="#"><i class="fa fa-weixin fa-2x" aria-hidden="true"></i></a></li>
					</div>
					<div class="grop-item">
						<li class="btn-group"><a href="#"><i class="fa fa-weibo fa-2x" aria-hidden="true"></i></a></li>
					</div>
					<div class="grop-item">
						<li class="btn-group"><a href="#"><i class="fa fa-firefox fa-2x" aria-hidden="true"></i></a></li>
					</div>
		         </div>

</body>
</html>