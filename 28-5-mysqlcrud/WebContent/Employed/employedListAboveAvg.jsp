<!-- 18.7.10 최지수 -->
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
				border : 1px solid;
			}
		</style>
	</head>
	<body>
		<h1>EmployedListAboveAvg</h1>
<%
	EmployedScoreDao ecdao = new EmployedScoreDao();
	int avg = ecdao.selectScoreAvg();
%>		
		<div>
			평균 : <%=avg %>
		</div>
		<table>
			<thead>
				<tr>
					<th>EMPLOYED_NO</th>
					<th>EMPLOYED_NAME</th>
					<th>EMPLOYED_SCORE</th>
				</tr>
			</thead>
			<tbody>
<%
		
		ArrayList<EmployedAndScore> list = ecdao.selectEmployedListAboveAvg();
		for(int i=0; i<list.size(); i++){
			
			EmployedAndScore eac = list.get(i);
			Employed e = eac.getEmployed();
			EmployedScore ec = eac.getEmployedScore();
%>
				<tr>
					<td><%=e.getEmployed_no() %></td>
					<td><%=e.getEmployed_name() %></td>
					<td><%=ec.getEmployed_score() %></td>
				</tr>
<%
		}
%>
				
			</tbody>
		</table>
	</body>
</html>