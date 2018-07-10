<!-- 이경선 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.*"%>
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
				<table border="1">
            <tr>
                <td>번호</td>
                <td>이름</td>
                <td>나이</td>
                <td>점수번호</td>
                <td>점수</td>
<%
	request.setCharacterEncoding("euc-kr");
	
	TeacherScoreDao tsdao = new TeacherScoreDao();
	ArrayList<TeacherAndScore> list = tsdao.selectTeacherAndScored();
	
	for(int i=0; i<list.size(); i++ ){
		TeacherAndScore tas = list.get(i);
		Teacher t = tas.getTeacher();
		TeacherScore ts = tas.getTeacherScore();
%>
			<tr>
				<td><%=t.getTeacher_no() %></td>
				<td><%=t.getTeacher_name() %></td>
				<td><%=t.getTeacher_age() %></td>
				<td><%=ts.getTeacher_score_no() %></td>
				<td><%=ts.getScore() %></td>
			</tr>
<% 		
	}
%>
		</table>	
		</body>
		</html>