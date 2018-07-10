<!-- 이경선 -->
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
		<h1>수정화면</h1>
		<form action="<%=request.getContextPath() %>/Teacher/updateTeacherAction.jsp" method="post">
			<input type="hidden" name="teacher_no" value="<%=t.getTeacher_no()%>">
			이름 : <input type="text" name="teacher_name" value="<%=t.getTeacher_name()%>">	<br>
			나이 : <input type="text" name="teacher_age" value="<%=t.getTeacher_age()%>">	<br>
			주소 : <input type="text" name="teacher_addr_content" value="<%=taddr.getTeacher_addr_content()%>">	<br>
			<button type="submit">수정</button>
		</form>
	</body>
</html>