<!-- 2018-07-08 김소희 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.MemberScoreDao" %>
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr"); %>	<!-- 한글 안 깨지게 -->
<jsp:useBean id="ms" class="service.MemberScore"/> 	<!-- MemberScore의 주소값을 변수 ms에 대입 MemberScore 객체 내부의 변수명이 같으면 set메서드에 값을 셋팅  -->
<jsp:setProperty name="ms" property="*"/>		 <!-- ms에 담겨있는 주소값을 따라가서 메소드 개수만큼 모두 호출  -->
<%

MemberScoreDao msdao = new MemberScoreDao();
int check = msdao.updateMemberScore(ms);

if(check == 0 ){
	msdao.insertMemberScore(ms);
}

response.sendRedirect(request.getContextPath() + "/Member/MemberList.jsp");

%>