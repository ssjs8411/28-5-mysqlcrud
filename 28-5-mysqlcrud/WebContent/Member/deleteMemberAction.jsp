<!-- 2018-07-08 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ page import = "service.MemberDao" %>		<!-- service��Ű�� �ȿ� MemberDaoŬ���� import-->
<%@ page import = "service.MemberAddrDao" %>	<!-- service��Ű�� �ȿ� MemberAddrDaoŬ���� import-->
<%@ page import = "service.MemberScoreDao" %>	<!-- service��Ű�� �ȿ� MemberScoreDaoŬ���� import-->
<!DOCTYPE html>
<%
	request.setCharacterEncoding("euc-kr");		//�ѱ� �������ʰ�

	int member_no = Integer.parseInt(request.getParameter("member_no")); //����ȯ
	
	MemberDao mdao = new MemberDao();					// MemberDao type���� mdao������ �����ϰ� new������ �޼ҵ�� MemberDao��ü�� �����Ͽ� ��ü �� �ּҸ�  mdao������ �Ҵ��Ѵ� 
	MemberAddrDao maddrdao = new MemberAddrDao();		// MemberAddrDao type���� maddrdao������ �����ϰ� new������ �޼ҵ�� MemberAddrDao��ü��  �����Ͽ� ��ü �� �ּҰ��� maddrdao������ �Ҵ��Ѵ�. 
	MemberScoreDao msdao = new MemberScoreDao();		// MemberScoreDao type���� msdao ������ �����ϰ� new������ �޼ҵ��  MemberScoreDao��ü�� �����Ͽ� ��ü �� �ּҰ���  msdao������ �Ҵ��Ѵ�
	
	mdao.deleteMember(member_no);						// member_no�� ����ִ� �ּҰ��� ���󰡼� deleteMember�޼ҵ带 ȣ���Ѵ�
	maddrdao.deleteMemberAddr(member_no);				// member_no�� ����ִ� �ּҰ��� ���󰡼� deleteMemberAddr�޼ҵ带 ȣ���Ѵ�
	msdao.deleteMemberScore(member_no);					// member_no�� ����ִ� �ּҰ��� ���󰡼� deleteMemberScore�޼ҵ带 ȣ���Ѵ�
	
	
	response.sendRedirect(request.getContextPath() + "/Member/MemberList.jsp");		//MemberList.jsp�� �̵�
%>