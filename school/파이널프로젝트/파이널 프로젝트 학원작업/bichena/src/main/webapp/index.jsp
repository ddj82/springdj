<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주류페이지</title>
<style>
img {
	width: 300px;
	hight: 300px;
}
img:hover {
	cursor: pointer;
	border: 1px solid black;
}
</style>
</head>
<body>
<c:choose>
	<c:when test="${userID == null }">
		<a href="login.jsp">로그인</a>
	</c:when>
	<c:otherwise>
		<%@ include file="menu.jsp" %>
	</c:otherwise>
</c:choose>
<br><br>
<a href="prodList.ko">주류목록</a>
<br><br>
<a href="">공지사항</a>
<a href="">자주 묻는 질문</a>
<a href="qnaList.ko">문의사항</a>
</body>
</html>