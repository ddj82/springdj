$(document).ready(function(){ 
	$( window ).resize(function() {
		var windowWidth = $( window ).width();
		if(windowWidth >= 978) {
			$("#subNavMenu").hide();
		}
	});
	
	$("#clMenu").click(function(){
		$("#subNavMenu").toggle();
	});
	
	$("#conWrite").click(function(){
		location.href = "insertBoard.jsp";
	});
	
	$("#conDel").click(function(){
		if(confirm("정말 삭제하시겠습니까?") == true){
			let v = document.fm.seq.value;
			location.href = "deleteBoard.do?seq="+v;
		}else{
		}
	});
	
	$("#conList").click(function(){
		location.href = "getBoardList.do";
	});
});

function selTr(val){
	location.href = "getBoard.do?seq="+val;
}

//회원탈퇴 함수 만들기
//delUser('${user.id}', 'delUser.do', '관리자는 회원탈퇴를 하실 수 없습니다.')
function delUser(){}

//한명의 정보를 가져오는 함수 만들기
//selUser('${user.id}')
function selUser(){}