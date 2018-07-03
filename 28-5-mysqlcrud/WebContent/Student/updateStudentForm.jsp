<!-- 18.7.3 최지수 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.StudentDao" %>
<%@ page import = "service.StudentAddrDao" %>
<%@ page import = "service.Student" %>
<%@ page import = "service.StudentAddr" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
<%
	request.setCharacterEncoding("euc-kr");
	int student_no = Integer.parseInt(request.getParameter("student_no"));
	
	StudentDao sdao = new StudentDao();
	Student s = sdao.selectUpdateStudent(student_no);
	
	StudentAddrDao saddrdao = new StudentAddrDao();
	StudentAddr saddr = saddrdao.selectUpdateStudentAddr(student_no);
%>
		<h1>수정화면</h1>
		<form action="<%=request.getContextPath() %>/Student/updateStudentAction.jsp" method="post">
			<input type="hidden" name="student_no" value="<%=s.getStudent_no()%>">
			이름 : <input type="text" name="student_name" value="<%=s.getStudent_name()%>">	<br>
			나이 : <input type="text" name="student_age" value="<%=s.getStudent_age()%>">	<br>
			주소 : <input type="text" name="student_addr_content" value="<%=saddr.getStudent_addr_content()%>">	<br>
			<button type="submit">수정</button>
		</form>
	</body>
</html>