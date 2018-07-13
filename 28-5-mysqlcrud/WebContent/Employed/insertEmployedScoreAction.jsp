<!-- 18.7.9 최지수 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.EmployedScoreDao" %>
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr"); %>	<!-- 한글 받아오기 -->
<jsp:useBean id="ec" class="service.EmployedScore"/> 	<!--  service패키지내 EmployedScore클래스의 주소값을 변수ec에 대입 -->
<jsp:setProperty name="ec" property="*"/>		<!--  변수 ec에 담겨있는 EmployedScore클래스의 메서드를 갯수만큼 호출한다 -->
<%
	EmployedScoreDao scdao = new EmployedScoreDao();
	int check = scdao.updateEmployedScore(ec);

	if(check == 0){
		scdao.insertEmployedScore(ec);
	}
	
	response.sendRedirect(request.getContextPath() + "/Employed/employedList.jsp");
%>