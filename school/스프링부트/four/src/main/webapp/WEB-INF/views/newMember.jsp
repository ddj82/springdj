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
	input[type=checkbox] {width:20px;height:20px;vertical-align:middle;margin-left:20px;}
	label {font-size:13pt;}
	</style>
</head>
<body class='container'>
	<h2>회원 가입</h2>
	<form action="newMember" method="post" class='card'>
		<input type="text" value='' name='userId' placeholder="user id" />
		<input type="text" value='' name='password' placeholder="password" />
		<input type="text" value='' name='name' placeholder="name" />
		<div class="input-group p-3">
		<h4>권한 선택</h4>
		<label><input type="checkbox" name="auth" value='super'> super</label>
		<label><input type="checkbox" name="auth" value='normal'> normal</label>
		</div>
		<input type='submit' value='가입' />
	</form>	
</body>
</html>