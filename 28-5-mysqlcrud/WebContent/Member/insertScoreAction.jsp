<!-- 2018-07-08 ����� -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.MemberScoreDao" %>
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr"); %>	<!-- �ѱ� �� ������ -->
<jsp:useBean id="ms" class="service.MemberScore"/> 	<!-- MemberScore�� �ּҰ��� ���� ms�� ���� MemberScore ��ü ������ �������� ������ set�޼��忡 ���� ����  -->
<jsp:setProperty name="ms" property="*"/>		 <!-- ms�� ����ִ� �ּҰ��� ���󰡼� �޼ҵ� ������ŭ ��� ȣ��  -->
<%

MemberScoreDao msdao = new MemberScoreDao();
int check = msdao.updateMemberScore(ms);

if(check == 0 ){
	msdao.insertMemberScore(ms);
}

response.sendRedirect(request.getContextPath() + "/Member/MemberList.jsp");

%>