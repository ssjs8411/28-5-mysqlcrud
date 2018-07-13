<!-- 18.6.25 최지수 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
		<style>
			table, th, td{
				border: 1px solid #444444;
			}
		</style>
	</head>
	<body>
		<form action="<%= request.getContextPath()%>/Student/insertStudentAction.jsp" method="post">
			<table>
				<tr>
					<td>학생이름</td>
					<td><input type="text" name="student_name"></td>
				</tr>
				<tr>
					<td>학생나이</td>
					<td><input type="text" name="student_age"></td>
				</tr>
				<tr>
					<td colspan="2"><button type="submit">입력</button></td>
				</tr>
			</table>
		</form>
	</body>
</html>