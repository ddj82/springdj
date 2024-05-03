<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.js"></script>
<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.7.1/kakao.min.js"
	integrity="sha384-kDljxUXHaJ9xAb2AzRd59KxjrFjzHa5TAoFQ6GbYTCAG0bjM55XohjjDT7tDDC01"
	crossorigin="anonymous"></script>
<script>
	Kakao.init('f8801431aadfbf2a0016165e1408e997'); // 사용하려는 앱의 JavaScript 키 입력
</script>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
.form-signin.mainBox {
	display: flex;
	flex-direction: column;
	align-items: center;
}

form.form-signin {
	text-align: center;
}

.form-signin.subBox {
	border: 1px solid black;
	text-align: center;
}
</style>
</head>
<body>

	<div class="form-signin mainBox">
		<div class="form-signin subBox">
			<form class="form-signin">
				<div class="form-group">
					<label for="inputUserName" class="sr-only">User Name</label> <input
						type="text" class="form-control" placeholder="ID" name="u_id"
						id="u_id" required autofocus>
				</div>
				<div class="form-group">
					<label for="inputPassword" class="sr-only">Password</label> <input
						type="password" class="form-control" placeholder="Password"
						name="u_pw" id="u_pw" required>
				</div>
				<button class="btn btn btn-lg btn-success btn-block" type="button">로그인</button>
				<a id="kakao-login-btn" href="javascript:loginWithKakao()"> <img
					src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg"
					width="222" alt="카카오 로그인 버튼" />
				</a>
				<p id="token-result"></p>
				<button class="api-btn" onclick="requestUserInfo()"
					style="visibility: hidden">사용자 정보 가져오기</button>
			</form>
			<a class="nav-item" href="idFind.jsp">아이디 찾기</a>
			<button onclick="ff()">주소</button>
		</div>
	</div>
	
<!-- 카카오 로그인  -->
	<script>
  function loginWithKakao() {
    Kakao.Auth.authorize({
      redirectUri: 'http://localhost:8090/ko/kakao.ko'
    });
  }

//   function requestUserInfo() {
//     Kakao.API.request({
//       url: '/v2/user/me',
//     })
//       .then(function(res) {
//         console.log("email : ",res.kakao_account.email);
//         console.log("name : ",res.kakao_account.name);
//         console.log("name : ",res.kakao_account.phone_number);
//         console.log("id : ",res.id);
//         console.log("res : ",res);
//       })
//       .catch(function(err) {
//         alert(
//           'failed to request user information: ' + JSON.stringify(err)
//         );
//       });
//   }

  // 아래는 데모를 위한 UI 코드입니다.
//   displayToken()
//   function displayToken() {
//     var token = getCookie();
// 	console.log('token: ',token);
//     if(token) {
//       Kakao.Auth.setAccessToken(token);
//       document.querySelector('button.api-btn').style.visibility = 'visible';
    
//       Kakao.API.request({
// 		  url: '/v1/user/shipping_address',
// 		})
// 		  .then(function(response) {
// 		    console.log("주소 : ",response.shipping_addresses[0].base_address);
// 		  })
// 		  .catch(function(error) {
// 		    console.log(error);
// 		  });
		  
//     }
//   }

//   function getCookie() {
//     var parts = '${accessToken}';
//     console.log('parts : ',parts);
//     if (parts.length === 2) { return parts[1].split(';')[0]; }
//     else{return parts;}
//   }
</script>


	<script>
		$(".btn-success").click(function() {

			var formData = {
				u_id : $("#u_id").val(),
				u_pw : $("#u_pw").val()
			};

			$.ajax({
				type : 'GET',
				data : formData,
				url : "login.ko",
				success : function(data) {
					location.href = data;
				}
			});
		});
	</script>

	<%
	if (request.getParameter("error") != null && request.getParameter("error").equals("1")) {
		out.println("<div class='alert alert-danger'>");
		out.println("아이디와 비밀번호를 확인해 주세요");
		out.println("</div>");
	}
	%>
	
	<%    
response.setHeader("Cache-Control","no-store");    
response.setHeader("Pragma","no-cache");    
response.setDateHeader("Expires",0);    
if (request.getProtocol().equals("HTTP/1.1"))  
        response.setHeader("Cache-Control", "no-cache");  
%>

	
</body>
</html>