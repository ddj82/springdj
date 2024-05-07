<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.drink.ko.vo.UsersVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.js"></script>
</head>
<body>
	<c:forEach items="${userList}" var="list">
		<div id="box1">고객님의 정보와 일치하는 아이디 목록입니다.</div>
		<c:choose>
			<c:when test="${list.u_state eq 2 }">
				<div id="idKakao">카카오로 가입하신 이력이 있습니다.</div>
			</c:when>
			<c:when test="${list.u_state eq 3 }">
				<div id="idNaver">네이버로 가입하신 이력이 있습니다.</div>
			</c:when>
			<c:otherwise>
				<div id="idEmail">${list.u_id }</div>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
</body>
</html>