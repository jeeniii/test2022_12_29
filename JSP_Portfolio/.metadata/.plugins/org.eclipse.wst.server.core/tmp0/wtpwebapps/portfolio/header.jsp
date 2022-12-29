<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="/resources/css/header.css" type="text/css">
</head>
<body>
	<header>
		<div class="realHeader">
			<div class="headbar">
				<ul>
					
					<c:if test="${ses.id ne null }">
						<li>
							${ses.nick_name }님
						</li>
						<li>
							<a href="/mem/logout?id=${ses.id }"><button type="button">로그아웃</button></a> 
						</li>
						<li>
							<a href="/mem/modify?id=${ses.id }"><button type="button">회원정보수정</button></a>
						</li>	
					</c:if>
					
					<c:if test="${ses.id eq null }">
						<li>
							<a href="/mem/login"><button type="button">로그인</button></a>
						</li>
						<li>
							<a href="/mem/join"><button type="button"> 회원가입</button></a>
						</li>
					</c:if>
				</ul>
			</div>
		</div>
		<div class="topic">
			<h1>Hello, This is My Story</h1>
		</div>
	</header>
</body>
</html>