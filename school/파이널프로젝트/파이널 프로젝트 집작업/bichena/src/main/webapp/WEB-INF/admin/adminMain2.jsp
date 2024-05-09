<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
if (!(session.getAttribute("userID") != null || session.getAttribute("userID").equals("admin"))) {
	response.sendRedirect("main.ko");
}
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
.navbar-brand{
    margin-left: 30px;

}
.bottom-line {
    display: block;
    width: 100%;
    border-bottom: 1px solid #E0E0E0;
}
.navbar-nav , .navbar-brand{
    font-family: "Noto Sans KR", sans-serif;
    font-optical-sizing: auto;
    font-weight: 600;
    font-style: normal;
}
.navbar {
    max-width: 1140px;
    height: 50px;
    display: flex;
    justify-content: space-between;
    margin: 10px auto;
}
.bottom-line {
    display: block;
    width: 100%;
    border-bottom: 1px solid #E0E0E0;
    margin-bottom: 20px;
}
.navbar-nav , .navbar-brand{
    font-size: 18px;
    align-items: center;
    
}
.navbar-default {
    background-color: white;
    border: none;
}
.nav-item {
    margin-bottom: 10px; /* 각 항목 사이의 간격 조절 */
}
@media (min-width: 768px) {
	.navbar {
	    border-radius: 4px;
	}
}
  </style>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>                        
            </button>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav">
            <li class="nav-item"><a href="adminOrderList.ko">주문목록</a></li>
            <li class="nav-item"><a href="adminProdList.ko">상품관리</a></li>
            <li class="nav-item"><a href="getUserList.ko">회원관리</a></li>
            <li class="nav-item"><a href="getNoticeList.ko">공지사항</a></li>
            <li class="nav-item"><a href="">상품후기</a></li>
            <li class="nav-item"><a href="getFaqList.ko">FAQ</a></li>
            <li class="nav-item"><a href="adminQnaList.ko">QNA</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="logout.ko"><span class="glyphicon glyphicon-log-in"></span></a></li>
        </ul>
        </div>
	</div>
</nav>
<div class="bottom-line"></div>

</body>
</html>
