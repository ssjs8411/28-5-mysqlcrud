<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="<%= request.getContextPath()%>/Student/insertStudentAction.jsp" method="post">
			�̸� : <input type="text" name="student_name">	<br>
			���� : <input type="text" name="student_age">	<br>
			<button type="submit">�Է�</button>
		</form>
	</body>
</html>