<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="<%= request.getContextPath()%>/Student/insertStudentAction.jsp" method="post">
			이름 : <input type="text" name="student_name">	<br>
			나이 : <input type="text" name="student_age">	<br>
			<button type="submit">입력</button>
		</form>
	</body>
</html>