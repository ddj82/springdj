<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.js"></script>
<script src="js/check.js"></script>
<script>
	var cnt = 0;
	$(function() {
		//아이디 중복체크
		$("#check").change(function() {
			var idNoneMessage = document.getElementById('idNoneMessage');
			var idCheckMessage = document.getElementById('idCheckMessage');
			var idSuccessMessage = document.getElementById('idSuccessMessage');
			let ids = document.joinform.id.value;
			let idval = {
				"u_id" : ids
			};
			console.log(ids);
			if (ids == '') {
				idSuccessMessage.style.display = 'none';
				idNoneMessage.style.display = 'block';
			} else {
				idNoneMessage.style.display = 'none';
				$.ajax({
					url : "checkId.ko",
					type : "post",
					data : idval,
					dataType : "json",
					cache : false,
					async : false,
					success : function(data) {
						console.log('아이디 중복체크 success');
						if (data > 0) {
							idSuccessMessage.style.display = 'none';
							idCheckMessage.style.display = 'block';
						} else {
							idSuccessMessage.style.display = 'block';
							idCheckMessage.style.display = 'none';
							cnt++;
						}
					},
					error : function(err) {
						console.log('error객체 : ', err);
					}
				});
			}
		});
	});
	
	
</script>
<style>
.joinform {
	display: flex;
	box-sizing: border-box;
	flex-direction: column;
}

.form_item {
	display: flex;
	align-items: center;
	position: relative;
	box-sizing: border-box;
	max-width: 100%;
	/* 	min-height: 50px; */
	padding: 0 10px 0 0px;
}

.inner {
	width: 400px;
	margin: 0 auto;
}
</style>
</head>
<body>
	<h1>회원가입</h1>
	<div class="inner">
		<form class="joinform" name="joinform" action="insertUser.ko"
			method="post" onSubmit="return insertchk()">
			<div>아이디</div>
			<div class="form_item">
				<div id="check" onclick="idInput()">
					<input type="text" id="id" name="u_id" placeholder="아이디"
						minlength="5" maxlength="20">
				</div>
				<div id="idNoneMessage" style="display: none; color: red;">아이디를
					입력해주세요.</div>
				<div id="idCheckMessage" style="display: none; color: red;">이미
					사용중인 아이디입니다.</div>
				<div id="idSuccessMessage" style="display: none; color: blue;">사용
					가능한 아이디입니다.</div>
			</div>
			<div class="form_item">
				<div class="item_name">비밀번호</div>
				<div onclick="pwInput()">
					<input type="password" id="pw" name="u_pw" placeholder="비밀번호"
						minlength="8" maxlength="16">
				</div>
				<div id="pwErrorMessage" style="display: none; color: red;">(비밀번호)올바른
					형식으로 입력해주세요.</div>
			</div>
			<div class="form_item">
				<div class="item_name">비밀번호 확인</div>
				<div onclick="pw1Input()">
					<input type="password" id="pw1" name="pw1" placeholder="비밀번호 확인"
						minlength="8" maxlength="16">
				</div>
				<div id="pw1ErrorMessage" style="display: none; color: red;">비밀번호와
					일치시켜 주세요.</div>
			</div>
			<div class="form_item">
				<div class="item_name">이름</div>
				<div onclick="nameInput()">
					<input type="text" id="name" name="u_name" placeholder="이름"
						minlength="1" value="<%=request.getParameter("name")%>" readonly>
				</div>
				<div id="nameErrorMessage" style="display: none; color: red;">이름을
					입력해주세요.</div>
			</div>
			<div class="form_item">
				<div class="item_name">닉네임</div>
				<div>
					<input type="text" id="nick" name="u_nick" placeholder="닉네임"
						minlength="1">
				</div>
			</div>

			<div class="form_item">
				<div class="item_name">성별</div>
				<div onclick="genderInput()">
					<input type="radio" id="gender" name="u_gen" value="남자" checked><label
						for="male">남자</label> <input type="radio" id="gender" name="u_gen"
						value="여자"><label for="female">여자</label>
				</div>
				<div id="genderErrorMessage" style="display: none; color: red;">성별을
					선택해주세요.</div>
			</div>

			<div class="form_item">
				<div class="item_name">생년월일</div>
				<div onclick="birthInput()">
					<input type="text" id="birth" name="u_birth" placeholder="생년월일"
						minlength="8" maxlength="8"
						value="<%=request.getParameter("birth")%>" readonly><br>
				</div>
				<div id="birthErrorMessage" style="display: none; color: red;">올바른
					생년월일을 입력해주세요.</div>
			</div>
			<div class="form_item">
				<div class="item_name">전화번호</div>
				<div onclick="telInput()">
					<input type="tel" id="tel" name="u_tel" placeholder="전화번호"
						minlength="11" maxlength="11"
						value="<%=request.getParameter("tel")%>" readonly><br>
				</div>
				<div id="telErrorMessage" style="display: none; color: red;">전화번호를
					입력해주세요.</div>
			</div>
			<div class="form_item">
				<div class="item_name">이메일</div>
				<div onclick="emailInput()">
					<input type="text" id="email" name="u_email" placeholder="이메일"
						minlength="5" maxlength="40"><br>
				</div>
				<div id="emailNoneMessage" style="display: none; color: red;">이메일을
					입력해주세요.</div>
				<div id="emailErrorMessage" style="display: none; color: red;">이메일을 올바른 형식으로 입력해주세요.</div>
			</div>
			<div class="form_item">
				<div class="item_name">주소</div>
				<div onclick="postcodeInput()">
					<input type="text" id="postcode" name="addr1" placeholder="우편번호"
						readonly><br>
				</div>
				<div>
					<input type="button" class="menu_h" onclick="execDaumPostcode()"
						value="우편번호 찾기">
				</div>
				<div id="postcodeErrorMessage" style="display: none; color: red;">우편번호를
					입력해주세요.</div>
			</div>
			<div class="form_item">
				<div onclick="addressInput()">
					<input type="text" id="address" name="addr2" placeholder="주소"
						readonly><br>
				</div>
				<div id="addressErrorMessage" style="display: none; color: red;">주소를
					입력해주세요.</div>
			</div>
			<div class="form_item">
				<div onclick="detailInput()">
					<input type="text" id="detailAddress" name="addr3"
						placeholder="상세주소"><br>
				</div>
				<div id="detailErrorMessage" style="display: none; color: red;">상세주소를
					입력해주세요.</div>
			</div>

			<button type="submit">전송</button>
		</form>
	</div>
</body>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
<script>
	function execDaumPostcode() {
		new daum.Postcode({
			oncomplete : function(data) {
				// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

				// 각 주소의 노출 규칙에 따라 주소를 조합한다.
				// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
				var addr = ''; // 주소 변수
				var extraAddr = ''; // 참고항목 변수

				//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
				if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
					addr = data.roadAddress;
				} else { // 사용자가 지번 주소를 선택했을 경우(J)
					addr = data.jibunAddress;
				}

				// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
				if (data.userSelectedType === 'R') {
					// 법정동명이 있을 경우 추가한다. (법정리는 제외)
					// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
					if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
						extraAddr += data.bname;
					}
					// 건물명이 있고, 공동주택일 경우 추가한다.
					if (data.buildingName !== '' && data.apartment === 'Y') {
						extraAddr += (extraAddr !== '' ? ', '
								+ data.buildingName : data.buildingName);
					}
					// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
					if (extraAddr !== '') {
						extraAddr = ' (' + extraAddr + ')';
					}
					// 조합된 참고항목을 해당 필드에 넣는다.
					//                 document.getElementById("extraAddress").value = extraAddr;

				} else {
					document.getElementById("extraAddress").value = '';
				}

				// 우편번호와 주소 정보를 해당 필드에 넣는다.
				document.getElementById('postcode').value = data.zonecode;
				document.getElementById("address").value = addr;
				// 커서를 상세주소 필드로 이동한다.
				document.getElementById("detailAddress").focus();
			}
		}).open();
	}
</script>

</html>