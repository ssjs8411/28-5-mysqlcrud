<!-- 18.7.4 ������ -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.EmployedAddrDao" %>
<%@ page import = "service.EmployedAddr" %>
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
		<h1>�ּ���ȸ</h1>
		
		<table>
			<tr>
				<th>��ȣ</th>
				<th>�ּ�</th>
			</tr>
<%
		request.setCharacterEncoding("euc-kr");
		int employed_no = Integer.parseInt(request.getParameter("employed_no"));
		
		EmployedAddrDao eaddrdao = new EmployedAddrDao();
		EmployedAddr eaddr = eaddrdao.selectEmployedAddr(employed_no);
		
%>
			<tr>
				<td><%= eaddr.getEmployed_no() %></td>
				<td><%= eaddr.getEmployed_addr_content() %></td>
			</tr>
		</table>
		<a href="<%=request.getContextPath() %>/Employed/EmployedList.jsp">����Ʈ</a>	
	</body>
</html>