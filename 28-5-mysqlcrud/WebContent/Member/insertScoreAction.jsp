<!-- 2018-07-08 ����� -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.MemberScoreDao" %>	<!-- service��Ű�� �ȿ� MemberScoreDaoŬ���� import-->
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr"); %>	<!-- �ѱ� �� ������ -->
<jsp:useBean id="ms" class="service.MemberScore"/> 	<!-- MemberScore�� �ּҰ��� ���� ms�� ���� MemberScore ��ü ������ �������� ������ set�޼��忡 ���� ����  -->
<jsp:setProperty name="ms" property="*"/>		 <!-- ms�� ����ִ� �ּҰ��� ���󰡼� �޼ҵ� ������ŭ ��� ȣ��  -->
<%

	MemberScoreDao msdao = new MemberScoreDao();
	//MemberScoreDao data type���� msdao���� �����ϰ�  new������ �޼ҵ��  ������  MemberScoreDao��ü�� �ּ� ���� msdao������ �Ҵ��Ѵ�
	int check = msdao.updateMemberScore(ms);
	//ms�� ����ִ� �ּ� ���� ���󰡼� updateMemberScore �޼ҵ� ȣ��
	if(check == 0 ){
		msdao.insertMemberScore(ms);
	}
	
	response.sendRedirect(request.getContextPath() + "/Member/memberList.jsp");
	//MemberList.jsp�� �̵�

%>