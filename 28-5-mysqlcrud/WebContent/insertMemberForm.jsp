<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>insertMemberForm</title>
</head>
<body>
<form action="<%= request.getContextPath() %>/insertMemberFormjsp" method="post">
	<table border="1">
		<tr>
			<td>�����ȣ</td>
			<td><input type="text" name="m_no" size="20"></td>
		</tr>
		<tr>
			<td>����̸�</td>
			<td><input type="text" name="m_name" size="20"></td>
		</tr>
		<tr>
			<td>�������</td>
			<td><input type="text" name="m_age" size="20"></td>
		</tr>
		<tr>
		<tr>
			<td colspan="4"><input type="submit" value="��ư"></td>
		</tr>
	</table>
</form>
</body>
</html>