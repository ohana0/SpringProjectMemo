<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
		<header class="d-flex align-items-center justify-content-between">
			<h2 class="pl-3">Memo</h2>
			<%-- 세션에 userid값이 있으면 사용자정보 태그 포함 --%>
			<c:if test="${not empty userId }">
				<div class="pr-3">${userName } <a href="/user/logout">로그아웃</a></div>
			
			</c:if>
		</header>