<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="Hello Spring" name="title"/>
</jsp:include>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
	<section id="content">
		<img src="${pageContext.request.contextPath }/resources/images/logo-spring.png" id="center-image" alt="스프링로고"/>
	</section>
	
	<button onclick="ajaxTest()">testAjax</button>
	<input type="text" id="userId"/>
	<button onclick="ajaxTest2()">vo객체 받기</button>
	<div id="result"></div>
	<script>
		function ajaxTest2() {
			var userId = $("#userId").val().trim();
			if (userId.length <= 0) {
				alert("id 입력!");
				return;
			}
			$.ajax({
				url: "${pageContext.request.contextPath}/ajaxTest2.do",
				dataType : "json",
				data : {"userId" : userId},
				success: function(data) {
					console.log(data);
				}
			});
		}
	
		function ajaxTest() {
			$.ajax({
				url : "${pageContext.request.contextPath}/ajaxTest.do",
				dataType: "json",
				success: function(data) {
					/* public Board(int boardNo, String boardTitle, String boardWriter, String boardContent, Date boardDate, int readCount,
							int fileCount) { */
					var table = $("<table>");
					table.append("<td><th>boardNo</th><th>title</th><th>writer</th><th>content</th><th>date</th><th>readCount</th></td>");
					console.log(data);
					console.log(table);
					for (var i = 0; i < data.length; i++) {
						var tr = $("<tr>");
						for (var key in data[i]) {
							var td = $("<td>");
							td.append(data[i][key]);
							tr.append(td);
						}
						table.append(tr);
					}
					$("#result").html(table);
				}
			});
		}
	</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
