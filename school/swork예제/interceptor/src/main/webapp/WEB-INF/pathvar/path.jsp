<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Path Variable 페이지입니다.</h2>
	<p>EL방식</p>
	<p>key1 = ${ key1 }</p>
	<p>key2 = ${ key2 }</p>
	<hr>
	<p>EL방식(파라미터.)</p>
	<p>key1 = ${ param.key1 }</p>
	<p>key2 = ${ param.key2 }</p>
	<hr>
	<p>request.getParameter방식</p>
	<p>key1 = <%=request.getParameter("key1") %></p>
	<p>key2 = <%=request.getParameter("key2") %></p>
	<hr>
</body>
</html>