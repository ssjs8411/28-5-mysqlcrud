<!-- 2018-07-02 ����� -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ page import = "service.MemberDao" %>
<%@ page import = "service.MemberAddrDao" %>
<%@ page import = "service.Member" %>
<%@ page import = "service.MemberAddr" %>
<!DOCTYPE html>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<jsp:useBean id="m" class="service.Member"/>  <!-- Member�� �ּҰ��� ���� m�� ���� Member ��ü ������ �������� ������ set�޼��忡 ���� ����  -->
<jsp:setProperty name="m" property="*"/> <!-- m�� ����ִ� �ּҰ��� ���󰡼� �޼ҵ� ������ŭ ��� ȣ��  -->
<jsp:useBean id="maddr" class="service.MemberAddr"/>  <!-- Member�� �ּҰ��� ���� maddr�� ���� Member ��ü ������ �������� ������ set�޼��忡 ���� ����  -->
<jsp:setProperty name="maddr" property="*"/> <!-- maddr�� ����ִ� �ּҰ��� ���󰡼� �޼ҵ� ������ŭ ��� ȣ��  -->

<%request.setCharacterEncoding("euc-kr"); %>  <!-- �ѱ� �������ʰ� -->

<%
	int member_no = Integer.parseInt(request.getParameter("member_no"));
	String member_name = request.getParameter("member_name");
	int member_age = Integer.parseInt(request.getParameter("member_age"));
	String member_addr_content = request.getParameter("member_addr_content");
	
	MemberAddrDao maddrdao = new MemberAddrDao();
	maddrdao.updateMemberAddr(maddr);
	
	MemberDao dao = new MemberDao();
	dao.updateMember(m);
	
	response.sendRedirect(request.getContextPath() + "/Member/MemberList.jsp");
%>