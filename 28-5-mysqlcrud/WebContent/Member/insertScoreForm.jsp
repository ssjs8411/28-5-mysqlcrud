<!-- 2018-07-08 김소희 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
</head>
<body>
<%
int member_no = Integer.parseInt(request.getParameter("member_no"));
%>

	<form action="<%=request.getContextPath()%>/Member/insertScoreAction.jsp">
		<input type="hidden" name="member_no" value="<%=member_no%>">
		score : <input type="text" name="score">
		 <input type="submit" value="입력">
	</form>
</body>
</html>