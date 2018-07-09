<!-- 18.7.4 최지수 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.EmployedDao" %>
<%@ page import = "service.EmployedAddrDao" %>
<%@ page import = "service.Employed" %>
<%@ page import = "service.EmployedAddr" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
<%
	request.setCharacterEncoding("euc-kr");
	int employed_no = Integer.parseInt(request.getParameter("employed_no"));
	
	EmployedDao edao = new EmployedDao();
	Employed e = edao.selectUpdateEmployed(employed_no);
	
	EmployedAddrDao eaddrdao = new EmployedAddrDao();
	EmployedAddr eaddr = eaddrdao.selectUpdateEmployedAddr(employed_no);
%>
		<h1>수정화면</h1>
		<form action="<%=request.getContextPath() %>/Employed/updateEmployedAction.jsp" method="post">
			<input type="hidden" name="employed_no" value="<%=e.getEmployed_no()%>">
			이름 : <input type="text" name="employed_name" value="<%=e.getEmployed_name()%>">	<br>
			나이 : <input type="text" name="employed_age" value="<%=e.getEmployed_age()%>">	<br>
			주소 : <input type="text" name="employed_addr_content" value="<%=eaddr.getEmployed_addr_content()%>">	<br>
			<button type="submit">수정</button>
		</form>	
	</body>
</html>