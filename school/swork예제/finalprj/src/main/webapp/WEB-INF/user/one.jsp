<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		border: 1px solid black;
		border-collapse: collapse;
	}
</style>
</head>
<body>
<h1>상품</h1>
<table>
	<tr><th>상품번호</th><th>품명</th></tr>
	<c:forEach items="${productList}" var="prod">
		<tr>
		  <td>${prod.pd_seq}</td>
		  <td>${prod.pd_name}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>