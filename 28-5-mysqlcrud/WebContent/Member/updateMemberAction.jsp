<!-- 2018-07-02 ����� -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ page import = "service.Member" %>				<!-- service��Ű�� �ȿ� MemberŬ���� import-->
<%@ page import = "service.MemberDao" %>			<!-- service��Ű�� �ȿ� MemberDaoŬ���� import-->
<%@ page import = "service.MemberAddr" %>			<!-- service��Ű�� �ȿ� MemberAddrŬ���� import-->
<%@ page import = "service.MemberAddrDao" %>		<!-- service��Ű�� �ȿ� MemberAddrDaoŬ���� import-->
<!DOCTYPE html>
<%request.setCharacterEncoding("euc-kr"); %>  <!-- �ѱ� �������ʰ� -->
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<jsp:useBean id="m" class="service.Member"/>  <!-- Member�� �ּҰ��� ���� m�� ���� Member ��ü ������ �������� ������ set�޼��忡 ���� ����  -->
<jsp:setProperty name="m" property="*"/> <!-- m�� ����ִ� �ּҰ��� ���󰡼� �޼ҵ� ������ŭ ��� ȣ��  -->
<jsp:useBean id="maddr" class="service.MemberAddr"/>  <!-- Member�� �ּҰ��� ���� maddr�� ���� Member ��ü ������ �������� ������ set�޼��忡 ���� ����  -->
<jsp:setProperty name="maddr" property="*"/> <!-- maddr�� ����ִ� �ּҰ��� ���󰡼� �޼ҵ� ������ŭ ��� ȣ��  -->


<%
	int member_no = Integer.parseInt(request.getParameter("member_no"));		//����ȯ
	String member_name = request.getParameter("member_name");
	int member_age = Integer.parseInt(request.getParameter("member_age"));
	String member_addr_content = request.getParameter("member_addr_content");
	
	MemberAddrDao maddrdao = new MemberAddrDao();
	//MemberAddrDao data type���� maddrdao ���� �����ϰ�  new������ �޼ҵ��  ������  MemberAddrDao ��ü�� �ּ� ���� maddrdao ������ �Ҵ��Ѵ�
	maddrdao.updateMemberAddr(maddr);
	//maddr�� ����ִ� �ּ� ���� ���󰡼� updateMemberAddr �޼ҵ带 ȣ��
	MemberDao mdao = new MemberDao();
	//MemberDao data type���� mdao ���� �����ϰ�  new������ �޼ҵ��  ������  MemberDao ��ü�� �ּ� ���� mdao ������ �Ҵ��Ѵ�
	mdao.updateMember(m);
	//m�� ����ִ� �ּ� ���� ���󰡼� updateMember �޼ҵ带 ȣ��
	
	response.sendRedirect(request.getContextPath() + "/Member/MemberList.jsp");
	//MemberList.jsp�� �̵�
%>
