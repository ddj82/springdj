<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의하기</title>
</head>
<body>
<form action="">
	<select name="q_cate">
		<option>회원/정보관리</option>
		<option>주문/결제</option>
		<option>배송</option>
		<option>반품/환불/교환</option>
		<option>영수증/증빙서류</option>
		<option selected>상품</option>
		<option>기타</option>
	</select>
	<input type="text" name="q_title">
	<textarea rows="10" name="q_content"></textarea>
	<input type="hidden" name="q_writer" value="${user.u_id }">
	<button type="submit">등록</button>
</form>
</body>
</html>