<!-- 28�� ����� -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.MemberDao" %>	<!-- service��Ű�� �ȿ� MemberDaoŬ���� import-->
<!DOCTYPE html>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<%request.setCharacterEncoding("euc-kr"); %>  <!-- �ѱ� �������ʰ� -->
<jsp:useBean id="m" class="service.Member"/>  <!-- Member�� �ּҰ��� ���� m�� ���� Member ��ü ������ �������� ������ set�޼��忡 ���� ����  -->
<jsp:setProperty name="m" property="*"/> <!-- m�� ����ִ� �ּҰ��� ���󰡼� �޼ҵ� ������ŭ ��� ȣ��  -->
<%
	MemberDao mdao = new MemberDao();
	//MemberDao type���� mdao ������ �����ϰ� new ������ �޼���� MemberDao��ü��  �����Ͽ� ��ü �� �ּҰ��� mdao������ �Ҵ��Ѵ�.
	mdao.insertMember(m);
	//m�� ����ִ� �ּҰ��� ���󰡼� insertMember�޼ҵ带 ȣ��
	response.sendRedirect(request.getContextPath() + "/Member/memberList.jsp");
	//MemberList.jsp�� �̵�
%>
