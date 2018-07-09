<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.TeacherDao" %>
<%@ page import = "service.TeacherAddrDao" %>
<%@ page import = "service.Teacher" %>
<%@ page import = "service.TeacherAddr" %>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("euc-kr");
%>
<jsp:useBean id="t" class="service.Teacher"/> 	
<jsp:setProperty name="t" property="*"/>		
<jsp:useBean id="taddr" class="service.TeacherAddr"/> 	
<jsp:setProperty name="taddr" property="*"/>		
<%
	int teacher_no = Integer.parseInt(request.getParameter("teacher_no"));
	String teacher_name = request.getParameter("teacher_name");
	int teacher_age = Integer.parseInt(request.getParameter("teacher_age"));
	String teacher_addr_content = request.getParameter("teacher_addr_content");
	
	TeacherAddrDao taddrdao = new TeacherAddrDao();
	taddrdao.updateTeacherAddr(taddr);

	TeacherDao tdao = new TeacherDao();
	tdao.updateTeacher(t);
	
	response.sendRedirect(request.getContextPath() + "/Teacher/teacherList.jsp");
%>
