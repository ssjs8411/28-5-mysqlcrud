<!-- 28�� ����� -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.MemberDao" %>
<!DOCTYPE html>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<jsp:useBean id="m" class="service.Member"/>  <!-- Member�� �ּҰ��� ���� m�� ���� Member ��ü ������ �������� ������ set�޼��忡 ���� ����  -->
<jsp:setProperty name="m" property="*"/> <!-- m�� ����ִ� �ּҰ��� ���󰡼� �޼ҵ� ������ŭ ��� ȣ��  -->
<%request.setCharacterEncoding("euc-kr"); %>  <!-- �ѱ� �������ʰ� -->
<%
	MemberDao mdao = new MemberDao(); //mdao ��ü ����
	mdao.insertMember(m);	//m�� ����ִ� �ּҰ��� ���󰡼� insertMember�޼ҵ带 ȣ�����ּ���
%>
