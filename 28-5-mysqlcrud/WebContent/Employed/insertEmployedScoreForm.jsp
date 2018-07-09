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
	int employed_no = Integer.parseInt(request.getParameter("employed_no"));
%>
		<form action="<%=request.getContextPath() %>/Employed/insertEmployedScoreAction.jsp" method="post">
			<input type="hidden" name="employed_no" value="<%=employed_no%>">
			점수 : <input type="text" name="employed_score">
			<input type="submit" value="입력">
		</form>	
	</body>
</html>