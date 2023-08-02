<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
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
		<section class="contents d-flex justify-content-center align-items-center">
			<div class="login-box">
				<input type="text" class="form-control mt-2" placeholder="Username" id="idInput">
				<input type="password" class="form-control mt-2" placeholder="****" id="passwordInput">
				<button type="button" class="btn btn-block btn-dark mt-2">로그인</button>
				<a href="/user/join-view" class="d-flex justify-content-center mt-1">회원가입</a>
			</div>
				
		</section>
		<footer class="d-flex justify-content-center align-items-center">
			<div>Copyright 2018. memo all rights reserved.</div>
		</footer>
	</div>

</body>
</html>