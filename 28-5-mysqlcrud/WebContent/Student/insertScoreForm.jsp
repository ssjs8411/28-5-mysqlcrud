<!-- 18.7.9 최지수 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
<%
	int student_no = Integer.parseInt(request.getParameter("student_no"));
%>
		<form action="<%=request.getContextPath() %>/Student/insertScoreAction.jsp" method="post">
			<input type="hidden" name="student_no" value="<%=student_no%>">
			점수 : <input type="text" name="score">
			<input type="submit" value="입력">
		</form>
	</body>
</html>