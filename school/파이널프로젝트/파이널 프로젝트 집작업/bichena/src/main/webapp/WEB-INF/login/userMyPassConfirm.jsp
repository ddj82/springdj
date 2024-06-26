<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 재확인</title>
</head>

<body>
	<h3>비밀번호 재확인</h3>
	<form action="reconPw.ko" class="confirmPw" id="confirmPw" method="post">
		<p>개인정보 보호를 위해 비밀번호를 한 번 더 입력해주세요.</p>
		<div>
			<input type="password" id="upw" name="u_pw" maxlength="16" pattern="[a-zA-Z0-9_\-~!@#$%^&*()]+">
		</div>
		<div>
			<input type="button" onclick="passChk()" value="확인">
		</div>
	</form>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.js"></script>
<script>
	document.addEventListener('DOMContentLoaded', function() {
		// 특정 입력 필드 가져오기
		var inputField = document.getElementById("confirmPw");
	
		// 입력 필드에 포커스될 때 엔터 키 이벤트 처리
		inputField.addEventListener("keydown", function(event) {
			// 엔터 키가 눌렸을 때 기본 이벤트(폼 제출) 막기
			if (event.key === "Enter") {
				event.preventDefault();
				passChk();
			}
		});
	});

	function passChk() {
		let upw = document.getElementById('upw').value;
		if (upw == '') {
			alert("비밀번호를 입력해주세요.");
		} else {
			let pwval = {
				"u_pw" : upw
			}

			$.ajax({
				url : "reconPw.ko",
				type : "post",
				data : pwval,
				dataType : "json",
				cache : false,
				async : false,
				success : function(data) {
					console.log('비밀번호 재확인!');
					if (data == 1) {
						location.href = 'userInfo.ko';
					} else {
						alert('비밀번호를 다시 확인해주세요.');
					}
				},
				error : function(err) {
					console.log('error : ', err);
				}
			});

		}
		console.log(upw);
	}
</script>
</html>