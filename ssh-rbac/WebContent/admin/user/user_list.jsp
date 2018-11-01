<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<table width="80%" border="1" cellpadding="0" cellspacing="0" align="center">
  <tr>
    <th>编号</th>
    <th>头像</th>
    <th>姓名</th>
    <th>账号</th>
    <th>邮箱</th>
    <th>电话</th>
    <th>注册时间</th>
    <th>操作</th>
  </tr>
  
  <c:forEach items="${users.items}" var="user" varStatus="vs">
  <tr>
    <td>${vs.count + users.pageSize * (users.pageNumber-1)}</td>
    <td>
      <c:if test="${!empty user.avator}">
    	<a href="${pageContext.request.contextPath}/${user.avator}" target="_blank"><img src="${pageContext.request.contextPath}/${user.avator}" height="25"/></a>
      </c:if>
    </td>
    <td>${user.name}</td>
    <td>${user.account}</td>
    <td>${user.email}</td>
    <td>${user.phone}</td>
    <td><fmt:formatDate value="${user.regtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
    <td><a href="${pageContext.request.contextPath}/admin/user/userEdit?id=${user.id}">修改</a> | <a href="javascript:del(${user.id},${page})">删除</a></td>
  </tr>
  </c:forEach>
</table>
<table width="80%" border="0" cellpadding="0" cellspacing="0" align="center">
  <tr align="right">
    <td>${users.showPage}</td>
  </tr>
</table>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" >
		function del(id,page){
			if(confirm("您确定要删除吗？")){
				window.location="${pageContext.request.contextPath}/admin/user/userDelete?id=" + id + "&page=" + page;
			}
		}
</script>
</body>
</html>