<!-- 2018-07-08 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ page import = "service.MemberAddrDao" %>
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr"); %>
<jsp:useBean id="maddr" class="service.MemberAddr"/>  <!-- MemberAddrDao의 주소값을 변수 maddr에 대입 MemberAddrDao 객체 내부의 변수명이 같으면 set메서드에 값을 셋팅  -->
<jsp:setProperty name="maddr" property="*"/> <!-- maddr에 담겨있는 주소값을 따라가서 메소드 개수만큼 모두 호출  -->
<%
MemberAddrDao maddrDao = new MemberAddrDao();
maddrDao.insertMemberAddr(maddr);

response.sendRedirect(request.getContextPath() + "/Member/MemberList.jsp");
%>
