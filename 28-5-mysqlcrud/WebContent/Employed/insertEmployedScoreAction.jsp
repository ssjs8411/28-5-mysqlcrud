<!-- 18.7.9 ������ -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.EmployedScoreDao" %>
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr"); %>	<!-- �ѱ� �޾ƿ��� -->
<jsp:useBean id="ec" class="service.EmployedScore"/> 	<!--  service��Ű���� EmployedScoreŬ������ �ּҰ��� ����ec�� ���� -->
<jsp:setProperty name="ec" property="*"/>		<!--  ���� ec�� ����ִ� EmployedScoreŬ������ �޼��带 ������ŭ ȣ���Ѵ� -->
<%
	EmployedScoreDao scdao = new EmployedScoreDao();
	int check = scdao.updateEmployedScore(ec);

	if(check == 0){
		scdao.insertEmployedScore(ec);
	}
	
	response.sendRedirect(request.getContextPath() + "/Employed/employedList.jsp");
%>