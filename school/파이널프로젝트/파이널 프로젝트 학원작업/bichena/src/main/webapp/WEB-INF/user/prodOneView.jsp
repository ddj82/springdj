<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주류상세페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.js"></script>
<style>
table {
width: 30%;
border: 1px solid black;
border-collapse: collapse;
}
th {
text-align: left;
}
img {
width: 300px;
}
div.div1 {
height: 350px;
}
div.clear span {
padding: 10px;
margin: 10px;
}
span.span2 {
font-size: 25px;
}
span.span1 {
color: gray;
font-weight: bold;
}
p {
margin: 10px 0;
}
p.p1 {
margin-bottom: 0;
}
p.p2 {
margin-top: 0;
}
div.clear {
padding: 10px 0;
}
.float {
float: left;
}
.clear {
clear: right;
}
.dtable {
padding: 10px;
}
.main {
width: 60%;
margin: 0 20%;
position: relative;
}
.main div {
width: 100%;
}
.pay {
position: fixed;
left: 65%;
top: 0;
}
</style>
<script>
$(function(){
	let pno = ${prodOne.p_no};
	let objParams = {p_no : pno};
	let values = []; //ArrayList 값을 받을 변수를 선언
	$.ajax({
		method : "POST",
		url : "prodOneNotice.do",
		data : objParams,
		cache : false,
		success : function(res) {
			if (res.code == "OK") { //controller에서 넘겨준 성공여부 코드
				values = res.prodNotice; //java에서 정의한 ArrayList명을 적어준다.
				console.log("배열 : ", values);
				$.each(values, function(i, o){
					 let date = new Date(o.pn_date);
					console.log('o.pn_date : ' , date.toLocaleDateString());
					$("#noticeTb").append("<tr><td>" + o.u_name + "</td><td>" + o.p_name + "</td><td>" + date.toLocaleDateString() + "</td></tr>"
							+ "<tr><td>" + o.pn_content + "</td><td>"
							+ "<tr><td>" + "<img alt='' src='img/notice/" + o.pn_img  + "' style='width:100px;'>" + "</td><td>");
				});
				console.log("성공");
			} else {
				console.log("실패");
			}
		}
	});
});
</script>
</head>
<body>
<div class="main">
<%@ include file="pay.jsp" %>
	<div class="div1">
		<img class="float" src="img/${prodOne.p_img }" title="img" alt="img">
		<div class="clear">
			<p><span class="span1"><small>${prodOne.p_desc}</small></span></p>
			<p><span class="span2"><strong>${prodOne.p_name}</strong></span></p>
			<p class="p1"><span class="span3"><small>판매가격</small></span></p>
			<p class="p2"><span class="span2"><strong>${prodOne.p_price}원</strong></span></p>
		</div>
	</div>
	<div class="dtable">
		<table>
			<tr>
				<th>주류종류</th><td>${prodOne.p_type}</td>
			</tr>
			<tr>
				<th>도수</th><td>${prodOne.p_dgr}%</td>
			</tr>
			<tr>
				<th>용량</th><td>컬럼추가해야할듯ml</td>
			</tr>
		</table>
	</div>
	<br><br><br> 
	<div class="dtable float" style="width:30%;">
		<table style="width:100%;">
			<tr>
				<th>단맛</th>
				<td>${prodOne.p_sw}</td>
			</tr>
			<tr>
				<th>신맛</th>
				<td>${prodOne.p_su}</td>
			</tr>
			<tr>
				<th>탄산</th>
				<td>${prodOne.p_sp}</td>
			</tr>
		</table>
	</div>
	<div class="dtable clear">
		<table>
			<tr>
				<th>원료</th><td>${prodOne.p_mat}</td>
			</tr>
			<tr>
				<th>재고</th><td>${prodOne.p_stock}</td>
			</tr>
		</table>
	</div>
</div>
<br>
<br>
<br> 
<br>
<br>
<br> 
<br>
<br>
<br> 
<br>
<br>
<br> 
<br>
<br>
<br> 
<div class="main">
	<table id="noticeTb" style="width:70%">
	</table>
</div>
<br>
<br>
<br> 
<br>
<br>
<br> 
<br>
<br>
<br> 
<br>
<br>
<br> 
<br>
<br>
<br> 
<br>
<br>
<br> 
<br>
<br>
<br> 
<br>
<br>
<br> 
<br>
<br>
<br> 
<br>
<br>
<br> 
</body>
</html>