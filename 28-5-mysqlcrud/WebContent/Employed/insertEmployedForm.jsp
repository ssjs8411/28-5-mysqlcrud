<!-- 18.6.26 최지수 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>insertEmployed</title>
	</head>
	<body>
			
		<form action="<%= request.getContextPath()%>/Employed/insertEmployedAction.jsp" method="post">
			이름 : <input type="text" name="employed_name">	<br>
			나이 : <input type="text" name="employed_age">	<br>
			<button type="submit">입력</button>
		</form>
	
	</body>
</html>