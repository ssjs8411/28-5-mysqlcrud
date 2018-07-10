<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.TeacherAddrDao" %>
<%@ page import = "service.TeacherAddr" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
		<style>
			table, th, td{
				border : 1px solid #444444;
			}
		</style>
	</head>
	<body>
		<h1>주소조회</h1>
		
		<table>
			<tr>
				<th>번호</th>
				<th>주소</th>
			</tr>
<%
		request.setCharacterEncoding("euc-kr");
		int teacher_no = Integer.parseInt(request.getParameter("teacher_no"));
		
		TeacherAddrDao taddrdao = new TeacherAddrDao();
		TeacherAddr taddr = taddrdao.selectTeacherAddr(teacher_no);
		
%>
			<tr>
				<td><%= taddr.getTeacher_no() %></td>
				<td><%= taddr.getTeacher_addr_content() %></td>
			</tr>
		</table>
		<a href="<%=request.getContextPath() %>/Teacher/teacherList.jsp">리스트</a>
	</body>
</html>