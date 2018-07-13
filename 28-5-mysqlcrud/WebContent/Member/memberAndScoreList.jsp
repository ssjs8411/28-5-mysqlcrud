<!-- 2018-07-09 김소희 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.MemberScoreDao" %>		<!-- service패키지 안에 MemberScoreDao클래스 import-->
<%@ page import = "service.MemberAndScore" %>		<!-- service패키지 안에 MemberAndScore클래스 import-->
<%@ page import = "java.util.ArrayList" %>			<!-- ArrayList는 java.util.ArrayList에 포함 import -->
<%@ page import = "service.Member" %>				<!-- service패키지 안에 Member클래스 import-->
<%@ page import = "service.MemberScore" %>			<!-- service패키지 안에 MemberScore클래스 import-->
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
	                <th>번호</th>
	                <th>이름</th>
	                <th>나이</th>
	                <th>점수번호</th>
	                <th>점수</th>
				<tr>
<%
	request.setCharacterEncoding("euc-kr");		//한글 안 깨지게
	
	MemberScoreDao msdao = new MemberScoreDao();
	//MemberScoreDao data type으로 msdao변수 생성하고  new생성자 메소드로  생성된  MemberScoreDao객체의 주소 값을 msdao변수에 할당한다
	ArrayList<MemberAndScore> list = msdao.selectMemberAndScore();
	//ArrayList<MemberAndScore> type으로 list 변수를 선언하고 selectMemberAndScore 메소드 호츨
	for(int i=0; i<list.size(); i++ ){		//반복문
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