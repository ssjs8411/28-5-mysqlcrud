<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.TeacherAddrDao" %>
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr"); %>
<jsp:useBean id="taddr" class="service.TeacherAddr"/> 	
<jsp:setProperty name="taddr" property="*"/>		
<%
	TeacherAddrDao taddrdao = new TeacherAddrDao();
	taddrdao.insertTeacherAddr(taddr);
	
	response.sendRedirect(request.getContextPath() + "/Teacher/teacherList.jsp");
%>