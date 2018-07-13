<!-- 2018-07-08 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import = "service.MemberAddrDao" %>	<!-- service패키지 안에 MemberAddrDao클래스 import-->
<%@ page import = "service.MemberAddr" %>		<!-- service패키지 안에 MemberAddr클래스 import-->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>memberAddrList</title>
</head>
	<body>
			<table border = "1">
				<tr>
					<td>번호</td>
					<td>주소</td>
				</tr>

<%
	request.setCharacterEncoding("UTF-8");		//한글 안 꺠지게

	int member_no = Integer.parseInt(request.getParameter("member_no"));
	MemberAddrDao madao = new MemberAddrDao();
	MemberAddr maddr = madao.selectMemberAddr(member_no);
	
%>

	
				<tr>
					<td><%= maddr.getMember_no() %></td>
					<td><%= maddr.getMember_addr_content()%></td>
				</tr>
			</table>
		<a href="<%= request.getContextPath()%>/Member/memberList.jsp">memberList</a>
	</body>
</html>