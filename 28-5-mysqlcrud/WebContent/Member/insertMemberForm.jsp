<!-- 28기 김소희 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>insertMemberForm</title>
</head>
<body>
<form action="<%= request.getContextPath() %>/Member/insertMemberAction.jsp" method="post"> <!--post 방식으로 Member 폴더 안에 insertMemberAction.jsp로 보내주세요 -->
	<table border="1">
		<tr>
			<td>멤버이름</td>
			<td><input type="text" name="member_name" size="20"></td>
		</tr>
		<tr>
			<td>멤버나이</td>
			<td><input type="text" name="member_age" size="20"></td>
		</tr>
		<tr>
			<td colspan="4"><input type="submit" value="버튼"></td>
		</tr>
	</table>
</form>
</body>
</html>