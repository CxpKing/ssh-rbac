<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/login.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#vcode").css("cursor","pointer");
		$("#vcode").click(function(){
			$(this).attr("src","${pageContext.request.contextPath}/admin/vcode?"+new Date().getTime());
		});
		$("#register").click(function(){
			window.location="${pageContext.request.contextPath}/admin/register.jsp";
		});
	});
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath}/admin/login" method="post">
		<table align="center" border="1" cellspacing="0" cellpadding="5"  bordercolor="black">
			<tr>
				<td class="left">账号</td>
				<td class="right"><input type="text" name="account"></td>
			</tr>
			<tr>
				<td class="left">密码</td>
				<td class="right"><input type="password" name="password"></td>
			</tr>
			<tr>
				<td class="left">验证码</td>
				<td class="right"><input type="text" name="code"><img id="vcode" src="${pageContext.request.contextPath}/admin/vcode"/></td>
			</tr>
			<tr align="center"> 
				<td colspan="2">
				<input type="submit" value="登陆"/> <input id="register" type="button" value="注册"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>