<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모 리스트</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>
	<div id="wrap">
		<%@ include file="/WEB-INF/jsp/include/header.jsp" %>
		
		<section class="contents">
			<h1 class="text-center">메모리스트</h1>
			<table class="table text-center">
				<thead>
					<tr>
						<th>No.</th>
						<th>제목</th>
						<th>시간</th>
						
					</tr>
				</thead>
				<tbody>
<c:forEach var="memo" items="${postList }" varStatus="status">
					<tr>
						<td>${memo.id }</td>
						<td><a href="/post/detail-view/${memo.id }">${memo.title }</a></td>
						<td><fmt:formatDate value="${memo.createdAt}" pattern="yyyy-MM-dd hh:mm:ss"></fmt:formatDate></td>
					</tr>
</c:forEach>
				</tbody>
		</table>
		
			<a href="/post/create-view" class="btn btn-secondary">글쓰기</a>
		</section>
		
		
		<%@ include file="/WEB-INF/jsp/include/footer.jsp" %>


	</div>
</body>
</html>