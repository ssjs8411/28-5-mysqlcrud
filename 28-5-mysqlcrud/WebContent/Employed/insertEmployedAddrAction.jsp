<!-- 18.7.4 최지수 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.EmployedAddrDao" %>
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr"); %>
<jsp:useBean id="eaddr" class="service.EmployedAddr"/> 	<!--  service패키지내 EmployedAddr클래스의 주소값을 변수eaddr에 대입 -->
<jsp:setProperty name="eaddr" property="*"/>		<!--  변수 eaddr에 담겨있는 EmployedAddr클래스의 메서드를 갯수만큼 호출한다 -->
<%
	EmployedAddrDao eaddrdao = new EmployedAddrDao();
	eaddrdao.insertEmployedAddr(eaddr);
	
	response.sendRedirect(request.getContextPath() + "/Employed/employedList.jsp");
%>