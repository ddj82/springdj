<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
div#boxFlex {
	display: flex;
	justify-content: center;
	width: 1000px;
	margin: 0 auto;
	padding: 20px;
	border: 1px solid rgb(224, 224, 224);
	border-radius: 10px;
}
div.all {
	box-sizing: initial;
	display: flex;
	justify-content: center;
}
div#name {
	padding: 0 200px 0 0;
	border-right: 0.5px solid rgb(178, 178, 178);
}
div#box {
	margin-left: 80px;
}
div#boxP1 {
	margin-left: 30px;
}

div#boxP2 {
	margin-left: 50px;
}

div#boxP3 {
	margin-left: 50px;
}

div#boxP4 {
	margin-left: 40px;
}
img.borrowImg.b {
	position: relative;
	height: 30px;
	width: 30px;
	margin-left: 50px;
}
img#recall {
	margin-left: 85px;
}
a.a_class {
	text-decoration-line: none;
	color: black;
}
a.a_class:visited {
	color: black;
}
</style>
<body>
	<div id='boxFlex' class="all">
		<div id='name' class="all">
			<p style="font-weight: bold;">제하사</p><p>님</p>
		</div>
	
		<div id='box' class="all">
			<a href='' class="a_class">
				<div id="boxP1" class="all">주문 내역</div>
				<img class="borrowImg b" id="order" src='img/imguser/order.png'>
			</a>
			<a href='' class="a_class">
				<div id="boxP2" class="all">취소 / 환불내역</div>
				<img class="borrowImg b" id="recall" src='img/imguser/recall.png'>
			</a>
			<a href='' class="a_class">
				<div id="boxP3" class="all">리뷰</div>
				<img class="borrowImg b" id="review" src='img/imguser/review.png'>
			</a>
			<a href='' class="a_class">
				<div id="boxP4" class="all">회원정보</div>
				<img class="borrowImg b" id="card" src='img/imguser/card.png'>
			</a>
		</div>
	</div>
</body>
</html>