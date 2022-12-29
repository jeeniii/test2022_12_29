<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/header.jsp" %>
<link rel="stylesheet" href="/resources/css/memberModify.css" type="text/css">
</head>
<body>
<section>
<div class="container">
		<div class="h1">
			<h1>회원정보수정</h1>
		</div>
		<form action="/mem/update" method="post">
		<div class="m_put">
			<span>아이디:</span>
			 <input type="text" name="id" readonly="readonly" value="${ses.id }">
		</div>
		<div class="m_put">
			<span>비밀번호:</span>
			 <input type="text" name="pwd" placeholder="비밀번호"> <br>
		</div>
		<div class="m_put">
			<span>닉네임:</span>
			 <input type="text" name="nick_name" placeholder="별명"> <br>
		</div>
		<div class="m_put">
			<span>전화번호:</span>
			 <input type="text" name="phone" oninput="hypenTel(this)" maxlength="13" placeholder="'-'제외">
		</div>
		<div class="m_put">
			<span>주소:</span>
				<input type="hidden" id="sample6_postcode" placeholder="우편번호">
				<input type="text" name="addr1" id="sample6_address" placeholder="주소">
				<input type="text" name="addr2" id="sample6_detailAddress" placeholder="상세주소">
				<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
				<input type="hidden" id="sample6_extraAddress" placeholder="참고항목">
		</div>
		<div class="m_btn">
			<button type="submit">제출</button>
		</div>
		</form>
</div>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
const hypenTel = (target) => {
	 target.value = target.value
	   .replace(/[^0-9]/g, '')
	   .replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
}

function sample6_execDaumPostcode() {
   new daum.Postcode({
       oncomplete: function(data) {
           var addr = ''; 
           var extraAddr = ''; 

           if (data.userSelectedType === 'R') { 
               addr = data.roadAddress;
           } else { 
               addr = data.jibunAddress;
           }

           if(data.userSelectedType === 'R'){
               if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                   extraAddr += data.bname;
               }
               if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
               }
               if(extraAddr !== ''){
                   extraAddr = ' (' + extraAddr + ')';
               }
               document.getElementById("sample6_extraAddress").value = extraAddr;
           
           } else {
               document.getElementById("sample6_extraAddress").value = '';
           }

           document.getElementById('sample6_postcode').value = data.zonecode;
           document.getElementById("sample6_address").value = addr;
           document.getElementById("sample6_detailAddress").focus();
       }
   }).open();
}
</script>
</section>
<%@ include file="/footer.jsp" %>
</body>
</html>