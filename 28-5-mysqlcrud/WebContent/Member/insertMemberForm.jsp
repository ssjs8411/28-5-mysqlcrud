<!-- 28�� ����� -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>insertMemberForm</title>
</head>
<body>
<form action="<%= request.getContextPath() %>/Member/insertMemberAction.jsp" method="post"> <!--post ������� Member ���� �ȿ� insertMemberAction.jsp�� �����ּ��� -->
	<table border="1">
		<tr>
			<td>����̸�</td>
			<td><input type="text" name="member_name" size="20"></td>
		</tr>
		<tr>
			<td>�������</td>
			<td><input type="text" name="member_age" size="20"></td>
		</tr>
		<tr>
			<td colspan="4"><input type="submit" value="��ư"></td>
		</tr>
	</table>
</form>
</body>
</html>