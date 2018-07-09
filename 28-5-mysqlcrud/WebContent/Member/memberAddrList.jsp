<!-- 2018-07-08 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ page import = "service.MemberAddrDao" %>
<%@ page import = "service.MemberAddr" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border = "1">
            <tr>
                <td>번호</td>
                <td>주소</td>
            </tr>
<%
	request.setCharacterEncoding("euc-kr");

	int member_no = Integer.parseInt(request.getParameter("member_no"));
	MemberAddrDao maddrao = new MemberAddrDao();
	MemberAddr maddr = maddrao.mSelectUpdateAddr(member_no);
%>
	<tr>
		<td><%= maddr.getMember_no() %></td>
		<td><%= maddr.getMember_addr_content()%></td>
	</tr>
	</table>
	<a href="<%= request.getContextPath()%>/Member/MemberList.jsp">MemberList</a>
</body>
</html>