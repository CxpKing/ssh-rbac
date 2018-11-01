<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<frameset rows="80,*,70" border="0" frameborder="1">
	<frame src="top.jsp" name="top" scrolling="no">
		<frameset cols="170,*">
			<frame src="left.jsp" name="left" scrolling="no">
			<frame src="right.jsp" name="right" scrolling="no">
		</frameset>
	<frame src="footer.jsp" name="footer" scrolling="no">
</frameset>
</html>