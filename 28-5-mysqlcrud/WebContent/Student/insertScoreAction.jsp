<!-- 18.7.9 ������ -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.StudentScoreDao" %>
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr"); %>	<!-- �ѱ� �޾ƿ��� -->
<jsp:useBean id="sc" class="service.StudentScore"/> 	<!--  service��Ű���� StudentScoreŬ������ �ּҰ��� ����sc�� ���� -->
<jsp:setProperty name="sc" property="*"/>		<!--  ���� sc�� ����ִ� StudentScoreŬ������ �޼��带 ������ŭ ȣ���Ѵ� -->
<%
	StudentScoreDao scdao = new StudentScoreDao();
	int check = scdao.updateStudentScore(sc);

	if(check == 0){
		scdao.insertStudentScore(sc);
	}
	
	response.sendRedirect(request.getContextPath() + "/Student/studentList.jsp");
%>