<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<jsp:include page="/WEB-INF/views/common/header.jsp">
      <jsp:param value="Dev 등록결과" name="pageTitle"/>
</jsp:include>
<section>
	<table class="table">
		<tr>
			<th scope="col">번호</th>
			<th scope="col">이름</th>
			<th scope="col">나이</th>
			<th scope="col">이메일</th>
			<th scope="col">성별</th>
			<th scope="col">개발가능언어</th>
			<th scope="col">수정</th>
		</tr>
		<c:forEach var="p" items="${list }" varStatus="vs">
			<tr>
				<td>${vs.count}</td>
				<td>${p["devName"] }</td>
				<td>${p["devAge"] }</td>
				<td>${p.devEmail }</td>
				<td>${p.devGender == "M"? "남" : "여" }</td>
				<%-- <c:forEach var="lang" items="" --%>
				<td>
				<c:forEach var="lang" items="${p.devLang}" varStatus="vs">
					${vs.index != 0 ? "," : "" }${lang }
				</c:forEach>
				</td>
				<td>
					<button type="button" class="btn btn-out-line-light" onclick="">수정</button>
					<button type="button" class="btn btn-out-line-light" onclick="">삭제</button>
				</td>
			</tr>
		</c:forEach>
	</table>

</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>