<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
span.prod img {
width: 300px;
}
span.prod {
cursor: pointer;
}
</style>
<script>
function prodOneView(val) {
// 	let objParams = {p_no : val};
// 	let values = []; //ArrayList 값을 받을 변수를 선언
// 	$.ajax({
// 		method : "POST",
// 		url : "prodOne.do",
// 		data : objParams,
// 		cache : false,
// // 		async : false,
// 		success : function(res) {
// 			if (res.code == "OK") { //controller에서 넘겨준 성공여부 코드
// 				console.log("성공");
				
// 			} else {
// 				console.log("실패");
// 			}
// 		},
// 		error : function(err){
// 			alert("오류가 발생했습니다.");
// 			console.log(err);
// 		}
// 	});
}
</script>
</head>
<body>
<c:forEach items="${prodList }" var="list">
<%-- 	<span class="prod" onclick="prodOneView('${list.p_no}')"> --%>
	<span class="prod" onclick="location.href = 'prodOne.do?p_no=' + ${list.p_no};">
		<img class="float" src="img/${list.p_img }" title="img" alt="img"><br>
		<span>${list.p_name }</span>
	</span>
</c:forEach>
</body>
</html>