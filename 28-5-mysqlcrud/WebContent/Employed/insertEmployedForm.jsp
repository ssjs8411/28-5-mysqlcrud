<!-- 18.6.26 ������ -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>insertEmployed</title>
	</head>
	<body>
			
		<form action="<%= request.getContextPath()%>/Employed/insertEmployedAction.jsp" method="post">
			�̸� : <input type="text" name="employed_name">	<br>
			���� : <input type="text" name="employed_age">	<br>
			<button type="submit">�Է�</button>
		</form>
	
	</body>
</html>