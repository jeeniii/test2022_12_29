<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/join.css" type="text/css">
<%@ include file="/header.jsp" %>
</head>
<body>
	<form action="/mem/register" method="post">
		<div class="j_put">
		<span>
			아이디:
		</span>
			 <input type="text" name="id" >
		</div>
		<div class="j_put">
			<span>
				비밀번호:
			</span>
				 <input type="password" name="pwd">
		</div>
		<div class="j_put">
			<span>
				닉네임:
			</span>
				 <input type="text" name="nick_name">
		</div>
		<div class="j_put">
			<span>
				전화번호:
			</span>
				 <input type="text" name="phone" oninput="hypenTel(this)" maxlength="13">
		</div>
		<div class="j_put">
		<span>
			주소:
		</span>
				<input type="hidden" id="sample6_postcode" placeholder="우편번호">
				<input type="text" name="addr1" id="sample6_address" placeholder="주소">
				<input type="text" name="addr2" id="sample6_detailAddress" placeholder="상세주소">
				<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
				<input type="hidden" id="sample6_extraAddress" placeholder="참고항목">
		</div>
		<div class="btndiv">
			<button type="submit" class="joinBtn">가입</button>
		</div>
	</form>
<section>
</section>
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
<%@ include file="/footer.jsp" %>
</body>
</html>