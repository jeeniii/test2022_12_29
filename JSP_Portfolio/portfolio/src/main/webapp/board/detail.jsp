<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/header.jsp" %>
<link rel="stylesheet" href="/resources/css/boardDetail.css" type="text/css">
</head>
<body>
<div class="img_div">
	<img alt="빈 이미지" src="/_fileUpload/${bvo.image_file }">

<table border="1">
	<tr>
		<th>Bno</th>
		<td>${bvo.bno }</td>
	</tr>
	<tr>
		<th>Writer</th>
		<td>${bvo.writer }</td>
	</tr>
	<tr>
		<th>Title</th>
		<td>${bvo.title }</td>
	</tr>
	<tr>
		<th>Content</th>
		<td>${bvo.content }</td>
	</tr>
</table>
<div class="d_btn">
<c:if test="${ses.nick_name eq bvo.writer }">
<a href="/brd/modify?bno=${bvo.bno }"><button type="button" class="b_btn">게시글 수정</button></a>
<a href="/brd/remove?bno=${bvo.bno }" onclick="return confirm('정말 삭제하시겠습니까?');"><button type="button" class="b_btn">게시글 삭제</button></a> <br>
</c:if>
</div>
</div>

<%@ include file="/footer.jsp" %>
</body>
</html>