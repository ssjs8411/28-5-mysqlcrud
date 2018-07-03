<!-- 18.7.3 최지수 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.StudentAddrDao" %>
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr"); %>
<jsp:useBean id="saddr" class="service.StudentAddr"/> 	<!--  service패키지내 StudentAddr클래스의 주소값을 변수saddr에 대입 -->
<jsp:setProperty name="saddr" property="*"/>		<!--  변수 saddr에 담겨있는 StudentAddr클래스의 메서드를 갯수만큼 호출한다 -->
<%
	StudentAddrDao saddrdao = new StudentAddrDao();
	saddrdao.insertStudentAddr(saddr);
	
	response.sendRedirect(request.getContextPath() + "/Student/studentList.jsp");
%>