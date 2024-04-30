<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="menuBox1">
	<c:choose>
		<c:when test='${user.u_id ne NULL}'>
			<ul class="navbar-nav nav-right">
				<li class="nav-item">${user.u_nick}님</li>

				<c:choose>
					<c:when test="${user.u_id eq 'admin'}">
						<li class="nav-item">
							<a class="nav-link" href="userList.do">회원정보</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="nav-item">
							<a class="nav-link" href="selUser.do?id=${user.u_nick}">나의정보</a>
						</li>
					</c:otherwise>
				</c:choose>
				
				<li class="nav-item"><a href="logout.ko">로그아웃</a></li>
			</ul>
		</c:when>
		<c:otherwise>
			<a href="login.jsp">로그인하기</a>
			<a href="idFind.jsp">아이디 찾기</a>
			<a href="pwFind.jsp">비밀번호 찾기</a>
		</c:otherwise>
	</c:choose>
</div>