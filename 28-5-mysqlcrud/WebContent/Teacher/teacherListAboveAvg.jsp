
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.TeacherScoreDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.TeacherAndScore" %>
<%@ page import = "service.Teacher" %>
<%@ page import = "service.TeacherScore" %>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>teacherListAboveAvg</title>
	</head>
		<style>
			table, th, td{
				border : 1px solid;
			}
		</style>
	<body>
		<h1>teacherListAboveAvg</h1>
		<%
			TeacherScoreDao tsdao = new TeacherScoreDao();
			int avg = tsdao.selectScoreAvg();
		%>
		<div>
			평균 : <%= avg %>
		</div>
		<table>
			<thead>
					<tr>
						<th>teacher_no</th>
						<th>teacher_name</th>
						<th>teacher_score</th>				
					</tr>
			</thead>
			<tbody>
				<% 
				
				ArrayList<TeacherAndScore> list = tsdao.selectTeacherListAboveAvg();
					for(int i=0; i<list.size(); i++){
						TeacherAndScore tas = list.get(i); 
						Teacher t = tas.getTeacher();
						TeacherScore ts = tas.getTeacherScore();
						
				%>
						<tr>
							<td><%=t.getTeacher_no()%></td>
							<td><%=t.getTeacher_name()%></td>
							<td><%=ts.getScore()%></td>
						</tr>
				<% 		
					}
				%>
			</tbody>
		</table>
	</body>
	</html>