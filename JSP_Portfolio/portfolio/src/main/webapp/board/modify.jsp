<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/boardModify.css" type="text/css">
<%@ include file="/header.jsp" %>
</head>
<body>
<div class="container">
<h1>게시판 수정</h1>
	<form action="/brd/update" method="post" enctype="multipart/form-data">
		<div class="bm_put">
			<span>
				번호:	
			</span>
		 <input type="text" name="bno" value="${bvo.bno }" readonly="readonly"> <br>
		</div>
		<div class="bm_put">
			<span>
				제목:
			</span>
		 <input type="text" name="title" value="${bvo.title }"> <br>
		</div>
		<div class="bm_put">
			<span>
				작성자:
			</span>
		 <input type="text" name="writer" value="${ses.nick_name }" readonly="readonly"> <br>
		</div>
		<div class="bm_put">
			<span>
				내용:
			</span>
		 <textarea rows="3" cols="30" name="content" >${bvo.content }</textarea>
		</div>
		<div class="bm_put">
			<span>
				이미지:
			</span>
			<input type="hidden" name="image_file" value="${bvo.image_file }">
			<input type="file" name="new_file" accept="image/png, image/jpg, img/jpeg, image/gif">
		</div>
		<div class="mb_btn">
		<button type="submit">수정하기</button>
		</div>
	</form>
</div>
<section></section>
<%@ include file="/footer.jsp" %>
</body>
</html>