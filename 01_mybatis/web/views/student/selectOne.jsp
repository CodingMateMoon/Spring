<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectOne</title>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<div id="student-container">
		<h2>학생 정보 검색</h2>
		<p>총 학생 수는 ${count }명 입니다.</p>
	</div>
</body>
</html>