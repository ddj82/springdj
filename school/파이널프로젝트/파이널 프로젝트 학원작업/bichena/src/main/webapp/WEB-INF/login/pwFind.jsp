<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<input type="text" class="form-control" placeholder="email" name="u_email" id="u_email" required>
	<button onclick="pwFind(event)">버튼</button>
	<div id="pwFindBox"></div>
	<div class="mailClass" style="display: none;">
		<input type="text" class="userMail" readonly>
		<button type="button" class="btn btn-primary" id="mail-Check-Btn">본인인증</button>
		<input type="text" style="display: none;" class="mail-check-input">
		<button type="button" id="mail-check-button" style="display: none;">인증번호확인</button>
		<div class="time"></div>
		<div id="mail-check-warn"></div>
		<div id="finallyPW"></div>
	</div>
	<script>
		var code;
		var count = 0;
		var timer = null;
		var isRunning = false;
		var display = $(".time");
		var leftSec = 180;

		function test() {
			const emailPattern = /[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]$/i;
			let email = $("#u_email").val();
			if (emailPattern.test(email)) {
				search();
			} else {
				$("#box1").html("이메일 형식을 확인해 주세요");
			}
		}

		function startTimer(leftSec, display) {
			var minutes, seconds;
			timer = setInterval(function() {
				minutes = parseInt(leftSec / 60, 10);
				seconds = parseInt(leftSec % 60, 10);

				minutes = minutes < 10 ? "0" + minutes : minutes;
				seconds = seconds < 10 ? "0" + seconds : seconds;

				display.html(minutes + ":" + seconds);

				// 타이머 끝
				if (--leftSec < 0) {
					clearInterval(timer);
					display.html("시간초과");
					code = null;
				}
			}, 1000);
		}

		function pwFind(event) {

			console.log("event : ", $("#u_email").val());

			var formData = {
				u_email : $("#u_email").val()
			};

			$.ajax({
				type : "POST",
				url : "pwFindId.ko",
				data : formData,
				cache : false,
				success : function(res) {
					console.log("res : ", res)
					if (res === "error") {
						let str = "존재하지 않는 이메일입니다.";
						$("#pwFindBox").html(str);

					} else {
						$("#u_email").attr("readonly", "true");
					}
				}
			});
		}

		$('#mail-Check-Btn').click(function() {

			const email = $('.userMail').val(); // 이메일 주소값 얻어오기!

			var formData = {
				email : email
			};

			$.ajax({
				type : 'POST',
				data : formData,
				url : 'mailCheck.ko',
				success : function(data) {
					console.log("data : " + data);
					code = data;
					alert('인증번호가 전송되었습니다.');
					$('.mail-check-input').css('display', 'block');
					$('#mail-check-button').css('display', 'block');
					startTimer(leftSec, display);
				}
			});
		});

		$('#mail-check-button').click(function() {

			const inputCode = $('.mail-check-input').val();
			const $resultMsg = $('#mail-check-warn');

			if (inputCode === code) {
				$resultMsg.html('인증번호가 일치합니다.');
				clearInterval(timer);
				count = 1;

				const email = $('.userMail').val(); // 이메일 주소값 얻어오기!
				const id = $('.form-control').val(); // 아이디 얻어오기!
				var formData = {
					u_email : email,
					u_id : id
				};

				$.ajax({
					type : 'POST',
					data : formData,
					url : 'pwFindStart.ko',
					success : function(data) {
						console.log("data : " + data);
						code = data;
						$('#finallyPW').html(data);
					}
				});
			} else {
				$resultMsg.html('인증번호가 불일치 합니다. 다시 확인해주세요!.');
				$resultMsg.css('color', 'red');
				count = 0;
			}
		});
	</script>
</body>
</html>