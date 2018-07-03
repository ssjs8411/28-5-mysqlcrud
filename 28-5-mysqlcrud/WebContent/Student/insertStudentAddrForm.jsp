<!-- 18.7.3 최지수 -->
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
		<form action="<%= request.getContextPath()%>/Student/insertStudentAddrAction.jsp" method="post">
			<input type="hidden" name="student_no" value="<%=student_no%>">
			주소 : <input type="text" name="student_addr_content">	<br>
			<button type="submit">입력</button>
		</form>
</body>
</html>