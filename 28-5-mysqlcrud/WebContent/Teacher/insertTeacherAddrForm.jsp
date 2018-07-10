<!-- 이경선 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	int teacher_no = Integer.parseInt(request.getParameter("teacher_no"));
%>		
		<form action="<%= request.getContextPath()%>/Teacher/insertTeacherAddrAction.jsp" method="post">
			<input type="hidden" name="teacher_no" value="<%=teacher_no%>">
			주소 : <input type="text" name="teacher_addr_content">	<br>
			<button type="submit">입력</button>
		</form>
</body>
</html>