<!-- 2018-07-09 김소희 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.MemberScoreDao" %>
<%@ page import = "service.MemberAndScore" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Member" %>
<%@ page import = "service.MemberScore" %>

<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
</head>
<body>
		<table border="1">
            <tr>
                <td>번호</td>
                <td>이름</td>
                <td>나이</td>
                <td>점수number</td>
                <td>점수</td>
<%
	request.setCharacterEncoding("euc-kr");
	
	MemberScoreDao msdao = new MemberScoreDao();
	ArrayList<MemberAndScore> list = msdao.selectMemberAndScore();
	
	for(int i=0; i<list.size(); i++ ){
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
</body>
</html>