<!-- 18.7.3 최지수 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.StudentDao" %>
<%@ page import = "service.StudentAddrDao" %>
<%@ page import = "service.Student" %>
<%@ page import = "service.StudentAddr" %>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("euc-kr");
%>
<jsp:useBean id="s" class="service.Student"/> 	<!--  service패키지내 Student클래스의 주소값을 변수s에 대입 -->
<jsp:setProperty name="s" property="*"/>		<!--  변수 s에 담겨있는 Student클래스의 메서드를 갯수만큼 호출한다 -->
<jsp:useBean id="saddr" class="service.StudentAddr"/> 	<!--  service패키지내 StudentAddr클래스의 주소값을 변수saddr에 대입 -->
<jsp:setProperty name="saddr" property="*"/>		<!--  변수 saddr에 담겨있는 Student클래스의 메서드를 갯수만큼 호출한다 -->
<%
	int student_no = Integer.parseInt(request.getParameter("student_no"));
	String student_name = request.getParameter("student_name");
	int student_age = Integer.parseInt(request.getParameter("student_age"));
	String student_addr_content = request.getParameter("student_addr_content");
	
	StudentAddrDao saddrdao = new StudentAddrDao();
	saddrdao.updateStudentAddr(saddr);

	StudentDao sdao = new StudentDao();
	sdao.updateStudent(s);
	
	response.sendRedirect(request.getContextPath() + "/Student/studentList.jsp");
%>
