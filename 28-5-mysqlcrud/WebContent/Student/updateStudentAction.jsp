<!-- 18.7.3 ������ -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.StudentDao" %>
<%@ page import = "service.StudentAddrDao" %>
<%@ page import = "service.Student" %>
<%@ page import = "service.StudentAddr" %>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("euc-kr");
%>
<jsp:useBean id="s" class="service.Student"/> 	<!--  service��Ű���� StudentŬ������ �ּҰ��� ����s�� ���� -->
<jsp:setProperty name="s" property="*"/>		<!--  ���� s�� ����ִ� StudentŬ������ �޼��带 ������ŭ ȣ���Ѵ� -->
<jsp:useBean id="saddr" class="service.StudentAddr"/> 	<!--  service��Ű���� StudentAddrŬ������ �ּҰ��� ����saddr�� ���� -->
<jsp:setProperty name="saddr" property="*"/>		<!--  ���� saddr�� ����ִ� StudentŬ������ �޼��带 ������ŭ ȣ���Ѵ� -->
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
