<!-- 2018-07-08 ����� -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ page import = "service.MemberAddrDao" %>	<!-- service��Ű�� �ȿ� MemberAddrDaoŬ���� import-->
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr"); %>
<jsp:useBean id="maddr" class="service.MemberAddr"/>  <!-- MemberAddrDao�� �ּҰ��� ���� maddr�� ���� MemberAddrDao ��ü ������ �������� ������ set�޼��忡 ���� ����  -->
<jsp:setProperty name="maddr" property="*"/> <!-- maddr�� ����ִ� �ּҰ��� ���󰡼� �޼ҵ� ������ŭ ��� ȣ��  -->
<%
	MemberAddrDao maddrDao = new MemberAddrDao();
	//MemberAddrDao type���� maddrDao ������ �����ϰ� new ������ �޼���� MemberAddrDao��ü�� �����Ͽ� ��ü �� �ּҰ��� maddrDao������ �Ҵ��Ѵ�.
	maddrDao.insertMemberAddr(maddr);
	//maddr�� ����ִ� �ּҰ��� ���󰡼� insertMemberAddr�޼ҵ带 ȣ��
	response.sendRedirect(request.getContextPath() + "/Member/MemberList.jsp");
	//MemberList.jsp�� �̵�
%>
