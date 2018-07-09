<!-- 18.7.9 최지수 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.StudentScoreDao" %>
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr"); %>	<!-- 한글 받아오기 -->
<jsp:useBean id="sc" class="service.StudentScore"/> 	<!--  service패키지내 StudentScore클래스의 주소값을 변수sc에 대입 -->
<jsp:setProperty name="sc" property="*"/>		<!--  변수 sc에 담겨있는 StudentScore클래스의 메서드를 갯수만큼 호출한다 -->
<%
	StudentScoreDao scdao = new StudentScoreDao();
	int check = scdao.updateStudentScore(sc);

	if(check == 0){
		scdao.insertStudentScore(sc);
	}
	
	response.sendRedirect(request.getContextPath() + "/Student/studentList.jsp");
%>