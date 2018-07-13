<!-- 2018-07-08 김소희 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ page import = "service.MemberAddr" %>	<!-- service패키지 안에 MemberAddr클래스 import-->
<%@ page import = "service.MemberAddrDao" %>	<!-- service패키지 안에 MemberAddrDao클래스 import-->
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr"); %>
<jsp:useBean id="maddr" class="service.MemberAddr"/>  <!-- MemberAddrDao의 주소값을 변수 maddr에 대입 MemberAddrDao 객체 내부의 변수명이 같으면 set메서드에 값을 셋팅  -->
<jsp:setProperty name="maddr" property="*"/> <!-- maddr에 담겨있는 주소값을 따라가서 메소드 개수만큼 모두 호출  -->
<%

	MemberAddr addr = new MemberAddr();
	// MemberAddr type으로 addr 변수를 선언하고 new 생성자 메소드로 MemberAddr객체를 생성하여 객체 내 주소값을 addr변수에 할당한다
	addr.setMember_no(Integer.parseInt(request.getParameter("member_no")));
	// addr에 담겨있는 주소값을 따라가서 
	addr.setMember_addr_content(request.getParameter("member_addr_content"));
	
	MemberAddrDao maddrDao = new MemberAddrDao();
	// MemberAddrDao type으로 maddrDao 변수를 선언하고 new 생성자 메서드로 MemberAddrDao객체를 생성하여 객체 내 주소값을 maddrDao변수에 할당한다.
	maddrDao.insertMemberAddr(addr);
	// maddr에 담겨있는 주소값을 따라가서 insertMemberAddr메소드를 호출
	response.sendRedirect(request.getContextPath() + "/Member/memberList.jsp");
	// memberList.jsp로 이동 */

%>
