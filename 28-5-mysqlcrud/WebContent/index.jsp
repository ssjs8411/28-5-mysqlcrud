<!-- 18.7.3 최지수 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
	table,td{
		border: 1px solid;
	}
</style>
</head>
<body>
	<h1>index.jsp</h1>
	<table>
		<tr>
			<td>멤버</td>
			<td>
				<a href="<%=request.getContextPath() %>/Member/insertMemberForm.jsp">멤버등록</a>
				<a href="<%=request.getContextPath() %>/Member/MemberList.jsp">멤버목록</a>
				<a href="<%=request.getContextPath() %>/Member/MemberAndScoreList.jsp">멤버점수</a>
				<a href="<%=request.getContextPath() %>/Member/memberListAboveAvg.jsp">평균점수이상목록</a></td>
		</tr>
		<tr>
			<td>학생</td>
			<td>
				<a href="<%=request.getContextPath() %>/Student/insertStudentForm.jsp">학생등록</a>
				<a href="<%=request.getContextPath() %>/Student/studentList.jsp">학생목록</a>
				<a href="<%=request.getContextPath() %>/Student/studentAndScoreList.jsp">학생점수</a>
				<a href="<%=request.getContextPath() %>/Student/studentListAboveAvg.jsp">평균점수이상목록</a></td>
		</tr>
		<tr>
			<td>교사</td>
			<td>
				<a href="<%=request.getContextPath() %>/Teacher/insertTeacherForm.jsp">교사등록</a>
				<a href="<%=request.getContextPath() %>/Teacher/teacherList.jsp">교사목록</a>
				<a href="<%=request.getContextPath() %>/Teacher/teacherAndScoreList.jsp">교사점수</a>
				<a href="<%=request.getContextPath() %>/Teacher/teacherListAboveAvg.jsp">평균점수이상목록</a></td>
		</tr>
		<tr>
			<td>직원</td>
			<td>
				<a href="<%=request.getContextPath() %>/Employed/insertEmployedForm.jsp">직원등록</a>
				<a href="<%=request.getContextPath() %>/Employed/employedList.jsp">직원목록</a>
				<a href="<%=request.getContextPath() %>/Employed/employedAndScoreList.jsp">직원점수</a>
				<a href="<%=request.getContextPath() %>/Employed/employedListAboveAvg.jsp">평균점수이상목록</a></td>
		</tr>
	</table>
</body>
</html>