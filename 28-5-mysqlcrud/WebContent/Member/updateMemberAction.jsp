<!-- 2018-07-02 김소희 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ page import = "service.Member" %>
<%@ page import = "service.MemberDao" %>
<%@ page import = "service.MemberAddr" %>
<%@ page import = "service.MemberAddrDao" %>
<!DOCTYPE html>
<%request.setCharacterEncoding("euc-kr"); %>  <!-- 한글 깨지지않게 -->
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<jsp:useBean id="m" class="service.Member"/>  <!-- Member의 주소값을 변수 m에 대입 Member 객체 내부의 변수명이 같으면 set메서드에 값을 셋팅  -->
<jsp:setProperty name="m" property="*"/> <!-- m에 담겨있는 주소값을 따라가서 메소드 개수만큼 모두 호출  -->
<jsp:useBean id="maddr" class="service.MemberAddr"/>  <!-- Member의 주소값을 변수 maddr에 대입 Member 객체 내부의 변수명이 같으면 set메서드에 값을 셋팅  -->
<jsp:setProperty name="maddr" property="*"/> <!-- maddr에 담겨있는 주소값을 따라가서 메소드 개수만큼 모두 호출  -->


<%
	int member_no = Integer.parseInt(request.getParameter("member_no"));
	String member_name = request.getParameter("member_name");
	int member_age = Integer.parseInt(request.getParameter("member_age"));
	String member_addr_content = request.getParameter("member_addr_content");
	
	MemberAddrDao maddrdao = new MemberAddrDao();
	maddrdao.updateMemberAddr(maddr);
	
	MemberDao mdao = new MemberDao();
	mdao.updateMember(m);
	
	response.sendRedirect(request.getContextPath() + "/Member/MemberList.jsp");
%>
