<!-- 2018-07-08 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ page import = "service.MemberDao" %>		<!-- service패키지 안에 MemberDao클래스 import-->
<%@ page import = "service.MemberAddrDao" %>	<!-- service패키지 안에 MemberAddrDao클래스 import-->
<!DOCTYPE html>
<%
	request.setCharacterEncoding("euc-kr");		//한글 깨지지않게

	int member_no = Integer.parseInt(request.getParameter("member_no")); //형변환
	
	MemberAddrDao maddrdao = new MemberAddrDao();
	//MemberAddrDao type으로 maddrdao 변수를 선언하고 new 생성자 메서드로 MemberAddrDao 객체를  생성하여 객체 내 주소값을 maddrdao변수에 할당한다.
	maddrdao.deleteMemberAddr(member_no);
	//member_no에 담겨있는 주소값을 따라가서 deleteMemberAddr메서드를 호출한다
	response.sendRedirect(request.getContextPath() + "/Member/MemberList.jsp");
	//MemberList.jsp로 이동
%>