<!-- 2018-07-08 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ page import = "service.MemberAddrDao" %>	<!-- service패키지 안에 MemberAddrDao클래스 import-->
<%@ page import = "service.MemberAddr" %>		<!-- service패키지 안에 MemberAddr클래스 import-->
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
	request.setCharacterEncoding("euc-kr");		//한글 안 꺠지게

	int member_no = Integer.parseInt(request.getParameter("member_no"));
	MemberAddrDao maddrao = new MemberAddrDao();
	//MemberAddrDao data type으로 maddrao변수 생성하고  new생성자 메소드로  생성된  MemberAddrDao객체의 주소 값을 maddrao변수에 할당한다
	MemberAddr maddr = maddrao.mSelectUpdateAddr(member_no);
	//member_no 담겨있는 주소 값을 따라가서 updateMemberScore 메소드 호출
%>
		<tr>
			<td><%= maddr.getMember_no() %></td>
			<td><%= maddr.getMember_addr_content()%></td>
		</tr>
		</table>
		<a href="<%= request.getContextPath()%>/Member/MemberList.jsp">MemberList</a>
	</body>
</html>