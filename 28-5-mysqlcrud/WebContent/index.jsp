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
		<li><a href="<%=request.getContextPath() %>/Student/studentList.jsp">studentList</a></li>
		<li><a href="<%=request.getContextPath() %>/Teachter/Teachterlist.jsp">Teachterlist</a></li>
		<li><a href="<%=request.getContextPath() %>/Employed/EmployedList.jsp">EmployedList</a></li>
	</ul>
	
	<ul>
		<li><a href="<%=request.getContextPath() %>/Member/memberListAboveAvg.jsp">MemberListAboveAvg</a></li>
		<li><a href="<%=request.getContextPath() %>/Student/studentListAboveAvg.jsp">studentListAboveAvg</a></li>
		<li><a href="<%=request.getContextPath() %>/Teachter/teacherListAboveAvg.jsp">TeachterlistAboveAvg</a></li>
		<li><a href="<%=request.getContextPath() %>/Employed/EmployedListAboveAvg.jsp">EmployedListAboveAvg</a></li>
	</ul>
</body>
</html>