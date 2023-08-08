<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모 입력</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>
	<div id="wrap">
		<%@ include file="/WEB-INF/jsp/include/header.jsp" %>
		
		<section class="contents d-flex justify-content-center">
			<div class="contents-box">
				<h1 class="text-center m-4">메모 입력</h1>
				
				<div class="d-flex m-4 align-items-center">
					<label class="col-2 text-center">제목 : </label>
					<input type="text" class="form-control col-10" placeholder="내용을 입력해 주세요" id="titleInput">
					
				</div>
				<textarea rows="10" class="form-control m-4" id="contentInput" placeholder="내용을 입력해 주세요"></textarea>
				<input type="file" class="form-control m-4">
				<div class="d-flex justify-content-between m-4">
					<a href="/post/list-view" class="btn btn-secondary">목록으로</a>
					<button type="button" class="btn btn-secondary" id="saveBtn">저장</button>
				</div>
			</div>

			
		</section>
		
		
		
		<%@ include file="/WEB-INF/jsp/include/footer.jsp" %>
<script>
	$(document).ready(function(){
		$("#saveBtn").on("click",function(){
			let title = $("#titleInput").val();
			let content = $("#contentInput").val();

			
			if(title == ""){
				alert("제목을 입력하세요");
				return;
			}
			else if(content == ""){
				alert("내용을 입력하세요");
				return;
			}
			$.ajax({
				type: "post"
				,url: "/post/create"
				,data: {"title":title,"content":content}
				,success:function(data){
					if(data.result == "success"){
						location.href="/post/list-view";
					}
					else{
						alert("메모입력 실패");
					}
				}
				
			})
			
			
			
		})
		
	})
	


</script>

	</div>
</body>
</html>