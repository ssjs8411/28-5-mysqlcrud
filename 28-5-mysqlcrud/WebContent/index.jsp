<!-- 18.7.3 ������ -->
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
			<td>���</td>
			<td>
				<a href="<%=request.getContextPath() %>/Member/insertMemberForm.jsp">������</a>
				<a href="<%=request.getContextPath() %>/Member/MemberList.jsp">������</a>
				<a href="<%=request.getContextPath() %>/Member/MemberAndScoreList.jsp">�������</a>
				<a href="<%=request.getContextPath() %>/Member/memberListAboveAvg.jsp">��������̻���</a></td>
		</tr>
		<tr>
			<td>�л�</td>
			<td>
				<a href="<%=request.getContextPath() %>/Student/insertStudentForm.jsp">�л����</a>
				<a href="<%=request.getContextPath() %>/Student/studentList.jsp">�л����</a>
				<a href="<%=request.getContextPath() %>/Student/studentAndScoreList.jsp">�л�����</a>
				<a href="<%=request.getContextPath() %>/Student/studentListAboveAvg.jsp">��������̻���</a></td>
		</tr>
		<tr>
			<td>����</td>
			<td>
				<a href="<%=request.getContextPath() %>/Teacher/insertTeacherForm.jsp">������</a>
				<a href="<%=request.getContextPath() %>/Teacher/teacherList.jsp">������</a>
				<a href="<%=request.getContextPath() %>/Teacher/teacherAndScoreList.jsp">��������</a>
				<a href="<%=request.getContextPath() %>/Teacher/teacherListAboveAvg.jsp">��������̻���</a></td>
		</tr>
		<tr>
			<td>����</td>
			<td>
				<a href="<%=request.getContextPath() %>/Employed/insertEmployedForm.jsp">�������</a>
				<a href="<%=request.getContextPath() %>/Employed/employedList.jsp">�������</a>
				<a href="<%=request.getContextPath() %>/Employed/employedAndScoreList.jsp">��������</a>
				<a href="<%=request.getContextPath() %>/Employed/employedListAboveAvg.jsp">��������̻���</a></td>
		</tr>
	</table>
</body>
</html>