<!-- 2018-07-09 ����� -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.MemberScoreDao" %>		<!-- service��Ű�� �ȿ� MemberScoreDaoŬ���� import-->
<%@ page import = "service.MemberAndScore" %>		<!-- service��Ű�� �ȿ� MemberAndScoreŬ���� import-->
<%@ page import = "java.util.ArrayList" %>			<!-- ArrayList�� java.util.ArrayList�� ���� import -->
<%@ page import = "service.Member" %>				<!-- service��Ű�� �ȿ� MemberŬ���� import-->
<%@ page import = "service.MemberScore" %>			<!-- service��Ű�� �ȿ� MemberScoreŬ���� import-->
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>membeAndScoreList</title>
	<style>
		table, th, td{
			border : 1px solid;
		}
	</style>
	</head>
	<body>
			<table>
	            <tr>
	                <th>��ȣ</th>
	                <th>�̸�</th>
	                <th>����</th>
	                <th>������ȣ</th>
	                <th>����</th>
				<tr>
<%
	request.setCharacterEncoding("euc-kr");		//�ѱ� �� ������
	
	MemberScoreDao msdao = new MemberScoreDao();
	//MemberScoreDao data type���� msdao���� �����ϰ�  new������ �޼ҵ��  ������  MemberScoreDao��ü�� �ּ� ���� msdao������ �Ҵ��Ѵ�
	ArrayList<MemberAndScore> list = msdao.selectMemberAndScore();
	//ArrayList<MemberAndScore> type���� list ������ �����ϰ� selectMemberAndScore �޼ҵ� ȣ��
	for(int i=0; i<list.size(); i++ ){		//�ݺ���
		MemberAndScore mas = list.get(i);
		Member m = mas.getMember();
		MemberScore ms = mas.getMemberScore();
%>
				<tr>
					<td><%=m.getMember_no() %></td>
					<td><%=m.getMember_name() %></td>
					<td><%=m.getMember_age() %></td>
					<td><%=ms.getMember_score_no() %></td>
					<td><%=ms.getScore() %></td>
				</tr>
<% 		
	}
%>
			</table>
		<a href="<%= request.getContextPath()%>/Member/memberList.jsp">memberList</a>
	</body>
</html>