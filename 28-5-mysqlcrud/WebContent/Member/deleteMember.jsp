<!-- 2018-07-08 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ page import = "service.MemberDao" %>		<!-- service��Ű�� �ȿ� MemberDaoŬ���� import-->
<%@ page import = "service.MemberAddrDao" %>	<!-- service��Ű�� �ȿ� MemberAddrDaoŬ���� import-->
<!DOCTYPE html>
<%
	request.setCharacterEncoding("euc-kr");		//�ѱ� �������ʰ�

	int member_no = Integer.parseInt(request.getParameter("member_no")); //����ȯ
	
	MemberAddrDao maddrdao = new MemberAddrDao();
	//MemberAddrDao type���� maddrdao ������ �����ϰ� new ������ �޼���� MemberAddrDao ��ü��  �����Ͽ� ��ü �� �ּҰ��� maddrdao������ �Ҵ��Ѵ�.
	maddrdao.deleteMemberAddr(member_no);
	//member_no�� ����ִ� �ּҰ��� ���󰡼� deleteMemberAddr�޼��带 ȣ���Ѵ�
	response.sendRedirect(request.getContextPath() + "/Member/MemberList.jsp");
	//MemberList.jsp�� �̵�
%>