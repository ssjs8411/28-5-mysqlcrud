<!-- 2018-07-02 김소희 -->
<!-- 2018-07-08 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ page import = "service.Member" %>
<%@ page import = "service.MemberAddr" %>
<%@ page import = "service.MemberDao" %>
<%@ page import = "service.MemberAddrDao" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>updateMemberForm</title>
	</head>
	<body>
<%
	request.setCharacterEncoding("euc-kr");
	
	int member_no = Integer.parseInt(request.getParameter("member_no"));

	MemberDao mdao = new MemberDao();
	Member m = mdao.mSelectUpdate(member_no);

	MemberAddrDao maddrdao = new MemberAddrDao();
	MemberAddr maddr = maddrdao.mSelectUpdateAddr(member_no);
	
	

%>
		<form action="<%=request.getContextPath() %>/Member/updateMemberAction.jsp" method="post">
			<input type="hidden" name="member_no" value="<%=m.getMember_no()%>">
			이름 : <input type="text" name="member_name" value="<%=m.getMember_name()%>">	<br>
			나이 : <input type="text" name="member_age" value="<%=m.getMember_age()%>">	<br>
			주소 : <input type="text" name="member_addr_content" value="<%=maddr.getMember_addr_content()%>">	<br>
			<button type="submit">수정</button>
		</form>
	</body>
</html>
