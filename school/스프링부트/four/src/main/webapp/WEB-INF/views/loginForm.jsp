<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>index페이지</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	<style>
		.fBtn{margin:0 20px;border-radius:5px!important;}
		.input-group{margin:0 auto;width:350px!important;}
	</style>
</head>
<body class='container'>
	<h2>로그인</h2>
	<form action="login" method="post" class='card'>
		<input type="text" name='username' placeholder="username" />
		<input type="text" name='password' placeholder="password" />
	
		<div class="input-group p-3">
			<input type='submit' class="btn btn-primary form-control fBtn" value='로그인' />
			<input type='button' class="btn btn-primary form-control fBtn" value='회원가입' onclick="javascript:location.href='newMember';"/>
		</div>
		
	</form>
</body>
</html>