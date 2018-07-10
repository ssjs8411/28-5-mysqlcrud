<!-- 2018-07-10 김소희 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ page import = "java.util.ArrayList" %>				<!-- ArrayList는 java.util.ArrayList에 포함 import -->
<%@ page import = "service.MemberScoreDao" %>			<!-- service패키지 안에 MemberScoreDao클래스 import-->
<%@ page import = "service.MemberAndScore" %>			<!-- service패키지 안에MemberAndScore클래스 import-->
<%@ page import = "service.Member" %>					<!-- service패키지 안에 Member클래스 import-->
<%@ page import = "service.MemberScore" %>				<!-- service패키지 안에 MemberScore클래스 import-->
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
		//MemberScoreDao data type으로 msdao 변수 생성하고  new생성자 메소드로  생성된  MemberScoreDao 객체의 주소 값을 msdao 변수에 할당한다
		int scoreAvg = msdao.seletScoreAvg();
		//int type으로 scoreAvg 변수 선언하고 seletScotreAvg 메소드 호출

	%>
	<div>
		평균 : <%=scoreAvg %>
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
				//ArrayList<MemberAndScore> data type으로 als 변수 생성하고  new생성자 메소드로  생성된  ArrayList<MemberAndScore> 객체의 주소 값을 als 변수에 할당한다
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