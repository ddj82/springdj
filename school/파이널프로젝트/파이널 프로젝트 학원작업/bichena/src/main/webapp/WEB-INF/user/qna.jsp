<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의사항</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.js"></script>
<script>
function qnaView(uid, qno, sid) {
// 	세션 아이디와 uid이 같은지 확인
// 	같으면 location.href = 'qnaView.ko?q_no=' + qno;
// 	다르면 alert('내 글만 조회 가능합니다.');
	if (uid == sid || sid == 'admin') {
		location.href = 'qnaView.ko?q_no=' + qno;
	} else {
		alert('작성자만 조회 가능합니다.');
	}
}
</script>
</head>
<body>
	<section class="title">문의목록</section>
	
	<section id="ListArea">
		<table>
			<tr class="tr1">
				<td>번호</td>
				<td>카테고리</td>
				<td>제목</td>
				<td>작성자</td>
				<td>날짜</td>
				<td>상태</td>
			</tr>
			<c:forEach items="${qnaList }" var="qna">
				<tr onclick="qnaView('${qna.q_writer }', ${qna.q_no }, '${user.u_id }')" style="cursor: pointer">
					<td>${qna.q_no }</td>
					<td>${qna.q_cate }</td>
					<td>${qna.q_title }</td>
					<td>${qna.q_writer }</td>
					<td>${qna.q_date }</td>
					<td>${qna.q_state }</td>
				</tr>
			</c:forEach>
		</table>
	</section>
	<c:if test="${user.u_id != null }">
		<button type="button" class="btndel btn" onclick="location.href = 'qnaInsertbtn.ko';">문의하기</button>
	</c:if>
</body>
</html>