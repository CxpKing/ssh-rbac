<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/admin/user/userList" method="post">
		<table>
			<tr>
				<td>账号</td>
				<td><input type="text" name="account"></td>
			</tr>
			<tr>
				<td>account</td>
				<td><input type="text" name="account"></td>
			</tr>
			<tr>
				<td colspan="2">记住密码<input type="radio" name="remember"></td>
			</tr>
		</table>
	</form>
</body>
</html>