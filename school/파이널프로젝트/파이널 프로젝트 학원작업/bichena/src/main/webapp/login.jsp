<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
.form-signin.mainBox {
	display: flex;
	flex-direction: column;
	align-items: center;
}

form.form-signin {
	text-align: center;
}

.form-signin.subBox {
	border: 1px solid black;
	text-align: center;
}
</style>
</head>
<body>
<c:choose>
	<c:when test="${userID == null }">
		<div class="form-signin mainBox">
			<div class="form-signin subBox">
				<form class="form-signin" action="login.ko" method="post">
					<div class="form-group">
						<label for="inputUserName" class="sr-only">User Name</label>
						<input type="text" class="form-control" placeholder="ID" name="u_id" required autofocus>
					</div>
					<div class="form-group">
						<label for="inputPassword" class="sr-only">Password</label>
						<input type="password" class="form-control" placeholder="Password" name="u_pw" required>
					</div>
					<button class="btn btn btn-lg btn-success btn-block" type="submit">로그인</button>
				</form>
				<a class="nav-item" href="idFind.jsp">아이디 찾기</a>
			</div>
		</div>
	</c:when>
	<c:otherwise>
		
	</c:otherwise>
</c:choose>

<%
if (request.getParameter("error") != null && request.getParameter("error").equals("1")) {
	out.println("<div class='alert alert-danger'>");
	out.println("아이디와 비밀번호를 확인해 주세요");
	out.println("</div>");
}
%>
</body>
</html>