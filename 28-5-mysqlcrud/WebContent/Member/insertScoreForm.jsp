<!-- 2018-07-08 ����� -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>insertScoreForm</title>
</head>
	<body>
<%
	int member_no = Integer.parseInt(request.getParameter("member_no"));	//����ȯ
%>

		<form action="<%=request.getContextPath()%>/Member/insertScoreAction.jsp">
			<input type="hidden" name="member_no" value="<%=member_no%>">
			score : <input type="text" name="score">
			 <input type="submit" value="�Է�">
		</form>
		<a href="<%= request.getContextPath()%>/Member/MemberList.jsp">MemberList</a>
	</body>
</html>