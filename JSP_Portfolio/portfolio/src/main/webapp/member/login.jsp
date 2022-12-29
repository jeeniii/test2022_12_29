<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/login.css" type="text/css">
<%@ include file="/header.jsp" %>
</head>
<body>
<form action="/mem/login_auth" method="post">
<div class="l_put">
	<span>아이디:</span>
	 <input type="text" name="id">
</div>
<div class="l_put">
	<span>패스워드:</span>
	 <input type="password" name="pwd">
</div>
<div class="btndiv">
	<button type="submit" id="login">로그인</button>
</div>
</form>
<section>
</section>
<%@ include file="/footer.jsp" %>
</body>
</html>