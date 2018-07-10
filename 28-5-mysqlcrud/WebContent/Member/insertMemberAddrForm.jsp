<!-- 2018-07-08 김소희-->
<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
</head>
	<body>
<%	
		int member_no = Integer.parseInt(request.getParameter("member_no"));		//형변환
%>

		<form action="<%=request.getContextPath()%>/Member/insertMemberAddrAction.jsp" method="post">
			<input type="hidden" name="member_no" value="<%=member_no%>"> 
			주소 : <input type="text" name="member_addr_content">
			<button type="submit">입력</button>
		</form>
</body>
</html>