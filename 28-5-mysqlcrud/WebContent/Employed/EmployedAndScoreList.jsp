<!-- 18.7.9 ������ -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.EmployedScoreDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.EmployedAndScore" %>
<%@ page import = "service.Employed" %>
<%@ page import = "service.EmployedScore" %>
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

	EmployedScoreDao scdao = new EmployedScoreDao();
	ArrayList<EmployedAndScore> aleac = scdao.selectEmployedAndScored();
	
	for(int i=0; i<aleac.size(); i++){
		EmployedAndScore eac = aleac.get(i);
		Employed e = eac.getEmployed();
		EmployedScore ec = eac.getEmployedScore();
%>
			<tr>
				<td><%=e.getEmployed_no() %></td>
				<td><%=e.getEmployed_name() %></td>
				<td><%=e.getEmployed_age() %></td>
				<td><%=ec.getEmployed_score_no() %></td>
				<td><%=ec.getEmployed_score() %></td>
			</tr>
<%
	}
%>
		</table>	
	</body>
</html>