<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<h1>Ajax Home</h1>
	<form>
		<input type="text" name="keyword" id="keyword" placeholder="제목이나 저자를 입력해주세요.(일부입력 가능)" size="100" />
		<button type="button" id="searchBtn">Search</button>
	</form>
	<form>
		boardNo : <input type="text" name="boardNo" id="boardNo"/><br>
		title : <input type="text" name="title" id="title"/><br>
		content : <textarea name="content" id="content"></textarea><br>
		writer : <input type="text" name="writer" id="writer"/><br>
	</form>
	<div>
		<button id="listBtn">List</button>
		<button id="readBtn">Read</button>
		<button id="registerBtn">Register</button>
		<button id="deleteBtn">Delete</button>
		<button id="modifyBtn">Modify</button>
	</div>
	<br><br>
	<h3>목록 보기</h3>
	<div id="dataBox"></div>
<script>
$(document).ready(function(){
	$("#listBtn").on("click", function(){
		$.get("/boards", {id : "admin"} ,function(data){
			console.log(data);
// 			alert(JSON.stringify(data));
			$("#dataBox").empty();
			if(data!= '') {
				$.each(data,function(i,v){
					$("#dataBox").append("번호: "+v.boardNo+"/ 제목: "+v.title+"/ 저자: "+v.writer+"/ 출판일: "+v.regDate.substr(0,10)+"/ 내용: "+v.content+"<br>");
				});
			}
		});
	});
	
	$("#readBtn").on("click", function(){
		let boardNoVal = $("#boardNo").val();
		$.get("/boards/"+boardNoVal, function(data){
			console.log(data);
			$("#dataBox").empty();
			if(data!= ''){
				$("#dataBox").append("번호: "+data.boardNo+"/ 제목: "+data.title+"/ 저자: "+data.writer+"/ 출판일: "+data.regDate.substr(0,10)+"/ 내용: "+data.content+"<br>");
				$("#boardNo").val(data.boardNo);
				$("#title").val(data.title);
				$("#content").val(data.content);
				$("#writer").val(data.writer);
			}
		});
	});
	
	$("#searchBtn").on("click", function(){
		let keywordVal = $("#keyword").val();
// 		let url = "/boards/search/"+keywordVal;
		let url = "/boards/test/"+keywordVal;
		if(keywordVal=='' ){
			$("#listBtn").click();
		}else{
			$.get(url, function(data){
				console.log(data.mapdata.result);
				$("#dataBox").empty();
				if(data!= '') {
					$.each(data.mapdata.result,function(i,v){
						$("#dataBox").append("번호: "+v.boardNo+"/ 제목: "+v.title+"/ 저자: "+v.writer+"/ 출판일: "+v.regDate.substr(0,10)+"/ 내용: "+v.content+"<br>");
					});
				}
// 				if(data!= '') {
// 					$.each(data,function(i,v){
// 						$("#dataBox").append("번호: "+v.boardNo+"/ 제목: "+v.title+"/ 저자: "+v.writer+"/ 출판일: "+v.regDate.substr(0,10)+"/ 내용: "+v.content+"<br>");
// 					});
// 				}
			});
			
		}
		
	});
	
	$("#registerBtn").on("click", function(){
		let boardObject = {
			title: $("#title").val(),
			content : $("#content").val(),
			writer : $("#writer").val()
		};
		
		$.post({url: "/boards", data: JSON.stringify(boardObject), contentType: "application/json; charset=UTF-8"}).done( function(result){
			if(result=='ok'){
				alert('등록되었습니다.');
				location.reload();
			}
		});
//	 		$.ajax({
//	 			type : "POST",
//	 			url : "/boards",
//	 			data : JSON.stringify(boardObject),
//	 			contentType : "application/json; charset=UTF-8",
//	 			success : function(result){
//	 				console.log(result);
//	 				alert(result);
//	 			},
//	 			error : function(request, status, error){
//	 				alert("code: "+request.status + "\n"
//	 				+ "message: "+request.responseText + "\n"
//	 				+ "error: "+error);
//	 			}
//	 		});
	});
	
	$("#deleteBtn").on("click", function(){
		let boardNo =  $("#boardNo").val();
		$.ajax({
			type : "DELETE",
			url : "/boards/"+boardNo,
			data : JSON.stringify(boardNo),
			contentType : "application/json; charset=UTF-8",
			success : function(result){
				console.log(result);
				alert(result);
			}
		});
	});
	
	
	$("#modifyBtn").on("click", function(){
		let boardNo =  $("#boardNo").val();
		let boardObject = {
			title: $("#title").val(),
			content : $("#content").val(),
			writer : $("#writer").val()
		};
		
		$.ajax({
			type : "PUT",
			url : "/boards/"+boardNo,
			data : JSON.stringify(boardObject),
			contentType : "application/json; charset=UTF-8",
			success : function(result){
				if(result='ok') {
					alert('수정되었습니다.');
					$("#readBtn").click();
				}
				else alert('수정되지 않았습니다.');
			}
		});
	});
});
</script>
</body>
</html>