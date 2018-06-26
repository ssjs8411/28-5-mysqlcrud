<!-- 18.6.26 최지수 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.EmployedDao"%>			<!-- service패키지내에 EmployedDao클래스 import -->
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr"); %>		<!-- 한글 받아오기 -->
<jsp:useBean id="emp" class="service.Employed"/> 	<!--  service패키지내 Employed클래스의 주소값을 변수 emp에 대입 -->
<jsp:setProperty name="emp" property="*"/>			<!--  변수 emp에 담겨있는 Employed클래스의 메서드를 갯수만큼 호출한다 -->
<%
EmployedDao edao = new EmployedDao();			// EmployedDao type으로 edao변수를 선언하고 new생성자메서드로 EmployedDao객체 내 주소값을 변수에 대입
	edao.insertEmployed(emp);					// edao 담겨있는 주소값을 따라가서 insertEmployed메서드 호출
%>