<!-- 18.7.4 최지수 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
<%
	int employed_no = Integer.parseInt(request.getParameter("employed_no"));
%>		
		<form action="<%= request.getContextPath()%>/Employed/insertEmployedAddrAction.jsp" method="post">
			<input type="hidden" name="employed_no" value="<%=employed_no%>">
			주소 : <input type="text" name="employed_addr_content">	<br>
			<button type="submit">입력</button>
		</form>	
	</body>
</html>