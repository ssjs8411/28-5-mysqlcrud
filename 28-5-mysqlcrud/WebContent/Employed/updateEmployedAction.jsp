<!-- 18.7.4 ������ -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.EmployedDao" %>
<%@ page import = "service.EmployedAddrDao" %>
<%@ page import = "service.Employed" %>
<%@ page import = "service.EmployedAddr" %>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("euc-kr");
%>
<jsp:useBean id="e" class="service.Employed"/> 	<!--  service��Ű���� EmployedŬ������ �ּҰ��� ����e�� ���� -->
<jsp:setProperty name="e" property="*"/>		<!--  ���� e�� ����ִ� EmployedŬ������ �޼��带 ������ŭ ȣ���Ѵ� -->
<jsp:useBean id="eaddr" class="service.EmployedAddr"/> 	<!--  service��Ű���� EmployedAddrŬ������ �ּҰ��� ����eaddr�� ���� -->
<jsp:setProperty name="eaddr" property="*"/>		<!--  ���� eaddr�� ����ִ� EmployedAddrŬ������ �޼��带 ������ŭ ȣ���Ѵ� -->
<%
	int employed_no = Integer.parseInt(request.getParameter("employed_no"));
	String employed_name = request.getParameter("employed_name");
	int employed_age = Integer.parseInt(request.getParameter("employed_age"));
	String employed_addr_content = request.getParameter("employed_addr_content");
	
	EmployedAddrDao eaddrdao = new EmployedAddrDao();
	eaddrdao.updateEmployedAddr(eaddr);

	EmployedDao edao = new EmployedDao();
	edao.updateEmployed(e);
	
	response.sendRedirect(request.getContextPath() + "/Employed/employedList.jsp");
%>
