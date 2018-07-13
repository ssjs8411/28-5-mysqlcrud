<!-- 18.7.9 ������ -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.StudentScoreDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.StudentAndScore" %>
<%@ page import = "service.Student" %>
<%@ page import = "service.StudentScore" %>
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
		<h1>��ü ��ȸ(��������)</h1>
		<table>
			<tr>
				<th>��ȣ</th>
				<th>�̸�</th>
				<th>����</th>
				<th>������ȣ</th>
				<th>����</th>
			</tr>
<%
	request.setCharacterEncoding("euc-kr");

	StudentScoreDao scdao = new StudentScoreDao();
	ArrayList<StudentAndScore> alsac = scdao.selectStudentAndScored();
	
	for(int i=0; i<alsac.size(); i++){
		StudentAndScore sac = alsac.get(i);
		Student s = sac.getStudent();
		StudentScore sc = sac.getStudentScore();
%>
			<tr>
				<td><%=s.getStudent_no() %></td>
				<td><%=s.getStudent_name() %></td>
				<td><%=s.getStudent_age() %></td>
				<td><%=sc.getStudent_score_no() %></td>
				<td><%=sc.getScore() %></td>
			</tr>
<%
	}
%>
		</table>
		<a href="<%=request.getContextPath()%>/Student/studentList.jsp">studentList</a>
	</body>
</html>