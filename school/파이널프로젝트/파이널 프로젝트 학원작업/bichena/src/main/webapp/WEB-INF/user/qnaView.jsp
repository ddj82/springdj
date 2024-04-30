<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의보기</title>
</head>
<body>
	<section class="title">문의목록</section>

	<section id="ListArea">
		<table>
			<tr>
				<td>카테고리</td>
				<td>${qnaView.q_cate }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${qnaView.q_title }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${qnaView.q_writer }</td>
			</tr>
			<tr>
				<td>날짜</td>
				<td>${qnaView.q_date }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${qnaView.q_content }</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td>${qnaView.q_img }</td>
			</tr>
		</table>
		<img src="img/imgQna/${qnaView.q_img }" title="img" alt="img" style="width: 200px;"> <br>
		<br>
		<c:choose>
			<c:when test="${user.u_id eq 'admin' }">
				<c:choose>
					<c:when test="${qnaView.a_content == null}">
						<form action="qnaAcontent.ko" method="post">
							<input type="hidden" name="q_no" value="${qnaView.q_no }">
							<textarea rows="10" name="a_content"></textarea>
							<button type="submit">확인</button>
						</form>
					</c:when>
					<c:otherwise>
						<textarea rows="10" name="a_content" readonly>${qnaView.a_content }</textarea>
					</c:otherwise>
				</c:choose>
			</c:when>
			<c:otherwise>
				<c:if test="${qnaView.a_content != null}">
					<textarea rows="10" name="a_content" readonly>${qnaView.a_content }</textarea>
				</c:if>
			</c:otherwise>
		</c:choose>
	</section>
	<button type="button" class="btndel btn" onclick="location.href = 'qnaDelete.ko?q_no=${qnaView.q_no }';">삭제</button>
</body>
</html>