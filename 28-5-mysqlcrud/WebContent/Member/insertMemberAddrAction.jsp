<!-- 2018-07-08 ����� -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ page import = "service.MemberAddr" %>	<!-- service��Ű�� �ȿ� MemberAddrŬ���� import-->
<%@ page import = "service.MemberAddrDao" %>	<!-- service��Ű�� �ȿ� MemberAddrDaoŬ���� import-->
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr"); %>
<jsp:useBean id="maddr" class="service.MemberAddr"/>  <!-- MemberAddrDao�� �ּҰ��� ���� maddr�� ���� MemberAddrDao ��ü ������ �������� ������ set�޼��忡 ���� ����  -->
<jsp:setProperty name="maddr" property="*"/> <!-- maddr�� ����ִ� �ּҰ��� ���󰡼� �޼ҵ� ������ŭ ��� ȣ��  -->
<%

	MemberAddr addr = new MemberAddr();
	// MemberAddr type���� addr ������ �����ϰ� new ������ �޼ҵ�� MemberAddr��ü�� �����Ͽ� ��ü �� �ּҰ��� addr������ �Ҵ��Ѵ�
	addr.setMember_no(Integer.parseInt(request.getParameter("member_no")));
	// addr�� ����ִ� �ּҰ��� ���󰡼� 
	addr.setMember_addr_content(request.getParameter("member_addr_content"));
	
	MemberAddrDao maddrDao = new MemberAddrDao();
	// MemberAddrDao type���� maddrDao ������ �����ϰ� new ������ �޼���� MemberAddrDao��ü�� �����Ͽ� ��ü �� �ּҰ��� maddrDao������ �Ҵ��Ѵ�.
	maddrDao.insertMemberAddr(addr);
	// maddr�� ����ִ� �ּҰ��� ���󰡼� insertMemberAddr�޼ҵ带 ȣ��
	response.sendRedirect(request.getContextPath() + "/Member/memberList.jsp");
	// memberList.jsp�� �̵� */

%>
