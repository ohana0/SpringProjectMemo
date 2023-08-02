<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="/static/css/style.css" type="text/css">

</head>
<body>
	<div id="wrap">
		<header class="d-flex align-items-center">
			<h2 class="pl-3">Memo</h2>
		</header>
		<section class="contents d-flex justify-content-center">
			<div class="join-box">
				<h1 class="d-flex justify-content-center m-3 title">회원가입</h1>
				<input type="text" class="form-control mt-2" placeholder="아이디" id="idInput">
				<input type="password" class="form-control mt-2" placeholder="****" id="passwordInput">
				<input type="password" class="form-control mt-2" placeholder="비밀번호확인" id="passwordConfirm">
				<input type="text" class="form-control mt-2" placeholder="이름" id="nameInput">
				<input type="text" class="form-control mt-2" placeholder="이메일 주소" id="emailInput">
				<button type="button" class="btn btn-block mt-2" id="joinBtn">가입</button>
				
			
			</div>
		</section>
		<footer class="d-flex justify-content-center align-items-center">
			<div>Copyright 2018. memo all rights reserved.</div>
		</footer>
	
	
	</div>
<script>
	$(document).ready(function(){
		$("#joinBtn").on("click",function(){
			let id = $("#idInput").val();
			let password = $("#passwordInput").val();
			let passwordConfirm = $("#passwordConfirm").val();
			let name = $("#nameInput").val();
			let email = $("#emailInput").val();
			if(id == ""){
				alert("id를 입력하세요");
				return;
			}
			if(password == ""){
				alert("password를 입력하세요");
				return;
			}
			if(password != passwordConfirm){
				alert("password 불일치");
				return;
			}
			if(name == ""){
				alert("이름을 입력하세요");
				return;
			}
			if(email == ""){
				alert("이메일을 입력하세요");
				return;
			}
			
			$.ajax({
				type:"post"
				,url:"/user/join"
				,data:{
					"loginId":id
					,"password":password
					,"name":name
					,"email":email
				}
				,success:function(data){
					if(data.result == "success"){
						alert("가입성공");
						location.href="/user/login-view"
					}
					else{
						alert("가입 실패");
					}
				}
				,error:function(){
					alert("오류발생");
				}
			
			
			})
			
			
			
		});
		
	});
</script>

</body>
</html>