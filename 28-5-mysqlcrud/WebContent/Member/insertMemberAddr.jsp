<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ page import = "service.MemberAddrDao" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<jsp:useBean id="m" class="service.Member"/>  <!-- Member�� �ּҰ��� ���� m�� ���� Member ��ü ������ �������� ������ set�޼��忡 ���� ����  -->
<jsp:setProperty name="m" property="*"/> <!-- m�� ����ִ� �ּҰ��� ���󰡼� �޼ҵ� ������ŭ ��� ȣ��  -->
</head>
<body>
<table border = "1">
	<tr>
		<td>�ּҹ�ȣ</td>
		<td>�����ȣ</td>
		<td>����ּ�</td>
		<td>�Է�</td>
	</tr>

</table>
</body>
</html>