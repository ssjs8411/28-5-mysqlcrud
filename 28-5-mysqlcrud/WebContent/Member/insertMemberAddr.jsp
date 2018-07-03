<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ page import = "service.MemberAddrDao" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<jsp:useBean id="m" class="service.Member"/>  <!-- Member의 주소값을 변수 m에 대입 Member 객체 내부의 변수명이 같으면 set메서드에 값을 셋팅  -->
<jsp:setProperty name="m" property="*"/> <!-- m에 담겨있는 주소값을 따라가서 메소드 개수만큼 모두 호출  -->
</head>
<body>
<table border = "1">
	<tr>
		<td>주소번호</td>
		<td>멤버번호</td>
		<td>멤버주소</td>
		<td>입력</td>
	</tr>

</table>
</body>
</html>