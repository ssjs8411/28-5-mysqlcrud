<!-- 2018-07-08 ����� -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ page import = "service.MemberDao" %>			<!-- service��Ű�� �ȿ� MemberDaoŬ���� import-->
<%@ page import = "service.Member" %>				<!-- service��Ű�� �ȿ� MemberŬ���� import-->
<%@ page import = "service.MemberAddr" %>			<!-- service��Ű�� �ȿ� MemberAddrŬ���� import-->
<%@ page import = "service.MemberAddrDao" %>		<!-- service��Ű�� �ȿ� MemberAddrDaoŬ���� import-->
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>updateMemberForm</title>
	</head>
	<body>
<%
	request.setCharacterEncoding("euc-kr");			//�ѱ� �� ������
	
	int member_no = Integer.parseInt(request.getParameter("member_no"));		//����ȯ

	MemberDao mdao = new MemberDao();
	//MemberDao data type���� mdao ���� �����ϰ�  new������ �޼ҵ��  ������  MemberDao ��ü�� �ּ� ���� mdao ������ �Ҵ��Ѵ�
	Member m = mdao.mSelectUpdate(member_no);
	//member_no�� ����ִ� �ּ� ���� ���󰡼� mSelectUpdate �޼ҵ带 ȣ���Ѵ�
	MemberAddrDao maddrdao = new MemberAddrDao();
	//MemberAddrDao data type���� maddrdao ���� �����ϰ�  new������ �޼ҵ��  ������  MemberAddrDao ��ü�� �ּ� ���� maddrdao ������ �Ҵ��Ѵ�
	MemberAddr maddr = maddrdao.mSelectUpdateAddr(member_no);
	//member_no�� ����ִ� �ּ� ���� ���󰡼� mSelectUpdateAddr �޼ҵ带 ȣ���Ѵ�
	

%>	
		<h1>����</h1>
		<form action="<%=request.getContextPath() %>/Member/updateMemberAction.jsp" method="post">
			<input type="hidden" name="member_no" value="<%=m.getMember_no()%>">
			�̸� : <input type="text" name="member_name" value="<%=m.getMember_name()%>">	<br>
			���� : <input type="text" name="member_age" value="<%=m.getMember_age()%>">	<br>
			�ּ� : <input type="text" name="member_addr_content" value="<%=maddr.getMember_addr_content()%>">	<br>
			<button type="submit">����</button>
		</form>
	</body>
</html>
