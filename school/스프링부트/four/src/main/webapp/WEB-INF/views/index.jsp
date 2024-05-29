<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<h2>인덱스 페이지 입니다.</h2>
	<a href="/login">로그인으로 가기</a><br>
	
	<c:if test="${result ne null }">${result.toString() }</c:if>
	
</body>
</html>