<!-- 18.7.3 ������ -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.StudentAddrDao" %>
<%@ page import = "service.StudentAddr" %>
<%@ page import = "java.util.ArrayList" %>
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
		<h1>�ּ���ȸ</h1>
		
		<table>
			<tr>
				<th>�ּҹ�ȣ</th>
				<th>�ּ�</th>
			</tr>
<%
		request.setCharacterEncoding("euc-kr");
		int student_no = Integer.parseInt(request.getParameter("student_no"));
		
		StudentAddrDao saddrdao = new StudentAddrDao();
		ArrayList<StudentAddr> alsa = saddrdao.selectStudentAddrList(student_no);
		
		for(int i=0; i<alsa.size(); i++){
			StudentAddr sa = alsa.get(i);
%>
			<tr>
				<td><%= sa.getStudent_addr_no() %></td>
				<td><%= sa.getStudent_addr_content() %></td>
			</tr>
<%			
		}
%>
			
		</table>
		<a href="<%=request.getContextPath() %>/Student/studentList.jsp">����Ʈ</a>
	</body>
</html>