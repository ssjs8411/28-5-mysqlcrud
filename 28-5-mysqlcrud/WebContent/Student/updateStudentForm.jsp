<!-- 18.7.3 ������ -->
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
		<h1>����ȭ��</h1>
		<form action="<%=request.getContextPath() %>/Student/updateStudentAction.jsp" method="post">
			<input type="hidden" name="student_no" value="<%=s.getStudent_no()%>">
			�̸� : <input type="text" name="student_name" value="<%=s.getStudent_name()%>">	<br>
			���� : <input type="text" name="student_age" value="<%=s.getStudent_age()%>">	<br>
			�ּ� : <input type="text" name="student_addr_content" value="<%=saddr.getStudent_addr_content()%>">	<br>
			<button type="submit">����</button>
		</form>
	</body>
</html>