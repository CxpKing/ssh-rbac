<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/admin/user/userAdd" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="name" value="${user.name}"><span>${msg.name}</span></td>
			</tr>
			<tr>
				<td>账号</td>
				<td><input type="text" name="account" value="${user.account}"><span>${msg.account}</span></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password" value="${user.password}"><span>${msg.password}</span></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="text" name="email" value="${user.email}"><span>${msg.email}</span></td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input type="text" name="phone" value="${user.phone}"><span>${msg.phone}</span></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input type="radio" name="sex" value="男" checked>男<input type="radio" name="sex" value="女">女</td>
			</tr>
			<tr>
				<td>头像</td>
				<td><input type="file" name="avator"></td>
			</tr>
			<tr>
				<td>保存</td>
				<td><input type="submit" value="提交"></td>
			</tr>		
		</table>
	</form>
</body>
</html>