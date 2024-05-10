<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
if (session.getAttribute("userID") == null) {%>
<script>
location.href="main.ko";
</script>
<%}
%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<body>
<%@ include file="/WEB-INF/admin/adminMain2.jsp" %>
<div>
   <h1>글쓰기</h1>      
</div>
<div>
  <form action="insertFaq.ko" method="post" enctype="multipart/form-data"> <!-- post방식에서는 받는곳에서 인코딩을 해주어야 한다, 하지만, 필터를 사용하여 넣어준다. -->
    <div>
      <div>
        <span>제목</span>
      </div>
      <input type="text" name="faq_title" placeholder="제목을 입력하세요." required>      
    </div>
    
    <div>
      <div>
        <span>내용</span>
      </div>
      <textarea rows="10" name="faq_content"></textarea>      
    </div>  
    
    
    <div id="footer">
	  	<button type="submit">새글 등록</button>
	  	<button id="conList" type="button">글목록</button>
	 </div>
  </form>  
</div>

<script>
	$("#conList").click(function(){
		location.href = "getFaqList.ko";
	});
</script>
</body>
</html>
