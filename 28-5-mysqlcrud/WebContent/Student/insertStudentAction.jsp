<!-- 18.6.25 최지수 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.StudentDao"%>		<!-- service패키지내에 StudentDao클래스 import -->
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr"); %>	<!-- 한글 받아오기 -->
<jsp:useBean id="s" class="service.Student"/> 	<!--  service패키지내 Student클래스의 주소값을 변수s에 대입 -->
<jsp:setProperty name="s" property="*"/>		<!--  변수 s에 담겨있는 Student클래스의 메서드를 갯수만큼 호출한다 -->
<%
	StudentDao sdao = new StudentDao();			// StudentDao type으로 sdao변수를 선언하고 new생성자메서드로 StudentDao객체 내 주소값을 변수에 대입
	sdao.insertStudent(s);						// sdao 담겨있는 주소값을 따라가서 insertStudent메서드 호출
%>