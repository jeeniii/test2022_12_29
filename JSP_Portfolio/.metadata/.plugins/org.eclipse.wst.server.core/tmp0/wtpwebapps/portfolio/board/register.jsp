<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/header.jsp" %>
<link rel="stylesheet" href="/resources/css/boardRegister.css" type="text/css">
</head>
<body>
<section>

	<form action="/brd/insert" method="post" enctype="multipart/form-data">
				<div class="r_input">
					<span>
						제목:
					</span>
						<input type="text" name="title" id="textbox1"> 
				</div>
				<div class="r_input">
					<span>
						작성자: 
					</span>
						<input type="text" name="writer" value="${ses.nick_name }" id="textbox2" readonly="readonly">
				</div>
				<div class="r_input">
					<span>
						내용: 
					</span>
						<textarea rows="30" cols="30" name="content"></textarea> 
				</div>
				<div class="r_input">
					<span>
						이미지:
					</span>
						<input type="file" id="file" name="image_file" accept="image/png, image/jpg, img/jpeg, image/gif">
				</div>
		<div class="boardRe">
			<button type="submit">게시판 등록</button>
		</div>
	</form>
</section>
	<%@ include file="/footer.jsp" %>
</body>
</html>