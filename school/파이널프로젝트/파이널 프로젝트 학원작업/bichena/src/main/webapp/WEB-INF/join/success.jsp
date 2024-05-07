<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.success {
	width: 500px;
	margin: 0 auto;
}

.do {
	width: 322px;
	padding: 5px;
	height: 40px;
	background-color: rgb(0, 150, 243);
	color: rgb(255, 255, 255);
	border-radius: 5px;
	border: none;
	cursor: pointer;
	font-size: 15px;
	font-weight: bold;
}

</style>
</head>
<body>
	<div class="success">
		<h1>회원가입이 완료되었습니다.</h1>
		<p>로그인 후 이용해주세요.</p>
		<form action="loginPage.ko">
			<input class="do" type="submit" value="로그인하기">
		</form>
	</div>
</body>
</html>