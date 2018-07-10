<!-- 2018-07-10 ����� -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ page import = "java.util.ArrayList" %>				<!-- ArrayList�� java.util.ArrayList�� ���� import -->
<%@ page import = "service.MemberScoreDao" %>			<!-- service��Ű�� �ȿ� MemberScoreDaoŬ���� import-->
<%@ page import = "service.MemberAndScore" %>			<!-- service��Ű�� �ȿ�MemberAndScoreŬ���� import-->
<%@ page import = "service.Member" %>					<!-- service��Ű�� �ȿ� MemberŬ���� import-->
<%@ page import = "service.MemberScore" %>				<!-- service��Ű�� �ȿ� MemberScoreŬ���� import-->
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>memberListAboveAvg</title>
</head>
<body>
	<h1>memberListAboveAvg</h1>
	<%

		MemberScoreDao msdao = new MemberScoreDao();
		//MemberScoreDao data type���� msdao ���� �����ϰ�  new������ �޼ҵ��  ������  MemberScoreDao ��ü�� �ּ� ���� msdao ������ �Ҵ��Ѵ�
		int scoreAvg = msdao.seletScoreAvg();
		//int type���� scoreAvg ���� �����ϰ� seletScotreAvg �޼ҵ� ȣ��

	%>
	<div>
		��� : <%=scoreAvg %>
	</div>
	<table border="1">
		<thead>
			<tr>
				<th>MEMBER_NO</th>
				<th>MEMBER_NAME</th>
				<th>MEMBER_SCORE</th>
			</tr>
		</thead>
		<tbody>
	<%
				ArrayList<MemberAndScore> als = new ArrayList<MemberAndScore>();
				//ArrayList<MemberAndScore> data type���� als ���� �����ϰ�  new������ �޼ҵ��  ������  ArrayList<MemberAndScore> ��ü�� �ּ� ���� als ������ �Ҵ��Ѵ�
				for(int i=0; i<als.size(); i++){
				
				MemberAndScore mas = als.get(i);
				Member m = mas.getMember();
				MemberScore ms = mas.getMemberScore();

	%>
			
				
				<tr>
					<td><%=m.getMember_no() %></td>
					<td><%=m.getMember_name()%></td>
					<td><%=ms.getScore() %></td>
				</tr>
	<%		
		}
	%>
		</tbody>
	</table>
</body>
</html>