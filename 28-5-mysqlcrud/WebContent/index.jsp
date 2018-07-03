<!-- 18.7.3 최지수 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>index.jsp</h1>
	<ul>
		<li><a href="<%=request.getContextPath() %>/Member/MemberList.jsp">MemberList</a></li>
		<li><a href="<%=request.getContextPath() %>/Student/studentList.jsp">MemberList</a></li>
		<li><a href="<%=request.getContextPath() %>/Teachter/Teachterlist.jsp">MemberList</a></li>
		<li><a href="<%=request.getContextPath() %>/Employed/EmployedList.jsp">MemberList</a></li>
	</ul>
</body>
</html>