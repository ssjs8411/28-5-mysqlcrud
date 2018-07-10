<!-- 2018-07-08 김소희 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ page import = "service.MemberDao" %>			<!-- service패키지 안에 MemberDao클래스 import-->
<%@ page import = "service.Member" %>				<!-- service패키지 안에 Member클래스 import-->
<%@ page import = "service.MemberAddr" %>			<!-- service패키지 안에 MemberAddr클래스 import-->
<%@ page import = "service.MemberAddrDao" %>		<!-- service패키지 안에 MemberAddrDao클래스 import-->
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>updateMemberForm</title>
	</head>
	<body>
<%
	request.setCharacterEncoding("euc-kr");			//한글 안 깨지게
	
	int member_no = Integer.parseInt(request.getParameter("member_no"));		//형변환

	MemberDao mdao = new MemberDao();
	//MemberDao data type으로 mdao 변수 생성하고  new생성자 메소드로  생성된  MemberDao 객체의 주소 값을 mdao 변수에 할당한다
	Member m = mdao.mSelectUpdate(member_no);
	//member_no에 담겨있는 주소 값을 따라가서 mSelectUpdate 메소드를 호출한다
	MemberAddrDao maddrdao = new MemberAddrDao();
	//MemberAddrDao data type으로 maddrdao 변수 생성하고  new생성자 메소드로  생성된  MemberAddrDao 객체의 주소 값을 maddrdao 변수에 할당한다
	MemberAddr maddr = maddrdao.mSelectUpdateAddr(member_no);
	//member_no에 담겨있는 주소 값을 따라가서 mSelectUpdateAddr 메소드를 호출한다
	

%>	
		<h1>수정</h1>
		<form action="<%=request.getContextPath() %>/Member/updateMemberAction.jsp" method="post">
			<input type="hidden" name="member_no" value="<%=m.getMember_no()%>">
			이름 : <input type="text" name="member_name" value="<%=m.getMember_name()%>">	<br>
			나이 : <input type="text" name="member_age" value="<%=m.getMember_age()%>">	<br>
			주소 : <input type="text" name="member_addr_content" value="<%=maddr.getMember_addr_content()%>">	<br>
			<button type="submit">수정</button>
		</form>
	</body>
</html>
