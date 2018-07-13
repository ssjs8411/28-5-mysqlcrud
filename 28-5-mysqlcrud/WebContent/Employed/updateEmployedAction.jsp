<!-- 18.7.4 최지수 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.EmployedDao" %>
<%@ page import = "service.EmployedAddrDao" %>
<%@ page import = "service.Employed" %>
<%@ page import = "service.EmployedAddr" %>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("euc-kr");
%>
<jsp:useBean id="e" class="service.Employed"/> 	<!--  service패키지내 Employed클래스의 주소값을 변수e에 대입 -->
<jsp:setProperty name="e" property="*"/>		<!--  변수 e에 담겨있는 Employed클래스의 메서드를 갯수만큼 호출한다 -->
<jsp:useBean id="eaddr" class="service.EmployedAddr"/> 	<!--  service패키지내 EmployedAddr클래스의 주소값을 변수eaddr에 대입 -->
<jsp:setProperty name="eaddr" property="*"/>		<!--  변수 eaddr에 담겨있는 EmployedAddr클래스의 메서드를 갯수만큼 호출한다 -->
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
