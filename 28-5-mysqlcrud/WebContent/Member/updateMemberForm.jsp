<!-- 28�� ����� -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ page import = "service.MemberDao" %>
<%@ page import = "service.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>updateMemberForm</title>
</head>
<body>
<%
	int send_no = Integer.parseInt(request.getParameter("send_no"));
	System.out.println (send_no +"<-send_no");
	
	MemberDao dao = new MemberDao();
	Member m = dao.mSelectforUpdate(send_no);
	
	int dbno = m.getMember_no();
	String dbname = m.getMember_name();
	int dbage = m.getMember_age();
	
	

	
%>
<form action="<%= request.getContextPath() %>/Member/updateMemberAction.jsp" method="post">
<table border="1">
<tr>
	<td>��ȣ</td>
	<td><input type="text" name="dbno" size="20" value="<%= m.getMember_no() %>" readonly></td>
<tr>
<tr>
	<td>�̸�</td>
	<td><input type="text" name="dbname" size="20" value="<%= m.getMember_name() %>"></td>
<tr>
<tr>
	<td>����</td>
	<td><input type="text" name="dbage" size="20" value="<%= m.getMember_age() %>"></td>
<tr>
<tr>
	<td colspan="4"><input type="submit" value="����"></td>
</tr>
<tr>
	<td colspan="4"><input type="submit" value="����"></td>
</tr>
</table>
</form>
<!--<table border = "1">
	<tr>
		<td>��ȣ</td>
		<td>�̸�</td>
		<td>����</td>
		<td>�ּ��Է�</td>
		<td>����</td>
		<td>����</td>
	</tr>
</table>-->
</body>
</html>