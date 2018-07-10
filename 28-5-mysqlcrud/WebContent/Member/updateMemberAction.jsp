<!-- 2018-07-02 김소희 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ page import = "service.Member" %>				<!-- service패키지 안에 Member클래스 import-->
<%@ page import = "service.MemberDao" %>			<!-- service패키지 안에 MemberDao클래스 import-->
<%@ page import = "service.MemberAddr" %>			<!-- service패키지 안에 MemberAddr클래스 import-->
<%@ page import = "service.MemberAddrDao" %>		<!-- service패키지 안에 MemberAddrDao클래스 import-->
<!DOCTYPE html>
<%request.setCharacterEncoding("euc-kr"); %>  <!-- 한글 깨지지않게 -->
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<jsp:useBean id="m" class="service.Member"/>  <!-- Member의 주소값을 변수 m에 대입 Member 객체 내부의 변수명이 같으면 set메서드에 값을 셋팅  -->
<jsp:setProperty name="m" property="*"/> <!-- m에 담겨있는 주소값을 따라가서 메소드 개수만큼 모두 호출  -->
<jsp:useBean id="maddr" class="service.MemberAddr"/>  <!-- Member의 주소값을 변수 maddr에 대입 Member 객체 내부의 변수명이 같으면 set메서드에 값을 셋팅  -->
<jsp:setProperty name="maddr" property="*"/> <!-- maddr에 담겨있는 주소값을 따라가서 메소드 개수만큼 모두 호출  -->


<%
	int member_no = Integer.parseInt(request.getParameter("member_no"));		//형변환
	String member_name = request.getParameter("member_name");
	int member_age = Integer.parseInt(request.getParameter("member_age"));
	String member_addr_content = request.getParameter("member_addr_content");
	
	MemberAddrDao maddrdao = new MemberAddrDao();
	//MemberAddrDao data type으로 maddrdao 변수 생성하고  new생성자 메소드로  생성된  MemberAddrDao 객체의 주소 값을 maddrdao 변수에 할당한다
	maddrdao.updateMemberAddr(maddr);
	//maddr에 담겨있는 주소 값을 따라가서 updateMemberAddr 메소드를 호출
	MemberDao mdao = new MemberDao();
	//MemberDao data type으로 mdao 변수 생성하고  new생성자 메소드로  생성된  MemberDao 객체의 주소 값을 mdao 변수에 할당한다
	mdao.updateMember(m);
	//m에 담겨있는 주소 값을 따라가서 updateMember 메소드를 호출
	
	response.sendRedirect(request.getContextPath() + "/Member/MemberList.jsp");
	//MemberList.jsp로 이동
%>
