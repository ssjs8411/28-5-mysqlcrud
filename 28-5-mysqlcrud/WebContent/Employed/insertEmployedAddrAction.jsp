<!-- 18.7.4 ������ -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.EmployedAddrDao" %>
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr"); %>
<jsp:useBean id="eaddr" class="service.EmployedAddr"/> 	<!--  service��Ű���� EmployedAddrŬ������ �ּҰ��� ����eaddr�� ���� -->
<jsp:setProperty name="eaddr" property="*"/>		<!--  ���� eaddr�� ����ִ� EmployedAddrŬ������ �޼��带 ������ŭ ȣ���Ѵ� -->
<%
	EmployedAddrDao eaddrdao = new EmployedAddrDao();
	eaddrdao.insertEmployedAddr(eaddr);
	
	response.sendRedirect(request.getContextPath() + "/Employed/employedList.jsp");
%>