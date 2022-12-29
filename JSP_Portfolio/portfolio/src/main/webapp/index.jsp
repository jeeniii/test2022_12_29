<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/index.css" type="text/css">
<%@ include file="/header.jsp" %>
</head>
<body>

<div class="main_container">
	<div class="sub_container">
		<c:if test="${ses.id ne null }">
		<c:if test="${ses.id eq 1111 }">		
			<a href="/mem/list"><button type="button">함께하는 이웃들</button></a> 
		</c:if>
			<a href="/brd/register"><button type="button">게시판 등록</button></a> 
			<a href="/brd/pageList"><button type="button">게시판 리스트</button></a>
			<a href="/mem/remove?id=${ses.id }" onclick="return confirm('정말 탈퇴하시겠습니까?');"><button type="button">회원 탈퇴</button></a> 
		</c:if>
	</div>
</div>

<section>
	
</section>
	
<script type="text/javascript">
const msg='<c:out value="${msg_login }" />';
console.log(msg);
if(msg =="true"){ //console.log(typeof(msg)); 결과 string이 찍혀서 ""로 감쌌다.
	const id='<c:out value="${ses.nick_name}"/>';
	console.log(id);
	if(id != null){
		alert(id+ "님 환영합니다.");
	}
}else if(msg=="false"){
	alert("아이디 또는 패스워드가 틀립니다.");
}


const msg2='<c:out value="${msg_register }" />';
console.log(msg2);
if(msg2=="false"){
	alert("모든 항목을 입력해주세요");
}else if(msg2=="true"){
	alert("회원가입을 환영합니다.");
}
</script>
<%@ include file="/footer.jsp" %>
</body>
</html>