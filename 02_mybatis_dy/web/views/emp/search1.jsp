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
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<div id="search-container">
		<form action="${path }/empSearchEnd.do" method="post">
			<select name="searchType" required>
				<option value="" disabled selected>검색타입</option>
				<option value="emp_id" <c:if test="${'emp_id' eq param.searchType}">selected</c:if>>사번</option>
				<option value="emp_name" <c:if test="${'emp_name' eq param.searchType}">selected</c:if>>사원명</option>
				<option value="email" <c:if test="${'email' eq param.searchType}">selected</c:if>>이메일</option>
				<option value="phone" <c:if test="${'phone' eq param.searchType}">selected</c:if>>전화번호</option>
			</select>
			<input type="text" name="keyword" value="${param.keyword }" required/>
			<input type="submit" value="검색"/>
		</form>
		<table>
			<tr>
				<th>사번</th>
				<th>사원명</th>
				<th>주민번호</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>부서코드</th>
				<th>직급코드</th>
				<th>급여레벨</th>
				<th>급여</th>
				<th>보너스율</th>
				<th>매니져사번</th>
				<th>입사일</th>
			</tr>
			<c:forEach var="emp" items="${list }">
				<tr>
					<td><c:out value="${emp['EMP_ID'] }"/></td>
					<td><c:out value="${emp['EMP_NAME'] }"/></td>
					<%-- <td><c:out value="${emp['EMP_NO'] }"/></td> --%>
					<td><c:out value="${fn:substring(emp['EMP_NO'],0,8).concat('******') }"/></td>
					<td><c:out value="${emp['EMAIL'] }"/></td>
					<td><c:out value="${emp['PHONE'] }"/></td>
					<td><c:out value="${emp['DEPT_CODE'] }"/></td>
					<td><c:out value="${emp['JOB_CODE'] }"/></td>
					<td><c:out value="${emp['SAL_LEVEL'] }"/></td>
					<%-- <td><c:out value="${emp['SALARY'] }"/></td> --%>
					<td><fmt:formatNumber value="${emp['SALARY'] }" type="currency"/></td>
					<%-- <td><c:out value="${emp['BONUS'] }"/></td> --%>
					<td><fmt:formatNumber value="${emp['BONUS'] }" type="percent"/></td>
					<td><c:out value="${emp['MANAGER_ID'] }"/></td>
					<%-- <td><c:out value="${emp['HIRE_DATE'] }"/></td> --%>
					<td><fmt:formatDate value="${emp['HIRE_DATE'] }" type="date" pattern="yyyy년 MM월 dd일"/></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>