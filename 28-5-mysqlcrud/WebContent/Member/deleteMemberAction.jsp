<!-- 2018-07-08 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ page import = "service.MemberDao" %>		<!-- service패키지 안에 MemberDao클래스 import-->
<%@ page import = "service.MemberAddrDao" %>	<!-- service패키지 안에 MemberAddrDao클래스 import-->
<%@ page import = "service.MemberScoreDao" %>	<!-- service패키지 안에 MemberScoreDao클래스 import-->
<!DOCTYPE html>
<%
	request.setCharacterEncoding("euc-kr");		//한글 깨지지않게

	int member_no = Integer.parseInt(request.getParameter("member_no")); //형변환
	
	MemberDao mdao = new MemberDao();					// MemberDao type으로 mdao변수를 선언하고 new생성자 메소드로 MemberDao객체를 생성하여 객체 내 주소를  mdao변수에 할당한다 
	MemberAddrDao maddrdao = new MemberAddrDao();		// MemberAddrDao type으로 maddrdao변수를 선언하고 new생성자 메소드로 MemberAddrDao객체를  생성하여 객체 내 주소값을 maddrdao변수에 할당한다. 
	MemberScoreDao msdao = new MemberScoreDao();		// MemberScoreDao type으로 msdao 변수를 선언하고 new생성자 메소드로  MemberScoreDao객체를 생성하여 객체 내 주소값을  msdao변수에 할당한다
	
	mdao.deleteMember(member_no);						// member_no에 담겨있는 주소값을 따라가서 deleteMember메소드를 호출한다
	maddrdao.deleteMemberAddr(member_no);				// member_no에 담겨있는 주소값을 따라가서 deleteMemberAddr메소드를 호출한다
	msdao.deleteMemberScore(member_no);					// member_no에 담겨있는 주소값을 따라가서 deleteMemberScore메소드를 호출한다
	
	
	response.sendRedirect(request.getContextPath() + "/Member/MemberList.jsp");		//MemberList.jsp로 이동
%>