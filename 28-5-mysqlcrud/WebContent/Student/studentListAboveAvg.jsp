<!-- 18.7.10 최지수 -->
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
				border : 1px solid;
			}
		</style>
	</head>
	<body>
		<h1>studentListAboveAvg</h1>
<%
	StudentScoreDao scdao = new StudentScoreDao();
	int avg = scdao.selectScoreAvg();
%>		
		<div>
			평균 : <%=avg %>
		</div>
		<table>
			<thead>
				<tr>
					<th>STUDENT_NO</th>
					<th>STUDENT_NAME</th>
					<th>STUDENT_SCORE</th>
				</tr>
			</thead>
			<tbody>
<%
		
		ArrayList<StudentAndScore> list = scdao.selectStudentListAboveAvg();
		for(int i=0; i<list.size(); i++){
			
			StudentAndScore sac = list.get(i);
			Student s = sac.getStudent();
			StudentScore sc = sac.getStudentScore();
%>
				<tr>
					<td><%=s.getStudent_no() %></td>
					<td><%=s.getStudent_name() %></td>
					<td><%=sc.getScore() %></td>
				</tr>
<%
		}
%>
				
			</tbody>
		</table>
	</body>
</html>