<!-- 18.7.3 ������ -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.StudentAddrDao" %>
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr"); %>
<jsp:useBean id="saddr" class="service.StudentAddr"/> 	<!--  service��Ű���� StudentAddrŬ������ �ּҰ��� ����saddr�� ���� -->
<jsp:setProperty name="saddr" property="*"/>		<!--  ���� saddr�� ����ִ� StudentAddrŬ������ �޼��带 ������ŭ ȣ���Ѵ� -->
<%
	StudentAddrDao saddrdao = new StudentAddrDao();
	saddrdao.insertStudentAddr(saddr);
	
	response.sendRedirect(request.getContextPath() + "/Student/studentList.jsp");
%>