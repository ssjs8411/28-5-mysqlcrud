<!-- �̰漱 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.TeacherDao" %>
<%@ page import = "service.TeacherAddrDao" %>
<%@ page import = "service.Teacher" %>
<%@ page import = "service.TeacherAddr" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
<%
	request.setCharacterEncoding("euc-kr");
	int teacher_no = Integer.parseInt(request.getParameter("teacher_no"));
	
	TeacherDao tdao = new TeacherDao();
	Teacher t = tdao.selectUpdateTeacher(teacher_no);
	
	TeacherAddrDao taddrdao = new TeacherAddrDao();
	TeacherAddr taddr = taddrdao.selectUpdateTeacherAddr(teacher_no);
%>
		<h1>����ȭ��</h1>
		<form action="<%=request.getContextPath() %>/Teacher/updateTeacherAction.jsp" method="post">
			<input type="hidden" name="teacher_no" value="<%=t.getTeacher_no()%>">
			�̸� : <input type="text" name="teacher_name" value="<%=t.getTeacher_name()%>">	<br>
			���� : <input type="text" name="teacher_age" value="<%=t.getTeacher_age()%>">	<br>
			�ּ� : <input type="text" name="teacher_addr_content" value="<%=taddr.getTeacher_addr_content()%>">	<br>
			<button type="submit">����</button>
		</form>
	</body>
</html>