<!-- 2018-07-08 김소희 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.MemberScoreDao" %>	<!-- service패키지 안에 MemberScoreDao클래스 import-->
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr"); %>	<!-- 한글 안 깨지게 -->
<jsp:useBean id="ms" class="service.MemberScore"/> 	<!-- MemberScore의 주소값을 변수 ms에 대입 MemberScore 객체 내부의 변수명이 같으면 set메서드에 값을 셋팅  -->
<jsp:setProperty name="ms" property="*"/>		 <!-- ms에 담겨있는 주소값을 따라가서 메소드 개수만큼 모두 호출  -->
<%

	MemberScoreDao msdao = new MemberScoreDao();
	//MemberScoreDao data type으로 msdao변수 생성하고  new생성자 메소드로  생성된  MemberScoreDao객체의 주소 값을 msdao변수에 할당한다
	int check = msdao.updateMemberScore(ms);
	//ms에 담겨있는 주소 값을 따라가서 updateMemberScore 메소드 호출
	if(check == 0 ){
		msdao.insertMemberScore(ms);
	}
	
	response.sendRedirect(request.getContextPath() + "/Member/memberList.jsp");
	//MemberList.jsp로 이동

%>