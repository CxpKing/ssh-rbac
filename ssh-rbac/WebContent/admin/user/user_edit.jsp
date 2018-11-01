<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/admin/user/userEditHandler" method="post" enctype="multipart/form-data"> 
		<input type="hidden" name="id" value="${user.id}"/>
		<input type="hidden" name="avator" value="${user.avator}"/>
		<input type="hidden" name="sex" value="${user.sex}">
		
		<table>
		<tr>
			<td>姓名</td>
			<td><input type="text" name="name" value="${user.name }"><span></span></td>
		</tr>
		<tr>
			<td>账号</td>
			<td><input type="text" name="account" value="${user.account }"><span></span></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="password" name="password" value="${user.password }"><span></span></td>
		</tr>
		<tr>
			<td>邮箱</td>
			<td><input type="text" name="email" value="${user.email }"><span></span></td>
		</tr>
		<tr>
			<td>电话</td>
			<td><input type="text" name="phone" value="${user.phone }" ><span></span></td>
		</tr>
		<tr>
			<td>头像</td>
			<td><input type="file" name="upfile" value="${user.avator }" ><span></span></td>
		</tr>
		<tr>
			<td>修改</td>
			<td><input type="submit" value="保存"><span></span></td>
		</tr>
	</table>
	</form>
</body>
</html>