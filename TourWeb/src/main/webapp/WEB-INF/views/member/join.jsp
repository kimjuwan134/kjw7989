<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title> 회원가입 | 투어리스트인투어 </title>
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/common.js"></script>  
<script src="${pageContext.request.contextPath}/resources/js/jquery.smooth-scroll.min.js"></script> 
<!--[if lte IE 9]>
    <script src="js/html5shiv.js"></script>
	<script src="js/placeholders.min.js"></script>
<![endif]-->
</head>

<body>
<ul class="skipnavi">
    <li><a href="#container">본문내용</a></li>
</ul>
<!-- wrap -->
<div id="wrap">

	<jsp:include page="../inc/top.jsp"/>
	
	<div id="container">
		<!-- location_area -->
		<div class="location_area member">
			<div class="box_inner">
				<h2 class="tit_page">TOURIST <span class="in">in</span> TOUR</h2>
				<p class="location">MEMBER <span class="path">/</span> 회원가입</p>
				<ul class="page_menu clear">
					<li><a href="javascript:;" class="on">회원가입</a></li>
				</ul>
			</div>
		</div>	
		<!-- //location_area -->

		<!-- bodytext_area -->
		<div class="bodytext_area box_inner">
			<!-- appForm -->
			<form action="${pageContext.request.contextPath}/member/insertPro" class="appForm" method="post" name="fr">
				<fieldset>
					<legend>상담문의 입력 양식</legend>
					<p class="info_pilsoo pilsoo_item">필수입력</p>
					<ul class="app_list">
						<li class="clear">
							<label for="id_lbl" class="tit_lbl pilsoo_item">아이디</label>
							<div class="app_content"><input type="text" name="id" class="w100p" id="id_lbl" placeholder="아이디 입력해주세요"/>
							</div>
						</li>
						<li class="clear">
							<label for="id_lbl" class="tit_lbl pilsoo_item"></label>
							<div class="app_content" id="idcheck"></div>
						</li>
						<li class="clear">
							<label for="pwd_lbl" class="tit_lbl pilsoo_item">비밀번호</label>
							<div class="app_content"><input type="password" name="pass" class="w100p" id="pwd_lbl" placeholder="비밀번호를 입력해주세요"/></div>
						</li>
						<li class="clear">
							<label for="pwd2_lbl" class="tit_lbl pilsoo_item">비밀번호 확인</label>
							<div class="app_content"><input type="password" name="pass2" class="w100p" id="pwd2_lbl" placeholder="비밀번호를 다시 한번 입력해주세요"/></div>
						</li>
						<li class="clear">
							<label for="name_lbl" class="tit_lbl pilsoo_item">작성자명</label>
							<div class="app_content"><input type="text" name="name" class="w100p" id="name_lbl" placeholder="이름을 입력해주세요"/></div>
						</li>
						<li class="clear">
							<label for="phone_lbl" class="tit_lbl pilsoo_item">연락처</label>
							<div class="app_content"><input type="tel" name="phone" class="w100p" id="phone_lbl" placeholder="휴대폰”-”없이 숫자만 입력하세요"/></div>
						</li>
						<li class="clear">
                            <label for="email_lbl" class="tit_lbl pilsoo_item">이메일</label>
                            <div class="app_content email_area">
                                <input type="text" name="email" class="w160" id="email_lbl" title="이메일 주소" />
                                <span class="ico_space">@</span>
                                <input type="text" name="email2" class="w160" id="email_lbl2" value=""title="이메일 제공업체 입력" />										
                                <div class="select_common">
                                    <select title="이메일 제공업체 목록" id="email3">
                                        <option value="">직접입력</option>
                                        <option value="naver.com">naver.com</option>
                                        <option value="hanmail.net">hanmail.net</option>
                                    </select>
                                </div>										
                            </div>
						</li>
						<li class="clear">
							<span class="tit_lbl">성별</span>
							<div class="app_content radio_area">
								<input type="radio" class="css-radio" id="mmm_lbl" name="gender" value="남"><label for="mmm_lbl">남</label>
								<input type="radio" class="css-radio" id="www_lbl" name="gender" value="여"><label for="www_lbl">여</label>
							</div>
						</li>
						<li class="clear">
                            <span class="tit_lbl">개인정보 활용동의</span>
							<div class="app_content checkbox_area">
								<input type="checkbox" class="css-checkbox" id="agree_lbl" name="agree" value="agree"><label for="agree_lbl">동의함</label>
							</div>
						</li>
						<li class="clear">
							<label for="content_lbl" class="tit_lbl">문의내용</label>
							<div class="app_content"><textarea name="content" id="content_lbl" class="w100p" placeholder="간단한 상담 요청 사항을 남겨주시면 보다 상세한 상담이 가능합니다.
전화 상담 희망시 기재 부탁드립니다."></textarea></div>
						</li>
					</ul>
<!-- 					 "javascript:document.fr.submit();" -->
					<p class="btn_line"><a href="#" class="btn_baseColor" id="submitbtn">회원가입</a></p>	
				</fieldset>
			</form>
			<!-- //appForm -->
			
		</div>
		<!-- //bodytext_area -->

	</div>
	<!-- //container -->

	<jsp:include page="../inc/bottom.jsp"/>

</div>
<!-- //wrap -->

<jsp:include page="../inc/popup.jsp"/>
<script type="text/javascript">
let email3 = document.getElementById("email3");
let email_lbl2 = document.getElementById("email_lbl2");
let submitbtn = document.getElementById("submitbtn");
email3.onchange = function() {
	email_lbl2.value = email3.value;
	if(email_lbl2.value == ""){
		email_lbl2.focus();
	}
}
submitbtn.addEventListener("click", submitbtnClick, false);
function submitbtnClick() {
	let id_lbl = document.getElementById("id_lbl");
	let pwd_lbl = document.getElementById("pwd_lbl");
	let pwd2_lbl = document.getElementById("pwd2_lbl");
	let name_lbl = document.getElementById("name_lbl");
	let phone_lbl = document.getElementById("phone_lbl");
	let email_lbl = document.getElementById("email_lbl");
	let mmm_lbl = document.getElementById("mmm_lbl");
	let www_lbl = document.getElementById("www_lbl");
	let agree_lbl = document.getElementById("agree_lbl");
	let content_lbl = document.getElementById("content_lbl");	
	if(id_lbl.value == "") {
		alert("아이디 입력하세요.");
		id_lbl.focus();
		return false;
	}
	if(id_lbl.value.length < 3){
		alert("아이디 3자 이상 입력해주세요");
		id_lbl.focus();
		return false;
	}
	if(pwd_lbl.value == "") {
		alert("비밀번호 입력하세요.");
		pwd_lbl.focus();
		return false;
	}
	if(pwd2_lbl.value == "") {
		alert("비밀번호 확인 입력하세요.");
		pwd2_lbl.focus();
		return false;
	}
	if(pwd_lbl.value != pwd2_lbl.value) {
		alert("비밀번호 틀림 다시 입력하세요");
		pwd_lbl.focus();
		return false;
	}
	if(name_lbl.value == "") {
		alert("이름 입력하세요.");
		name_lbl.focus();
		return false;
	}
	if(phone_lbl.value == "") {
		alert("연락처 입력하세요.");
		phone_lbl.focus();
		return false;
	}
	if(email_lbl.value == "") {
		alert("이메일 입력하세요.");
		email_lbl.focus();
		return false;
	}
	if(email_lbl2.value == "") {
		alert("이메일 주소 입력하세요.");
		email_lbl2.focus();
		return false;
	}
	if(mmm_lbl.checked == false && www_lbl.checked == false) {
		alert("성별 선택해주세요");
		mmm_lbl.focus();
		return false;
	}
	if(agree_lbl.checked == false) {
		alert("동의 체크해주세요");
		agree_lbl.focus();
		return false;
	}
	if(content_lbl.value == "") {
		alert("문의 내용 입력하세요.");
		content_lbl.focus();
		return false;
	}
	document.fr.submit();
}

</script>
<script type="text/javascript">

	$(function(){
		$('#id_lbl').blur(function(){
// 			$('#idcheck').html("<b>포커스 해제</b>").css('color', 'red');
// 			alert($('#id_lbl').val());
			$.ajax({
				url:'${pageContext.request.contextPath}/member/idCheck',
				data:{'id':$('#id_lbl').val()},
				success:function(result){
					if(result == 'iddup'){
						result = "아이디 중복";
						$('#idcheck').html(result).css('color', 'red');
					}else{
						result = "아이디 사용 가능";
						$('#idcheck').html(result).css('color', 'green');
					}					
					
				}
			});//ajax()
		});//blur()
	});//시작()

</script>
</body>
</html>