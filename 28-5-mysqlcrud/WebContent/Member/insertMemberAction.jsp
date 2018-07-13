<!-- 28기 김소희 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.MemberDao" %>	<!-- service패키지 안에 MemberDao클래스 import-->
<!DOCTYPE html>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<%request.setCharacterEncoding("euc-kr"); %>  <!-- 한글 깨지지않게 -->
<jsp:useBean id="m" class="service.Member"/>  <!-- Member의 주소값을 변수 m에 대입 Member 객체 내부의 변수명이 같으면 set메서드에 값을 셋팅  -->
<jsp:setProperty name="m" property="*"/> <!-- m에 담겨있는 주소값을 따라가서 메소드 개수만큼 모두 호출  -->
<%
	MemberDao mdao = new MemberDao();
	//MemberDao type으로 mdao 변수를 선언하고 new 생성자 메서드로 MemberDao객체를  생성하여 객체 내 주소값을 mdao변수에 할당한다.
	mdao.insertMember(m);
	//m에 담겨있는 주소값을 따라가서 insertMember메소드를 호출
	response.sendRedirect(request.getContextPath() + "/Member/memberList.jsp");
	//MemberList.jsp로 이동
%>
