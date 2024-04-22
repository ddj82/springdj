<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if (request.getParameter("result") != null) { %>
<div>회원가입 성공 여부: <strong><%=request.getParameter("result") %></strong></div>
<%} %>
<a href="insert.jsp">글쓰기</a>
</body>
</html>